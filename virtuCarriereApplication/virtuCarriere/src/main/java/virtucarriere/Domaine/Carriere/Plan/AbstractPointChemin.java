package virtucarriere.Domaine.Carriere.Plan;

import java.awt.Color;
import java.awt.Point;

public abstract class AbstractPointChemin extends Element {

  private Color color = null;

  public AbstractPointChemin(Point point, int p_width, int p_length, Color color) {
    super(point, p_width, p_length);
    this.color = color;
  }

  public Color getColor() {
    return color;
  }
}
