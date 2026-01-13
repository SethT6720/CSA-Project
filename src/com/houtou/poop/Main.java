package com.houtou.poop;

import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;

import com.houtou.poop.Character.Enemy;
import com.houtou.poop.Item.Item;
import com.houtou.poop.Item.Tool;
import com.houtou.poop.Location.EnterableLocation;
import com.houtou.poop.Location.Location;
import com.houtou.poop.Character.Player;

public class Main {
    private static Player player;
    private static Scanner input;

    public static void lookAround(Map map) {
        System.out.println("You look around and see:");
        System.out.println(map.toString());
    }

    public static void playerInventory() {
        System.out.println(player.inventoryToString());
    }

    public static void checkPlayerEquips() {
        System.out.println(player.checkEquips());
    }

    public static void equipPlayer(String equipType) throws IllegalArgumentException {
        boolean validEquipType = (Objects.equals(equipType, "weapon") || Objects.equals(equipType, "armor") || Objects.equals(equipType, "accessory"));

        if (validEquipType) {
            boolean alreadyEquipped = player.equippedItems.stream().anyMatch(item -> Objects.equals(item.getType(), equipType));

            if (!alreadyEquipped) {
                Tool[] allItemsOfType = player.inventory.stream().filter(tool -> Objects.equals(tool.getType(), equipType)).toArray(Tool[]::new);
                System.out.println("Which of the following " + equipType + "(s) would you like to equip?");
                for (int i = 0; i < allItemsOfType.length; i++) {
                    System.out.println("\t[" + (i + 1) + "] - " + allItemsOfType[i].getName());
                }
                System.out.print("Enter choice...\n> ");
                int choice = input.nextInt();

                while (choice < 1 || choice > allItemsOfType.length) {
                    System.out.print("Entered choice was not one of the listed options. Please enter a valid selection...\n> ");
                    choice = input.nextInt();
                }
                input.nextLine();

                player.equipItem(allItemsOfType[choice - 1]);
            } else {
                System.out.println("Player already was a(n) " + equipType + " equipped. Would you like to unequip it an equip a new " + equipType + " instead? [y/n]");
                System.out.print("> ");
                String choice = input.nextLine().trim().toLowerCase();

                while (!(Objects.equals(choice, "y") || Objects.equals(choice, "n"))) {
                    System.out.println("Choice inputted was not a valid choice. Please input a valid choice [y/n]");
                    System.out.print("> ");
                    choice = input.nextLine().trim().toLowerCase();
                }

                switch (choice) {
                    case "y":
                        player.unequipItem(equipType);
                        equipPlayer(equipType);
                        break;
                    case "n":
                        break;
                }
            }
        } else {
            throw new IllegalArgumentException("Provided equip type was not a valid type. Please try again with a valid equip type (weapon, armor, accessory)");
        }
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
                if (currentPos.x > 0) {
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

    public static void fight(Enemy enemy) {
        System.out.println("An " + enemy.getName() + " appears!");
        boolean inCombat = true;
        int enemyhp = enemy.getHealth();
        int enemydef = enemy.getDefense();
        int enemystr = enemy.getStrength();

        int playerhp = player.getHealth();
        int playerdef = player.getDefense();
        int playerstr = player.getStrength();

        while (inCombat) {
            System.out.printf("HP: %s\t Def: %s\nStr: %s\n", enemy.getHealth(), enemy.getDefense(), enemy.getStrength());
            System.out.printf("\nYour Stats:\nHP: %s\tDef: %s\nStr: %s\n", player.getHealth(), player.getDefense(), player.getStrength());

            System.out.println("What would you like to do?\n[1] - Attack\nEnter Choice: ");
            int selectedInput = input.nextInt();
            input.nextLine();
            if (selectedInput != 1) {
                System.out.print("You inputted [1] - attack, Correct?\nY/N\nEnter choice: ");
                input.nextLine();
                System.out.println("Perfect, thank you for choosing to attack of your own free will :)");
            }

            enemyhp -= playerstr - enemydef;
            if (enemyhp <= 0) {

            }
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


        //MAPS


        Map map = new Map(3, 3);
        Location startingLocation = new Location(1, 1, "Starting Tile", "The place where you woke up in this strange land");
        map.addLocation(1, 1, startingLocation);

        EnterableLocation bog = new EnterableLocation(2, 2, "THE BOG :o", "A moist land full of medium creatures, when expeditioners hear the name they shake with fear, only known as...THE BOG ;(", 2, 2);
        map.addLocation(2, 2, bog);

        EnterableLocation temperateShrublands = new EnterableLocation(1, 0, "THE TEMPERATE SHRUBLANDS", "Not too hot, not too cool, but just temperate...shurblands.", 3, 2);
        map.addLocation(1, 0, temperateShrublands);

        EnterableLocation village = new EnterableLocation(0,1, "Poop Village", "A village,built by poop, powered by poop", 2, 2);
        map.addLocation(0, 1, village);

        EnterableLocation pizzaria = new EnterableLocation(0,2, "Abandoned pizzaria", "An old abandoned pizzaria full of animal like robotics, you can tell a purple man used to reside in the hallways.", 2, 2);
        map.addLocation(0, 2, pizzaria);

        EnterableLocation space = new EnterableLocation(0,0, "Outer space", "An endless (almost its still 2x2) void", 2, 2);
        map.addLocation(0, 0, space);

        EnterableLocation venezuela = new EnterableLocation(2,1, "Venezuela", "weird politics but still an awesome country", 2, 2);
        map.addLocation(2, 1, venezuela);

        EnterableLocation gourmetWorld = new EnterableLocation(2,0, "Gourmet World", "A world made from the gourmet cells that landed on the planet 3 billion years ago boasting numerous gourmet ingredients.", 2, 2);
        map.addLocation(2, 0, gourmetWorld);

        EnterableLocation center = new EnterableLocation(1,2, "Venezuela 2 (the center of the earth)", "Area zero for the meteorite that brought gourmet cells to the world. Every ingredient comes from the pure 100% diary free gourmet cells found here.", 2, 2);
        map.addLocation(1, 2, center);

        input = new Scanner(System.in);
        System.out.println(godRendingDeathBlade);
        System.out.println("Welcome to Houtou's Poop Adventure!");
        System.out.print("Please enter your character's name: ");
        String playerName = input.nextLine();
        player = new Player(playerName, 10, 1, 1, "You", 1, 1);
        player.currentMap = map;
        player.inventory.add(stick);
        player.inventory.add(rustySword);
        player.inventory.add(godRendingDeathBlade);

        player.inventory.add(filthyRags);
        player.inventory.add(poopCrustedArmor);
        player.inventory.add(quintessentialGodArmor);

        player.inventory.add(poo);
        player.inventory.add(manaCrystalBrooch);
        player.inventory.add(poo2);


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
                    playerInventory();
                    break;
                case "check-equips":
                    checkPlayerEquips();
                    break;
                case "equip":
                    try {
                        if (splitWords.length > 1) {
                            equipPlayer(splitWords[1]);
                        } else {
                            System.out.println("Please provide an item to equip");
                        }
                    } catch (IllegalArgumentException err) {
                        System.out.println(err.getMessage());
                    }
                    break;
                case "unequip":
                    String equipType = splitWords[1];
                    boolean validEquipType = (Objects.equals(equipType, "weapon") || Objects.equals(equipType, "armor") || Objects.equals(equipType, "accessory"));
                    if (validEquipType) {
                        player.unequipItem(equipType);
                        System.out.println(equipType + " unequipped");
                    } else {
                        System.out.println("Tool type inputted was not a valid type. Please provide a valid type (weapon, armor, accessory).");
                    }
                    break;
                case "quit":
                    System.out.println("Thanks for playing!");
                    input.close();
                    playing = false;
                    break;
                case "whereami":
                    System.out.println("You are currently at: " + player.getPosition());
                    break;
                case "fight":
                    fight(new Enemy("ene", 10, 0, 0, "blank", 1, 1));
                    break;
                case "help":
                    System.out.println("Available Actions:\n\tmove [direction] - Move in a direction (north, south, east, west)\n\tlook - Look around and create a map of your surroundings\n\tinspect - Inspects the your current tile\n\tinteract - Interacts with whatever is at your current tile\n\twhereami - Find your current Coordinates\n\tinventory - Check your inventory\n\tequip [item-type] - Equips an item to the corresponding slot (weapon, armor, accessory)\n\tunequip [item-type] - Unequips the item at the corresponding slot (weapon, armor, accessory)\n\tcheck-equips - Prints a list of your currently equipped items\n\tquit - Exit the game\n\thelp - Shows this screen");
                    break;
                default:
                    System.out.println("Unknown command. Type help to see available commands.");
                    break;
            }
        }

        input.close();
    }
}


/*
Equip and unequip is mostly working
Nate you need to fix equip so that you can equip armor/accessory without needing a weapon equipped. Problem with indexes and accessing ones without something in the previous one
Potentially also a problem with the list mixing up weapon and armor slots after unequipping a weapon with armor still equipped
my recommendation would prob be to populate the list with three null values, then just replace those when equipping things
and replacing the item with null when unequipping things

I think the only thing really left to do is to work on combat
 */