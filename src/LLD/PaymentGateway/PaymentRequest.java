package LLD.PaymentGateway;

import java.util.Map;

public class PaymentRequest {
    private final int amount;
    private final  String transactionId;
    private final String payerid;
    private final PaymentType type;
    private final Map<String, String> paymentDetails;

    public PaymentRequest(int amount, String transactionId, String payerid, PaymentType type, Map<String, String> paymentDetails) {
        this.amount = amount;
        this.transactionId = transactionId;
        this.payerid = payerid;
        this.type = type;
        this.paymentDetails = paymentDetails;
    }

    public String getPayerid() {
        return payerid;
    }

    public int getAmount() {
        return amount;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public PaymentType getType() {
        return type;
    }

    public Map<String, String> getPaymentDetails() {
        return paymentDetails;
    }
}
