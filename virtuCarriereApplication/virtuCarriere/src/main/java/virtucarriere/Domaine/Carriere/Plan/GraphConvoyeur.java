package virtucarriere.Domaine.Carriere.Plan;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import virtucarriere.Domaine.Controller.*;

public class GraphConvoyeur extends AbstractGraph<Equipement, Convoyeur> implements Serializable, Observable {

  private List<Observer> observerList = new ArrayList<>();  
  
  private boolean hasDependencies() {
    return false;
  }
  
  @Override
  public void notifyObservers(String action, Object end){
    for (Observer observer : this.observerList){
      observer.update(action, end);
    }
  }
  
  @Override
  public void addObserver(Observer observer){
    this.observerList.add(observer);
  }
  
  @Override
  public void removeObserver(Observer observer){
    this.observerList.remove(observer);
  }

  @Override
  public void addEnd(Equipement end) {
    if (endExist(end)) {
      throw new RuntimeException("Le Point existe déja");
    }
    ends.add(end);
    links.add(new ArrayList<Convoyeur>());
    notifyObservers("add", end);
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
      notifyObservers("delete", end);

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
    notifyObservers("add", link);
  }

  private boolean isValidLink(Equipement start, List<Equipement> end) {
    boolean result;
    if (start.getClass() == Tas.class) {
      result = (end.size() == 0);
    } else if (!(start.getClass() == Crible.class)) {
      result =
          end.stream().allMatch(equipement -> start.getDependency().contains(equipement.getClass()))
              && (end.size() == 1);
    } else {
      if (end.size() == 0) {
        result = true;
      } else {
        result =
            end.stream()
                .allMatch(equipement -> start.getDependency().contains(equipement.getClass()));
      }
    }
    return result;
  }

  public boolean validateDependencies() {
    return ends.stream()
        .allMatch(equipement -> isValidLink(equipement, getAdjacentsOut(equipement)));
  }
}
