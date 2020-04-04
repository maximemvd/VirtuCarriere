package virtucarriere.Domaine.Carriere.Simulation;
/** @author philippevincent */
import java.awt.Point;
import java.util.LinkedList;
import java.util.List;

public class Simulation {

  List<Camion> camionList;

  List<Chargeur> chargeurList;

  private boolean simulation;

  public Simulation() {
    camionList = new LinkedList<Camion>();
    chargeurList = new LinkedList<Chargeur>();
    simulation = true;
  };

  public void CamionShowUp(String client, String produit, double quantite) {

    Jeton jeton = createToken(client, produit, quantite);
    int sizeCamion = camionList.size();
    int start = 100 * sizeCamion;
    Point point = new Point(start, start);
    Camion camionSimulation = new Camion(jeton, start, point); // create camion
    camionList.add(camionSimulation);
  }

  public List<Camion> getCamionList() {
    return camionList;
  }

  public Jeton createToken(String client, String produit, double quantite) {
    Jeton newJeton = new Jeton(client, produit, quantite, "ENCOURS");
    return newJeton;
  }

  public Point indiqueAuCamionEmplacement(String produit, double quantite) {
    // getSHortestPath to produit
    Point point = new Point(200, 200);
    return point;
  };

  public void changeEtat(Camion p_camion, String etat) {
    p_camion.changeEtat(etat);
  }
}
