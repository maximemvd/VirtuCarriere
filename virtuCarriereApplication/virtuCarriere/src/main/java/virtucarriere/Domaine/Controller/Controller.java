/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package virtucarriere.Domaine.Controller;

import java.awt.Point;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.io.FileInputStream;
import java.io.*;
import javax.swing.*;
import javax.swing.filechooser.FileSystemView;
import virtucarriere.Domaine.Carriere.Plan.Arc;
import virtucarriere.Domaine.Carriere.Plan.Broyeur;
import virtucarriere.Domaine.Carriere.Plan.Concasseur;
import virtucarriere.Domaine.Carriere.Plan.Crible;
import virtucarriere.Domaine.Carriere.Plan.Entree;
import virtucarriere.Domaine.Carriere.Plan.Equipement;
import virtucarriere.Domaine.Carriere.Plan.Noeud;
import virtucarriere.Domaine.Carriere.Plan.Tas;
import virtucarriere.Domaine.Carriere.Simulation.Camion;

public class Controller implements Serializable {

  private double attribute;

  private int undoRedo;
  private ArrayList<ElementContainer> elementContainerList;

  private ElementContainer elementContainer;

  public enum EquipementModes {
    RIEN,
    CONCASSEUR,
    CRIBLE,
    BROYEUR,
    CONVOYEUR,
    NOEUD,
    TAS,
    ENTREE,
    ARC
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
    Crible newCrible = new Crible(mousePoint, 2, 2, false, 2);
    elementContainer.addEquipement(newCrible);
  }

  public void addConcasseur(Point mousePoint) {
    Concasseur newConcasseur = new Concasseur(mousePoint, 2, 2, false, 2);
    elementContainer.addEquipement(newConcasseur);
  }

  public void addBroyeur(Point mousePoint) {
    Broyeur newBroyeur = new Broyeur(mousePoint, 2, 2, false, 2);
    elementContainer.addEquipement(newBroyeur);
  }
  /*
    public void addConvoyeur(Point mousePoint) {
      Noeud noeud = new Noeud(mousePoint, 1, 1, false);
      Convoyeur newConvoyeur = new Convoyeur(mousePoint, 2, 2, false, 2, noeud);
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
        case TAS:
          addTas(mousePoint);
          break;
        case ENTREE:
          addEntree(mousePoint);
          break;
        case ARC:
          // addArc(mousePoint)
        default:
          break;
      }
  }

  public void removeEquipement(Equipement equipement) {
    elementContainer.removeEquipement(equipement);
  }

  public void addTas(Point mousePoint) {
    Tas tas = new Tas(mousePoint, 1, 1, false, "matériaux", 2);
    elementContainer.addNoeud(tas);
  }

  public void addNoeud(Point mousePoint) {
    Noeud noeud = new Noeud(mousePoint, 1, 1, false);
    elementContainer.addNoeud(noeud);
  }

  public void removeNoeud(Noeud noeud) {
    elementContainer.removeNoeud(noeud);
  }

  public void addEntree(Point mousePoint) {
    Entree entree = new Entree(mousePoint, 3, 3, false, 4);
    elementContainer.addEntree(entree);
  }

  public void removeEntree(Entree entree) {
    elementContainer.removeEntree(entree);
  }

  public void addArc(Point mousePoint, Noeud firstNoeud, Noeud secondNoeud) {
    Arc arc = new Arc(mousePoint, 5, 1, false, firstNoeud, secondNoeud);
    elementContainer.addArc(arc);
  }

  public void switchSelectionStatus(double x, double y, boolean isShiftDown) {
    this.elementContainer.switchSelectionStatus(x, y, isShiftDown);
  }

  public void updateSelectedItemsPositions(Point delta) {
    elementContainer.updateSelectedItemsPosition(delta);
  }

  public ElementContainer getElementContainer() {
    return elementContainer;
  }

  public List<Equipement> getEquipementList() {
    return elementContainer.getEquipemenetList();
  }

  public List<Arc> getArcList() {
    return elementContainer.getArcList();
  }

  public List<Object> getSelectionList() {
    return elementContainer.getSelectionList();
  }

  public List<Entree> getEntreeList() {
    return elementContainer.getEntreeList();
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

  public void openFile(){
    JFileChooser chooser = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());

    chooser.setDialogTitle("Open");
    int returnValue = chooser.showDialog(null, "Open");

    if (returnValue == JFileChooser.APPROVE_OPTION) {
        File selectedFile = chooser.getSelectedFile();
        try {
            FileInputStream inputFile = new FileInputStream(new File(String.valueOf(selectedFile)));
            ObjectInputStream inputObject = new ObjectInputStream(inputFile);
            setElement((ElementContainer) inputObject.readObject());
            System.out.println(selectedFile);
            selectedFile = new File(String.valueOf(selectedFile).substring(0, String.valueOf(selectedFile).lastIndexOf('.')));
            elementContainer.setFile(selectedFile);
            

        } catch (IOException e) {
            System.out.println(e);
        } catch (ClassNotFoundException e) {
            System.out.println(e);
        }
    }
  }
 
  public void saveAs(){
      
    JFileChooser chooser = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());

    chooser.setDialogTitle("Save");
    int returnValue = chooser.showDialog(null, "Save");

    if (returnValue == JFileChooser.APPROVE_OPTION) {
        File selectedFile = chooser.getSelectedFile();
        try {
            FileOutputStream fileOut = new FileOutputStream(selectedFile + ".ser");
            ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
            objectOut.writeObject(this.elementContainer);
            objectOut.close();
            elementContainer.setFile(selectedFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
  }
  
  public void save(){
    
    if (elementContainer.getFile() == null){
        saveAs();
    }
    else {
        try {
            FileOutputStream fileOut = new FileOutputStream(elementContainer.getFile() + ".ser");
            ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
            objectOut.writeObject(this.elementContainer);
            objectOut.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
  }
  
  public void undo() {}

  public void redo() {}
}
