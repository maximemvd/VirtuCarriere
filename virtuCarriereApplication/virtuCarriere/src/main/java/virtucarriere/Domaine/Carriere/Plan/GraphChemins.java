package virtucarriere.Domaine.Carriere.Plan;

public class GraphChemins extends AbstractGraph<Noeud, Arc> {

  public double getCost(Arc arc) {
    return arc.getCost();
  }

  @Override
  public void addEnd(Noeud end) {
    if (endExist(end)) {
      throw new RuntimeException("Le Point existe déja");
    }
    ends.add(end);
  }

  @Override
  public void removeEnd(Noeud end) {
    if (endExist(end)) {
      ends.remove(end);
    } else {
      throw new RuntimeException("Ce neud n'existe pas");
    }
  }

  @Override
  public boolean endExist(Noeud end) {
    return ends.contains(end);
  }

  @Override
  public void addLink(Arc link) {
    if (linkExist(link)) {
      throw new RuntimeException("Cet arc existe déjà");
    }
  }
}
