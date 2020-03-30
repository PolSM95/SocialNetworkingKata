package socialnetwork.core;

import socialnetwork.infraestructure.Console;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class User {
    private String name;
    private Posts posts;
    private Console console;
    private Follows follows;

    public User(String name, Console console){
        this.name = name;
        this.console = console;
        this.posts = new Posts(console);
        this.follows = new Follows();
    }

    public void addPost(Post post){
        if(post != null){
            posts.addPost(post);
        }
    }

    public void addFollow(User user){
        follows.addFollow(user);
    }
    public void printPosts() {
        posts.printPosts();
    }
    public void printWall(){
        List<Post> temporalList = new ArrayList<>();

        temporalList = posts.insertPostsIntoList(temporalList);
        temporalList = follows.insertPostsIntoList(temporalList);

        for (Post post : temporalList) {
            post.printWallFormat(console);
        }
    }

    public Posts getPosts() {
        return posts;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(name, user.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
