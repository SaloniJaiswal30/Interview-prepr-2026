package LLD.Splitwise;

import java.util.List;

public class SplitwiseService {
    private static volatile SplitwiseService instance;
    private UserService userService;
    private GroupService groupService;
    private ExpenseService  expenseService;

    private SplitwiseService(){}

    public static SplitwiseService getSplitwiseControllerInstance(){
        synchronized(SplitwiseService.class){
            if (instance != null) {
                instance = new SplitwiseService();
            }
        }
        return instance;
    }

    public void addUser(String id, String name,String phoneno){
        userService.addUser(id,name,phoneno);
    }

    public void createGroup(String id, String name,List<String> userIds){
        if(userService.validateUsers(userIds))
            groupService.createGroup(id,name,userIds);
        else
            throw new UserNotFoundException("User not found");

    }

    public void addMemberInGroup(String groupId, String userId){
        groupService.addMemberInGroup(groupId,  userId);
    }

    public void removeMemberFromGroup(String groupId, String userId){
        groupService.removeMemberFromGroup(groupId,  userId);
    }

    public void addExpense(Expense ex){
        expenseService.addExpense(ex);
    }

    public void simplify(int groupId){

    }


    public void settle(int groupId){

    }



}
