package LLD.Splitwise.Split;

import LLD.Splitwise.Expense;

public interface SplitStrategy {
    void updateSplitAmount(Expense ex);
}
