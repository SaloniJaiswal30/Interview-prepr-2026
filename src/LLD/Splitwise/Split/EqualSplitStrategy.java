package LLD.Splitwise.Split;

import LLD.Splitwise.Expense;
import LLD.Splitwise.ReceiverSplit;

public class EqualSplitStrategy implements SplitStrategy {
    @Override
    public void updateSplitAmount(Expense ex) {
        //Todo:check how .333 split happens
        for(ReceiverSplit split: ex.getReceiverId()){
            double totalReceivers = ex.getReceiverId().size();
            double share= ex.getAmount()/totalReceivers;
            split.setAmount(share);
        }
    }
}
