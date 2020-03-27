package socialnetwork.core.command;

import socialnetwork.core.Post;
import socialnetwork.core.User;

public interface Command {
    void execute(User user);
}
