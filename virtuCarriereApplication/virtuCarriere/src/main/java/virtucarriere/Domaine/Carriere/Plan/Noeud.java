/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package virtucarriere.Domaine.Carriere.Plan;

import java.awt.Color;
import java.awt.Point;

public class Noeud extends Element {

  private Color color;
  private Point point;

  public Noeud(Point point, int p_width, int p_length, boolean p_selectionStatus) {
    super(point, p_width, p_length, p_selectionStatus);
    this.color = Color.BLACK;
  }

  public Point getPoint() {
    return point;
  }

  public Color getColor() {
    System.out.print(color);
    return color;
  }
}
