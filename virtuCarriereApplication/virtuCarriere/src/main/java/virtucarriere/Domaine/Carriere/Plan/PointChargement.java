/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package virtucarriere.Domaine.Carriere.Plan;

import java.awt.Color;
import java.awt.Point;

/** @author philippevincent */
public class PointChargement extends AbstractPointChemin {

  private Color color;

  private Noeud noeud;
  private String name;

  public PointChargement(Point p_point, int p_width, int p_length) {
    super(p_point, p_width, p_length);
    this.color = Color.PINK;
    this.name = "Point de chargement";
  }

  public Color getColor() {
    return color;
  }

  public String getName() {
    return name;
  }
}
