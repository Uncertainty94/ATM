package view;

/**
 * Created by mmishanin on 11.03.2016.
 */
public class Display {

    public void displayInfo(String text){
        System.out.println("*From display* " + text);
    }

    public void displayMenu(){
        System.out.println("*From display*");
        System.out.println("1. Watch balance");
        System.out.println("2. Take Money");
        System.out.println("3. Exit");
    }
}
