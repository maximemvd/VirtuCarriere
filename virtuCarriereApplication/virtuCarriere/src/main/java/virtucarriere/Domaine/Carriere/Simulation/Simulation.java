package virtucarriere.Domaine.Carriere.Simulation;
/** @author philippevincent */
import java.awt.Point;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.atomic.AtomicReference;
import virtucarriere.Domaine.Carriere.Plan.AbstractPointChemin;
import virtucarriere.Domaine.Carriere.Plan.Entree;
import virtucarriere.Domaine.Carriere.Plan.GraphChemins;
import virtucarriere.Domaine.Carriere.Plan.Tas;

public class Simulation implements Serializable {

  private GraphChemins graphChemin;
  private AlgoChemin algoChemin;
  List<Camion> camionList;
  List<Chargeur> chargeurList;
  private Chargeur chargeurCourant;
  private boolean simulationAnimation;
  private double simulationSpeed;

  public Simulation() {
    simulationSpeed = 2;
    simulationAnimation = false;
    camionList = new LinkedList<Camion>();
    chargeurList = new LinkedList<Chargeur>();
    algoChemin = new AlgoChemin(graphChemin);
  }

  public void setGraphCheminSimulation(GraphChemins p_graphChemin) {
    this.graphChemin = p_graphChemin;
    this.algoChemin = new AlgoChemin(graphChemin);
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
    List<Vehicule> vehicules = new ArrayList<>(camionList);
    vehicules.addAll(chargeurList);
    vehicules.stream()
        .filter(vehicule -> vehicule.contains(x, y))
        .forEach(Vehicule::switchSelectionStatus);
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
      }
    }
    return leTas;
  }

  private Entree getEntree() {
    return (Entree)
        graphChemin.getEnds().stream()
            .filter(abstractPointChemin -> abstractPointChemin instanceof Entree)
            .findFirst()
            .orElseThrow(() -> new RuntimeException("Aucune entree n'existe danms le plan"));
  }

  public Vector<AbstractPointChemin> cheminDuCamion(Tas tas) {
    return algoChemin.getShortestPathBetweenTwoNoeuds(getEntree(), tas.getPointChargement());
  }

  public Vector<AbstractPointChemin> cheminDuCamionRetour(Tas tas) {
    return algoChemin.getShortestPathBetweenTwoNoeuds(tas.getPointChargement(), getEntree());
  }

  public Chargeur choisirChargeurIdeal(Tas tas) {

    Vector<AbstractPointChemin> cheminMinimal = new Vector<>(graphChemin.getEnds());

    Chargeur chargeurSimulation = chargeurList.get(0);

    for (Chargeur chargeurCourant : chargeurList) {

      Vector<AbstractPointChemin> cheminChargeurCourant =
          ChargeurCheminToPath(chargeurCourant, tas);

      if (cheminMinimal.size() > cheminChargeurCourant.size()) {
        chargeurSimulation = chargeurCourant;
        cheminMinimal = cheminChargeurCourant;
      }

      System.out.print(chargeurSimulation);
    }
    return chargeurSimulation;
  }

  public Vector<AbstractPointChemin> ChargeurCheminToPath(Chargeur p_chargeur, Tas p_tas) {

    AtomicReference<Vector<AbstractPointChemin>> chemin = new AtomicReference<>();

    graphChemin.getEnds().stream()
        .filter(
            abstractPointChemin ->
                abstractPointChemin.contains(p_chargeur.getX(), p_chargeur.getY()))
        .findFirst()
        .ifPresent(
            abstractPointChemin ->
                chemin.set(
                    algoChemin.getShortestPathBetweenTwoNoeuds(
                        abstractPointChemin, p_tas.getNoeud())));

    return chemin.get();
  }
}
