
//package zeitz_borkv3;

import java.util.Scanner;

/**
 * The type Exit.
 */
public class Exit {

    /**
     * The type No exit exception.
     */
    class NoExitException extends Exception {}

    private String dir;
    private Room src, dest;

    /**
     * Instantiates a new Exit.
     *
     * @param dir  the dir
     * @param src  the src
     * @param dest the dest
     */
    Exit(String dir, Room src, Room dest) {
        init();
        this.dir = dir;
        this.src = src;
        this.dest = dest;
        src.addExit(this);
    }

    /**
     * Given a Scanner object positioned at the beginning of an "exit" file
     * entry, read and return an Exit object representing it.
     *
     * @param s Scanner to read everything in.
     * @param d The dungeon that contains this exit (so that Room objects may be obtained.)
     * @throws NoExitException               The reader object is not positioned at thestart of an exit entry. A side effect of this is the reader's cursoris now positioned one line past where it was.
     * @throws Dungeon.IllegalDungeonFormatException the illegal dungeon format exception
     */
    Exit(Scanner s, Dungeon d) throws NoExitException,
        Dungeon.IllegalDungeonFormatException {

        init();
        String srcTitle = s.nextLine();
        if (srcTitle.equals(Dungeon.TOP_LEVEL_DELIM)) {
            throw new NoExitException();
        }
        src = d.getRoom(srcTitle);
        dir = s.nextLine();
        dest = d.getRoom(s.nextLine());
        
        // I'm an Exit object. Great. Add me as an exit to my source Room too,
        // though.
        src.addExit(this);

        // throw away delimiter
        if (!s.nextLine().equals(Dungeon.SECOND_LEVEL_DELIM)) {
            throw new Dungeon.IllegalDungeonFormatException("No '" +
                Dungeon.SECOND_LEVEL_DELIM + "' after exit.");
        }
    }

    // Common object initialization tasks.
    private void init() {
    }

    /**
     * Describe string.
     *
     * @return the string
     */
    String describe() {
        return "You can go " + dir + " to " + dest.getTitle() + ".";
    }

    /**
     * Gets dir.
     *
     * @return the dir
     */
    String getDir() { return dir; }

    /**
     * Gets src.
     *
     * @return the src
     */
    Room getSrc() { return src; }

    /**
     * Gets dest.
     *
     * @return the dest
     */
    Room getDest() { return dest; }
}
