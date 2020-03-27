package unit;

import org.junit.Before;
import org.mockito.InOrder;
import socialnetwork.core.ActionHandler;

import static org.mockito.Mockito.inOrder;
import static org.mockito.Mockito.mock;

public class ActionHandlerShould {
    ActionHandler actionHandler;
    InOrder inOrder;

    @Before
    public void init(){
        actionHandler = mock(ActionHandler.class);
        inOrder = inOrder(actionHandler);
    }
}
