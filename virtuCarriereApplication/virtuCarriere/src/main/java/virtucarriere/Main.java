/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package virtucarriere;

import javax.swing.JFrame;

/** @author maximemivilledeschenes */
public class Main {

  /** @param args the command line arguments */
  public static void main(String[] args) {
    virtucarriere.gui.MainWindow mainWindow = new virtucarriere.gui.MainWindow();
    mainWindow.setExtendedState(mainWindow.getExtendedState() | JFrame.MAXIMIZED_BOTH);
    mainWindow.setTitle("VirtuCarrière");
    mainWindow.setVisible(true);
  }
}
