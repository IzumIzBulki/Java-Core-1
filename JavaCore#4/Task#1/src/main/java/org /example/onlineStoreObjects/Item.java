package org.example.onlineStoreObjects;

public class Item implements Comparable<Item>{
    private String item;

    public Item(String item){
        this.item = item;
    }
    public String getItem() {
        return item;
    }

    @Override
    public int compareTo(Item o) {
        return this.getItem().compareTo(o.getItem());
    }

    @Override
    public String toString() {
        return item;
    }
}
