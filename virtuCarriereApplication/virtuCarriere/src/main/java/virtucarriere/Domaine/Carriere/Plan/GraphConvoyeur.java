package virtucarriere.Domaine.Carriere.Plan;

public class GraphConvoyeur extends AbstractGraph<Equipement, Convoyeur> {
  private boolean hasDependencies() {
    return false;
  }

  @Override
  public void addEnd(Equipement end) {
    if (endExist(end)) {
      throw new RuntimeException("Le Point existe déja");
    }
    ends.add(end);
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
  }
}
