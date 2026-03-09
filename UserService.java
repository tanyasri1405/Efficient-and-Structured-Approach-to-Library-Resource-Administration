
package backend;

import java.util.HashMap;

public class UserService {

    HashMap<String, User> users = new HashMap<>();

    public boolean register(String username, String password, String email, String phone) {
        if(users.containsKey(username)) return false;
        users.put(username, new User(username, password, email, phone));
        return true;
    }

    public boolean login(String username, String password) {
        if(!users.containsKey(username)) return false;
        return users.get(username).password.equals(password);
    }

    public boolean verifyUser(String username, String email, String phone) {
        if(!users.containsKey(username)) return false;
        User u = users.get(username);
        return u.email.equals(email) && u.phone.equals(phone);
    }

    public void updatePassword(String username, String newPassword) {
        users.get(username).password = newPassword;
    }
}
