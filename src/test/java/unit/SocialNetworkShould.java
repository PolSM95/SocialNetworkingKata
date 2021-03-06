package unit;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InOrder;
import socialnetwork.core.*;
import socialnetwork.infraestructure.Console;
import socialnetwork.infraestructure.TimeFormatter;

import static org.mockito.Mockito.*;

public class SocialNetworkShould {
    Console console;
    ActionHandler actionHandler;
    Users users;
    SocialNetwork socialNetwork;
    TimeFormatter timeFormatter;
    InOrder inOrder;

    @Before
    public void init(){
        console = mock(Console.class);
        timeFormatter = mock(TimeFormatter.class);
        users = new Users(timeFormatter);
        actionHandler = new ActionHandler(console, users, timeFormatter);
        socialNetwork = new SocialNetwork(actionHandler, console, users);
        inOrder = inOrder(console);
    }

    @Test
    public void add_post_into_user_posts(){
        socialNetwork.processAction("Alice -> I love the weather today");
        socialNetwork.processAction("Alice");

        verify(console).printLine("I love the weather today");
    }
    @Test
    public void read_multiple_posts_from_a_given_user(){
        socialNetwork.processAction("Bob -> Damn! We lost!");
        socialNetwork.processAction("Bob -> Good game though.");
        socialNetwork.processAction("Bob");

        verify(console).printLine("Damn! We lost!");
        verify(console).printLine("Good game though.");
    }

    @Test
    public void add_follows_into_user_followList(){
        socialNetwork.processAction("Charlie -> I'm in New York today! Anyone want to have a coffee?");
        socialNetwork.processAction("Charlie follows Alice");
        socialNetwork.processAction("Charlie wall");

        verify(console).printLine("Charlie - I'm in New York today! Anyone want to have a coffee?");
    }
    @Test
    public void print_wall_when_two_users_posted(){
        socialNetwork.processAction("Charlie -> I'm in New York today! Anyone want to have a coffee?");
        socialNetwork.processAction("Charlie follows Alice");
        socialNetwork.processAction("Alice -> I'm in New York today!");
        socialNetwork.processAction("Charlie wall");

        verify(console).printLine("Charlie - I'm in New York today! Anyone want to have a coffee?");
        verify(console).printLine("Alice - I'm in New York today!");
    }
}
