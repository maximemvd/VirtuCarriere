package virtucarriere.Domaine.Carriere.Simulation;
/** @author philippevincent */
import java.awt.Point;
import java.util.LinkedList;
import java.util.List;

public class Simulation {

  List<Camion> camionList;

  List<Chargeur> chargeurList;

  private Chargeur chargeurCourant;

  public Simulation() {
    camionList = new LinkedList<Camion>();
    chargeurList = new LinkedList<Chargeur>();
  };

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
  public void CamionShowUp(String client, String produit, double quantite) {
    Jeton jeton = createToken(client, produit, quantite);
    int sizeCamion = camionList.size();
    int start = 100 * sizeCamion;
    Point point = new Point(start, start);
    Camion camionSimulation = new Camion(jeton, start, point, false); // create camion
    camionList.add(camionSimulation);
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

  //  chargeur
  public void addChargeur(Chargeur p_chargeur) {
    chargeurList.add(p_chargeur);
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
    Jeton newJeton = new Jeton(client, produit, quantite, "ENCOURS");
    return newJeton;
  }

  public void changeEtat(Camion p_camion, String etat) {
    p_camion.changeEtat(etat);
  }

  public boolean verificationJeton(Camion p_camion) {
    //  Si le jeton courant du chargeur est bien égal au jeton du camion, le camion est chargé, son
    // jeton passe à l'état livré.
    return p_camion.getJeton() == getJetonChargeurCourant();
  }

  public Facture genererFacture(Camion p_camion) {
    // on va dire que tous les materiaux coutent 10$ pour l'instant
    double quantity = p_camion.getJeton().getQuantite();
    Facture facture = new Facture(10, quantity);
    return facture;
  }

  public void envoieAuCHargeur(Jeton jeton) {
    // retourne le chargeur que l'on veut
  }

  public Point indiqueAuCamionEmplacement(String produit) {
    // getSHortestPath to produit
    Point point = new Point(300, 500);
    return point;
  };
}
