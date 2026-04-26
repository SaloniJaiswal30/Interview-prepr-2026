package LLD.VendingMachine;

public class VendingMachine {
    private static VendingMachine instance;
    private VendingStates currentsState;
    private InventoryManagement inventoryMgmt;
    private int currentSelectedItem;
    private int balance;
    private VendingMachine(){
        this.currentsState = new ItemSelectionState(this);
        this. inventoryMgmt= new InventoryManagement();
    }

    public InventoryManagement getInventoryMgmt() {
        return inventoryMgmt;
    }

    public void setInventoryMgmt(InventoryManagement inventoryMgmt) {
        this.inventoryMgmt = inventoryMgmt;
    }

    public int getCurrentSelectedItem() {
        return currentSelectedItem;
    }

    public void setCurrentSelectedItem(int currentSelectedItem) {
        this.currentSelectedItem = currentSelectedItem;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public static VendingMachine getInstance(){
        if(instance==null) {
            synchronized(VendingMachine.class){
                if (instance == null) {
                    instance = new VendingMachine();
                }
            }
        }
        return instance;
    }

    public void selectItem(int id) {
        currentsState.selectItem(id);
    }

    public Item getSelectedItem(){
        return inventoryMgmt.getItem(currentSelectedItem);
    }

    public void insertCoin(int coin) {
        currentsState.insertCoin(coin);
    }

    public void dispatch() {
        currentsState.dispatch();
    }

    public void cancelTransaction() {
        currentsState.cancelTransaction();
    }

    public VendingStates getCurrentsState() {
        return currentsState;
    }

    public void setCurrentsState(VendingStates currentsState) {
        this.currentsState = currentsState;
    }

    public void reset() {
        currentSelectedItem = -1;
        balance = 0;
    }

    public void refund(int amount){
        System.out.println("Refunding: " + amount);
        balance = balance-amount;
    }

    public void reduceQty(){
        inventoryMgmt.reduceQty(currentSelectedItem);
    }

    public void addItem(int id, String name, int price, int invid, int qty){
        inventoryMgmt.addItem(new Inventory(invid, new Item(id,name,price),qty));
    }
}
