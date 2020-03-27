package socialnetwork.core.command;

import socialnetwork.core.Post;
import socialnetwork.core.User;

public class CommandRead implements Command {
    @Override
    public void execute(User user) {
        user.printPosts();
    }
}
