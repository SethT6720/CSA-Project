package com.houtou.poop.Item;

public class Tool extends Item {
private int stat;

public Tool(String name, int value, String description, String type, int stat){
    super(name,value,description,type);
    this.stat = stat;

}
//Getters
    public int getStat(){
        return stat;
    }
}
