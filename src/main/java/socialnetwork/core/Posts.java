package socialnetwork.core;

import socialnetwork.infraestructure.Console;

import java.util.ArrayList;
import java.util.List;

public class Posts {
    private Console console;
    private List<Post> postList;

    public Posts(Console console){
        this.console = console;
        postList = new ArrayList<>();
    }

    public void printPosts() {
        for (Post post: postList) {
            post.print(console);
        }
    }

    public void addPost(Post post){
        postList.add(post);
    }

    public List<Post> insertPostsIntoList(List<Post> allPosts){
         allPosts.addAll(postList);
         return allPosts;
    }

}
