package acceptance;

import org.junit.Before;


import static org.mockito.Mockito.*;

import org.junit.Test;
import org.mockito.InOrder;
import socialnetwork.infraestructure.Console;
import socialnetwork.core.*;
import socialnetwork.infraestructure.TimeFormatter;

import java.util.Date;


public class TimeFormatterShould {

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
    public void verify_that_format_is_correct(){
        when(timeFormatter.giveFormat(any(Date.class))).thenReturn(
                " (5 minutes ago)",
                " (2 minutes ago)",
                " (1 minutes ago)"
        );

        socialNetwork.processAction("Alice -> I love the weather today");
        socialNetwork.processAction("Bob -> Damn! We lost!");
        socialNetwork.processAction("Bob -> Good game though.");

        socialNetwork.processAction("Alice");
        socialNetwork.processAction("Bob");


        inOrder.verify(console).printLine("I love the weather today (5 minutes ago)");
        inOrder.verify(console).printLine("Damn! We lost! (2 minutes ago)");
        inOrder.verify(console).printLine("Good game though. (1 minutes ago)");

    }
}
