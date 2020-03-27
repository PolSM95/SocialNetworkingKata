package acceptance;

import org.junit.Before;
import org.junit.jupiter.api.Test;


import static org.mockito.Mockito.*;

import org.mockito.InOrder;
import socialnetwork.infraestructure.Console;
import socialnetwork.core.*;


public class AcceptanceTestShould {

    Console console;
    ActionHandler actionHandler;
    Users users;
    SocialNetwork socialNetwork;
    InOrder inOrder;

    @Before
    public void init(){
        console = mock(Console.class);
        users = new Users();
        actionHandler = new ActionHandler(console, users);
        socialNetwork = new SocialNetwork(actionHandler, console, users);
        inOrder = inOrder(console);
    }

    @Test
    public void AcceptanceTest_posting_read(){

        socialNetwork.processAction("Alice -> I love the weather today");
        socialNetwork.processAction("Bob -> Damn! We lost!");
        socialNetwork.processAction("Bob -> Good game though.");

        socialNetwork.processAction("Alice");
        socialNetwork.processAction("Bob");

        inOrder.verify(console).printLine("I love the weather today");
        inOrder.verify(console).printLine("Damn! We lost!");
        inOrder.verify(console).printLine("Good game though.");
    }
    /*
    Following: Charlie can subscribe to Alice’s and Bob’s timelines, and view an aggregated list of all subscriptions
​
    \> Charlie -> I'm in New York today! Anyone want to have a coffee?
    ​
    \> Charlie follows Alice
    ​
    \> Charlie wall
     */

}
