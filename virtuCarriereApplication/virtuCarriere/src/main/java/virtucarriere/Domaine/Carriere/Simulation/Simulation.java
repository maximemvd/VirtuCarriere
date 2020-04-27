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
import virtucarriere.Domaine.Carriere.Plan.Element;
import virtucarriere.Domaine.Controller.*;

public class Simulation implements Serializable, Observable {

  private GraphChemins graphChemin;
  private AlgoChemin algoChemin;
  List<Camion> camionList;
  List<Chargeur> chargeurList;
  List<Observer> observerList = new LinkedList<>();

  public Simulation() {
    camionList = new LinkedList<Camion>();
    chargeurList = new LinkedList<Chargeur>();
    algoChemin = new AlgoChemin(graphChemin);
  }
  
  public void setCamionList(List<Camion> camionList){
    this.camionList = camionList;
  }
  
  public void setChargeurList(List<Chargeur> chargeurList){
    this.chargeurList = chargeurList;
  }
  
  @Override
  public void notifyObservers(String action, Object element){
    for (Observer observer : this.observerList){
      observer.update(action, element);
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

  public void setGraphCheminSimulation(GraphChemins p_graphChemin) {
    this.graphChemin = p_graphChemin;
    this.algoChemin = new AlgoChemin(graphChemin);
  }

  public void EditCamion(Camion p_camion, String nom, String produit, double qte) {
    Jeton jeton = new Jeton(nom, produit, qte);
    p_camion.editerParams(jeton);
  }

  public void CamionShowUp(Point point, String client, String produit, double quantite, int p_temps) {
    try {
      Jeton jeton = new Jeton(client, produit, quantite);
      Camion camionSimulation = new Camion(jeton, point, 0, p_temps); // create camion
      camionList.add(camionSimulation);
      notifyObservers("add", camionSimulation);
    } catch (Exception exception) {
      System.out.println(exception);
    }
  }
  
  public void quickAddCamion(Camion camion){
    camionList.add(camion);
    notifyObservers("add", camion);
  }

  public void removeCamion(Camion p_camion) {
    try {
      camionList.remove(p_camion);
      notifyObservers("delete", p_camion);
    }
    catch (Exception error) {
      System.out.println(error);
    }
  }

  public List<Camion> getCamionList() {
    return camionList;
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
      Chargeur p_chargeur = new Chargeur(p_point, 0);
      chargeurList.add(p_chargeur);
      notifyObservers("add", p_chargeur);
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

  public void quickAddChargeur(Chargeur chargeur){
    chargeurList.add(chargeur);
  }
  
  public void removeChargeur(Chargeur p_chargeur) {
    try {
      chargeurList.remove(p_chargeur);
      notifyObservers("delete", p_chargeur);
    } catch (Exception error) {
      System.out.println(error);
    }
  }

  public List<Chargeur> getChargeurList() {
    return chargeurList;
  }


  public Jeton createToken(String client, String produit, double quantite) {
    return new Jeton(client, produit, quantite);
  }

  public boolean verificationJeton(Camion p_camion, Chargeur p_chargeur) {
    return p_camion.getJeton() == p_chargeur.getJeton();
  }

  public Facture genererFacture(Camion p_camion) {
    Jeton jeton = p_camion.getJeton();
   return new Facture(jeton.getCodeProduit(), jeton.getQuantite());
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
    }
    return chargeurSimulation;
  }

  public Vector<AbstractPointChemin> ChargeurCheminToPath(Chargeur p_chargeur, Tas p_tas) {
    return algoChemin.getShortestPathBetweenTowPoints(p_chargeur.getPoint(), p_tas.getPoint());
  }
}
