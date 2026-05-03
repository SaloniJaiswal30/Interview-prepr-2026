package LLD.Splitwise;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserService {
    private Map<String, User> userMap;

    private UserService(){
        userMap = new HashMap<>();
    }

    public void addUser(String id, String name,String phoneno){
        userMap.put(id,new User(id,name,phoneno));
    }

    public void setUserMap(Map<String, User> userMap) {
        this.userMap = userMap;
    }

    public User getUser(String id) {
        if (!userMap.containsKey(id)) {
            userMap.put(id, new User(id, "no_name", "xxxxxxxxx"));
        }
        return userMap.get(id);
    }

    public boolean validateUsers(List<String> userIds){
        //validate and return true if all present
        return true;
    }

}
