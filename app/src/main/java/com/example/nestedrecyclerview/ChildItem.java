package com.example.nestedrecyclerview;

public class ChildItem {

    String itemName, itemQty, itemPrice;
    int imageID;

    public ChildItem(String itemName, String itemQty, String itemPrice,int imageID) {
        this.itemName = itemName;
        this.itemQty = itemQty;
        this.itemPrice = itemPrice;
        this.imageID = imageID;
    }
}
