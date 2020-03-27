package socialnetwork.core;

import socialnetwork.core.command.*;
import socialnetwork.infraestructure.Console;


public class SocialNetwork {
    private ActionHandler actionHandler;
    private Console console;
    public Users users;

    public SocialNetwork(ActionHandler actionHandler, Console console, Users users){
        this.actionHandler = actionHandler;
        this.console = console;
        this.users = users;
    }

    public void processAction(String inputMessage) {
        Command command = actionHandler.extractCommand(inputMessage);
        User user = actionHandler.extractUser(inputMessage);

        User actualUser = users.checkUser(user);

        if(command instanceof CommandPost){
            command.execute(actualUser);
        }
        if(command instanceof CommandRead){
            command.execute(actualUser);
        }
        if(command instanceof CommandFollow){
            command.execute(actualUser);
        }
        if(command instanceof CommandWall){
            command.execute(actualUser);
        }

    }


}
