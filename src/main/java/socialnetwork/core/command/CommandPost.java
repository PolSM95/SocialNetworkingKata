package socialnetwork.core.command;

import socialnetwork.core.Post;
import socialnetwork.core.User;

public class CommandPost implements Command {
    Post post;

    public CommandPost(Post post){
        this.post = post;
    }

    // Used sleep to synchronize Threads when posting multiple posts
    @Override
    public void execute(User user) {
        try {
            Thread.sleep(100);
            user.addPost(post);
        } catch (Exception e){
            System.err.println(e);
        }
    }
}
