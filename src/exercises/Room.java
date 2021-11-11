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

    protected void switchLight(){
        lightning = !lightning;
        if (lightning){
            out.println("Switched light on.");
        }
        else{
            out.println("Switched light out.");
        }
    }

    protected void enterNeighbour(){
        printNeighbours();

        int choice = Integer.parseInt(getUserInput(neighbours.size()));
        //enter the neighbour
        neighbours.get(choice-1).enter();
    }

    protected void printInitialText(){
        out.println("You are in the " + name + ".");
        out.println("What do you want to do?");



        //option 1 to switch lights
        //option 2 to leave the current room
        //option 3 to enter neighbour room
        //option 4 (if current room is kitchen or bathroom) switch stove/shower

        out.println("1) Switch light.");
        out.println("2) Leave room.");
        out.println("3) Enter neighbouring room.");
    }

    protected void printNeighbours(){
        for (int i = 1; i<=neighbours.size(); i++){
            out.print(i + ")" );
            out.println(neighbours.get(i-1).name);
        }
    }

    protected boolean checkUserInput(String input, int maxChoice){
        boolean result = false;

        for (int i = 1; i<=maxChoice; i++){
            if (Integer.parseInt(input) <= maxChoice){
                return true;
            }
        }
        return false;
    }

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
                out.println("Please enter valid number");
            }
        }while(!correctInput);

        return input;
    }

}
