package LLD.PaymentGateway;

import java.util.ArrayList;
import java.util.List;

public interface PaymentObserver {
    public void TransactionNotification(Transaction transaction);
}
