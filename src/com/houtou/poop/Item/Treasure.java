package com.houtou.poop.Item;

public class Treasure extends Item {
private int quantity;

public Treasure(String name, int value, String description, String type, int quantity) {
    super(name, value, description, type);
    this.quantity = quantity;
}

    public int getSellValue() {return this.getValue() * this.getQuantity();}

    public int getQuantity() {return this.quantity;}

    public void setQuantity(int quantity) {this.quantity = quantity;}


    public String toString() {
        return this.getName() + ":\n" + "Type: " + this.getType() + "\nValue: " + this.getValue() + "\nQuantity: " + this.getQuantity() + "\nDescription: " + this.getDescription();
    }
}
