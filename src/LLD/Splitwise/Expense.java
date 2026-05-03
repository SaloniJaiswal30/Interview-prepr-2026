package LLD.Splitwise;

import java.util.List;

public class Expense {
    String id;
    String payerId;
    List<ReceiverSplit> receiverId;
    double amount;
    String groupId;
    StrategyType strategyType;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPayerId() {
        return payerId;
    }

    public void setPayerId(String payerId) {
        this.payerId = payerId;
    }

    public List<ReceiverSplit> getReceiverId() {
        return receiverId;
    }

    public void setReceiverId(List<ReceiverSplit> receiverId) {
        this.receiverId = receiverId;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public StrategyType getStrategyType() {
        return strategyType;
    }

    public void setStrategyType(StrategyType strategyType) {
        this.strategyType = strategyType;
    }

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }
}
