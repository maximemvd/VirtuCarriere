package virtucarriere.Domaine.Carriere.Plan;

public class GraphConvoyeur extends AbstractGraph<Noeud, Arc> {
  private boolean hasDependencies() {
    return false;
  }
}
