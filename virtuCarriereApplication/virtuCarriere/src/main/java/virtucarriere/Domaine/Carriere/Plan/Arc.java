/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package virtucarriere.Domaine.Carriere.Plan;

import java.awt.Color;
import java.awt.Point;

public class Arc extends AbstractLien<Noeud> {

  private Noeud starting;
  private Noeud arrival;
  private double cout;
  private Color color;

  public Arc(
      Point point,
      int p_width,
      int p_length,
      boolean p_selectionStatus,
      Noeud starting,
      Noeud arrival) {
    // TODO Valider comment intégrer element
    super(point, p_width, p_length, p_selectionStatus);

    this.starting = starting;
    this.arrival = arrival;
  }

  public Noeud getArrival() {
    return arrival;
  }

  public double getCost() {
    return cout;
  }

  public Color getColor() {
    System.out.print(color);
    return color;
  }
}
