/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package virtucarriere.Domaine.Carriere.Plan;

import java.awt.Color;
import java.awt.Point;
import java.util.Collections;
import java.util.List;

public class Broyeur extends Equipement {

  private Color color;
  private static List<Class<? extends Equipement>> dependency = Collections.emptyList();

  public Broyeur(
      Point point, int p_width, int p_length, boolean p_selectionStatus, double p_angle) {

    super(point, p_width, p_length, p_selectionStatus, p_angle, dependency);
    this.color = Color.GREEN;
  }

  public Color getColor() {
    System.out.print(color);
    return color;
  }
}
