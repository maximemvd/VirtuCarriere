/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package virtucarriere.Domaine.Controller;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;
import virtucarriere.Domaine.Carriere.Plan.Broyeur;
import virtucarriere.Domaine.Carriere.Plan.Concasseur;
import virtucarriere.Domaine.Carriere.Plan.Crible;
import virtucarriere.Domaine.Carriere.Plan.Equipement;
import virtucarriere.Domaine.Carriere.Plan.Noeud;
import virtucarriere.Domaine.Carriere.Simulation.Camion;

public class Controller {

  private double attribute;

  private int undoRedo;
  private ArrayList<ElementContainer> elementContainerList;

  private ElementContainer elementContainer;

  public enum EquipementModes {
    CONCASSEUR,
    CRIBLE,
    BROYEUR,
    CONVOYEUR,
    NOEUD,
    TAS
  }

  public Controller(ElementContainer elementContainer) {
    this.elementContainer = elementContainer;
  }

  public Controller() {
    elementContainer = new ElementContainer();
  }

  public void setElement(ElementContainer elementContainer) {
    this.elementContainer = elementContainer;
  }

  public void addCrible(Point mousePoint) {
    Crible newCrible = new Crible(mousePoint, 2, 2, true, 2);
    elementContainer.addEquipement(newCrible);
  }

  public void addConcasseur(Point mousePoint) {
    Concasseur newConcasseur = new Concasseur(mousePoint, 2, 2, true, 2);
    elementContainer.addEquipement(newConcasseur);
  }

  public void addBroyeur(Point mousePoint) {
    Broyeur newBroyeur = new Broyeur(mousePoint, 2, 2, true, 2);
    elementContainer.addEquipement(newBroyeur);
  }
  /*
   public void addConvoyeur(Point mousePoint) {
     Noeud noeud = new Noeud(mousePoint, 1, 1, true);
     Convoyeur newConvoyeur = new Convoyeur(mousePoint, 2, 2, true, 2, noeud);
     elementContainer.addEquipement(newConvoyeur);
   }

  */

  public void addEquipement(EquipementModes mode, Point mousePoint) {
    if (null != mode)
      switch (mode) {
        case CONCASSEUR:
          addConcasseur(mousePoint);
          break;
        case CRIBLE:
          addCrible(mousePoint);
          break;
          /*
          case CONVOYEUR:
            addConvoyeur(mousePoint);
            break;
             */
        case BROYEUR:
          addBroyeur(mousePoint);
          break;
        case NOEUD:
          addNoeud(mousePoint);
          break;
        default:
          break;
      }
  }

  public void addTas(Point mousePoint) {
    System.out.print("hey");
  }

  public void addNoeud(Point mousePoint) {
    Noeud noeud = new Noeud(mousePoint, 1, 1, true);
    elementContainer.addNoeud(noeud);
  }

  public void switchSelectionStatus(double x, double y, boolean isShiftDown) {
    this.elementContainer.switchSelectionStatus(x, y, isShiftDown);
  }

  public ElementContainer getElementContainer() {
    return elementContainer;
  }

  public List<Equipement> getEquipementList() {
    return elementContainer.getEquipemenetList();
  }

  public List<Camion> getCamionList() {
    return elementContainer.getVehiculeList();
  }

  public List<Noeud> getNoeudList() {
    return elementContainer.getNoeudList();
  }

  public void addContainer() {
    // ElementContainer elementContainer = new ElementContainer(this.elementContainer);

  }

  private void deleteElementsAfterPointer(int undoRedoPointerState) {
    if (elementContainerList.isEmpty()) {
      return;
    }
  }

  public void undo() {}

  public void redo() {}
}
