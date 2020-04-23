package virtucarriere.Domaine.Carriere.Plan;

import java.awt.Color;
import java.awt.Point;

public abstract class AbstractPointChemin extends Element {

  public AbstractPointChemin(Point point, int p_width, int p_length) {
    super(point, p_width, p_length);
  }

  public abstract Color getColor();
}
