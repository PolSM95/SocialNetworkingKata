package socialnetwork.core.command;

import socialnetwork.core.Post;
import socialnetwork.core.User;

public class CommandPost implements Command {
    Post post;

    public CommandPost(Post post){
        this.post = post;
    }
    @Override
    public void execute(User user) {
        user.addPost(post);
    }
}
