/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package virtucarriere.Domaine.Carriere.Plan;

import java.awt.Color;
import java.awt.Point;
import java.util.Objects;

public class Convoyeur extends AbstractLien<Equipement> {

  private Equipement arrival;
  private Equipement starting;
  private Color color;
  private String name;

  public Convoyeur(
      Point point, int p_width, int p_length, Equipement starting, Equipement arrival) {
    super(point, p_width, p_length);

    this.starting = starting;
    this.arrival = arrival;
    this.color = Color.YELLOW;
    this.name = "Convoyeur";
  }

  public void setStarting(Equipement starting) {
    this.starting = starting;
  }

  @Override
  public Equipement getStarting() {
    return this.starting;
  }

  public void setArrival(Equipement arrival) {
    this.arrival = arrival;
  }

  @Override
  public Equipement getArrival() {
    return this.arrival;
  }

  // Code pour savoir si la position de la souris est sur le convoyeur inspiré de
  // https://stackoverflow.com/questions/19730302/determining-if-a-coordinate-is-on-a-line
  public boolean containsConvoyeur(double x, double y, double x1, double y1, double x2, double y2) {
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

  public Point middlePointOfConvoyeur(int x1, int y1, int x2, int y2) {
    return new Point((x1 + x2) / 2, (y1 + y2) / 2);
  }

  @Override
  public int hashCode() {
    return Objects.hash(starting, arrival);
  }

  public Color getColor() {
    return this.color;
  }

  @Override
  public String getName() {
    return name;
  }
}
