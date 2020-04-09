package virtucarriere.Domaine.Carriere.Plan;

import java.util.List;
import java.util.ArrayList;

public class GraphChemins extends AbstractGraph<AbstractPointChemin, Arc> {

  public double getCost(Arc arc) {
    return arc.getCost();
  }

  @Override
  public void addEnd(AbstractPointChemin end) {
    if (endExist(end)) {
      throw new RuntimeException("Le Point existe déja");
    }
    ends.add(end);
    links.add(new ArrayList<Arc>());
  }

  @Override
  public void removeEnd(AbstractPointChemin end) {
    if (endExist(end)) {
      ends.remove(end);
    } else {
      throw new RuntimeException("Ce noeud n'existe pas");
    }
  }

  @Override
  public boolean endExist(AbstractPointChemin end) {
    return ends.contains(end);
  }

  @Override
  public void addLink(Arc link) {
    if (linkExist(link)) {
      throw new RuntimeException("Cet arc existe déjà");
    }
    int index = ends.indexOf(link.getStarting());
    links.elementAt(index).add(link);
  }
}
