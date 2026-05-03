package LLD.Splitwise;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupService {
    private Map<String, Group> groupMap;

    public Map<String, Group> getGroupMap() {
        return groupMap;
    }

    public void setGroupMap(Map<String, Group> groupMap) {
        this.groupMap = groupMap;
    }

    public Group getGroup(String groupId) {
        return groupMap.get(groupId);
    }

    private GroupService(){
        groupMap = new HashMap<>();
    }

    public void createGroup(String id, String name, List<String> userIds){
        //validation for users registered in splitwise
        Group group = new Group(id,name,userIds);
        groupMap.put(id,group);
    }

    public void addMemberInGroup(String groupId, String userId){
        //if not present then add

    }

    public void removeMemberFromGroup(String groupId, String userId){
        //if present then remove
    }

    public void addExpense(String groupId, String expenseId){
        Group group = groupMap.get(groupId);
        group.addExpenseList(expenseId);
    }

}
