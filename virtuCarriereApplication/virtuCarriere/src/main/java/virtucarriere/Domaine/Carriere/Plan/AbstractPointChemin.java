package virtucarriere.Domaine.Carriere.Plan;

import java.awt.Color;
import java.awt.Point;
import java.awt.Shape;
import java.awt.geom.Ellipse2D;

public abstract class AbstractPointChemin extends Element {

  private Color color;
  private int radius;

  public AbstractPointChemin(Point point, int radius, Color color) {
    super(point);
    this.radius = radius;
    this.color = color;
    loadShape();
  }

  public Color getColor() {
    return color;
  }

  @Override
  protected void loadShape() {
    Point upperleft = new Point(point.x - radius, point.y - radius);
    Shape shape = new Ellipse2D.Double(upperleft.getX(), upperleft.getY(), radius * 2, radius * 2);
    setShape(shape);
  }
}
