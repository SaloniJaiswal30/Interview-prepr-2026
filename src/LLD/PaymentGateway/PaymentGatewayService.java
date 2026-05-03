package LLD.PaymentGateway;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class PaymentGatewayService {
    private static PaymentGatewayService instance;

    private PaymentGatewayService(){}

    public static synchronized PaymentGatewayService getInstance() {
        if (instance == null) {
            instance = new PaymentGatewayService();
        }
        return  instance;
    }

    public void startPayment(PaymentRequest paymentRequest){
        PaymentFactory factory = new PaymentFactory();
        PaymentService paymentService = factory.getPaymentType(paymentRequest.getType());
        Transaction  transaction = new Transaction(paymentRequest.getTransactionId(),paymentRequest,PaymentStatus.INITIATED, LocalDateTime.now());
        if(paymentService.validate(paymentRequest)) {
            if(paymentService.pay(paymentRequest)!=null) {
                transaction.setStatus(PaymentStatus.SUCCESSFUL);
            }
            else
                transaction.setStatus(PaymentStatus.FAILED);
            notifyObservers(transaction, paymentRequest.getObservers());
        }

    }

    public void notifyObservers(Transaction transaction, List<PaymentObserver> observers){
        for (PaymentObserver observer : observers) {
            observer.TransactionNotification(transaction);
        }
    }

}
