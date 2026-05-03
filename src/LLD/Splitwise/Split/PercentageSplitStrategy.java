package LLD.Splitwise.Split;

import LLD.Splitwise.Expense;
import LLD.Splitwise.ReceiverSplit;

public class PercentageSplitStrategy implements SplitStrategy {
    @Override
    public void updateSplitAmount(Expense ex) {
    //validate percentage value should be equal to 100;
        for(ReceiverSplit split: ex.getReceiverId()){
            double actualAmount = (split.getAmount()*ex.getAmount())/100;
            split.setAmount(actualAmount);
        }
    }
}
