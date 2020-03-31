package socialnetwork.core;

import socialnetwork.core.command.*;
import socialnetwork.infraestructure.Console;
import socialnetwork.infraestructure.TimeFormatter;

public class ActionHandler {

    private String separator;
    private Console console;
    private Users users;
    private TimeFormatter timeFormatter;

    public ActionHandler(Console console, Users users, TimeFormatter timeFormatter){
        this.console = console;
        this.users = users;
        this.timeFormatter = timeFormatter;
    }

    public Command extractCommand(String inputMessage) {
        if(inputMessage.contains(Actions.POST.getValue())){
            separator = Actions.POST.getValue();
            return new CommandPost(extractPost(inputMessage));
        }

        if(inputMessage.contains(Actions.FOLLOW.getValue())){
            separator = Actions.FOLLOW.getValue();
            return new CommandFollow(extractFollowedUser(inputMessage));
        }

        if(inputMessage.contains(Actions.WALL.getValue())){
            separator = Actions.WALL.getValue();
            return new CommandWall();
        }


        separator = "";
        return new CommandRead();
    }

    public User extractUser(String inputMessage){
        if(separator.equals("")){
            return new User(inputMessage, console);
        }
        return users.checkUser(new User(inputMessage.split(separator)[0], console));
    }

    public Post extractPost(String inputMessage){
        return new Post(inputMessage.split(separator)[1], inputMessage.split(separator)[0], timeFormatter);
    }
    public User extractFollowedUser(String inputMessage){
        return users.checkUser(new User(inputMessage.split(separator)[1], console));
    }
}
