package socialnetwork.core.command;

import socialnetwork.core.Post;
import socialnetwork.core.User;

public class CommandWall implements Command {
    @Override
    public void execute(User user) {
        user.printWall();
    }
}
