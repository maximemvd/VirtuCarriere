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

  public PointChargement(Point p_point) {
    super(p_point, 10, Color.PINK);
    setName("Point de chargement");
  }
}
