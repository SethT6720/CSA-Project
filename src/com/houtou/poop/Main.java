package com.houtou.poop;

import java.util.Scanner;

import com.houtou.poop.Item.Tool;
import com.houtou.poop.Location.Location;
import com.houtou.poop.Character.Player;

public class Main {
    public static void lookAround(Map map) {
        System.out.println("You look around and see:");
        System.out.println(map.toString());
    }

    public static void main(String[] args) {


        //weapons
        //Tool stick = new Tool("stick", 1, "A wooden stick", "weapon", 2);
        //Tool rustySword = new Tool("Rusty Sword", 6, "A sword covered in poo that caused oxidation", "weapon", 5);
        //Tool ugandanClub = new Tool("Ugandan Club", 42, "Hand crafted thousand sun club of death", "weapon", 13);
        //Tool godRendingDeathBlade = new Tool("God Rending Death Blade", 300, "Hand crafted blade made by the soul bonded artifact god forged with the essence of yang and death", "weapon", 25);
        //Tool chineseNuke = new Tool("Chinese Nuke", 10000, "Nuke infused with the heavenly 7 elemental interaction combining each element with ruin capabilities forming an unstoppable force of nature", "weapon", 100);

        //Tool filthyRags = new Tool("filthy rags", 2, "Rags covered in poo effectively reducing their effective effectiveness", "armor", 3);
        //Tool poopCrustedArmor = new Tool("Poop Crusted Armor", 10, "A once great armor forged out of galvanized square steel dumped into the sewers to rot", "armor", 8);
        //Tool nineYangGodLeafRobe = new Tool("Nine Yang God Leaf Robe", 120, "A robe formed from a leaf that fell from the nine yang revolving divine god tree, woven by 13 seamstresses over the course of 12 nights", "armor", 27);
        //Tool tenThousandGolemHeavenlySteelMindConstruct = new Tool("Ten Thousand Golem Heavenly Steel Mind Construct", 500, "Mind construct that creates an army of 10,000 golems made entierely out of yin yang god infused heavenly steel", "armor", 81);
        //Tool quintessentialGodArmor = new Tool("Quintessential God Armor", 5000, "Rags covered in poo effectively reducing their effective effectiveness", "armor", 3);
        Map map = new Map(3, 3);
        Location startingLocation = new Location(1, 1, "Starting Location", 2, 2);
        map.addLocation(1, 1, startingLocation);

        Scanner input = new Scanner(System.in);
        System.out.println("Welcome to Houtou's Poop Adventure!");
        System.out.print("Please enter your character's name: ");
        String playerName = input.nextLine();
        Player player = new Player(playerName, 10, 1, 1, "You");
        System.out.println("Hello, " + player.getName() + "! Your adventure begins now.");
        System.out.println("You are currently at: " + player.getPosition().toString());
        System.out.println("Available Actions:\n\tmove [direction] - Move in a direction (north, south, east, west)\n\tlook - Look around your current location\n\tinventory - Check your inventory\n\tquit - Exit the game");
        boolean playing = true;
        while (playing) {
            System.out.print("> ");
            String command = input.nextLine().trim().toLowerCase();
            switch (command) {
                case "move":
                    System.out.println("You move to a new location.");
                    break;
                case "look":
                    lookAround(map);
                    break;
                case "inventory":
                    System.out.println("Your inventory is empty.");
                    break;
                case "quit":
                    System.out.println("Thanks for playing!");
                    input.close();
                    playing = false;
                    break;
                case "help":
                    System.out.println("Available Actions:\n\tmove [direction] - Move in a direction (north, south, east, west)\n\tlook - Look around your current location\n\tinventory - Check your inventory\n\tquit - Exit the game");
                    break;
                default:
                    System.out.println("Unknown command. Type help to see available commands.");
                    break;
            }
        }

        input.close();
    }
}
