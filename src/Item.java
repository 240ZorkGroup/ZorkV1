
//package zeitz_borkv3;

import java.util.Scanner;
import java.util.Hashtable;

public class Item {

    static class NoItemException extends Exception {}

    private String primaryName;
    private int weight;
    private Hashtable<String,Hashtable<String,String>> premessages;
    private Hashtable<String,String> messages;


    /**
     * Item - added functionality of events for each specific-item command.
     * @param s The scanner that reads from the file.
     * @throws NoItemException - no more items
     * @throws Dungeon.IllegalDungeonFormatException - illegal dungeon format
     */
    Item(Scanner s) throws NoItemException,
        Dungeon.IllegalDungeonFormatException {

        messages = new Hashtable<String,String>();

        // Read item name.
        primaryName = s.nextLine();
        if (primaryName.equals(Dungeon.TOP_LEVEL_DELIM)) {
            throw new NoItemException();
        }

        // Read item weight.
        weight = Integer.valueOf(s.nextLine());

        // Read and parse verbs lines, as long as there are more.
        String verbLine = s.nextLine();
        while (!verbLine.equals(Dungeon.SECOND_LEVEL_DELIM)) {
            if (verbLine.equals(Dungeon.TOP_LEVEL_DELIM)) {
                throw new Dungeon.IllegalDungeonFormatException("No '" + Dungeon.SECOND_LEVEL_DELIM + "' after item.");
            }

            //TODO finish the itemSpecificCommands with EVENTS
            String[] verbParts = verbLine.split(":");                                       // Splits original string
            if (verbParts[0].contains("[")) {
                String command = verbParts[0].substring(0, verbParts[0].indexOf("["));      // Gives the command
                messages.put(command,verbParts[1]);                                         // puts the command and verb in messages
                String event = verbParts[0].substring(verbParts[0].indexOf("[")+1, verbParts[0].indexOf("]"));          // separates the events [] from the command
                if (event.contains(",")) {                                                  // splits the events if there are more than 1
                    String[] events = event.split(",");
                    for (String ele : events){
                        System.out.println(ele);                                            //TODO Debug/testing Print lines
                        //messages.put(command,event);
                    }
                } else {
                    System.out.println(event);                                              //TODO debug/testing print lines.
                    //messages.put(command,event);
                }
            } else {
                messages.put(verbParts[0],verbParts[1]);
            }
            verbLine = s.nextLine();
        }
    }

    boolean goesBy(String name) {
        // could have other aliases
        return this.primaryName.equals(name);
    }

    String getPrimaryName() { return primaryName; }

    public String getMessageForVerb(String verb) {
        return messages.get(verb);
    }

    public String toString() {
        return primaryName;
    }

    public int getWeight(){
        return weight;
    }
}
