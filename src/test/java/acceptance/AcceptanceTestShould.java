package acceptance;

import org.junit.Before;


import static org.mockito.Mockito.*;

import org.junit.Test;
import org.mockito.InOrder;
import socialnetwork.infraestructure.Console;
import socialnetwork.core.*;
import socialnetwork.infraestructure.TimeFormatter;

import java.util.Date;


public class AcceptanceTestShould {
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
    public void acceptanceTest_posting_read(){
        when(timeFormatter.giveFormat(any(Date.class))).thenReturn(
                " (5 minutes ago)",
                " (2 minutes ago)",
                " (1 minutes ago)",
                " (2 seconds ago)",
                " (5 minutes ago)",
                " (15 seconds ago)",
                " (1 minutes ago)",
                " (2 minutes ago)",
                " (5 minutes ago)"
        );

        socialNetwork.processAction("Alice -> I love the weather today");
        socialNetwork.processAction("Bob -> Damn! We lost!");
        socialNetwork.processAction("Bob -> Good game though.");

        socialNetwork.processAction("Alice");
        socialNetwork.processAction("Bob");

        socialNetwork.processAction("Charlie -> I'm in New York today! Anyone want to have a coffee?");
        socialNetwork.processAction("Charlie follows Alice");
        socialNetwork.processAction("Charlie wall");

        socialNetwork.processAction("Charlie follows Bob");
        socialNetwork.processAction("Charlie wall");

        inOrder.verify(console).printLine("I love the weather today (5 minutes ago)");
        inOrder.verify(console).printLine("Damn! We lost! (2 minutes ago)");
        inOrder.verify(console).printLine("Good game though. (1 minutes ago)");

        inOrder.verify(console).printLine("Charlie - I'm in New York today! Anyone want to have a coffee? (2 seconds ago)");
        inOrder.verify(console).printLine("Alice - I love the weather today (5 minutes ago)");

        inOrder.verify(console).printLine("Charlie - I'm in New York today! Anyone want to have a coffee? (15 seconds ago)");
        inOrder.verify(console).printLine("Bob - Good game though. (1 minutes ago)");
        inOrder.verify(console).printLine("Bob - Damn! We lost! (2 minutes ago)");
        inOrder.verify(console).printLine("Alice - I love the weather today (5 minutes ago)");
    }
}
