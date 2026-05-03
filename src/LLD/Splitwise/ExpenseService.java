package LLD.Splitwise;

import LLD.Splitwise.Split.SplitStrategy;
import LLD.Splitwise.Split.SplitStrategyFactory;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ExpenseService {

    private SplitStrategyFactory splitStrategyFactory;
    private Map<String, Expense> expenseMap;
    private GroupService groupService;
    private  ConcurrentHashMap<String, ConcurrentHashMap<String, Double>> balances;

    void addExpense(Expense ex){
        SplitStrategy splitStrategy = splitStrategyFactory.getStrategy(ex.getStrategyType());
        splitStrategy.updateSplitAmount(ex);
        expenseMap.put(ex.getId(),ex);
        if(ex.getGroupId()!=null){
            groupService.addExpense(ex.getGroupId(),ex.getId());
        }

        for (ReceiverSplit split : ex.getReceiverId()) {
            if (!split.getReceiver().equals(ex. getPayerId())) {
                updateBalance(split.getReceiver(), ex. getPayerId(), split.getAmount());
            }
        }
    }

    // Increases the debt from fromUserId to toUserId by amount
    // Also mirrors the update: toUserId's record shows they are owed
    public synchronized void updateBalance(String fromUserId, String toUserId, double amount) {
        // Forward direction: fromUser owes toUser more
        balances.computeIfAbsent(fromUserId, k -> new ConcurrentHashMap<>())
                .merge(toUserId, amount, Double::sum);

        // Mirror direction: toUser is owed more by fromUser (negative amount)
        balances.computeIfAbsent(toUserId, k -> new ConcurrentHashMap<>())
                .merge(fromUserId, -amount, Double::sum);
    }


}
