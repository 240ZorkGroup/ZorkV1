
//package zeitz_borkv3;

import java.util.Hashtable;
import java.util.Scanner;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;

/**
 * The type Dungeon.
 */
public class Dungeon {

    /**
     * The type Illegal dungeon format exception.
     */
    public static class IllegalDungeonFormatException extends Exception {
        /**
         * Instantiates a new Illegal dungeon format exception.
         *
         * @param e the e
         */
        public IllegalDungeonFormatException(String e) {
            super(e);
        }
    }

    /**
     * The constant TOP_LEVEL_DELIM.
     */
// Variables relating to both dungeon file and game state storage.
    static String TOP_LEVEL_DELIM = "===";
    /**
     * The constant SECOND_LEVEL_DELIM.
     */
    static String SECOND_LEVEL_DELIM = "---";

    /**
     * The constant FILENAME_LEADER.
     */
// Variables relating to game state (.sav) storage.
    static String FILENAME_LEADER = "Dungeon file: ";
    /**
     * The Room states marker.
     */
    private static String ROOM_STATES_MARKER = "Room states:";

    private String name;
    private Room entry;
    private Hashtable<String,Room> rooms;
    private Hashtable<String,Item> items;
    private Hashtable<String,NPC> npcs;
    private String filename;

    /**
     * Read from the .bork filename passed, and instantiate a Dungeon object
     * based on it.
     *
     * @param filename The file you want to load from.
     * @throws FileNotFoundException         File not found
     * @throws IllegalDungeonFormatException Illegal Dungeon file format
     */
    public Dungeon(String filename) throws FileNotFoundException,
        IllegalDungeonFormatException {

        this(filename, true);
    }

    /**
     * Read from the .bork filename passed, and instantiate a Dungeon object
     * based on it, including (possibly) the items in their original locations.
     *
     * @param filename  The file you want to load from
     * @param initState true
     * @throws FileNotFoundException         File not found.
     * @throws IllegalDungeonFormatException Illegal dungeon file format
     */
    public Dungeon(String filename, boolean initState)
        throws FileNotFoundException, IllegalDungeonFormatException {

        init();
        this.filename = filename;

        Scanner s = new Scanner(new FileReader(filename));
        name = s.nextLine();

        s.nextLine();   // Throw away version indicator.

        // Throw away delimiter.
        if (!s.nextLine().equals(TOP_LEVEL_DELIM)) {
            throw new IllegalDungeonFormatException("No '" +
                TOP_LEVEL_DELIM + "' after version indicator.");
        }

        // Throw away Items starter.
        /*
      The constant ITEMS_MARKER.
     */
        String ITEMS_MARKER = "Items:";
        if (!s.nextLine().equals(ITEMS_MARKER)) {
            throw new IllegalDungeonFormatException("No '" + ITEMS_MARKER + "' line where expected.");
        }

        try {
            // Instantiate items.
            //noinspection InfiniteLoopStatement
            while (true) {
                add(new Item(s));
            }
        } catch (Item.NoItemException e) {  /* end of items */ }


        // Throw away NPCs starter.
        /*
      The constant NPCS_MARKER.
     */
        String NPCS_MARKER = "NPCs:";
        if (!s.nextLine().equals(NPCS_MARKER)) {
            throw new IllegalDungeonFormatException("No '" + NPCS_MARKER + "' line where expected.");
        }
        try {
            // Instantiate NPCs.
            //noinspection InfiniteLoopStatement
            while (true) {
                add(new NPC(s));
            }
        } catch (NPC.NoNPCException e) { /* end of NPCs */ }


        // Throw away Rooms starter.
        /*
      The constant ROOMS_MARKER.
     */
        String ROOMS_MARKER = "Rooms:";
        if (!s.nextLine().equals(ROOMS_MARKER)) {
            throw new IllegalDungeonFormatException("No '" + ROOMS_MARKER + "' line where expected.");
        }

        try {
            // Instantiate and add first room (the entry).
            entry = new Room(s, this, initState);
            add(entry);

            // Instantiate and add other rooms.
            //noinspection InfiniteLoopStatement
            while (true) {
                add(new Room(s, this, initState));
            }
        } catch (Room.NoRoomException e) {  /* end of rooms */ }

        // Throw away Exits starter.
        /*
      The constant EXITS_MARKER.
     */
        String EXITS_MARKER = "Exits:";
        if (!s.nextLine().equals(EXITS_MARKER)) {
            throw new IllegalDungeonFormatException("No '" + EXITS_MARKER + "' line where expected.");
        }

        try {
            // Instantiate exits.
            //noinspection InfiniteLoopStatement
            while (true) {
                Exit exit = new Exit(s, this);
            }
        } catch (Exit.NoExitException e) {  /* end of exits */ }

        s.close();
    }
    
    // Common object initialization tasks, regardless of which constructor
    // is used.
    private void init() {
        rooms = new Hashtable<>();
        items = new Hashtable<>();
        npcs = new Hashtable<>();
    }

    /**
     * Store state.
     *
     * @param w the w
     * @throws IOException the io exception
     */
/*
     * Store the current (changeable) state of this dungeon to the writer
     * passed.
     */
    void storeState(PrintWriter w) throws IOException {
        w.println(FILENAME_LEADER + getFilename());
        w.println(ROOM_STATES_MARKER);
        for (Room room : rooms.values()) {
            room.storeState(w);
        }
        //noinspection SuspiciousNameCombination
        w.println(TOP_LEVEL_DELIM);
    }

    /**
     * Restore state.
     *
     * @param s the s
     * @throws GameState.IllegalSaveFormatException the illegal save format exception
     */
/*
     * Restore the (changeable) state of this dungeon to that reflected in the
     * reader passed.
     */
    void restoreState(Scanner s) throws GameState.IllegalSaveFormatException {

        // Note: the filename has already been read at this point.
        
        if (!s.nextLine().equals(ROOM_STATES_MARKER)) {
            throw new GameState.IllegalSaveFormatException("No '" +
                ROOM_STATES_MARKER + "' after dungeon filename in save file.");
        }

        String roomName = s.nextLine();
        while (!roomName.equals(TOP_LEVEL_DELIM)) {
            getRoom(roomName.substring(0,roomName.length()-1)).
                restoreState(s, this);
            roomName = s.nextLine();
        }
    }

    /**
     * Gets entry.
     *
     * @return the entry
     */
    public Room getEntry() {
        return entry;
    }

    /**
     * Gets name.
     *
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Gets filename.
     *
     * @return the filename
     */
    public String getFilename() {
        return filename;
    }


    /**
     * Add.
     *
     * @param room the room
     */
    public void add(Room room) {
        rooms.put(room.getTitle(),room);
    }

    /**
     * Add.
     *
     * @param npc the npc
     */
    public void add(NPC npc) {
        npcs.put(npc.getMonsterName(),npc);
    }

    /**
     * Add.
     *
     * @param item the item
     */
    public void add(Item item) {
        items.put(item.getPrimaryName(),item);
    }

    /**
     * Remove.
     *
     * @param item the item
     */
    void remove(Item item) {
        //noinspection SuspiciousMethodCalls
        items.remove(item);
    }

    /**
     * Gets room.
     *
     * @param roomTitle the room title
     * @return the room
     */
    Room getRoom(String roomTitle) {
        return rooms.get(roomTitle);
    }

    /**
     * Get rooms hashtable.
     *
     * @return the hashtable
     */
    Hashtable<String,Room> getRooms(){
        return this.rooms;
    }

    /**
     * Get items hashtable.
     *
     * @return the hashtable
     */
    public Hashtable<String,Item> getItems(){
        return this.items;
    }

    /**
     * Get the Item object whose primary name is passed. This has nothing to
     * do with where the Adventurer might be, or what's in his/her inventory,
     * etc.
     *
     * @param primaryItemName the item name that you want to get.
     * @return item item
     * @throws Item.NoItemException the no item exception
     */
    Item getItem(String primaryItemName) throws Item.NoItemException {
        
        if (items.get(primaryItemName) == null) {
            throw new Item.NoItemException();
        }
        return items.get(primaryItemName);
    }

    /**
     * Get the NPC whose name is passed.
     *
     * @param primaryNPCName The primary name of the NPC you want to get.
     * @return NPC npc
     * @throws NPC.NoNPCException the no npc exception
     */
    NPC getNPC(String primaryNPCName) throws NPC.NoNPCException {
        if (npcs.get(primaryNPCName) == null) {
            throw new NPC.NoNPCException();
        }
        return npcs.get(primaryNPCName);
    }
}
