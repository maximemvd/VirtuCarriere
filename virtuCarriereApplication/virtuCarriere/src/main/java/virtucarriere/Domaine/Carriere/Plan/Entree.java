/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package virtucarriere.Domaine.Carriere.Plan;

import java.awt.Color;
import java.awt.Point;

/** @author maximemivilledeschenes */
public class Entree extends Element {

  private double angle;
  private Color color;

  public Entree(
      Point p_point, int p_width, int p_length, boolean p_selectionStatus, double p_angle) {
    super(p_point, p_width, p_length, p_selectionStatus);
    this.angle = p_angle;
    this.color = Color.DARK_GRAY;
  }

  @Override
  public Color getColor() {
    return color;
  }
}
