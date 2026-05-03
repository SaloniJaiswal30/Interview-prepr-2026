package LLD.Splitwise.Split;

import LLD.Splitwise.Expense;

public class ExactSplitStrategy implements SplitStrategy {
    @Override
    public void updateSplitAmount(Expense ex) {
        // just validate if amount in the splits is equal to the totalamount
    }
}
