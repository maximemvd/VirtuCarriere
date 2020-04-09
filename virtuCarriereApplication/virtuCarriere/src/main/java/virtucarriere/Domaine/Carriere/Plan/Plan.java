package virtucarriere.Domaine.Carriere.Plan;

import java.awt.Point;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import javax.swing.*;

public class Plan {

  GraphConvoyeur equipments;
  GraphChemins chemins;
  List<Noeud> noeudsForArcList;
  List<Entree> entreeList;

  public Plan() {
    equipments = new GraphConvoyeur();
    chemins = new GraphChemins();
    noeudsForArcList = new LinkedList<Noeud>();
    entreeList = new LinkedList<Entree>();
  }

  public void addArc(Arc arc) {
    chemins.addLink(arc);
  }

  public void removeArc(Arc arc) {
    chemins.removeLink(arc);
  }

  public void addEquipment(Equipement equipement) {
    equipments.addEnd(equipement);
  }

  public void addBroyeur(Point mousePoint) {
    Broyeur broyeur = new Broyeur(mousePoint, 1, 1, 0);
    addEquipment(broyeur);
  }

  public void addConcasseur(Point mousePoint) {
    Concasseur concasseur = new Concasseur(mousePoint, 1, 1, 0);
    addEquipment(concasseur);
  }

  public void addCrible(Point mousePoint) {
    Crible crible = new Crible(mousePoint, 1, 1, 0);
    addEquipment(crible);
  }

  public void addTas(Point mousePoint) {
    Tas tas = new Tas(mousePoint, 1, 1, "code", 1);
    addEquipment(tas);
    // TODO add noeudChargement;
  }

  public void addConvoyeur(Point mousePoint) {
    // Convoyeur convoyeur = new Convoyeur(mousePoint, 1, 4, );
    // equipments.addLink(convoyeur);
  }

  public void addEntree(Point mousePoint) {
    if (this.entreeList.size() == 1) {
      JOptionPane.showMessageDialog(
          null, "Attention, il ne peut avoir qu'une seule entrée à la carrière");
    } else {
      Entree entree = new Entree(mousePoint, 2, 4, 0);
      chemins.addEnd(entree);
      entreeList.add(entree);
    }
  }

  public void removeEntree(Entree entree) {
    chemins.removeEnd(entree);
  }

  public boolean validateElementPresent(Point point) {
    return false;
  }

  public void addNoeud(Point mousePoint) {
    Noeud noeud = new Noeud(mousePoint, 3, 3);
    chemins.addEnd(noeud);
  }

  public Element getElement(Element element) {
    // TODO aller chercher

    return element;
  }

  public void deleteSelected() {
    // TODO delete les éléments sélectionnés
  }

  public void updateSelectedItemsPosition(double deltaX, double deltaY) {

    for (Element item : getEquipements()) {
      if (item.isSelected()) {
        item.translate(deltaX, deltaY);
      }
    }
    for (Element item : getNoeuds()) {
      if (item.isSelected()) {
        item.translate(deltaX, deltaY);
      }
    }

    for (Element item : getEntreeList()) {
      if (item.isSelected()) {
        item.translate(deltaX, deltaY);
      }
    }
  }

  public void removeNoeud(AbstractPointChemin noeud) {
    chemins.removeEnd(noeud);
  }

  public boolean isNoeudPresent(Noeud p_noeud) {

    /*
    for (Noeud item : this.noeudList) {
      if (item.contains(p_noeud.getX(), p_noeud.getY())) {
        return true;
      }
    }
    return false;
    */
    return true;
  }

  public boolean isEquipementPresent(Equipement equipement) {
    // TODO
    return true;
  }

  public void switchSelectionStatus(double x, double y) {
    for (Element item : getEquipements()) {
      if (item.contains(x, y)) {
        item.switchSelectionStatus();
      }
    }

    for (Element item : getNoeuds()) {
      if (item.contains(x, y)) {
        item.switchSelectionStatus();
      }
    }

    for (Element item : getEntreeList()) {
      if (item.contains(x, y)) {
        item.switchSelectionStatus();
      }
    }

    for (List<Arc> listOfArc : getArcs()) {
      for (Arc item : listOfArc) {
        Noeud starting = item.getStarting();
        Noeud arrival = item.getArrival();

        double xPosStarting = starting.getX();
        double yPosStarting = starting.getY();
        double xPosArrival = arrival.getX();
        double yPosArrival = arrival.getY();

        if (item.containsArc(x, y, xPosStarting, yPosStarting, xPosArrival, yPosArrival)) {
          item.switchSelectionStatus();
        }
      }
    }
  }

  public void removePlan(Element element) {
    // TODO implement remove element;
  }

  public void noeudSelection(double x, double y) {
    for (Element noeud : getNoeuds()) {
      if (noeud.contains(x, y)) {
        noeudsForArcList.add((Noeud) noeud);
        noeud.setSelectionStatus(true);
      }
    }
  }

  public void removeElement(Element element) {}

  public void removeEquipement(Equipement equipement) {
    equipments.removeEnd(equipement);
  }

  public List<Equipement> getEquipements() {
    return equipments.getEnds();
  }

  public ArrayList<List<Convoyeur>> getConvoyeurs() {
    return equipments.getLinks();
  }

  public List<AbstractPointChemin> getNoeuds() {
    return chemins.getEnds();
  }

  public ArrayList<List<Arc>> getArcs() {
    return chemins.getLinks();
  }

  public List<Noeud> getNoeudForArcList() {
    return this.noeudsForArcList;
  }

  public List<Entree> getEntreeList() {
    return this.entreeList;
  }
}
