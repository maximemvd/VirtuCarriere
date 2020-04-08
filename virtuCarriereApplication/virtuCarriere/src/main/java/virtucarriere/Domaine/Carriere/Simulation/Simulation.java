package virtucarriere.Domaine.Carriere.Simulation;
/** @author philippevincent */
import java.awt.Point;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.Vector;
import virtucarriere.Domaine.Carriere.Plan.Entree;
import virtucarriere.Domaine.Carriere.Plan.GraphChemins;
import virtucarriere.Domaine.Carriere.Plan.Noeud;
import virtucarriere.Domaine.Carriere.Plan.Tas;

public class Simulation {

  private Entree entreeCarriere;

  private List<Tas> tasList;

  private List<Noeud> noeudList;

  private GraphChemins graphChemin;

  List<Camion> camionList;

  List<Chargeur> chargeurList;

  private Chargeur chargeurCourant;

  private Camion camionCourant;

  private Tas tasCourant;

  public Simulation() {
    camionList = new LinkedList<Camion>();
    chargeurList = new LinkedList<Chargeur>();
  }

  private void setCourantTas(Tas tas) {
    this.tasCourant = tas;
  }

  public void setTasList(List<Tas> p_tas) {
    this.tasList = p_tas;
  }

  public void setNoeudList(List<Noeud> p_noeud) {
    this.noeudList = p_noeud;
  }

  public void setEntreCarriere(Entree p_entree) {
    this.entreeCarriere = p_entree;
  }

  public void setChargeurCourant(Chargeur p_chargeur) {
    this.chargeurCourant = p_chargeur;
  }

  public void setCamionCourant(Camion p_camion) {
    this.camionCourant = p_camion;
  }

  public Chargeur getChargeurCourant() {
    return chargeurCourant;
  }

  public Jeton getJetonChargeurCourant() {
    return chargeurCourant.getJeton();
  }

  public Jeton getJetonCamionCourant() {
    return camionCourant.getJeton();
  }

  public void camionCourantGoTo(Point point) {
    camionCourant.goTO(point);
  }

  // camion
  public void CamionShowUp(String client, String produit, double quantite) {
    try {
      Point positionEntre = entreeCarriere.getPoint();
      Jeton jeton = createToken(client, produit, quantite);
      int sizeCamion = camionList.size();
      int start = 100 * sizeCamion;
      Point point = new Point(positionEntre.x + start, positionEntre.y);
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

  public void removeVehicule(Vehicule vehicule) {
    if (vehicule.getClass() == Camion.class) {
      // removeCamion(vehicule);
    } else if (vehicule.getClass() == Chargeur.class) {
      removeChargeur(vehicule);
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

  public void removeChargeur(Vehicule p_chargeur) {
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
    Jeton newJeton = new Jeton(client, produit, quantite, "ENCOURS");
    return newJeton;
  }

  public void changeEtat(String etat) {
    camionCourant.changeEtat(etat);
  }

  public boolean verificationJeton(Camion p_camion) {
    return camionCourant.getJeton() == getJetonChargeurCourant();
  }

  public Facture genererFacture(Camion p_camion) {
    // on va dire que tous les materiaux coutent 10$ pour l'instant
    double quantity = p_camion.getJeton().getQuantite();
    Facture facture = new Facture(10, quantity);
    return facture;
  }

  public void trouverTas(String produit) {

    // donc ici on veux choisir c'est quel le tas le plus approprié selon la commande du client
    // donc premierement on regarde c'est quel les tas qui contiennent les matériaux que le camion a
    // de besoin, on les mets dans la liste tasValide
    List<Tas> tasValide = new LinkedList<>();
    tasList.forEach(
        (tas) -> {
          if (tas.getMaterialCode().equals(produit)) {
            tasValide.add(tas);
          }
        });

    // apres on va avoir une liste de tas valide, on veut le tas le  plus proche du camion

    // on peux avoir les coordonnées du camion avec camionCourant.getPoint() ou
    // entreeCourant.getPoint(), c'est mieux d'y aller avec camionCourant()

    // une fois qu'on la choisit, on fait setTasCourant(Le tas choisit)

  }

  public void indiqueAuCamionEmplacement(String produit) {
    // donc ici on veut indiquer au camion le meilleur chemin pour se rendre au tas

    //  donc le camionCourant doit se rendre au tasCourant.getPoint();

    // la liste de noeud va etre dans noeudList

    // retourner une liste de point que le camion doit prendre si possible

  };

  public void choisirCargeurIdeal(Jeton jeton, Tas tas) {
    // ici on va chercher tous les chargeurs et on prends le chargeur le plus proche de tasCourant
    // on faire this.chargeurCourant = (le chargeur qu'on vient de choisir) ou juste retourner le
    // chargeur le mieux adapter
  }

  public void indiqueAuChargeurChemin() {
    // on indique au chargeurCourant le chemin pour se rendre au tas

  }

  public void indiqueAuCamionCheminRetour() {
    //  on indique au camion le chemin de retour pour retourner à l'entrée
  };

  public Vector<Noeud> getShortestPath(Noeud stop) {
    Vector<Noeud> results = new Vector<>();

    Noeud entree = entreeCarriere;

    results.addAll(getShortestPathBetweenTwoNoeuds(entree, stop));
    results.addAll(getShortestPathBetweenTwoNoeuds(stop, entree));

    return results;
  }

  public Vector<Noeud> getShortestPathBetweenTwoNoeuds(Noeud start, Noeud end) {
    Vector<DataDijkstra> result = new Vector<DataDijkstra>();
    List<DataDijkstra> data = new java.util.ArrayList<>(Collections.emptyList());

    graphChemin
        .getEnds()
        .forEach(
            treatingEnd -> {
              data.add(new DataDijkstra(treatingEnd, Double.MAX_VALUE));
            });

    data.stream()
        .filter(dataDijkstra -> dataDijkstra.getEnd().equals(start))
        .findFirst()
        .ifPresent(dataDijkstra -> dataDijkstra.setTotalCost(0));

    DataDijkstra treating;
    do {
      treating = data.stream().min(Comparator.comparing(DataDijkstra::getTotalCost)).get();
      data.remove(treating);
      result.add(treating);
      final double[] newCost = new double[1];
      final double[] oldCost = new double[1];
      final double[] linkCost = new double[1];

      List<Noeud> adj = graphChemin.getAdjacentsOut(treating.getEnd());
      DataDijkstra finalTreating = treating;
      data.stream()
          .filter(dataDijkstra -> adj.contains(dataDijkstra.getEnd()))
          .findFirst()
          .ifPresent(
              dataDijkstra -> {
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

    if (endOfPath.getTotalCost() == Double.MAX_VALUE)
      throw new RuntimeException("Aucun chemin n'existe entre ces deux noeuds");

    return buildPath(start, end, result);
  }

  private Vector<Noeud> buildPath(Noeud start, Noeud end, Vector<DataDijkstra> afterAlgo) {
    Vector<Noeud> path = new Vector<>();

    final Noeud[] now = {end};
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

    private Noeud predecessor = null;
    private Noeud end;
    private double totalCost;

    public DataDijkstra(Noeud end, double totalCost) {
      this.end = end;
      this.totalCost = totalCost;
    }

    public Noeud getEnd() {
      return end;
    }

    public double getTotalCost() {
      return totalCost;
    }

    public void setTotalCost(double totalCost) {
      this.totalCost = totalCost;
    }

    public void setPredecessor(Noeud end) {
      predecessor = end;
    }

    public Noeud getPredecessor() {
      return predecessor;
    }
  }
}
