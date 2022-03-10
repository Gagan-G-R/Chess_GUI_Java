import java.util.Scanner;
import javax.swing.*;

public class Main implements Runnable{

    public void run() {
        SwingUtilities.invokeLater(new StartMenu());
    }

    public static void main(String[] args) {

        SwingUtilities.invokeLater(new Main());

        //Pieces pieces = new Pieces();
        //new GUIBoard(pieces);
        
    }

}
