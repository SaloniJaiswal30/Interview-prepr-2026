package LLD.VendingMachine;

public abstract class VendingStates {
    VendingMachine vendingMachine;
    public VendingStates(VendingMachine vm) {
        this.vendingMachine=vm;
    }

    public abstract void selectItem(int id);
    public abstract void insertCoin(int coins);
    public abstract void cancelTransaction();
    public abstract void dispatch();
}
