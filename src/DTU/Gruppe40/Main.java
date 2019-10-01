package DTU.Gruppe40;
import gui_main.GUI;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	    GUI gui = new GUI();
	    gui.setDice(1, 3);

	    Scanner input = new Scanner(System.in);

	    while(true) {
            input.nextLine();
            int roll1 = (int)(Math.random() * 6.0 + 1.0);
            int roll2 = (int)(Math.random() * 6.0 + 1.0);
            System.out.println("New roll: " + roll1 + " " + roll2);

            gui.setDice(roll1, roll2);
        }
    }


}
