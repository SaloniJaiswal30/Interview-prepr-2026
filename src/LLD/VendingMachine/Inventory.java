package LLD.VendingMachine;

public class Inventory {
    private final int id;
    private final Item item;
    private int qty;

    public Inventory(int id, Item item, int qty) {
        this.id = id;
        this.item = item;
        this.qty = qty;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public Item getItem() {
        return item;
    }

    public int getId() {
        return id;
    }
}
