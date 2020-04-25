package virtucarriere.Domaine.Carriere.Plan;

import static java.lang.Math.pow;

import java.awt.Color;
import java.awt.Point;
import java.awt.Shape;
import java.awt.geom.Ellipse2D;

public abstract class AbstractPointChemin extends Element {

  private Color color = null;
  private int radius;

  public AbstractPointChemin(Point point, int radius, Color color) {
    super(point);
    this.radius = radius;
    this.color = color;
    double offset = (pow(radius, 2)) / 2;
    Point upperleft = new Point((int) (point.getX() - offset), (int) (point.y - offset));
    Shape shape = new Ellipse2D.Double(upperleft.getX(), upperleft.getY(), radius * 2, radius * 2);
    this.setShape(shape);
  }

  public Color getColor() {
    return color;
  }
}
