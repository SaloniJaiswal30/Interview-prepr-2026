package LLD.VendingMachine;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InventoryManagement {
    private Map<Integer,Inventory> inventoryMap;

    public InventoryManagement() {
        this.inventoryMap = new HashMap<>();
    }

    public void addItem(Inventory inv){
        inventoryMap.put(inv.getId(),inv);
    }

    public Item getItem(int id){
        return inventoryMap.get(id).getItem();
    }

    public boolean isAvailableQty(int id){
        return inventoryMap.containsKey(id);
    }

    public void reduceQty(int id){
        Inventory temp = inventoryMap.get(id);
        temp.setQty(temp.getQty()-1);
        if(temp.getQty()==0)
        {
            inventoryMap.remove(id);
        }
    }
}
