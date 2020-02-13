
import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        GUI.MainWindow mainWindow = new GUI.MainWindow();
        mainWindow.setExtendedState(mainWindow.getExtendedState() | JFrame.MAXIMIZED_BOTH);
        mainWindow.setVisible(true);
    }
}
