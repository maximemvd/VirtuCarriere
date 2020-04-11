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
  private double cout;
  private Color color;
  private String name;

  public Arc(
      Point point,
      int p_width,
      int p_length,
      AbstractPointChemin starting,
      AbstractPointChemin arrival) {
    // TODO Valider comment intégrer element
    super(point, p_width, p_length);

    this.starting = starting;
    this.arrival = arrival;
    this.color = Color.BLACK;
    this.name = "Arc";
  }

  @Override
  public AbstractPointChemin getArrival() {
    return arrival;
  }

  public double getCost() {
    return cout;
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
  public boolean containsArc(double x, double y, double x1, double y1, double x2, double y2) {
    double dy = y2 - y1;
    double dx = x2 - x1;
    double dist = Math.sqrt(dx * dx + dy * dy);

    double angle = Math.atan2(dy, dx);
    double cos = Math.cos(-angle);
    double sin = Math.sin(-angle);

    double xRot = (x - x1) * cos - (y - y1) * sin;
    double yRot = (x - x1) * sin + (y - y1) * cos;

    if (0 <= xRot && xRot <= dist) {
      double tolerance = 3;
      return Math.abs(yRot) <= tolerance;
    }
    return false;
  }

  public Point middlePointOfArc(int x1, int y1, int x2, int y2) {
    return new Point((x1 + x2) / 2, (y1 + y2) / 2);
  }

  public String getName() {
    return name;
  }

  @Override
  public void setPointChargement(int p_x, int p_y) {}

  @Override
  public int hashCode() {
    return Objects.hash(starting, arrival);
  }
}
