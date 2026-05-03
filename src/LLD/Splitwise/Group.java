package LLD.Splitwise;

import java.util.List;
import java.util.Map;

public class Group {
    private final String groupId;
    private String groupName;
    private List<String> userList;
    private List<String> expenseIds;

    public Group(String groupId,String groupName,List<String> userList) {
        this.groupId = groupId;
        this.groupName=groupName;
        this.userList = userList;
    }

    public String getGroupId() {
        return groupId;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public List<String> getPersonList() {
        return userList;
    }

    public void setPersonList(List<String> userList) {
        this.userList = userList;
    }

    public void addExpenseList(String exId){
        expenseIds.add(exId);
    }
}
