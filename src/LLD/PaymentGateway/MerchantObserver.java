package LLD.PaymentGateway;

public class MerchantObserver implements PaymentObserver {
    private final int id;
    private final String name;

    public MerchantObserver(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public void TransactionNotification(Transaction transaction) {
        System.out.println("Merchant Observer Notification received ");
    }
}