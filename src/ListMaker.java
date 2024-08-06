import java.util.ArrayList;
import java.util.Scanner;
public class ListMaker {
    private static ArrayList<String> list = new ArrayList<String>();
    private static Scanner scan = new Scanner(System.in);
    private static boolean done = false;
    public static void main(String[] args) {
        do {
            display();
            String menuItem = SafeInput.getRegExString(scan, "Enter a menu item", "[AaDdPpQq]"); // Retrieves a menu item using SafeInput's getRegExString() function
            switch(menuItem) {
                case "a", "A":
                    add();
                    break;
                case "d", "D":
                    delete();
                    break;
                case "p", "P":
                    print();
                    break;
                case "q", "Q":
                    quit();
                    break;
            }
        }
        while (!done);
    }
    private static void display() {
        print();
        System.out.println("A - Add\nD - Delete\nP - Print\nQ - Quit");
    }
    private static void add() {
        String addItem = SafeInput.getNonZeroLenString(scan, "Enter the item you would like to add");
        list.add(addItem);
    }
    private static void delete() {
        print();
        int deleteIndex = SafeInput.getRangedInt(scan, "Enter the number of the item you would like to delete", 1, list.size());
        list.remove(deleteIndex - 1);
    }
    private static void print() {
        System.out.println("Current list: ");
        for(int i = 0; i < list.size(); i++) {
            System.out.println((i + 1)+". "+list.get(i));
        }
    }
    private static void quit() {
        if(SafeInput.getYNConfirm(scan, "Are you sure you want to quit?")) {
            done = true;
        }
    }
}