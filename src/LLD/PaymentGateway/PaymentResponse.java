package LLD.PaymentGateway;

public class PaymentResponse {
    private final PaymentStatus status;
    private final String msg;

    public PaymentResponse(PaymentStatus status, String msg) {
        this.status = status;
        this.msg = msg;
    }
}
