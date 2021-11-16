package exercises;

import java.util.ArrayList;

import static java.lang.System.out;

public class Kitchen extends Room{
    protected boolean stove;

    public Kitchen(){
        super("Kitchen");
        stove = false;
    }
    public Kitchen(ArrayList<Room> neighbours){
        super("Kitchen", neighbours);
        stove = false;
    }

    public boolean getStove() {
        return stove;
    }

    public void switchStove(){
        stove = !stove;
        if (stove){
            out.println("Switched stove on.");
        }
        else{
            out.println("Switched stove out.");
        }
    }

    /**
     * lists all options the kitchen offers.
     */
    @Override
    public void enter() {
        //as long as the user didn´t leave the room it
        do {
            printInitialText();
            //attach 4th option
            out.println("4) Switch stove.");

            switch (getUserInput(4)){
                case "1":
                    switchLight();
                    break;

                case "2":
                    //leave the current Room and return to the previous room
                    return;

                case "3":
                    enterNeighbour();
                    break;
                case "4":
                    switchStove();
                    break;
            }
        }while(true);
    }
}
