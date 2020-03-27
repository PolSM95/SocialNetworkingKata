package socialnetwork.core.command;

import socialnetwork.core.Post;
import socialnetwork.core.User;

public class CommandFollow implements Command {
    User followedUser;

    public CommandFollow(User followedUser){
        this.followedUser = followedUser;
    }
    @Override
    public void execute(User user) {
        user.addFollow(followedUser);
    }
}
