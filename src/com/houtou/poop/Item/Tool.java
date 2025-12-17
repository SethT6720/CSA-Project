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
    public void setStat(int stat){
    this.stat = stat;
    }

    public String toString() {
        return this.getName() + ":\n" + "Type: " + this.getType() + "\nValue: " + this.getValue() + "\nStat: " + this.getStat() + "\nDescription: " + this.getDescription();
    }
}
