
//package zeitz_borkv3;

class ItemSpecificCommand extends Command {

    private String verb;
    private String noun;
                        

    ItemSpecificCommand(String verb, String noun) {
        this.verb = verb;
        this.noun = noun;
    }

    public String execute() {
        
        Item itemReferredTo = null;
        try {
            itemReferredTo = GameState.instance().getItemInVicinityNamed(noun);
        } catch (Item.NoItemException e) {
            return "There's no " + noun + " here.";
        }


        
        String msg = itemReferredTo.getMessageForVerb(verb);

        //TODO switch for ItemSpecificCommands
        switch (verb) {
            case "drink":
                if (noun == "DrPepper"){
                    System.out.println("This needs to transform into an EmptyCan now.");
                    //GameState.instance().transform(DrPepper,emptyCan);
                }
                break;
            //add more to it.
        }



        return (msg == null ? 
            "Sorry, you can't " + verb + " the " + noun + "." : msg) + "\n";
    }
}
