package virtucarriere.Domaine.Carriere.Plan;

import java.awt.*;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;
import java.util.Objects;

public abstract class AbstractLien<EndType extends Element> extends Element {

  protected EndType arrival;
  protected EndType starting;

  public AbstractLien(EndType starting, EndType arrival) {
    super(new Point());
    this.starting = starting;
    this.arrival = arrival;
    super.setPoint(
        new Point(
            (int) (starting.getX() + arrival.getX()) / 2,
            (int) (starting.getY() + arrival.getY()) / 2));
    loadShape();
  }

  public EndType getArrival() {
    return arrival;
  }

  public EndType getStarting() {
    return starting;
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

  @Override
  public boolean contains(double p_x, double p_y) {
    int size = 4;
    Shape mouse = new Rectangle((int) (p_x - size / 2), (int) (p_y - 1.5), 2, 2);
    return shape.intersects((Rectangle2D) mouse);
  }

  @Override
  protected void loadShape() {
    Line2D shape =
        new Line2D.Double(starting.getX(), starting.getY(), arrival.getX(), arrival.getY());
    setShape(shape);
  }
}
