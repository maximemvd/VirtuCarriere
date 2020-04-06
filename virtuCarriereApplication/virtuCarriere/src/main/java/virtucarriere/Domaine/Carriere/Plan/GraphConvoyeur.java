package virtucarriere.Domaine.Carriere.Plan;

public class GraphConvoyeur extends AbstractGraph<Equipement, Convoyeur> {
  private boolean hasDependencies() {
    return false;
  }
}
