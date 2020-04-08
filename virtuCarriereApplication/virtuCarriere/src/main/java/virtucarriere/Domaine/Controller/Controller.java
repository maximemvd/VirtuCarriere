/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package virtucarriere.Domaine.Controller;

import java.awt.Point;
import java.io.*;
import java.io.FileInputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import javax.swing.*;
import javax.swing.filechooser.FileSystemView;
import virtucarriere.Domaine.Carriere.Plan.Arc;
import virtucarriere.Domaine.Carriere.Plan.Crible;
import virtucarriere.Domaine.Carriere.Plan.Entree;
import virtucarriere.Domaine.Carriere.Plan.Equipement;
import virtucarriere.Domaine.Carriere.Plan.Noeud;
import virtucarriere.Domaine.Carriere.Plan.Tas;
import virtucarriere.Domaine.Carriere.Simulation.Camion;
import virtucarriere.Domaine.Carriere.Simulation.Chargeur;
import virtucarriere.Domaine.Carriere.Simulation.Vehicule;

public class Controller implements Serializable {

  private double attribute;

  private int undoRedo;
  private ArrayList<ElementContainer> elementContainerList;

  private ElementContainer elementContainer;
  private Plan plan;

  public enum EquipementModes {
    RIEN,
    CONCASSEUR,
    CRIBLE,
    BROYEUR,
    CONVOYEUR,
    NOEUD,
    TAS,
    ENTREE
  }

  public enum VehiculeModes {
    CAMION,
    CHARGEUR
  }

  public enum ArcMode {
    ARC
  }

  public Controller(ElementContainer elementContainer) {
    this.elementContainer = elementContainer;
  }

  public Controller() {
    elementContainer = new ElementContainer();
  }

  public Point getEntreePoint() {
    Point entree = new Point(300, 0);
    return entree;
  }

  public List<Noeud> getNoeudForArcList() {
    return elementContainer.getNoeudForArcList();
  }

  public void setElement(ElementContainer elementContainer) {
    this.elementContainer = elementContainer;
  }

  public void addCrible(Point mousePoint) {
    Crible newCrible = new Crible(mousePoint, 2, 2, 2);
    //  elementContainer.addElement(newCrible);
  }

  public void addConcasseur(Point mousePoint, EquipementModes modes) {

    elementContainer.addElement(mousePoint, modes);
  }

  public void addBroyeur(Point mousePoint, EquipementModes modes) {
    elementContainer.addElement(mousePoint, modes);
  }
  
  public Tas TrouverTasCorrespondant(String produit)
  {
      return elementContainer.trouverTasCorrespondant(produit);
  }
  
  public Vector<Noeud> cheminDuCamion(Tas tas){
      return elementContainer.cheminDuCamion(tas);
  }

  public List<Camion> getCamionList() {
    return elementContainer.getCamionList();
  }

  public List<Chargeur> getChargeurList() {
    return elementContainer.getChargeurList();
  }

  public void addVehicule(
      VehiculeModes mode, Point mousePoint, double qte, String produit, String client) {
    elementContainer.addVehicule(mode, mousePoint, qte, produit, client);
  }

  public void generateFacture(Camion p_camion) {
    elementContainer.generateFacture(p_camion);
  }

  public void verificationJeton(Camion p_camion) {
    elementContainer.verificationJeton(p_camion);
  }

  public void changeEtat(Camion p_camion, String etat) {
    elementContainer.changeEtat(p_camion, etat);
  }

 

  public void createToken(String client, String produit, double quantite) {
    elementContainer.createToken(client, produit, quantite);
  }

  public void removeVehicule(Vehicule p_vehicule) {
    elementContainer.removeVehicule(p_vehicule);
  }

  public void genererFacture(Camion p_camion) {
    elementContainer.generateFacture(p_camion);
  }

  public List<Equipement> getEquipementList() {
    return elementContainer.getEquipementList();
  }

  public List<Entree> getEntreeList() {
    return elementContainer.getEntreeList();
  }

  public ArrayList<List<Arc>> getArcList() {
    return elementContainer.getArcList();
  }

  public void addArc(Point mousePoint, Noeud starting, Noeud arrival) {
    Arc arc = new Arc(mousePoint, 5, 5, starting, arrival);
    //  elementContainer.addArc(arc);
  }

  public void removeEquipement(Equipement equipement) {
    // elementContainer.removeEquipement(equipement);
  }

  public void addTas(Point mousePoint) {
    // Tas tas = new Tas(mousePoint, 1, double 1, "matériaux", 2, "or", double  100);
    //  elementContainer.addEquipement(tas);
  }

  public void addNoeud(Point mousePoint) {
    Noeud noeud = new Noeud(mousePoint, 1, 1);
    //  elementContainer.addNoeud(noeud);
  }

  public void removeNoeud(Noeud noeud) {
    //  elementContainer.removeNoeud(noeud);
  }

  public void removeArc(Arc arc) {
    //  elementContainer.removeArc(arc);
  }

  public void addEntree(Point mousePoint) {
    Entree entree = new Entree(mousePoint, 3, 3, 4);
    Noeud noeud = new Noeud(mousePoint, 1, 1);
    // elementContainer.addEntree(entree, noeud);
  }

  public void removeEntree(Entree entree) {
    //  elementContainer.removeEntree(entree);
  }

  public void noeudSelection(double x, double y) {
    this.elementContainer.noeudSelection(x, y);
  }

  public void switchSelectionStatus(double x, double y, boolean isShiftDown) {
    this.elementContainer.switchSelectionStatus(x, y, isShiftDown);
  }

  public void updateSelectedItemsPositions(double deltaX, double deltaY) {
    elementContainer.updateSelectedItemsPosition(deltaX, deltaY);
  }

  public ElementContainer getElementContainer() {
    return elementContainer;
  }

  public void deleteSelected() {
    plan.deleteSelected();
  }

  public void addContainer() {
    // ElementContainer elementContainer = new ElementContainer(this.elementContainer);

  }

  private void deleteElementsAfterPointer(int undoRedoPointerState) {
    if (elementContainerList.isEmpty()) {
      return;
    }
  }

  public void openFile() {
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
        selectedFile =
            new File(
                String.valueOf(selectedFile)
                    .substring(0, String.valueOf(selectedFile).lastIndexOf('.')));
        elementContainer.setFile(selectedFile);

      } catch (IOException e) {
        System.out.println(e);
      } catch (ClassNotFoundException e) {
        System.out.println(e);
      }
    }
  }

  public void saveAs() {

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

  public void save() {

    if (elementContainer.getFile() == null) {
      saveAs();
    } else {
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

  public void newProject() {
    String[] options = {"Enregistrer", "Nouveau projet"};
    int choix =
        JOptionPane.showOptionDialog(
            null,
            "Voulez-vous enregistrer votre travail ?",
            "Attention!",
            JOptionPane.DEFAULT_OPTION,
            JOptionPane.WARNING_MESSAGE,
            null,
            options,
            options[0]);

    if (choix == 0) {
      save();
    }
    this.elementContainer = new ElementContainer();
  }

  public void undo() {}

  public void redo() {}
}
