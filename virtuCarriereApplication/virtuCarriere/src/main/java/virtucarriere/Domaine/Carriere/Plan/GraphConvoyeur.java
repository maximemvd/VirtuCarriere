package virtucarriere.Domaine.Carriere.Plan;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

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
      // Enlever les convoyeurs qui ont comme Arrival lequipement a supprimer
      List<Convoyeur> toDelete = new ArrayList<Convoyeur>();
      links.forEach(
          l_link -> {
            l_link.forEach(
                convoyeur -> {
                  if (convoyeur.getArrival() == end) {
                    toDelete.add(convoyeur);
                  }
                });
          });

      toDelete.forEach(
          convoyeur -> {
            removeLink(convoyeur);
          });

      // Enlever le noeud et les arcs qui sortent de celui ci
      int index = ends.indexOf(end);
      ends.remove(end);
      links.remove(links.elementAt(index));

    } else {
      throw new RuntimeException("Ce noeud n'existe pas");
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

  public boolean validateDependencies() {
    // TODO
    return true;
  }
}
