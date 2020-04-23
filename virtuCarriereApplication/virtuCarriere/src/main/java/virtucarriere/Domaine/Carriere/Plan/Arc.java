/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package virtucarriere.Domaine.Carriere.Plan;

import java.awt.Color;
import java.awt.Point;
import java.util.Objects;

public class Arc extends AbstractLien<AbstractPointChemin> {

  private AbstractPointChemin starting;
  private AbstractPointChemin arrival;
  private Color color;

  public Arc(
      Point point,
      int p_width,
      int p_length,
      AbstractPointChemin starting,
      AbstractPointChemin arrival) {
    super(point, p_width, p_length);
    this.starting = starting;
    this.arrival = arrival;
    this.color = Color.BLACK;
    setName("Arc");
    super.setPoint(
        new Point(
            (int) (starting.getX() + arrival.getX()) / 2,
            (int) (starting.getY() + arrival.getY()) / 2));
  }

  @Override
  public AbstractPointChemin getArrival() {
    return arrival;
  }

  public double getCost() {
    double dy = starting.getY() - arrival.getY();
    double dx = starting.getX() - arrival.getX();
    return Math.sqrt(dx * dx + dy * dy);
  }

  @Override
  public AbstractPointChemin getStarting() {
    return starting;
  }

  public Color getColor() {
    return color;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Arc arc = (Arc) o;
    return starting.equals(arc.starting) && arrival.equals(arc.arrival);
  }

  // Code pour savoir si la position de la souris est sur l'arc inspiré de
  // https://stackoverflow.com/questions/19730302/determining-if-a-coordinate-is-on-a-line
  @Override
  public boolean contains(double x, double y) {
    double dy = arrival.getY() - starting.getY();
    double dx = arrival.getX() - starting.getX();
    double dist = Math.sqrt(dx * dx + dy * dy);

    double angle = Math.atan2(dy, dx);
    double cos = Math.cos(-angle);
    double sin = Math.sin(-angle);

    double xRot = (x - starting.getX()) * cos - (y - starting.getY()) * sin;
    double yRot = (x - starting.getX()) * sin + (y - starting.getY()) * cos;

    if (0 <= xRot && xRot <= dist) {
      double tolerance = 3;
      return Math.abs(yRot) <= tolerance;
    }
    return false;
  }

  public String getName() {
    return name;
  }

  @Override
  public int hashCode() {
    return Objects.hash(starting, arrival);
  }
}
