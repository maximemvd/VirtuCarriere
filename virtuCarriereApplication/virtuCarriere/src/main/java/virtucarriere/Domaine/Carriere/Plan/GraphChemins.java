package virtucarriere.Domaine.Carriere.Plan;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import virtucarriere.Domaine.Controller.*;

public class GraphChemins extends AbstractGraph<AbstractPointChemin, Arc> implements Serializable, Observable {

  private List<Observer> observerList = new ArrayList<>();
    
  public double getCost(Arc arc) {
    return arc.getCost();
  }
  
  @Override
  public void notifyObservers(){
    for (Observer observer : this.observerList){
      observer.update();
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
      // Enlever les arcs qui ont comme Arrival le noeud a supprimer
      List<Arc> toDelete = new ArrayList<Arc>();
      links.forEach(
          l_link -> {
            l_link.forEach(
                arc -> {
                  if (arc.getArrival() == end) {
                    toDelete.add(arc);
                  }
                });
          });

      toDelete.forEach(
          arc -> {
            removeLink(arc);
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
