
//package zeitz_borkv3;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Hashtable;

/**
 * The type Item.
 */
public class Item {

    /**
     * The type No item exception.
     */
    static class NoItemException extends Exception {
    }

    private String primaryName;
    private int weight;
    private Hashtable<String, ArrayList<String>> events;
    private Hashtable<String, String> messages;


    /**
     * Item - added functionality of events for each specific-item command.
     *
     * @param s The scanner that reads from the file.
     * @throws NoItemException               - no more items
     * @throws Dungeon.IllegalDungeonFormatException the illegal dungeon format exception
     */
    Item(Scanner s) throws NoItemException,
            Dungeon.IllegalDungeonFormatException {

        messages = new Hashtable<String, String>();
        events = new Hashtable<String,ArrayList<String>>();

        // Read item name.
        primaryName = s.nextLine();
        if (primaryName.equals(Dungeon.TOP_LEVEL_DELIM)) {
            throw new NoItemException();
        }

        // Read item weight.
        weight = Integer.valueOf(s.nextLine());

        // Read and parse verbs lines, as long as there are more.
        String verbLine = s.nextLine();
        System.out.println(primaryName);                                                        // TODO Debug/Testing print lines.
        while (!verbLine.equals(Dungeon.SECOND_LEVEL_DELIM)) {
            if (verbLine.equals(Dungeon.TOP_LEVEL_DELIM)) {
                throw new Dungeon.IllegalDungeonFormatException("No '" + Dungeon.SECOND_LEVEL_DELIM + "' after item.");
            }


            //TODO finish the itemSpecificCommands with EVENTS.

            String[] verbParts = verbLine.split(":");                                       // Splits original string
            if (verbParts[0].contains("[")) {                                               // If there is an event for the itemSpecificCommand:
                String command = verbParts[0].substring(0, verbParts[0].indexOf("["));      // Gives the command
                messages.put(command, verbParts[1]);                                        // puts the command and verb in "messages"
                String event = verbParts[0].substring(verbParts[0].indexOf("[") + 1, verbParts[0].indexOf("]"));   // separates the event from the command

                if (event.contains(",")) {                                          // If there is more than 1 event:
                    String[] eventMessages = event.split(",");                              // Split the events up and put them in String[] "eventMessages"
                    ArrayList<String> eventsList = new ArrayList<String>();
                    for (String ele : eventMessages){                                       // for each element in String[] "eventMessages"
                        System.out.println(" - " + command + " : " + ele);                                            // TODO Debug/Testing print lines.
                        eventsList.add(ele);
                        events.put(command, eventsList);                                    // Put the command and element in the Hashtable "events" (for all elements)
                    }

                } else {
                    ArrayList<String> eventsList = new ArrayList<String>();         // If there is only one event:
                    eventsList.add(event);
                    System.out.println(" - " + command + " : " + event);                                            // TODO Debug/Testing print lines.
                    events.put(command, eventsList);                                        // Put the command and the event in Hashtable "events".
                }

            } else {                                                                // If there are no events:
                System.out.println(" - " + verbParts[0]);                                            // TODO Debug/Testing print lines.
                messages.put(verbParts[0], verbParts[1]);                                   // Put the command and message in "messages"
            }
            verbLine = s.nextLine();
        }
    }

    /**
     * Goes by boolean.
     *
     * @param name the name
     * @return the boolean
     */
    boolean goesBy(String name) {
        // could have other aliases
        return this.primaryName.equals(name);
    }

    /**
     * Gets primary name.
     *
     * @return the primary name
     */
    String getPrimaryName() {
        return primaryName;
    }

    /**
     * Gets message for verb.
     *
     * @param verb the verb
     * @return the message for verb
     */
    public String getMessageForVerb(String verb) {
        return messages.get(verb);
    }

    public String toString() {
        return primaryName;
    }

    /**
     * Gets weight.
     *
     * @return the weight
     */
    public int getWeight() {
        return weight;
    }

    /**
     * Gets event for verb.
     *
     * @param verbsWithEvents the verbs with events
     * @return the event for verb
     */
    public ArrayList<String> getEventForVerb(String verbsWithEvents) {
        return events.get(verbsWithEvents);
    }

    /**
     * Transform
     *
     * @param item Item to replace this item.
     * @throws NoItemException the no item exception
     */
    void transform(Item item) throws Item.NoItemException {
        GameState.instance().getDungeon().add(item);// dungeon   //TODO this might be wrong.
        GameState.instance().addToInventory(item); // inventory
        GameState.instance().disappear(this);
    }
}
