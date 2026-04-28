package LLD.PaymentGateway;

import java.util.*;

public class PaymentGatewayDemo {
    public static void main(String[] args) {
        // 1. Setup the gateway facade
        PaymentGatewayService paymentGateway = PaymentGatewayService.getInstance();

        // 2. Register observers to be notified of transaction events
        paymentGateway.addObserver(new MerchantObserver(1,"saloni"));
        paymentGateway.addObserver(new CustomerObserver(2,"Rohit","xyz@gmail.com"));

        System.out.println("----------- SCENARIO 1: Successful Credit Card Payment -----------");
        // a. Merchant's backend creates a payment request
        PaymentRequest ccRequest = new PaymentRequest(50,"3293","tyler",PaymentType.CARD,Map.of("cardNumber", "1234..."));

        // b. Merchant's backend sends it to the facade
        paymentGateway.startPayment(ccRequest);
        System.out.println("----------- SCENARIO 1: Successful Credit Card Payment Done -----------");


    }
}