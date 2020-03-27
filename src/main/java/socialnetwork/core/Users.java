package socialnetwork.core;

import java.util.ArrayList;
import java.util.List;

public class Users {
    private List<User> userList = new ArrayList<>();
    public void addUser(User user){
        userList.add(user);
    }

    public User checkUser(User user) {
        for (User actualUser : userList) {
            if (actualUser.equals(user)) {
                return actualUser;
            }
        }
        addUser(user);
        return user;
    }
}
