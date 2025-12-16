package com.houtou.poop;

import com.houtou.poop.Item.Tool;
import com.houtou.poop.Character.Character;

public class Main {
    public static void main(String[] args) {


        //weapons
        Tool stick = new Tool("stick", 1, "A wooden stick", "weapon", 2);
        Tool rustySword = new Tool("Rusty Sword", 6, "A sword covered in poo that caused oxidation", "weapon", 5);
        Tool ugandanClub = new Tool("Ugandan Club", 42, "Hand crafted thousand sun club of death", "weapon", 13);
        Tool godRendingDeathBlade = new Tool("God Rending Death Blade", 300, "Hand crafted blade made by the soul bonded artifact god forged with the essence of yang and death", "weapon", 25);
        Tool chineseNuke = new Tool("Chinese Nuke", 10000, "Nuke infused with the heavenly 7 elemental interaction combining each element with ruin capabilities forming an unstoppable force of nature", "weapon", 100);

        //Tool filthyRags = new Tool("filthy rags", 2, "Rags covered in poo effectively reducing their effective effectiveness", "armor", 3);
        //Tool poopCrustedArmor = new Tool("Poop Crusted Armor", 10, "A once great armor forged out of galvanized square steel dumped into the sewers to rot", "armor", 8);
        //Tool nineYangGodLeafRobe = new Tool("Nine Yang God Leaf Robe", 120, "A robe formed from a leaf that fell from the nine yang revolving divine god tree, woven by 13 seamstresses over the course of 12 nights", "armor", 27);
        //Tool tenThousandGolemHeavenlySteelMindConstruct = new Tool("Ten Thousand Golem Heavenly Steel Mind Construct", 500, "Mind construct that creates an army of 10,000 golems made entierely out of yin yang god infused heavenly steel", "armor", 81);
        //Tool quintessentialGodArmor = new Tool("Quintessential God Armor", 5000, "Rags covered in poo effectively reducing their effective effectiveness", "armor", 3);
        Map map = new Map(3, 3);
        Character seth = new Character("Seth", 10, 0, 0, "Seth");
        map.map[0][0] = seth.getPosition();
        System.out.print(map);
    }
}
