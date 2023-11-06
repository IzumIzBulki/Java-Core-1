package org.example.onlineStoreObjects;

public class Order {
    private Buyer buyer;
    private Item item;
    private int quantity;
    public Order(int buyer, String item, int quantity){
        this.buyer = new Buyer(buyer);
        this.item = new Item((item));
        this.quantity = quantity;
    }

    public Buyer getBuyer() {
        return buyer;
    }

    public Item getItem() {
        return item;
    }

    public int getQuantity() {
        return quantity;
    }

    @Override
    public String toString() {
        return "Order{" +
                "buyer=" + buyer +
                ", item=" + item +
                ", quantity=" + quantity +
                '}';
    }
}
