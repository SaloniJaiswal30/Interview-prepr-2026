package LLD.Splitwise.Split;

import LLD.Splitwise.StrategyType;

public class SplitStrategyFactory {
    public SplitStrategy getStrategy(StrategyType type){
        switch(type){
            case StrategyType.EQUAL_SPLIT:
                return new EqualSplitStrategy();

            case StrategyType.EXACT_SPLIT:
                return new ExactSplitStrategy();

            case StrategyType.PERCENTAGE_SPLIT:
                return new PercentageSplitStrategy();

            default:
                throw new IllegalArgumentException("wrong type");
        }
        
    }
}
