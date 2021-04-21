package com.example.nestedrecyclerview;

public class ParentItem {

    String orderId, quantity, price;
    int imageId;

    public ParentItem(String orderId, String quantity, String price, int imageId) {
        this.orderId = orderId;
        this.quantity = quantity;
        this.price = price;
        this.imageId = imageId;
    }
}
