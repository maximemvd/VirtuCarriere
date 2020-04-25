package virtucarriere.Domaine.Carriere.Plan;

import java.awt.Color;
import java.awt.Point;
import java.awt.Shape;
import java.awt.geom.Ellipse2D;

public abstract class AbstractPointChemin extends Element {

  private Color color = null;
  private int radius;

  public AbstractPointChemin(Point point, int radius, Color color) {
    super(point);
    this.color = color;
  }

  public Color getColor() {
    return color;
  }

  @Override
  public boolean contains(double p_x, double p_y) {
    Shape shape = new Ellipse2D.Double(point.getX(), point.getY(), radius, radius);
    return shape.contains(p_x, p_y);
  }
}
