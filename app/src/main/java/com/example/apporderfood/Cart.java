package com.example.apporderfood;

public class Cart {
    private final int image, money, quantity;
    private final String foodName;

    public Cart(int image, String foodName, int money, int quantity) {
        this.image = image;
        this.foodName = foodName;
        this.money = money;
        this.quantity = quantity;
    }

    public int getImage() {
        return image;
    }

    public String getFoodName() {
        return foodName;
    }

    public int getMoney() {
        return money;
    }

    public int getQuantity() {
        return quantity;
    }
}
