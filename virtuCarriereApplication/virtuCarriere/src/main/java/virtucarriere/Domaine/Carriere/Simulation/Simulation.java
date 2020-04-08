package virtucarriere.Domaine.Carriere.Simulation;
/** @author philippevincent */
import java.awt.Point;
import java.util.LinkedList;
import java.util.List;
import virtucarriere.Domaine.Carriere.Plan.Entree;
import virtucarriere.Domaine.Carriere.Plan.GraphChemins;
import virtucarriere.Domaine.Carriere.Plan.GraphConvoyeur;
import virtucarriere.Domaine.Carriere.Plan.Noeud;
import virtucarriere.Domaine.Carriere.Plan.Tas;

public class Simulation {

  List<Camion> camionList;

  private Entree entreeCarriere;

  private List<Tas> tasList;

  private List<Noeud> noeudList;

  private GraphChemins graphChemin;

  private GraphConvoyeur graphConvoyeur;

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

  public Point indiqueAuCamionEmplacement(String produit) {
    List<Tas> tasValide = new LinkedList<>();
    tasList.forEach(
        (tas) -> {
          if (tas.getMaterialCode().equals(produit)) {
            tasValide.add(tas);
          }
        });
    // implémenter les méthodes a vincent
    Tas tas = tasValide.get(0);
    Point point = tas.getPoint();
    return point;
  };

  public void envoieAuCHargeur(Jeton jeton, Tas tas) {
    // retourne le chargeur que l'on veut
    Point pointTas = tas.getPoint();
    // implemente la méthode à Vincent
  }

  public void indiqueAuCamionCheminRetour() {};
}
