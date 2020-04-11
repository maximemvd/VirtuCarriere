/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package virtucarriere.Domaine.Carriere.Plan;

import java.awt.Color;
import java.awt.Point;

/** @author maximemivilledeschenes */
public class Entree extends AbstractPointChemin {

  private double angle;
  private Color color;
  private String name;

  public Entree(Point p_point, int p_width, int p_length, double p_angle) {
    super(p_point, p_width, p_length);
    this.angle = p_angle;
    this.color = Color.DARK_GRAY;
    this.name = "Entrée";
  }

  @Override
  public Color getColor() {
    return color;
  }

  @Override
  public String getName() {
    return name;
  }

  @Override
  public void setPointChargement(int p_x, int p_y) {}
}
