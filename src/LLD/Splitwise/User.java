package LLD.Splitwise;

import java.util.List;
import java.util.Map;

public class User {
    private final String id;
    private final String name;
    private final String phoneNo;
    private String mailId;
    List<String> groupIdList;

    public User(String id, String name, String phoneNo) {
        this.id = id;
        this.name = name;
        this.phoneNo = phoneNo;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public String getMailId() {
        return mailId;
    }

    public void setMailId(String mailId) {
        this.mailId = mailId;
    }

    public List<String> getGroupList() {
        return groupIdList;
    }

    public void setGroupList(List<String> groupList) {
        this.groupIdList = groupList;
    }
}
