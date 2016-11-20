
//package zeitz_borkv3;

import java.util.ArrayList;
import java.util.Scanner;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * The type Room.
 */
public class Room {

    /**
     * The type No room exception.
     */
    class NoRoomException extends Exception {
    }

    /**
     * The Contents starter.
     */
    static String CONTENTS_STARTER = "Contents: ";
    /**
     * The Npcs starter.
     */
    static String NPCS_STARTER = "NPC: ";

    private String title;
    private String desc;
    private boolean beenHere;
    private ArrayList<Item> contents;
    private ArrayList<Exit> exits;
    private ArrayList<NPC> npcs;

    /**
     * Instantiates a new Room.
     *
     * @param title the title
     */
    Room(String title) {
        init();
        this.title = title;
    }

    /**
     * Instantiates a new Room.
     *
     * @param s the s
     * @param d the d
     * @throws NoRoomException                       the no room exception
     * @throws Dungeon.IllegalDungeonFormatException the illegal dungeon format exception
     */
    Room(Scanner s, Dungeon d) throws NoRoomException,
            Dungeon.IllegalDungeonFormatException {

        this(s, d, true);
    }

    /**
     * Given a Scanner object positioned at the beginning of a "room" file
     * entry, read and return a Room object representing it.
     *
     * @param s         scanner
     * @param d         dungeon
     * @param initState initState
     * @throws NoRoomException                       the no room exception
     * @throws Dungeon.IllegalDungeonFormatException the illegal dungeon format exception
     */
    Room(Scanner s, Dungeon d, boolean initState) throws NoRoomException,
            Dungeon.IllegalDungeonFormatException {

        init();
        title = s.nextLine();
        desc = "";
        if (title.equals(Dungeon.TOP_LEVEL_DELIM)) {
            throw new NoRoomException();
        }

        String lineOfDesc = s.nextLine();
        while (!lineOfDesc.equals(Dungeon.SECOND_LEVEL_DELIM) &&
                !lineOfDesc.equals(Dungeon.TOP_LEVEL_DELIM)) {

            if (lineOfDesc.startsWith(CONTENTS_STARTER)) {
                String itemsList = lineOfDesc.substring(CONTENTS_STARTER.length());
                String[] itemNames = itemsList.split(",");
                for (String itemName : itemNames) {
                    try {
                        if (initState) {
                            add(d.getItem(itemName));
                        }
                    } catch (Item.NoItemException e) {
                        throw new Dungeon.IllegalDungeonFormatException(
                                "No such item '" + itemName + "'");
                    }
                }
            }
            if (lineOfDesc.startsWith(NPCS_STARTER)) {
                String npcList = lineOfDesc.substring(NPCS_STARTER.length());
                String[] npcNames = npcList.split(",");
                for (String npcName : npcNames) {
                    try {
                        if (initState) {
                            add(d.getNPC(npcName));
                        }
                    } catch (NPC.NoNPCException e) {
                        throw new Dungeon.IllegalDungeonFormatException("No such NPC '" + npcName + "'");
                    }
                }
            } else {
                desc += lineOfDesc + "\n";
            }
            lineOfDesc = s.nextLine();
        }

        // throw away delimiter
        if (!lineOfDesc.equals(Dungeon.SECOND_LEVEL_DELIM)) {
            throw new Dungeon.IllegalDungeonFormatException("No '" +
                    Dungeon.SECOND_LEVEL_DELIM + "' after room.");
        }
    }

    // Common object initialization tasks.
    private void init() {
        contents = new ArrayList<Item>();
        exits = new ArrayList<Exit>();
        npcs = new ArrayList<NPC>();
        beenHere = false;
    }

    /**
     * Gets title.
     *
     * @return the title
     */
    String getTitle() {
        return title;
    }

    /**
     * Sets desc.
     *
     * @param desc the desc
     */
    void setDesc(String desc) {
        this.desc = desc;
    }

    /**
     * Store state.
     *
     * @param w the w
     * @throws IOException the io exception
     */
/*
     * Store the current (changeable) state of this room to the writer
     * passed.
     */
    void storeState(PrintWriter w) throws IOException {
        w.println(title + ":");
        w.println("beenHere=" + beenHere);
        if (contents.size() > 0) { // Room Contents
            w.print(CONTENTS_STARTER);
            for (int i = 0; i < contents.size() - 1; i++) {
                w.print(contents.get(i).getPrimaryName() + ",");
            }
            w.println(contents.get(contents.size() - 1).getPrimaryName());
        }
        if (npcs.size() > 0) { // NPCs in Room
            w.print(NPCS_STARTER);
            for (int i = 0; i < npcs.size() - 1; i++) {
                w.print(npcs.get(i).getMonsterName() + ",");
            }
            w.println(npcs.get(npcs.size() - 1));
        }
        w.println(Dungeon.SECOND_LEVEL_DELIM);
    }

    /**
     * Restore state.
     *
     * @param s the s
     * @param d the d
     * @throws GameState.IllegalSaveFormatException the illegal save format exception
     */
    void restoreState(Scanner s, Dungeon d) throws
            GameState.IllegalSaveFormatException {

        String line = s.nextLine();
        if (!line.startsWith("beenHere")) {
            throw new GameState.IllegalSaveFormatException("No beenHere.");
        }
        beenHere = Boolean.valueOf(line.substring(line.indexOf("=") + 1));

        line = s.nextLine();
        if (line.startsWith(CONTENTS_STARTER)) {
            String itemsList = line.substring(CONTENTS_STARTER.length());
            String[] itemNames = itemsList.split(",");
            for (String itemName : itemNames) {
                try {
                    add(d.getItem(itemName));
                } catch (Item.NoItemException e) {
                    throw new GameState.IllegalSaveFormatException("No such item '" + itemName + "'");
                }
            }
            s.nextLine();  // Consume "---".
        }
        if (line.startsWith(NPCS_STARTER)) {
            String npcsList = line.substring(NPCS_STARTER.length());
            String[] npcsNames = npcsList.split(",");
            for (String npcsName : npcsNames) {
                try {
                    add(d.getNPC(npcsName));
                } catch (NPC.NoNPCException e) {
                    throw new GameState.IllegalSaveFormatException("No such NPC '" + npcsName + "'");
                }
            }
            s.nextLine();  // Consume "---".
        }
    }

    /**
     * Describe string.
     *
     * @return the string
     */
    public String describe() {
        String description;
        if (beenHere) {
            description = title;
        } else {
            description = title + "\n" + desc;
        }

        for (Item item : contents) {
            description += "\nThere is a " + item.getPrimaryName() + " here.";
        }

        if (contents.size() > 0) {
            description += "\n";
        }

        for (NPC npc : npcs) {
            description += "\n" + npc.getMonsterName() + " is in here. You can speak to it.";
        }

        if (npcs.size() > 0) {
            description += "\n";
        }

        if (VerboseCommand.verboseToggle) {
            for (Exit exit : exits) {
                description += "\n" + exit.describe();
            }
        }


        beenHere = true;
        return description;
    }


    /**
     * Leave by room.
     *
     * @param dir the dir
     * @return the room
     */
    public Room leaveBy(String dir) {
        for (Exit exit : exits) {
            if (exit.getDir().equals(dir)) {
                return exit.getDest();
            }
        }
        return null;
    }

    /**
     * Add exit.
     *
     * @param exit the exit
     */
    void addExit(Exit exit) {
        exits.add(exit);
    }

    /**
     * Add.
     *
     * @param item the item
     */
    void add(Item item) {
        contents.add(item);
    }

    /**
     * Add.
     *
     * @param npc the npc
     */
    void add(NPC npc) {
        npcs.add(npc);
    }

    /**
     * Remove.
     *
     * @param item the item
     */
    void remove(Item item) {
        contents.remove(item);
    }

    /**
     * Gets item named.
     *
     * @param name the name
     * @return the item named
     * @throws Item.NoItemException the no item exception
     */
    Item getItemNamed(String name) throws Item.NoItemException {
        for (Item item : contents) {
            if (item.goesBy(name)) {
                return item;
            }
        }
        throw new Item.NoItemException();
    }

    /**
     * Gets npc named.
     *
     * @param name the name
     * @return the npc named
     * @throws NPC.NoNPCException the no npc exception
     */
    NPC getNPCNamed(String name) throws NPC.NoNPCException {
        for (NPC npc : npcs) {
            if (npc.goesBy(name)) {
                return npc;
            }
        }
        throw new NPC.NoNPCException();
    }

    /**
     * Gets np cs.
     *
     * @return the np cs
     */
    ArrayList<NPC> getNPCs() {
        return npcs;
    }

    /**
     * Gets contents.
     *
     * @return the contents
     */
    ArrayList<Item> getContents() {
        return contents;
    }
}
