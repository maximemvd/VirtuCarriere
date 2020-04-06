/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package virtucarriere.Domaine.Controller;

import java.awt.Point;
import java.io.*;
import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;
import javax.swing.JOptionPane;
import virtucarriere.Domaine.Carriere.Plan.Arc;
import virtucarriere.Domaine.Carriere.Plan.Element;
import virtucarriere.Domaine.Carriere.Plan.Entree;
import virtucarriere.Domaine.Carriere.Plan.Equipement;
import virtucarriere.Domaine.Carriere.Plan.Noeud;
import virtucarriere.Domaine.Carriere.Simulation.Camion;
import virtucarriere.Domaine.Carriere.Simulation.Chargeur;
import virtucarriere.Domaine.Carriere.Simulation.Vehicule;

public class ElementContainer implements Serializable {

  private List<Equipement> equipementList;
  private List<Noeud> noeudList;
  private List<Vehicule> vehiculeList;
  private List<Entree> entreeList;
  private List<Arc> arcList;
  private List<Element> selectionList;
  private List<Noeud> noeudForArcList;
  static File file;

  public ElementContainer() {
    equipementList = new LinkedList<Equipement>();
    vehiculeList = new LinkedList<Vehicule>();
    noeudList = new LinkedList<Noeud>();
    entreeList = new LinkedList<Entree>();
    arcList = new LinkedList<Arc>();
    noeudForArcList = new LinkedList<Noeud>();
  }

  public void switchSelectionStatus(double x, double y, boolean isShiftDown) {
    for (Element item : this.equipementList) {
      if (item.contains(x, y)) {
        item.switchSelectionStatus();
      }
    }

    for (Element item : this.noeudList) {
      if (item.contains(x, y)) {
        item.switchSelectionStatus();
      }
    }

    for (Element item : this.entreeList) {
      if (item.contains(x, y)) {
        item.switchSelectionStatus();
      }
    }

    for (Vehicule item : this.vehiculeList) {
      if (item.contains(x, y)) {
        item.switchSelectionStatus();
      }
    }
  }

  void updateSelectedItemsPosition(double deltaX, double deltaY) {
    for (Element item : this.equipementList) {
      if (item.isSelected()) {
        item.translate(deltaX, deltaY);
      }
    }
    for (Element item : this.noeudList) {
      if (item.isSelected()) {
        item.translate(deltaX, deltaY);
      }
    }
  }

  public void noeudSelection(double x, double y) {
    for (Noeud noeud : this.noeudList) {
      if (noeud.contains(x, y)) {
        noeudForArcList.add(noeud);
        noeud.setSelectionStatus(true);
      }
    }
  }

  public List<Noeud> getNoeudForArcList() {
    return this.noeudForArcList;
  }

  public boolean equipementIsEmpty() {
    return equipementList.isEmpty();
  }

  public boolean VehiculeIsEmpty() {
    return vehiculeList.isEmpty();
  }

  public boolean noeudIsEmpty() {
    return noeudList.isEmpty();
  }

  public List<Equipement> getEquipemenetList() {
    return equipementList;
  }

  public List<Element> getSelectionList() {
    return selectionList;
  }

  public List<Vehicule> getVehiculeList() {
    return vehiculeList;
  }

  public List<Noeud> getNoeudList() {
    return noeudList;
  }

  public List<Entree> getEntreeList() {
    return entreeList;
  }

  public List<Arc> getArcList() {
    return arcList;
  }

  public double getNumberOfEquipementList() {
    return equipementList.size();
  }

  public double getNumberOfVehiculeList() {
    return vehiculeList.size();
  }

  public double getNumberOfNoeudList() {
    return noeudList.size();
  }

  public void setFile(File p_file) {
    this.file = p_file;
  }

  public File getFile() {
    return file;
  }

  public boolean isEquipmentPresent(Equipement p_equipement) {
    for (Equipement item : this.equipementList) {
      if (item.contains(p_equipement.getX(), p_equipement.getY())) {
        return true;
      }
    }
    return false;
  }

  public void addEquipement(Equipement p_equipement) {
    if (isEquipmentPresent(p_equipement)) {
      JOptionPane.showMessageDialog(null, "Attention, un équipement est déjà présent");
    } else {
      equipementList.add(p_equipement);
    }
  }

  public void removeEquipement(Equipement p_equipement) {
    try {
      equipementList.remove(p_equipement);
    } catch (Exception error) {
      System.out.println(error);
    }
  }

  public void addChargeur(Chargeur p_chargeur) {
    vehiculeList.add(p_chargeur);
  }

  public void removeVehicule(Vehicule p_vehicule) {
    try {
      vehiculeList.remove(p_vehicule);
    } catch (Exception error) {
      System.out.println(error);
    }
  }

  public boolean isVehiculePresent(Vehicule p_vehicule) {
    for (Vehicule item : this.vehiculeList) {
      if (item.contains(p_vehicule.getX(), p_vehicule.getY())) {
        return true;
      }
    }
    return false;
  }

  public void addCamion(Camion p_Camion) {
    if (isVehiculePresent(p_Camion)) {
      JOptionPane.showMessageDialog(null, "Attention, un véhicule est déjà présent");
    } else {
      vehiculeList.add(p_Camion);
    }
  }

  public void addEntree(Entree newEntree) {
    if (entreeList.size() == 1) {
      JOptionPane.showMessageDialog(
          null, "Attention, il ne peut y avoir qu'une seule entrée à la carrière");
    } else {
      entreeList.add(newEntree);
    }
  }

  public void addArc(Arc newArc) {
    arcList.add(newArc);
  }

  public void removeArc(Arc p_arc) {
    try {
      arcList.remove(p_arc);
    } catch (Exception error) {
      System.out.println(error);
    }
  }

  public void removeEntree(Entree p_entree) {
    try {
      entreeList.remove(p_entree);
    } catch (Exception error) {
      System.out.println(error);
    }
  }

  public boolean isNoeudPresent(Noeud p_noeud) {
    for (Noeud item : this.noeudList) {
      if (item.contains(p_noeud.getX(), p_noeud.getY())) {
        return true;
      }
    }
    return false;
  }

  public void addNoeud(Noeud p_noeud) {
    if (isNoeudPresent(p_noeud)) {
      JOptionPane.showMessageDialog(null, "Attention, un noeud ou un tas est déjà présent");
    } else {
      noeudList.add(p_noeud);
    }
  }

  public void removeNoeud(Noeud p_noeud) {
    try {
      noeudList.remove(p_noeud);
    } catch (Exception error) {
      System.out.println(error);
    }
  }

  // public void generateCamionSimulation(Jeton jeton, double depart) {
  //     Camion vehiculePretPourSimulation = vehiculeList.get(0);
  //     System.out.println(vehiculePretPourSimulation);
  //     // appeler fonction pour simulation
  //     this.vehiculeList.remove(vehiculePretPourSimulation);
  // }

  public String askReason() {
    return "La raison";
  }

  // public double getNextPosition() {
  //     double nextPosition = 10;
  //     return nextPosition;
  // }

  public boolean askValidPlace(Point point) {
    double x = point.getX();
    double y = point.getY();

    if (x < 0 && y < 0) {
      return false;
    } else {
      return true;
    }
  }

  public boolean validanceDependance(String type, Point point) {
    return true;
  }
}
