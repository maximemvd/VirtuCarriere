package virtucarriere.Domaine.Carriere.Plan;

import java.awt.*;
import java.util.Objects;

public abstract class AbstractLien<EndType extends Element> extends Element {

  protected EndType arrival;
  protected EndType starting;

  public AbstractLien(Point point, int p_width, int p_length, EndType starting, EndType arrival) {
    super(point, p_width, p_length);
    this.starting = starting;
    this.arrival = arrival;
    super.setPoint(
        new Point(
            (int) (starting.getX() + arrival.getX()) / 2,
            (int) (starting.getY() + arrival.getY()) / 2));
  }

  public EndType getArrival() {
    return arrival;
  }

  public EndType getStarting() {
    return starting;
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

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AbstractLien link = (AbstractLien) o;
    return starting.equals(link.starting) && arrival.equals(link.arrival);
  }

  @Override
  public int hashCode() {
    return Objects.hash(starting, arrival);
  }
}
