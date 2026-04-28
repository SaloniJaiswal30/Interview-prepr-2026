package LLD.PaymentGateway;

import java.time.LocalDateTime;

public class Transaction {
    private final String id;
    private final  PaymentRequest paymentRequest;
    private  PaymentStatus status;
    private final LocalDateTime date;

    public Transaction(String id, PaymentRequest paymentRequest, PaymentStatus status, LocalDateTime date) {
        this.id = id;
        this.paymentRequest = paymentRequest;
        this.status = status;
        this.date = date;
    }

    public String getId() {
        return id;
    }

    public PaymentRequest getPaymentRequest() {
        return paymentRequest;
    }

    public PaymentStatus getStatus() {
        return status;
    }

    public void setStatus(PaymentStatus status) {
        this.status = status;
    }

    public LocalDateTime getDate() {
        return date;
    }
}
