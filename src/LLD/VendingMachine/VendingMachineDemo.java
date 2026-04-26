package LLD.VendingMachine;

public class VendingMachineDemo {
    public static void main(String[] args) {
        VendingMachine vendingMachine = VendingMachine.getInstance();

        // Add products to the inventory
        vendingMachine.addItem(1, "Coke", 25, 3,5);
        vendingMachine.addItem(2, "Pepsi", 25, 2,5);
        vendingMachine.addItem(3, "Water", 10, 5,5);

        // Select a product
        System.out.println("\n--- Step 1: Select an item ---");
        vendingMachine.selectItem(2);

        // Insert coins
        System.out.println("\n--- Step 2: Insert coins ---");
        vendingMachine.insertCoin(60);

        // Dispense the product
        System.out.println("\n--- Step 3: Dispense item ---");
        vendingMachine.dispatch(); // Should dispense Coke

        // Select another item
        System.out.println("\n--- Step 4: Select another item ---");
        vendingMachine.selectItem(5);

        // Insert more amount
        System.out.println("\n--- Step 5: Insert more than needed ---");
        vendingMachine.insertCoin(10); // 25

        // Try to dispense the product
        System.out.println("\n--- Step 6: Dispense and return change ---");
        vendingMachine.dispatch();
    }
}