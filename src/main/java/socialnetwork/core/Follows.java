package socialnetwork.core;

import java.util.ArrayList;
import java.util.List;

public class Follows {
    private List<User> followList = new ArrayList<>();
    public void addFollow(User user){
        followList.add(user);
    }
    public List<Post> insertPostsIntoList(List<Post> allPosts){
        for (User user: followList) {
            Posts posts = user.getPosts();
            posts.insertPostsIntoList(allPosts);
        }
        return allPosts;
    }
}
