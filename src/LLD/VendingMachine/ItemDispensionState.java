package LLD.VendingMachine;

public class ItemDispensionState extends VendingStates {

    public ItemDispensionState(VendingMachine vm) {
        super(vm);
    }

    @Override
    public void selectItem(int id) {
        System.out.println("Can't select item in dispense State");

    }

    @Override
    public void insertCoin(int coins) {
        System.out.println("Can't insert coin in dispense State");

    }

    @Override
    public void cancelTransaction() {
        vendingMachine.reset();
        if(vendingMachine.getBalance()!=0){
            vendingMachine.refund(vendingMachine.getBalance());
        }
        vendingMachine.setCurrentsState(new ItemSelectionState(vendingMachine));
    }

    @Override
    public void dispatch() {
        int itemPrice = vendingMachine.getSelectedItem().getPrice();
        if(itemPrice<=vendingMachine.getBalance()) {
            int refundAmount = vendingMachine.getBalance()-itemPrice;
            vendingMachine.refund(refundAmount);
            vendingMachine.reduceQty();
            vendingMachine.setCurrentsState(new ItemSelectionState(vendingMachine));
        }
    }
}
