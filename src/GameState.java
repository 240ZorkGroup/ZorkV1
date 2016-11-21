
//package zeitz_borkv3;

import java.time.LocalDateTime;
import java.util.Scanner;
import java.util.ArrayList;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;

/**
 * GameState - Keeps track of the current state of the game.
 *
 * @author Billy Andrews, Maryfay Jackson, Kelly Morgan
 * @version 20161107
 */
public class GameState {

    /**
     * The type Illegal save format exception.
     */
    public static class IllegalSaveFormatException extends Exception {
        /**
         * Instantiates a new Illegal save format exception.
         *
         * @param e the e
         */
        public IllegalSaveFormatException(String e) {
            super(e);
        }
    }

    /**
     * Time of day - 0 = day / 1 = night
     */
    static boolean dayTime;
    /**
     *  Movement Counter - counts the amounts of movement commands given. Used to set the time of day.
     */
    /**
     * The Default save file.
     */
    static String DEFAULT_SAVE_FILE = "bork_save";
    /**
     * The Save file extension.
     */
    static String SAVE_FILE_EXTENSION = ".sav";
    /**
     * The Save file version.
     */
    static String SAVE_FILE_VERSION = "Bork v3.0 save data";

    /**
     * The Adventurer marker.
     */
    static String ADVENTURER_MARKER = "Adventurer:";
    /**
     * The Current room leader.
     */
    static String CURRENT_ROOM_LEADER = "Current room: ";
    /**
     * The Inventory leader.
     */
    static String INVENTORY_LEADER = "Inventory: ";
    /**
     * The Score leader.
     */
    static String SCORE_LEADER = "Score: ";
    /**
     * The Health leader.
     */
    static String HEALTH_LEADER = "Health: ";
    /**
     * The Score.
     */
    static int score = 0;
    /**
     * The Health.
     */
    static int health = 100;

    private static GameState theInstance;
    private Dungeon dungeon;
    private ArrayList<Item> inventory;
    private Room adventurersCurrentRoom;


    /**
     * The Instance.
     *
     * @return GameState theInstance - returns the current state of the game, including room, inventory, etc.
     */
    static synchronized GameState instance() {
        if (theInstance == null) {
            theInstance = new GameState();
        }
        return theInstance;
    }

    /**
     * Constructor for GameState provides the player with a new empty inventory.
     */
    private GameState() {
        inventory = new ArrayList<Item>();
    }

    /**
     * restore
     *
     * @param filename - denotes which file the game should read from (.bork or .sav)
     * @throws FileNotFoundException                 - file not found
     * @throws IllegalSaveFormatException            - illegal save format
     * @throws Dungeon.IllegalDungeonFormatException the illegal dungeon format exception
     */
    void restore(String filename) throws FileNotFoundException,
            IllegalSaveFormatException, Dungeon.IllegalDungeonFormatException {

        Scanner s = new Scanner(new FileReader(filename));

        if (!s.nextLine().equals(SAVE_FILE_VERSION)) {
            throw new IllegalSaveFormatException("Save file not compatible.");
        }

        String dungeonFileLine = s.nextLine();

        if (!dungeonFileLine.startsWith(Dungeon.FILENAME_LEADER)) {
            throw new IllegalSaveFormatException("No '" + Dungeon.FILENAME_LEADER + "' after version indicator.");
        }

        dungeon = new Dungeon(dungeonFileLine.substring(
                Dungeon.FILENAME_LEADER.length()), false);
        dungeon.restoreState(s);

        s.nextLine();  // Throw away "Adventurer:".
        String currentRoomLine = s.nextLine();
        adventurersCurrentRoom = dungeon.getRoom(
                currentRoomLine.substring(CURRENT_ROOM_LEADER.length()));
        if (s.hasNext()) {
            String inventoryList = s.nextLine().substring(
                    INVENTORY_LEADER.length());
            String[] inventoryItems = inventoryList.split(",");
            for (String itemName : inventoryItems) {
                try {
                    addToInventory(dungeon.getItem(itemName));
                } catch (Item.NoItemException e) {
                    throw new IllegalSaveFormatException("No such item '" + itemName + "'");
                }
            }
        }
        if (s.hasNext()) { // SCORE
            String number = s.nextLine().substring(SCORE_LEADER.length());
            ;
            this.score = Integer.parseInt(number);
        }
        if (s.hasNext()) { // HEALTH
            String number = s.nextLine().substring(HEALTH_LEADER.length());
            ;
            this.health = Integer.parseInt(number);
        }
    }

    /**
     * store - Saves the game's progress
     *
     * @throws IOException - Thrown if the game cannot save.
     */
    void store() throws IOException {
        store(DEFAULT_SAVE_FILE);
    }

    /**
     * store - Saves the game's progress.
     *
     * @param saveName - the filename
     * @throws IOException - thrown if the game cannot save.
     */
    void store(String saveName) throws IOException {
        String filename = saveName + SAVE_FILE_EXTENSION;
        PrintWriter w = new PrintWriter(new FileWriter(filename));
        w.println(SAVE_FILE_VERSION);
        dungeon.storeState(w);
        w.println(ADVENTURER_MARKER);
        w.println(CURRENT_ROOM_LEADER + adventurersCurrentRoom.getTitle());
        if (inventory.size() > 0) {
            w.print(INVENTORY_LEADER);
            for (int i = 0; i < inventory.size() - 1; i++) {
                w.print(inventory.get(i).getPrimaryName() + ",");
            }
            w.println(inventory.get(inventory.size() - 1).getPrimaryName());
        }
        w.println(SCORE_LEADER + this.score);
        w.println(HEALTH_LEADER + this.health);
        //TODO add Health and Score to write file.
        w.close();
    }

    /**
     * Initialize.
     *
     * @param dungeon the dungeon
     */
    void initialize(Dungeon dungeon) {
        this.dungeon = dungeon;
        adventurersCurrentRoom = dungeon.getEntry();
    }

    /**
     * Gets inventory names.
     *
     * @return the inventory names
     */
    ArrayList<String> getInventoryNames() {
        ArrayList<String> names = new ArrayList<String>();
        for (Item item : inventory) {
            names.add(item.getPrimaryName());
        }
        return names;
    }

    /**
     * Add to inventory.
     *
     * @param item the item
     */
    void addToInventory(Item item) /* throws TooHeavyException */ {
        inventory.add(item);
    }

    /**
     * Remove from inventory.
     *
     * @param item the item
     */
    void removeFromInventory(Item item) {
        inventory.remove(item);
    }

    /**
     * Gets item in vicinity named.
     *
     * @param name the name
     * @return the item in vicinity named
     * @throws Item.NoItemException the no item exception
     */
    Item getItemInVicinityNamed(String name) throws Item.NoItemException {

        // First, check inventory.
        for (Item item : inventory) {
            if (item.goesBy(name)) {
                return item;
            }
        }

        // Next, check room contents.
        for (Item item : adventurersCurrentRoom.getContents()) {
            if (item.goesBy(name)) {
                return item;
            }
        }

        throw new Item.NoItemException();
    }

    /**
     * Gets item from inventory named.
     *
     * @param name the name
     * @return the item from inventory named
     * @throws Item.NoItemException the no item exception
     */
    Item getItemFromInventoryNamed(String name) throws Item.NoItemException {

        for (Item item : inventory) {
            if (item.goesBy(name)) {
                return item;
            }
        }
        throw new Item.NoItemException();
    }

    /**
     * Gets adventurers current room.
     *
     * @return the adventurers current room
     */
    Room getAdventurersCurrentRoom() {
        return adventurersCurrentRoom;
    }

    /**
     * Sets adventurers current room.
     *
     * @param room the room
     */
    void setAdventurersCurrentRoom(Room room) {
        adventurersCurrentRoom = room;
    }

    /**
     * Gets dungeon.
     *
     * @return the dungeon
     */
    Dungeon getDungeon() {
        return dungeon;
    }

    /**
     * getHealth - Retrieves the player's current health points, based on a 0-100 scale.
     *
     * @return the player's health points.
     */
    int getHealth() {
        return health;
    }

    /**
     * depleteHunger - As the player traverses the dungeon, his hunger takes a toll and subtracts 1 point per movement command.
     */
    void depleteHunger() {
        health = health - 1;
    }

    /**
     * setHealth - Sets the player's health.
     *
     * @param healthPoints the amount of health points to be added. Can be negative to subtract points.
     */
    void setHealth(int healthPoints) {
        this.health = health + healthPoints;
    }

    /**
     * getScore - Retrieves the player's current score.
     *
     * @return returns the score
     */
    int getScore() {
        return score;
    }

    /**
     * setScore - Sets the player's score.
     *
     * @param points the amount of points to be added. Can be negative to subtract points.
     */
    void setScore(int points) {
        this.score = score + points;
    }


    /**
     * Wound
     * Wounds the player's health. If the player's health gets too low, they will die.
     *
     * @param hp the number of points to deduct from the player's health. Using a negative number will "heal" the player.
     */
    void wound(int hp) { //TODO Something weird going on with this. It takes away health when it's supposed to add. Making it add makes it not work correctly.
        setHealth(hp);
        if (health <= 0) {
            die();
        }
    }

    /**
     * Die
     * The player loses and the game ends.
     */
    void die() {
        System.out.println("YOU LOST!");
        System.out.println("GAME OVER");
        System.exit(0);
    }

    /**
     * Win
     * The player wins and the game ends.
     */
    void win() {
        System.out.println("YOU WON!");
        System.out.println("GAME OVER");
        System.exit(0);
    }


    /**
     * Disappear
     * Makes an item cease to exist by removing it from the room, inventory, and dungeon.
     *
     * @param item will be deleted globally.
     * @throws Item.NoItemException the no item exception
     */
    void disappear(Item item) throws Item.NoItemException {
        inventory.remove(item); // inventory
        getAdventurersCurrentRoom().remove(item);// room
        dungeon.remove(item);// dungeon
    }


    /**
     * Teleport
     * Sets the adventurers current room to a random room generated by the Dungeon class.
     */
    void teleport() {
        setAdventurersCurrentRoom(dungeon.getRandomRoom());

    }

    /**
     * getTimeOfDay
     *
     * @return TimeOfDay. false = night-time / true = day-time.
     */
    boolean getTimeOfDay() {
        return dayTime;
    }

    /**
     * changeTimeOfDay
     */
    void changeTimeOfDay() {
        if (dayTime == false) {
            System.out.println("It is now day-time outside.");
            dayTime = true;
        } else if (dayTime == true) {
            System.out.println("It is now night-time outside.");
            dayTime = false;
        }
    }

}
