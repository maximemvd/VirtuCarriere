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

  private Angle angle;
  private Color color;

  public Entree(Point p_point, double p_angle) {
    super(p_point, 10, Color.DARK_GRAY);
    this.angle = new Angle(p_angle);
    setName("Entrée");
  }
}
