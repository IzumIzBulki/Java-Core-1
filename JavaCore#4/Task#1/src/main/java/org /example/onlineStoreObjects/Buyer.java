package org.example.onlineStoreObjects;

public class Buyer implements Comparable<Buyer>{
    private int userID;
    public Buyer(int userID){
        this.userID = userID;
    }
    public int getUserID() {return userID;}

    @Override
    public int compareTo(Buyer o) {
        return Integer.compare(this.userID, o.userID);
    }

    @Override
    public String toString() {
        return String.format("%d", userID);
    }
}
