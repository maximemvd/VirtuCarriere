package virtucarriere.Domaine.Carriere.Simulation;
/** @author philippevincent */
import java.awt.Point;
import java.io.Serializable;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.Vector;
import virtucarriere.Domaine.Carriere.Plan.AbstractPointChemin;
import virtucarriere.Domaine.Carriere.Plan.Entree;
import virtucarriere.Domaine.Carriere.Plan.GraphChemins;
import virtucarriere.Domaine.Carriere.Plan.Noeud;
import virtucarriere.Domaine.Carriere.Plan.Tas;

public class Simulation implements Serializable {

  private Entree entreeCarriere;

  private GraphChemins graphChemin;

  List<Camion> camionList;

  List<Chargeur> chargeurList;

  private Chargeur chargeurCourant;

  private boolean simulationAnimation;

  private double simulationSpeed;

  public Simulation() {
    entreeCarriere = null;
    simulationSpeed = 2;
    simulationAnimation = false;
    camionList = new LinkedList<Camion>();
    chargeurList = new LinkedList<Chargeur>();
  }

  public void setGraphCheminSimulation(GraphChemins p_graphChemin) {
    this.graphChemin = p_graphChemin;
  }

  public void EditCamion(Camion p_camion, String nom, String produit, double qte) {
    Jeton jeton = new Jeton(nom, produit, qte);
    p_camion.editerParams(jeton);
  }

  public double getSimulationSpeed() {
    return simulationSpeed;
  }

  public void setSimulationSpeed(double newSpeed) {
    this.simulationSpeed = newSpeed;
  }

  public boolean getSimulationAnimation() {
    return simulationAnimation;
  }

  public void startSimulation() {
    this.simulationAnimation = true;
  }

  public void closeSimulation() {
    this.simulationAnimation = false;
  }

  public void setEntreCarriere(Entree p_entree) {
    this.entreeCarriere = p_entree;
  }

  public void setChargeurCourant(Chargeur p_chargeur) {
    this.chargeurCourant = p_chargeur;
  }

  public Chargeur getChargeurCourant() {
    return chargeurCourant;
  }

  public Jeton getJetonChargeurCourant() {
    return chargeurCourant.getJeton();
  }

  // camion
  public void CamionShowUp(Point point, String client, String produit, double quantite) {
    try {
      Jeton jeton = new Jeton(client, produit, quantite);
      Camion camionSimulation = new Camion(jeton, point); // create camion
      camionList.add(camionSimulation);
    } catch (Exception exception) {
      System.out.println(exception);
    }
  }

  public void removeCamion(Camion p_camion) {
    try {
      camionList.remove(p_camion);
    } catch (Exception error) {
      System.out.println(error);
    }
  }

  public List<Camion> getCamionList() {
    return camionList;
  }

  public double camionListSize() {
    return camionList.size();
  }

  public boolean camionIsEmpty() {
    return camionList.isEmpty();
  }

  public void switchSelectionStatus(double x, double y) {
    for (Camion item : camionList) {
      if (item.contains(x, y)) {
        item.switchSelectionStatus();
      }
    }
    for (Chargeur item : this.chargeurList) {
      if (item.contains(x, y)) {
        item.switchSelectionStatus();
      }
    }
  }

  public void updateSelectedItemsPosition(double deltaX, double deltaY) {

    for (Chargeur item : getChargeurList()) {
      if (item.isSelected()) {
        item.translate(deltaX, deltaY);
      }
    }
  }

  public void addChargeur(Point p_point) {
    try {
      Chargeur p_chargeur = new Chargeur(p_point);
      chargeurList.add(p_chargeur);
    } catch (Exception error) {
      System.out.println(error);
    }
  }

  public void changementSelectionStatus(double x, double y) {
    for (Camion item : camionList) {
      if (item.contains(x, y)) {
        item.switchSelectionStatus();
      }
    }
    for (Chargeur item : this.chargeurList) {
      if (item.contains(x, y)) {
        item.switchSelectionStatus();
      }
    }
  }

  public void removeChargeur(Chargeur p_chargeur) {
    try {
      chargeurList.remove(p_chargeur);
    } catch (Exception error) {
      System.out.println(error);
    }
  }

  public List<Chargeur> getChargeurList() {
    return chargeurList;
  }

  public double chargeurListSize() {
    return chargeurList.size();
  }

  public boolean chargeurIsEmpty() {
    return chargeurList.isEmpty();
  }

  public Jeton createToken(String client, String produit, double quantite) {
    return new Jeton(client, produit, quantite);
  }

  public boolean verificationJeton(Camion p_camion, Chargeur p_chargeur) {
    return p_camion.getJeton() == p_chargeur.getJeton();
  }

  public Facture genererFacture(Camion p_camion) {
    Jeton jeton = p_camion.getJeton();
    Facture facture = new Facture(jeton.getCodeProduit(), jeton.getQuantite());
    return facture;
  }

  public Tas trouverTas(List<Tas> tasList, String produit) {

    Tas leTas = null;

    for (Tas tas : tasList) {
      if (tas.getMaterialCode().equals(produit)) {
        leTas = tas;
        break;
      }
    }
    return leTas;
  }

  public Vector<AbstractPointChemin> cheminDuCamion(Tas tas) {
    return getShortestPathToGo(tas.getPointChargement());
  };

  public Vector<AbstractPointChemin> cheminDuCamionRetour(Tas tas) {
    return getShortestPathToComeBack(tas.getPointChargement());
  };

  public Chargeur choisirChargeurIdeal(Tas tas) {

    // Vector<AbstractPointChemin> cheminMinimal = cheminDuCamion(tas);
    Chargeur chargeurSimulation = chargeurList.get(0);
    //  for (Chargeur chargeurCourant : chargeurList) {

    //  Vector<AbstractPointChemin> cheminChargeurCourant =
    //    ChargeurCheminToPath(chargeurCourant, tas);
    // System.out.print(cheminChargeurCourant);
    // System.out.print("Test");
    // if (cheminMinimal.size() > cheminChargeurCourant.size()) {
    // chargeurSimulation = chargeurCourant;
    // System.out.print(chargeurSimulation);
    // cheminMinimal = cheminChargeurCourant;
    System.out.print(chargeurSimulation);
    return chargeurSimulation;
  }

  public Vector<AbstractPointChemin> ChargeurCheminToPath(
      Chargeur p_chargeur, Tas p_tas, List<Noeud> listeNoeud) {

    Vector<AbstractPointChemin> chemin = null;
    System.out.print(listeNoeud.size());

    for (Noeud noeud : listeNoeud) {
      if (noeud.contains(p_chargeur.getX(), p_chargeur.getY())) {
        chemin = getShortestPathBetweenTwoNoeuds(noeud, p_tas.getNoeud());
      }
    }

    System.out.print("Bon chemin de chargeur jusqu'au tas");
    System.out.print(chemin);
    return chemin;
  }

  public Vector<AbstractPointChemin> getShortestPathToGo(AbstractPointChemin stop) {
    Vector<AbstractPointChemin> results = new Vector<>();
    System.out.print(entreeCarriere);

    results.addAll(getShortestPathBetweenTwoNoeuds(entreeCarriere, stop));

    return results;
  }

  public Vector<AbstractPointChemin> getShortestPathToComeBack(AbstractPointChemin stop) {
    Vector<AbstractPointChemin> results = new Vector<>();

    // AbstractPointChemin entree = entreeCarriere;

    results.addAll(getShortestPathBetweenTwoNoeuds(stop, entreeCarriere));

    return results;
  }

  public Vector<AbstractPointChemin> getShortestPathBetweenTwoNoeuds(
      AbstractPointChemin start, AbstractPointChemin end) {
    Vector<DataDijkstra> result = new Vector<DataDijkstra>();
    List<DataDijkstra> data = new java.util.ArrayList<>(Collections.emptyList());

    System.out.print(graphChemin);

    graphChemin
        .getEnds()
        .forEach(
            treatingEnd -> {
              data.add(new DataDijkstra(treatingEnd, Double.MAX_VALUE));
            });
    System.out.print("hello world");
    data.stream()
        .filter(dataDijkstra -> dataDijkstra.getEnd().equals(start))
        .findFirst()
        .ifPresent(dataDijkstra -> dataDijkstra.setTotalCost(0));
    System.out.print("allo");
    DataDijkstra treating;
    do {
      treating = data.stream().min(Comparator.comparing(DataDijkstra::getTotalCost)).get();
      data.remove(treating);
      result.add(treating);
      final double[] newCost = new double[1];
      final double[] oldCost = new double[1];
      final double[] linkCost = new double[1];
      System.out.print("testing");
      List<AbstractPointChemin> adj = graphChemin.getAdjacentsOut(treating.getEnd());
      DataDijkstra finalTreating = treating;
      System.out.print("allo algo");
      data.stream()
          .filter(dataDijkstra -> adj.contains(dataDijkstra.getEnd()))
          .findFirst()
          .ifPresent(
              dataDijkstra -> {
                System.out.print("allo algo wow pour vrai");
                linkCost[0] =
                    graphChemin.getLink(finalTreating.getEnd(), dataDijkstra.getEnd()).getCost();
                oldCost[0] = dataDijkstra.getTotalCost();
                newCost[0] = linkCost[0] + finalTreating.getTotalCost();
                if (newCost[0] < oldCost[0]) {
                  dataDijkstra.setTotalCost(newCost[0]);
                  dataDijkstra.setPredecessor(finalTreating.getEnd());
                }
              });

    } while (!data.isEmpty());

    DataDijkstra endOfPath =
        result.stream().filter(dataDijkstra -> dataDijkstra.getEnd() == end).findFirst().get();
    System.out.print("allo algo wow");
    if (endOfPath.getTotalCost() == Double.MAX_VALUE)
      throw new RuntimeException("Aucun chemin n'existe entre ces deux noeuds");

    return buildPath(start, end, result);
  }

  private Vector<AbstractPointChemin> buildPath(
      AbstractPointChemin start, AbstractPointChemin end, Vector<DataDijkstra> afterAlgo) {
    Vector<AbstractPointChemin> path = new Vector<>();

    final AbstractPointChemin[] now = {end};
    Optional<DataDijkstra> treating =
        afterAlgo.stream().filter(dataDijkstra -> dataDijkstra.getEnd().equals(now[0])).findFirst();
    do {
      treating.ifPresent(
          dataDijkstra -> {
            path.add(dataDijkstra.getPredecessor());
            now[0] = dataDijkstra.getPredecessor();
          });
      treating =
          afterAlgo.stream()
              .filter(dataDijkstra -> dataDijkstra.getEnd().equals(now[0]))
              .findFirst();
    } while (!start.equals(treating.get().getEnd()));

    Collections.reverse(path);
    return path;
  }

  private static class DataDijkstra {

    private AbstractPointChemin predecessor = null;
    private AbstractPointChemin end;
    private double totalCost;

    public DataDijkstra(AbstractPointChemin end, double totalCost) {
      this.end = end;
      this.totalCost = totalCost;
    }

    public AbstractPointChemin getEnd() {
      return end;
    }

    public double getTotalCost() {
      return totalCost;
    }

    public void setTotalCost(double totalCost) {
      this.totalCost = totalCost;
    }

    public void setPredecessor(AbstractPointChemin end) {
      predecessor = end;
    }

    public AbstractPointChemin getPredecessor() {
      return predecessor;
    }
  }
}
