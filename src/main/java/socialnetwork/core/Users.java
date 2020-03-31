package socialnetwork.core;

import socialnetwork.infraestructure.TimeFormatter;

import java.util.ArrayList;
import java.util.List;

public class Users {
    private List<User> userList = new ArrayList<>();
    private TimeFormatter timeFormatter;

    public void addUser(User user){
        userList.add(user);
    }

    public Users(TimeFormatter timeFormatter) {
        this.timeFormatter = timeFormatter;
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
