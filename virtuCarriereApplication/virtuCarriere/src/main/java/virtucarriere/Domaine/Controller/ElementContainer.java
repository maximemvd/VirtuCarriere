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

  private List<Object> selectionList;

  static File file;

  public ElementContainer() {
    equipementList = new LinkedList<Equipement>();
    vehiculeList = new LinkedList<Vehicule>();
    noeudList = new LinkedList<Noeud>();
    entreeList = new LinkedList<Entree>();
    arcList = new LinkedList<Arc>();
    selectionList = new LinkedList<Object>();
  }

  public void switchSelectionStatus(double x, double y, boolean isShiftDown) {
    for (Element item : this.equipementList) {
      if (item.contains(x, y)) {
        item.switchSelectionStatus();
        selectionList.add(item);
      }
    }

    for (Element item : this.noeudList) {
      if (item.contains(x, y)) {
        item.switchSelectionStatus();
        selectionList.add(item);
      }
    }

    for (Element item : this.entreeList) {
      if (item.contains(x, y)) {
        item.switchSelectionStatus();
        selectionList.add(item);
      }
    }
  }

  void updateSelectedItemsPosition(Point delta) {
    for (Element item : this.equipementList) {
      if (item.isSelected()) {
        item.translate(delta);
      }
    }
    for (Element item : this.noeudList) {
      if (item.isSelected()) {
        item.translate(delta);
      }
    }
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

  public List<Object> getSelectionList() {
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

  public void addEquipement(Equipement p_equipement) {
    try {
      equipementList.add(p_equipement);
    } catch (Exception error) {
      System.out.println(error);
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

  public void removeChargeur(Chargeur p_chargeur) {
    try {
      vehiculeList.remove(p_chargeur);
    } catch (Exception error) {
      System.out.println(error);
    }
  }

  public void addCamion(Camion p_Camion) {
    vehiculeList.add(p_Camion);
  }

  public void removeCamion(Camion p_camion) {
    try {
      vehiculeList.remove(p_camion);
    } catch (Exception error) {
      System.out.println(error);
    }
  }

  public void addEntree(Entree newEntree) {
    entreeList.add(newEntree);
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

  public void addNoeud(Noeud p_noeud) {
    noeudList.add(p_noeud);
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
