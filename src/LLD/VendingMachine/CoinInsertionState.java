package LLD.VendingMachine;

public class CoinInsertionState extends VendingStates {

    public CoinInsertionState(VendingMachine vm) {
        super(vm);
    }

    @Override
    public void selectItem(int id) {
        System.out.println("Can't select item in coin insertion State");
    }

    @Override
    public void insertCoin(int coins) {
        if(vendingMachine.getSelectedItem().getPrice()<=coins) {
            vendingMachine.setBalance(coins);
            vendingMachine.setCurrentsState(new ItemDispensionState(vendingMachine));
        }
        else{
            System.out.println("Not enough money");
        }
        // we can also take multiple coins and change state once the balance become more than the price;
    }

    @Override
    public void cancelTransaction() {
        vendingMachine.reset();
        vendingMachine.setCurrentsState(new ItemSelectionState(vendingMachine));
    }

    @Override
    public void dispatch() {
        System.out.println("Can't dispatch in coin insertion State");

    }
}
