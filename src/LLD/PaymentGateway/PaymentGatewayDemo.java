package LLD.PaymentGateway;

import java.util.*;

public class PaymentGatewayDemo {
    public static void main(String[] args) {
        // 1. Setup the gateway facade
        PaymentGatewayService paymentGateway = PaymentGatewayService.getInstance();

        // 2. Register observers to be notified of transaction events
        List<PaymentObserver> observers = List.of(
                new MerchantObserver(1, "saloni"),
                new CustomerObserver(2, "Rohit", "xyz@gmail.com")
        );

        System.out.println("----------- SCENARIO 1: Successful Credit Card Payment -----------");
        // a. Merchant's backend creates a payment request
        PaymentRequest ccRequest = new PaymentRequest(50,"3293","tyler",PaymentType.CARD,Map.of("cardNumber", "1234..."),observers);

        // b. Merchant's backend sends it to the facade
        paymentGateway.startPayment(ccRequest);
        System.out.println("----------- SCENARIO 1: Successful Credit Card Payment Done -----------");


    }
}