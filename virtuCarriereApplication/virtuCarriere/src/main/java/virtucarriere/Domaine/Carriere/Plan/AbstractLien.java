package virtucarriere.Domaine.Carriere.Plan;

import java.awt.Point;

public abstract class AbstractLien<EndType extends Point> implements Lien<Point> {

  public EndType getArrival() {
    return null;
  }
}
