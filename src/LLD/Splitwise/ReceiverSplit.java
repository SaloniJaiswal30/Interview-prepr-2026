package LLD.Splitwise;

public class ReceiverSplit {
    String receiver;
    double amount;

    public ReceiverSplit(String receiver, int amount) {
        this.receiver = receiver;
        this.amount = amount;
    }

    public String getReceiver() {
        return receiver;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}
