package virtucarriere.Domaine.Carriere.Plan;

import java.awt.Point;

public abstract class AbstractLien<EndType extends Element> extends Element {

  public AbstractLien(Point point, int p_width, int p_length) {
    super(point, p_width, p_length);
  }

  public EndType getArrival() {
    return null;
  }

  public EndType getStarting() {
    return null;
  }
}
