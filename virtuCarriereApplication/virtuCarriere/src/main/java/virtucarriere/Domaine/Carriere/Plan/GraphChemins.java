package virtucarriere.Domaine.Carriere.Plan;

public class GraphChemins extends AbstractGraph<Noeud, Arc> {
  public double getCost(Arc arc) {
    return arc.getCost();
  }
}
