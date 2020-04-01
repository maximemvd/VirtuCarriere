/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package virtucarriere.gui;

import javax.swing.JComponent;
import java.awt.Color;
import java.awt.Graphics;

/**
 *
 * @author Francis_Boulianne
 */
public class MouseCoordinates extends JComponent{
  public int x;
  public int y;
  
  public MouseCoordinates() {
    this.setBackground(Color.blue);
  }

  // use the xy coordinates to update the mouse cursor text/label
  protected void paintComponent(Graphics g)
  {
    super.paintComponent(g);
    String s = x + ", " + y;
    g.setColor(Color.black);
    g.drawString(s, x, y);
  }
  
  public void setX(int p_x){
      this.x = p_x;
  }
  
  public void setY(int p_y){
      this.y = p_y;
  }
}
