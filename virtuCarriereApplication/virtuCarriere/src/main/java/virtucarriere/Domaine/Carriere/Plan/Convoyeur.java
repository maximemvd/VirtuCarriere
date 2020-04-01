/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package virtucarriere.Domaine.Carriere.Plan;

import java.awt.Color;
import java.awt.Point;

public class Convoyeur extends Equipement {

  private Noeud destination;

  private Color color;

  public Convoyeur(
      Point point,
      int p_width,
      int p_length,
      boolean p_selectionStatus,
      double p_angle,
      Noeud p_destination) {

    super(point, p_width = 2, p_length = 2, p_selectionStatus = false, p_angle);

    this.destination = p_destination;
    this.color = Color.magenta;
  }

  public void setDestination(Noeud p_destination) {
    this.destination = p_destination;
  }

  public Noeud getDestination() {
    return this.destination;
  }

  public Color getColor() {
    System.out.print(color);
    return color;
  }
}
