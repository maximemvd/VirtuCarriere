/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package virtucarriere.Domaine.Controller;

import java.awt.Point;
import java.io.File;
import java.io.Serializable;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import virtucarriere.Domaine.Carriere.Plan.*;
import virtucarriere.Domaine.Carriere.Plan.Element;
import virtucarriere.Domaine.Carriere.Plan.Entree;
import virtucarriere.Domaine.Carriere.Plan.Equipement;
import virtucarriere.Domaine.Carriere.Plan.Noeud;
import virtucarriere.Domaine.Carriere.Plan.Plan;
import virtucarriere.Domaine.Carriere.Plan.Tas;
import virtucarriere.Domaine.Carriere.Simulation.Camion;
import virtucarriere.Domaine.Carriere.Simulation.Chargeur;
import virtucarriere.Domaine.Carriere.Simulation.Facture;
import virtucarriere.Domaine.Carriere.Simulation.Simulation;
import virtucarriere.Domaine.Controller.Controller.EquipementModes;

public class ElementContainer implements Serializable, Observer, Observable {

  private Plan plan = new Plan();
  private Simulation simulation = new Simulation();
  static File file;
  private URL url = null;
  private List<Observer> observerList = new ArrayList<>();
  
  public Simulation getSimulation(){
    return this.simulation;
  }
  
  public void setSimulation(Simulation simulation){
    setCamionList(simulation.getCamionList());
    setChargeurList(simulation.getChargeurList());
  }
  
  public void setCamionList(List<Camion> camionList){
    simulation.setCamionList(camionList);
  }
  
  public void setChargeurList(List<Chargeur> chargeurList){
    simulation.setChargeurList(chargeurList);
  }

  public void initObserver(Controller controller) {
    addObserver(controller);
    plan.initObservers(this);
    simulation.addObserver(this);
  }

  @Override
  public void update(String action, Object element) {
    notifyObservers(action, element);
  }

  @Override
  public void notifyObservers(String action, Object element) {
    for (Observer observer : this.observerList) {
      observer.update(action, element);
    }
  }

  @Override
  public void addObserver(Observer observer) {
    this.observerList.add(observer);
  }

  @Override
  public void removeObserver(Observer observer) {
    this.observerList.remove(observer);
  }

  public URL getBackGroundUrl() {
    return url;
  }

  public void setUrlBackGround(URL newUrl) {
    this.url = newUrl;
  }

  public void switchSelectionStatus(double x, double y, boolean isShiftDown) {
    plan.switchSelectionStatus(x, y);
  }

  public void updateSelectedItemsPosition(double deltaX, double deltaY) {
    plan.updateSelectedItemsPosition(deltaX, deltaY);
    simulation.updateSelectedItemsPosition(deltaX, deltaY);
  }

  public Chargeur trouverChargeurCorrespondant(Tas tas) {
    return simulation.choisirChargeurIdeal(tas);
  }

  public Vector<AbstractPointChemin> ChargeurCheminToPath(
      Chargeur p_chargeur, Tas p_tas, List<Noeud> noeudList) {
    return simulation.ChargeurCheminToPath(p_chargeur, p_tas);
  }

  public Tas trouverTasCorrespondant(List<Tas> tas, String produit) {
    return simulation.trouverTas(tas, produit);
  }

  public void setFile(File p_file) {
    this.file = p_file;
  }

  public List<Noeud> getAllNoeuds() {
    return plan.getAllNoeuds();
  }

  public Vector<AbstractPointChemin> cheminDuCamion(Tas tas) {
    return simulation.cheminDuCamion(tas);
  }

  public File getFile() {
    return file;
  }

  public void isNoeudPresent(Noeud p_noeud) {
    plan.isNoeudPresent(p_noeud);
  }

  public void isEquipementPresent(Equipement equipement) {
    plan.isEquipementPresent(equipement);
  }

  public void addArc(Point point) {
    plan.addArc(point);
  }
  
  public void quickAddNoeud(AbstractPointChemin noeud){
    plan.quickAddNoeud(noeud);
  }
  
  public void quickAddConvoyeur(Convoyeur convoyeur){
    plan.quickAddConvoyeur(convoyeur);
  }
  
  public void quickAddArc(Arc arc){
    plan.quickAddArc(arc);
  }

  public void addChemin(Point point) {
    plan.addChemin(point);
  }

  public void clearEquipementConv() {
    plan.clearEquipementConv();
  }

  public void addElement(Point mousePoint, EquipementModes mode, double angle) {
    if (null != mode)
      switch (mode) {
        case CONVOYEUR:
          plan.addConvoyeur(mousePoint);
          break;
        case CONCASSEUR:
          plan.addConcasseur(mousePoint, angle);
          break;
        case CRIBLE:
          plan.addCrible(mousePoint, angle);
          break;
        case BROYEUR:
          plan.addBroyeur(mousePoint, angle);
          break;
        case NOEUD:
          plan.addNoeud(mousePoint);
          break;
        case TAS:
          // plan.addTas(mousePoint);
          break;
        case ENTREE:
          plan.addEntree(mousePoint);
          break;
        default:
          break;
      }
  }

  public void removePlan(Element element) {
    plan.removeElement(element);
  }

  public void addTas(Point mousePoint, String code, double angle) {
    plan.addTas(mousePoint, code, angle);
  }

  public void removeCamion(Camion p_camion) {
    simulation.removeCamion(p_camion);
  }
  
  public void quickAddCamion(Camion camion){
    simulation.quickAddCamion(camion);
  }

  public void addCamion(Point point, String client, String produit, double qte, int p_temps) {
    simulation.CamionShowUp(point, client, produit, qte, p_temps);
  }

  public void changementSelectionStatus(double x, double y) {
    simulation.changementSelectionStatus(x, y);
  }

  public void removeArc(Arc p_arc) {
    plan.removeArc(p_arc);
  }

  public void removeConvoyeur(Convoyeur convoyeur) {
    plan.removeConvoyeur(convoyeur);
  }
  
  public void quickAddChargeur(Chargeur chargeur){
    simulation.quickAddChargeur(chargeur);
  }

  public void addChargeur(Point point) {
    simulation.addChargeur(point);
  }

  public List<Camion> getCamionList() {
    return simulation.getCamionList();
  }

  public void EditCamion(Camion p_camion, String nom, String produit, double qte) {
    simulation.EditCamion(p_camion, nom, produit, qte);
  }

  public void generateFacture(Camion p_camion) {
    simulation.genererFacture(p_camion);
  }

  public boolean verificationJeton(Camion p_camion, Chargeur p_chargeur) {
    return simulation.verificationJeton(p_camion, p_chargeur);
  }

  public Vector<AbstractPointChemin> cheminDuCamionRetour(Tas tas) {
    return simulation.cheminDuCamionRetour(tas);
  }

  public void removeChargeur(Chargeur p_chargeur) {
    simulation.removeChargeur(p_chargeur);
  }

  public Facture genererFacture(Camion p_camion) {
    return simulation.genererFacture(p_camion);
  }

  public List<Chargeur> getChargeurList() {
    return simulation.getChargeurList();
  }

  public void createToken(String client, String produit, double quantite) {
    simulation.createToken(client, produit, quantite);
  }

  public List<Noeud> getNoeudForArcList() {
    return plan.getNoeudForArcList();
  }

  public List<AbstractPointChemin> getPointsForArcList() {
    return plan.getPointsForArcList();
  }

  public List<Equipement> getEquipementList() {
    return plan.getEquipements();
  }

  public Entree getEntree() {
    return plan.getEntree();
  }

  public List<AbstractPointChemin> getNoeudList() {
    return plan.getNoeuds();
  }

  public ArrayList<List<Arc>> getArcList() {
    return plan.getArcs();
  }

  public ArrayList<List<Convoyeur>> getConvoyeurList() {
    return plan.getConvoyeurs();
  }

  public void removeEquipement(Equipement equipement) {
    plan.removeEquipement(equipement);
  }

  public void addEquipement(Equipement equipement) {
    plan.addEquipment(equipement);
  }

  public void addConvoyeurForPopup(Equipement firstEquipement, Equipement secondEquipement) {
    plan.addConvoyeurForPopup(firstEquipement, secondEquipement);
  }

  public void removeNoeud(AbstractPointChemin noeud) {
    plan.removeNoeud(noeud);
  }

  public void snapSelectedElementToGrid(double gridGap) {
    for (Element element : plan.getEquipements()) {
      if (element.isSelected()) {
        this.snapElementToGrid(element, gridGap);
      }
    }
  }






  private void snapElementToGrid(Element element, double gridGap) {
    int horizontal = (int) (element.getX() / gridGap);
    int vertical = (int) (element.getY() / gridGap);

    // Point2D[] gridSquaresCorners = getGridSquareCorners(horizontal, vertical, gridGap);
    // Point2D closestCorner =
  }
  /*
    private Point2D[] getGridSquareCorners(double horizontalGridSquare, double verticalGridSquare, double gridGap) {
      double[] gridSquarePos = getGridSquarePos(horizontalGridSquare, verticalGridSquare, gridGap);

      Point2D topLeft = new Point2D.Double(gridSquarePos[0], gridSquarePos[2]);
      Point2D topRight = new Point2D.Double(gridSquarePos[1], gridSquarePos[2]);
      Point2D bottomRight = new Point2D.Double(gridSquarePos[1], gridSquarePos[3]);
      Point2D bottomLeft = new Point2D.Double(gridSquarePos[0], gridSquarePos[3]);

      return new Point2D[]{topLeft, topRight, bottomRight, bottomLeft};

    }



  */

  public Element getElement(Point point) {
    return plan.getElement(point);
  }

  public boolean validateDependencies() {
    return plan.validateDependencies();
  }

  public GraphChemins getGraphChemin() {
    return plan.GetGraphChemins();
  }

  public void setGraphCheminSimulation(GraphChemins p_chemin) {
    simulation.setGraphCheminSimulation(p_chemin);
  }
}
