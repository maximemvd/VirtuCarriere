package virtucarriere.Domaine.Carriere.Plan;

import java.io.Serializable;
import java.util.ArrayList;

public class GraphConvoyeur extends AbstractGraph<Equipement, Convoyeur> implements Serializable {
  private boolean hasDependencies() {
    return false;
  }

  @Override
  public void addEnd(Equipement end) {
    if (endExist(end)) {
      throw new RuntimeException("Le Point existe déja");
    }
    ends.add(end);
    links.add(new ArrayList<Convoyeur>());
  }

  @Override
  public void removeEnd(Equipement end) {
    if (endExist(end)) {
      ends.remove(end);
    } else {
      throw new RuntimeException("Ce neud n'existe pas");
    }
  }

  @Override
  public boolean endExist(Equipement end) {
    return ends.contains(end);
  }

  @Override
  public void addLink(Convoyeur link) {
    if (linkExist(link)) {
      throw new RuntimeException("Cet arc existe déjà");
    }
    int index = ends.indexOf(link.getStarting());
    links.elementAt(index).add(link);
  }
}
