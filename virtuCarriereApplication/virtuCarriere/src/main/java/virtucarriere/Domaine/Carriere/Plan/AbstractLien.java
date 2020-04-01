package virtucarriere.Domaine.Carriere.Plan;

import java.awt.Point;

public abstract class AbstractLien<EndType extends Element> extends Element
    implements Lien<Element> {

  public AbstractLien(Point point, int p_width, int p_length, boolean p_selectionStatus) {
    super(point, p_width, p_length, p_selectionStatus);
  }

  public EndType getArrival() {
    return null;
  }
}