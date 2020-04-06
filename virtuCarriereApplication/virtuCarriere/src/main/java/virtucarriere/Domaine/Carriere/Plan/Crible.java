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

public class Crible extends Equipement {

  private Color color;
  private String name;
  private static List<Class<? extends Equipement>> dependency = Collections.emptyList();

  public Crible(Point point, int p_width, int p_length, double p_angle) {

    super(point, p_width = 2, p_length = 2, p_angle, dependency);

    this.color = Color.RED;
    this.name = "Crible";
  }

  public Color getColor() {
    return color;
  }

  public String getName() {
    return name;
  }
}
