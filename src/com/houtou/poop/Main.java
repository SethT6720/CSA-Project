package com.houtou.poop;

import java.util.Scanner;

import com.houtou.poop.Item.Tool;
import com.houtou.poop.Location.EnterableLocation;
import com.houtou.poop.Location.Location;
import com.houtou.poop.Character.Player;

public class Main {
    private static Player player;

    public static void lookAround(Map map) {
        System.out.println("You look around and see:");
        System.out.println(map.toString());
    }

    public static void playerInventory() {

    }

    public static void move(String dir) throws IllegalArgumentException {
        Coords currentPos = player.getPosition();

        switch (dir) {
            case "north":
                if (currentPos.y > 0) {
                    currentPos.y--;
                    System.out.println(player);
                } else {
                    throw new IllegalArgumentException("There is a barrier preventing you from moving further North");
                }
                break;
            case "south":
                if (currentPos.y < player.currentMap.getHeight() - 1) {
                    currentPos.y++;
                    System.out.println(player);
                } else {
                    throw new IllegalArgumentException("There is a barrier preventing you from moving further South");
                }
                break;
            case "east":
                if (currentPos.x < player.currentMap.getWidth() - 1) {
                    currentPos.x++;
                    System.out.println(player);
                } else {
                    throw new IllegalArgumentException("There is a barrier preventing you from moving further East");
                }
                break;
            case "west":
                if (currentPos.x < 0) {
                    currentPos.x--;
                    System.out.println(player);
                } else {
                    throw new IllegalArgumentException("There is a barrier preventing you from moving further West");
                }
                break;
            default:
                throw new IllegalArgumentException("Direction provided was not recognized... Valid directions are (north, south, east, west)");
        }
    }

    public static void main(String[] args) {


        //weapons
        Tool stick = new Tool("stick", 1, "A wooden stick", "weapon", 2);
        Tool rustySword = new Tool("Rusty Sword", 6, "A sword covered in poo that caused oxidation", "weapon", 5);
        Tool ugandanClub = new Tool("Ugandan Club", 42, "Handcrafted thousand sun club of death", "weapon", 13);
        Tool godRendingDeathBlade = new Tool("God Rending Death Blade", 300, "Handcrafted blade made by the soul bonded artifact god forged with the essence of yang and death", "weapon", 25);
        Tool chineseNuke = new Tool("Chinese Nuke", 10000, "Nuke infused with the heavenly 7 elemental interaction combining each element with ruin capabilities forming an unstoppable force of nature", "weapon", 100);

        Tool filthyRags = new Tool("filthy rags", 2, "Rags covered in poo effectively reducing their effective effectiveness", "armor", 3);
        Tool poopCrustedArmor = new Tool("Poop Crusted Armor", 10, "A once great armor forged out of galvanized square steel dumped into the sewers to rot", "armor", 8);
        Tool nineYangGodLeafRobe = new Tool("Nine Yang God Leaf Robe", 120, "A robe formed from a leaf that fell from the nine yang revolving divine god tree, woven by 13 seamstresses over the course of 12 nights", "armor", 27);
        Tool tenThousandGolemHeavenlySteelMindConstruct = new Tool("Ten Thousand Golem Heavenly Steel Mind Construct", 500, "Mind construct that creates an army of 10,000 golems made entirely out of yin yang god infused heavenly steel", "armor", 81);
        Tool quintessentialGodArmor = new Tool("Quintessential God Armor", 5000, "Normally creating a Dynamis requires an [Extremity Circulation Modus Operandi], which circulates Boundary essences in harmony to produce unimaginable effects akin to one holding a Dynamis of Extremity. It is considered \"an Essence reserved for Apex Aeonic Lifeforms\" as one needed to have [Aeonic Extremity Meridians] to take the concepts (different paths of Extremity) to at least be at the 10th Boundary Layer before Convergence is possible", "armor", 150);

        Tool poo = new Tool("poo", 1, "A piece of monster fecal matter", "accessory", 1);
        Tool memoryLocket = new Tool("Memory Locket", 4, "A locket containing a picture of a simpler time", "accessory", 3);
        Tool manaCrystalBrooch = new Tool("Mana Crystal Brooch", 35, "Mythril amulet with a resonating mana crystal", "accessory", 13);
        Tool mindlessCagedSwordHeartGodRealSoul = new Tool("Mindless Caged Sword Heart God Real Soul", 350, "Caged soul of the former soul heart god who conquered the 31 diferent human and demon realms uniting them under the 7 different elements to manifest her domain. The god killing sword appeared and she had to sacrifice her creation to contain it thus ruining her mind forever", "accessory", 36);
        Tool poo2 = new Tool("2nd poo", 100000000, "Poo from the creator so is kinda valuable", "accessory", 100000);

        Map map = new Map(3, 3);
        Location startingLocation = new Location(1, 1, "Starting Tile", "The place where you woke up in this strange land");
        map.addLocation(1, 1, startingLocation);

        Scanner input = new Scanner(System.in);
        System.out.println(godRendingDeathBlade);
        System.out.println("Welcome to Houtou's Poop Adventure!");
        System.out.print("Please enter your character's name: ");
        String playerName = input.nextLine();
        player = new Player(playerName, 10, 1, 1, "You");
        player.currentMap = map;
        System.out.println("Hello, " + player.getName() + "! Your adventure begins now.");
        System.out.println("You are currently at: " + player.getPosition().toString());
        System.out.println("Type help for a list of commands");
        boolean playing = true;
        while (playing) {
            System.out.print("> ");
            String[] splitWords = input.nextLine().trim().toLowerCase().split(" ");
            String command = splitWords[0];
            switch (command) {
                case "move":
                    try {
                        if (splitWords.length > 1) {
                            move(splitWords[1]);
                        } else {
                            System.out.println("Please provide a direction to move in - (north, south, east, west)");
                        }
                    } catch (IllegalArgumentException err) {
                        System.out.println(err.getMessage());
                    }
                    break;
                case "look":
                    lookAround(map);
                    break;
                case "inspect":
                    Coords playerPosition = player.getPosition();
                    Coords currentCoords = player.currentMap.map[playerPosition.y][playerPosition.x];

                    System.out.println(currentCoords);
                    System.out.println(currentCoords.thingHere.getDescription());
                    if (currentCoords.isTileEnterable()) {
                        System.out.println("This tile is enterable");
                    } else {
                        System.out.println("This tile is not enterable");
                    }
                    break;
                case "inventory":
                    System.out.println("Your inventory is empty.");
                    break;
                case "quit":
                    System.out.println("Thanks for playing!");
                    input.close();
                    playing = false;
                    break;
                case "whereami":
                    System.out.println("You are currently at: " + player.getPosition());
                    break;
                case "help":
                    System.out.println("Available Actions:\n\tmove [direction] - Move in a direction (north, south, east, west)\n\tlook - Look around and create a map of your surroundings\n\tinspect - Inspects the your current tile\n\tinteract - Interacts with whatever is at your current tile\n\twhereami - Find your current Coordinates\n\tinventory - Check your inventory\n\tquit - Exit the game\n\thelp - Shows this screen");
                    break;
                default:
                    System.out.println("Unknown command. Type help to see available commands.");
                    break;
            }
        }

        input.close();
    }
}
