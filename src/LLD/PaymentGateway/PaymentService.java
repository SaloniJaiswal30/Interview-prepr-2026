package LLD.PaymentGateway;

public interface PaymentService {
    public boolean validate(PaymentRequest paymentRequest);
    public PaymentResponse pay(PaymentRequest paymentRequest);
}
