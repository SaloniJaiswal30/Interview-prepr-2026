package LLD.PaymentGateway;

public class PaymentFactory {
    public PaymentService getPaymentType(PaymentType type){
        switch(type) {
            case PaymentType.UPI:
                return new UPIService();
            case PaymentType.CARD:
                return new CardService();
            case PaymentType.PAYPAL:
                return new PaypalService();
            default:
                throw new IllegalArgumentException("wrong payment type");
        }

    }
}
