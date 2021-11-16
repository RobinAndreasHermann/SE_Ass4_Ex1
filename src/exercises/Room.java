package exercises;

import java.util.ArrayList;
import java.util.Scanner;


import static java.lang.System.out;

public class Room {
    protected String name;
    protected boolean lightning;
    protected ArrayList<Room> neighbours;

    public Room(String name){
        this.name = name;
    }

    public Room(String name, ArrayList<Room> neighbours){
        this.name = name;
        this.neighbours = neighbours;
    }

    public void setNeighbours(ArrayList<Room> neighbours) {
        this.neighbours = neighbours;
    }

    public String getName(){
        return this.name;
    }

    public boolean getLightning() {
        return lightning;
    }

    /**
     * lists all options the current room offers.
     */
    public void enter(){
        //as long as the user didn´t leave the room it
        do {
            printInitialText();

            switch (getUserInput(3)){
                case "1":
                    switchLight();
                    break;

                case "2":
                    //leave the current Room and return to the previous room
                    return;

                case "3":
                    enterNeighbour();
                    break;
            }
        }while(true);
    }

    /**
     * Switches the state of the light and prints the new state.
     */
    protected void switchLight(){
        lightning = !lightning;
        if (lightning){
            out.println("Switched light on.");
        }
        else{
            out.println("Switched light out.");
        }
    }

    /**
     * Lists all neighbours, asks for input and calls the chosen room.
     */
    protected void enterNeighbour(){
        printNeighbours();

        int choice = Integer.parseInt(getUserInput(neighbours.size()));
        //enter the neighbour
        neighbours.get(choice-1).enter();
    }

    /**
     * Prints the name of the current room and the option of the room.
     */
    protected void printInitialText(){
        out.println("You are in the " + name + ".");
        out.println("What do you want to do?");

        out.println("1) Switch light.");
        out.println("2) Leave room.");
        out.println("3) Enter neighbouring room.");
    }

    /**
     * Prints all neighbours of the current room.
     */
    protected void printNeighbours(){
        for (int i = 1; i<=neighbours.size(); i++){
            out.print(i + ")" );
            out.println(neighbours.get(i-1).name);
        }
    }

    /**
     * Checks if input <= maxChoice.
     * @param input The users choice.
     * @param maxChoice The max valid option the user can choose.
     * @return True, if the input <= maxChoice. Otherwise false.
     */
    protected boolean checkUserInput(String input, int maxChoice){
        int inputInt = Integer.parseInt(input);
        return inputInt > 0 && inputInt <= maxChoice;
    }

    /**
     * Asks the user to choose an option, as long as he enters a valid choice.
     * @param maxChoice The maximum choice number
     * @return The users valid choice.
     */
    protected String getUserInput(int maxChoice){
        Scanner scanner = new Scanner(System.in);

        //check user input
        boolean correctInput = false;
        String input = "";
        do {
            try {
                input = scanner.nextLine();
                correctInput = checkUserInput(input, maxChoice);
            //catch input that is no integer
            } catch (NumberFormatException e) {
                out.println("Please enter a valid number");
            }
        }while(!correctInput);

        return input;
    }

}
