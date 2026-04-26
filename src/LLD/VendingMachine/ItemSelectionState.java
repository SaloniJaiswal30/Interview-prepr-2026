package LLD.VendingMachine;

import java.util.List;

public class ItemSelectionState extends VendingStates {

    public ItemSelectionState(VendingMachine vm) {
        super(vm);
    }

    @Override
    public void selectItem(int id) {
        if(vendingMachine.getInventoryMgmt().isAvailableQty(id)) {
            vendingMachine.setCurrentSelectedItem(id);
            vendingMachine.setCurrentsState(new CoinInsertionState(vendingMachine));
        }
    }

    @Override
    public void insertCoin(int coins) {
        System.out.println("Can't insert coin in selection State");
    }

    @Override
    public void cancelTransaction() {
        System.out.println("No money to refund");
    }

    @Override
    public void dispatch() {
        System.out.println("Can't dispatch in selection State");

    }
}
