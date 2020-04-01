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
  private String name;

  public Noeud(Point point, int p_width, int p_length, boolean p_selectionStatus) {
    super(point, p_width, p_length, p_selectionStatus);
    this.color = Color.CYAN;
    this.name = "Noeud";
  }

  public Color getColor() {
    return color;
  }

  public String getName() {
    return name;
  }
}
