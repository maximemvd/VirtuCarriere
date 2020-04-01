/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package virtucarriere.Domaine.Carriere.Plan;

import java.awt.Color;
import java.awt.Point;

public class Concasseur extends Equipement {

  private Color color;

  public Concasseur(
      Point point, int p_width, int p_length, boolean p_selectionStatus, double p_angle) {

    super(point, p_width = 2, p_length = 2, p_selectionStatus = false, p_angle);
    this.color = Color.PINK;
  }

  public Color getColor() {
    System.out.print(color);
    return color;
  }
}
