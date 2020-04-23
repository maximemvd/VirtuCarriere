/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package virtucarriere.Domaine.Carriere.Plan;

import java.awt.Color;
import java.awt.Point;

public class Arc extends AbstractLien<AbstractPointChemin> {

  private Color color;

  public Arc(
      Point point,
      int p_width,
      int p_length,
      AbstractPointChemin starting,
      AbstractPointChemin arrival) {
    super(point, p_width, p_length, starting, arrival);
    this.color = Color.BLACK;
    setName("Arc");
    super.setPoint(
        new Point(
            (int) (starting.getX() + arrival.getX()) / 2,
            (int) (starting.getY() + arrival.getY()) / 2));
  }

  public double getCost() {
    double dy = starting.getY() - arrival.getY();
    double dx = starting.getX() - arrival.getX();
    return Math.sqrt(dx * dx + dy * dy);
  }

  public Color getColor() {
    return color;
  }
}
