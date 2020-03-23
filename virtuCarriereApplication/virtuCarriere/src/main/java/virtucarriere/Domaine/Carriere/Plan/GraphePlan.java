package virtucarriere.Domaine.Carriere.Plan;

import java.util.List;
import java.util.Vector;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class GraphePlan {

  private Vector<Noeud> noeuds;
  private Vector<List<Arc>> arcs;

  public void addNoeud(Noeud noeud) {
    if (noeudExiste(noeud)) {
      throw new RuntimeException("Le noeud existe déja");
    }
    noeuds.add(noeud);
  }


  public void removeNoeud(Noeud noeud) {
    if (noeudExiste(noeud)) {
      noeuds.remove(noeud);
    } else {
      throw new RuntimeException("Ce neud n'existe pas");
    }
  }

  public boolean noeudExiste(Noeud noeud) {
    return noeuds.contains(noeud);
  }

  public void addArc(Arc arc) {
    if (arcExiste(arc)) {
      throw new RuntimeException("Cet arc existe déjà");
    }
  }

  public void removeArc(Arc arc) {
    if (arcExiste(arc)) {
      arcs.remove(arc);
    } else {
      throw new RuntimeException("Cet arc n'existe pas");
    }
  }


  public boolean arcExiste(Arc arc) {
    return arcs.contains(arc);
  }

  List<Noeud> getAdjacents(Noeud noeud) {
    List<Noeud> adjacents;
    int index = noeuds.indexOf(noeud);
    adjacents = arcs.elementAt(index).stream()
        .map(Arc::getArrival)
        .collect(Collectors.toList());
    return adjacents;
  }
/*
  double getCost(Noeud source, Noeud destination) {
    Arc arc = new Arc(source, destination);
    double cost = 0;
    if (arcExiste(arc)) {
      cost = arc.getCost();
    }
    return cost;
  }

 */
}
