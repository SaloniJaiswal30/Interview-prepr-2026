package LLD.PaymentGateway;

public class CustomerObserver implements PaymentObserver {
    private final int id;
    private final String name;
    private final String mailId;

    public CustomerObserver(int id, String name, String mailId) {
        this.id = id;
        this.name = name;
        this.mailId = mailId;
    }

    @Override
    public void TransactionNotification(Transaction transaction) {
        System.out.println("Customer Observer Notification received ");
    }
}
