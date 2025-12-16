package com.houtou.poop.Item;

public class Item {

    //value is used when buying and selling what it is
    private String name;
    private int value;
    private String description;
    //type can be like weapon or armor or spell or whatever junk
    private String type;

    public Item() {
        this.name = "none";
        this.value = 0;
        this.description = "poopoo";
        this.type = "item";
    }

    public Item(String name, int value, String description, String type){
        this.name = name;
        this.value = value;
        this.description = description;
        this.type = type;
    }


//getters
    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getType() {
        return type;
    }

    public int getValue() {
        return value;
    }

//setters
    public void setDescription(String description) {
        this.description = description;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
