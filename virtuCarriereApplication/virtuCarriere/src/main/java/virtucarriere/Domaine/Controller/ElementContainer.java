/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package virtucarriere.Domaine.Controller;

import java.awt.Point;
import java.io.File;
import java.io.Serializable;
import java.util.List;
import java.util.Vector;
import virtucarriere.Domaine.Carriere.Plan.Element;
import virtucarriere.Domaine.Carriere.Plan.Entree;
import virtucarriere.Domaine.Carriere.Plan.Equipement;
import virtucarriere.Domaine.Carriere.Plan.Noeud;
import virtucarriere.Domaine.Carriere.Plan.Plan;
import virtucarriere.Domaine.Carriere.Plan.Tas;
import virtucarriere.Domaine.Carriere.Simulation.Camion;
import virtucarriere.Domaine.Carriere.Simulation.Chargeur;
import virtucarriere.Domaine.Carriere.Simulation.Simulation;
import virtucarriere.Domaine.Carriere.Simulation.Vehicule;
import virtucarriere.Domaine.Controller.Controller.EquipementModes;
import virtucarriere.Domaine.Controller.Controller.VehiculeModes;

public class ElementContainer implements Serializable {

  private Plan plan = new Plan();
  private Simulation simulation = new Simulation();
  static File file;

  // TODO add function to get element with argument point
  public void switchSelectionStatus(double x, double y, boolean isShiftDown) {
    plan.switchSelectionStatus(x, y);
  }

  public void updateSelectedItemsPosition(double deltaX, double deltaY) {
    plan.updateSelectedItemsPosition(deltaX, deltaY);
  }
  
  public Tas trouverTasCorrespondant(String produit){
      return simulation.trouverTas(produit);
  }

  public void noeudSelection(double x, double y) {
    /*
        for (Noeud noeud : this.noeudList) {
        if (noeud.contains(x, y)) {
          noeudForArcList.add(noeud);
          noeud.setSelectionStatus(true);
        }
      }
    */
    plan.noeudSelection(x, y);
  }

  public void setFile(File p_file) {
    this.file = p_file;
  }
  
  public Vector<Noeud> cheminDuCamion(Tas tas){
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

  public void addElement(Point mousePoint, EquipementModes mode) {
    if (null != mode)
      switch (mode) {
        case CONCASSEUR:
          plan.addConcasseur(mousePoint);
          break;
        case CRIBLE:
          plan.addCrible(mousePoint);
          break;
        case BROYEUR:
          plan.addBroyeur(mousePoint);
          break;
        case NOEUD:
          plan.addNoeud(mousePoint);
          break;
        case TAS:
          plan.addTas(mousePoint);
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

  public void removeVehicule(Vehicule p_vehicule) {
    System.out.println("hello world");
    simulation.removeVehicule(p_vehicule);
  }

  public void addVehicule(
      VehiculeModes mode, Point mousePoint, double qte, String produit, String client) {
    if (null != mode)
      switch (mode) {
        case CAMION:
          simulation.CamionShowUp(client, produit, qte);
          break;
        case CHARGEUR:
          simulation.addChargeur(mousePoint);
          break;
      }
  }
  
  public List<Camion> getCamionList() {
       return simulation.getCamionList();
  }

 
  public void generateFacture(Camion p_camion) {
    simulation.genererFacture(p_camion);
  }

  public void verificationJeton(Camion p_camion) {
    simulation.verificationJeton(p_camion);
  }

  public void changeEtat(Camion p_camion, String etat) {
    simulation.changeEtat(etat);
  }


  
  public List<Chargeur> getChargeurList(){
     return  simulation.getChargeurList();
  }
  
  public void createToken(String client, String produit, double quantite) {
    simulation.createToken(client, produit, quantite);
  }
}
