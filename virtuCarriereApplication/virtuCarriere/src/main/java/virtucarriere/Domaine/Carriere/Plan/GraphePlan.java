package virtucarriere.Domaine.Carriere.Plan;

import java.util.List;
import java.util.Vector;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class GraphePlan {
  private Vector<Noeud> noeuds;
  private Vector<List<Arc>> arcs;

  void addNoeud(Noeud noeud){
    if (noeudExiste(noeud)){
      throw new RuntimeException("Le noeud existe déja");
    }
    noeuds.add(noeud);
  }

  void removeNoeud(Noeud noeud){
    if (noeudExiste(noeud)){
      noeuds.remove(noeud);
    }else {
      throw new RuntimeException("Ce neud n'existe pas");
    }
  }

  boolean noeudExiste(Noeud noeud){
    return noeuds.contains(noeud);
  }

  void addArc(Arc arc){
    if(arcExiste(arc)){
      throw new RuntimeException("Cet arc existe déjà");
    }
  }

  void removeArc(Arc arc){
    if (arcExiste(arc)){
      arcs.remove(arc);
    }else {
      throw new RuntimeException("Cet arc n'existe pas");
    }
  }

  boolean arcExiste(Arc arc){
    return arcs.contains(arc);
  }

  List<Noeud> getAdjacents(Noeud noeud){
    List<Noeud> adjacents;
    int index = noeuds.indexOf(noeud);
    adjacents = arcs.elementAt(index).stream()
        .map(s -> s.getArrival())
        .collect(Collectors.toList());
    return adjacents;
  }
}
