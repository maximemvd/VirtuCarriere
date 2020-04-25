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
    Shape shape = new Ellipse2D.Double(point.getX(), point.getY(), radius, radius);
    this.setShape(shape);
  }

  public Color getColor() {
    return color;
  }
}
