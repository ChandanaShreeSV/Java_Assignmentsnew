import java.util.*;
class ShoppingCart {
    private List<String> items = new ArrayList<>();
    public void addItem(String item) {
        items.add(item);
        System.out.println("Added: " + item);
    }
    public void removeItem(int index) {
        if (index >= 0 && index < items.size()) {
            System.out.println("Removed: " + items.remove(index));
        } else {
            System.out.println("Invalid index");
        }
    }
    public String getItem(int index) {
        return (index >= 0 && index < items.size()) ? items.get(index) : "Invalid index";
    }
    public static void main(String[] args) {
        ShoppingCart cart = new ShoppingCart();
        cart.addItem("Laptop");
        cart.addItem("Phone");
        cart.addItem("Headphones");
        cart.addItem("Charger");
        cart.addItem("Mouse");
        cart.addItem("Keyboard");

        System.out.println("Item at index 2: " + cart.getItem(2));
        cart.removeItem(3);
        System.out.println("Item at index 3: " + cart.getItem(3));
    }
}
