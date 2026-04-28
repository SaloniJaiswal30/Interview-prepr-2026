package LLD.PaymentGateway;

public class PaypalService implements PaymentService{
    @Override
    public boolean validate(PaymentRequest paymentRequest) {
        return true;
    }

    @Override
    public PaymentResponse pay(PaymentRequest paymentRequest) {
        return new PaymentResponse(PaymentStatus.SUCCESSFUL,"PaypalService");
    }
}
