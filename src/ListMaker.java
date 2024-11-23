import java.util.ArrayList;
import java.util.Scanner;

public class ListMaker {
    public static void main(String[] args) {
        boolean runStatus = true;
        ArrayList<String> myArrList = new ArrayList<>();
        do {
            System.out.println("A – Add an item to the list");
            System.out.println("D – Delete an item from the list");
            System.out.println("I – Insert an item into the list");
            System.out.println("P – Print (i.e. display) the list");
            System.out.println("Q – Quit the program");
            Scanner in = new Scanner(System.in);
            String input = SafeInput.getNonZeroLenString(in, "Please make a selection");
            switch (input) {
                case "A", "a":
                    String newItem = SafeInput.getNonZeroLenString(in, "What string would you like to insert?");
                    myArrList.add(newItem);
                    break;
                case "D", "d":
                    int arrSelect = SafeInput.getRangedInt(in,"What array item would you like to delete?", -1, myArrList.size());
                    myArrList.remove(arrSelect);
                    break;
                case "I", "i":
                    int insertLoc = SafeInput.getRangedInt(in, "Where would you like to insert the String?", -1, myArrList.size());
                    String newItem2 = SafeInput.getNonZeroLenString(in, "What string would you like to insert?");
                    myArrList.set(insertLoc, newItem2);
                    break;
                case "P", "p":
                    System.out.println(myArrList);
                    break;
                case "Q", "q":
                    boolean confirmation = SafeInput.getYNConfirm(in,"Are you sure you want to quit?");
                    if(!confirmation){
                        break;
                    }
                    runStatus = false;
                    break;
                default:
                    SafeInput.getNonZeroLenString(in, "Please make a selection");
                    break;
            }
        } while (runStatus);
    }
}
