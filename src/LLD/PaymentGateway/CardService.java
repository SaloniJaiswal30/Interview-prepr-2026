package LLD.PaymentGateway;

public class CardService implements PaymentService {
    @Override
    public boolean validate(PaymentRequest paymentRequest) {
        return true;
    }

    @Override
    public PaymentResponse pay(PaymentRequest paymentRequest) {
        System.out.println("card payment done");
        return new PaymentResponse(PaymentStatus.SUCCESSFUL,"CardService");
    }
}
