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
import virtucarriere.Domaine.Carriere.Plan.AbstractPointChemin;
import virtucarriere.Domaine.Carriere.Plan.Arc;
import virtucarriere.Domaine.Carriere.Plan.Convoyeur;
import virtucarriere.Domaine.Carriere.Plan.Entree;
import virtucarriere.Domaine.Carriere.Plan.Equipement;
import virtucarriere.Domaine.Carriere.Plan.GraphChemins;
import virtucarriere.Domaine.Carriere.Plan.Noeud;
import virtucarriere.Domaine.Carriere.Plan.Tas;
import virtucarriere.Domaine.Carriere.Simulation.Camion;
import virtucarriere.Domaine.Carriere.Simulation.Chargeur;
import virtucarriere.Domaine.Carriere.Simulation.Facture;

public class Controller implements Serializable {

  private ElementContainer elementContainer;

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

  public Controller() {
    elementContainer = new ElementContainer();
  }

  public List<Noeud> getNoeudForArcList() {
    return elementContainer.getNoeudForArcList();
  }

  public void setElement(ElementContainer elementContainer) {
    this.elementContainer = elementContainer;
  }

  public void addConvoyeur(Point mousePoint, EquipementModes modes) {
    elementContainer.addElement(mousePoint, modes);
  }
  
  public void addCrible(Point mousePoint, EquipementModes modes) {
    elementContainer.addElement(mousePoint, modes);
  }

  public void addConcasseur(Point mousePoint, EquipementModes modes) {
    elementContainer.addElement(mousePoint, modes);
  }

  public void addBroyeur(Point mousePoint, EquipementModes modes) {
    elementContainer.addElement(mousePoint, modes);
  }

  public Tas TrouverTasCorrespondant(List<Tas> tas, String produit) {
    return elementContainer.trouverTasCorrespondant(tas, produit);
  }

  public void EditCamion(Camion p_camion, String nom, String produit, double qte) {
    elementContainer.EditCamion(p_camion, nom, produit, qte);
  }

  public Vector<AbstractPointChemin> cheminDuCamion(Tas tas) {
    return elementContainer.cheminDuCamion(tas);
  }

  public List<Camion> getCamionList() {
    return elementContainer.getCamionList();
  }

  public List<Chargeur> getChargeurList() {
    return elementContainer.getChargeurList();
  }

  public void addChargeur(Point point) {
    elementContainer.addChargeur(point);
  }

  public void addCamion(Point point, String client, String produit, double qte) {
    elementContainer.addCamion(point, client, produit, qte);
  }

  public Vector<AbstractPointChemin> cheminDuCamionRetour(Tas tas) {
    return elementContainer.cheminDuCamionRetour(tas);
  }

  public Facture genererFacture(Camion p_camion) {
    return elementContainer.genererFacture(p_camion);
  }

  public void createToken(String client, String produit, double quantite) {
    elementContainer.createToken(client, produit, quantite);
  }

  public void removeChargeur(Chargeur p_chargeur) {
    elementContainer.removeChargeur(p_chargeur);
  }

  public void removeCamion(Camion p_camion) {
    elementContainer.removeCamion(p_camion);
  }

  public List<Equipement> getEquipementList() {
    return elementContainer.getEquipementList();
  }

  public Entree getEntree() {
    return elementContainer.getEntree();
  }

  public List<AbstractPointChemin> getNoeudList() {
    return elementContainer.getNoeudList();
  }

  public ArrayList<List<Arc>> getArcList() {
    return elementContainer.getArcList();
  }

  public ArrayList<List<Convoyeur>> getConvoyeurList() {
    return elementContainer.getConvoyeurList();
  }
  
  public void clearEquipementConv(){
      elementContainer.clearEquipementConv();
  }

  public Chargeur choisirChargeurCorrespondant(Tas tas) {
    return elementContainer.trouverChargeurCorrespondant(tas);
  }

  public Vector<AbstractPointChemin> ChargeurCheminToPath(Chargeur p_chargeur, Tas p_tas) {
    return elementContainer.ChargeurCheminToPath(p_chargeur, p_tas);
  }

  public boolean verificationJeton(Camion p_camion, Chargeur p_chargeur) {
    return elementContainer.verificationJeton(p_camion, p_chargeur);
  }

  public void removeEquipement(Equipement equipement) {
    elementContainer.removeEquipement(equipement);
  }

  public void addEquipement(EquipementModes mode, Point mousePoint) {
    if (null != mode)
      switch (mode) {
        case CONVOYEUR:
          addConvoyeur(mousePoint, mode);
          break;
        case CONCASSEUR:
          addConcasseur(mousePoint, mode);
          break;
        case CRIBLE:
          addCrible(mousePoint, mode);
          break;
        case BROYEUR:
          addBroyeur(mousePoint, mode);
          break;
        case NOEUD:
          addNoeud(mousePoint, mode);
          break;
        case TAS:
          // addTas(mousePoint);
          break;
        case ENTREE:
          addEntree(mousePoint, mode);
          break;
        default:
          break;
      }
  }

  public void addTas(Point mousePoint, String code) {
    elementContainer.addTas(mousePoint, code);
  }

  public void addNoeud(Point mousePoint, EquipementModes mode) {
    elementContainer.addElement(mousePoint, mode);
  }

  public void changementSelectionStatus(double x, double y) {
    this.elementContainer.changementSelectionStatus(x, y);
  }

  public void addArc(Point mousePoint, double x, double y) {
    elementContainer.addArc(mousePoint, x, y);
  }

  public void removeNoeud(AbstractPointChemin noeud) {
    elementContainer.removeNoeud(noeud);
  }

  public void removeArc(Arc arc) {
    elementContainer.removeArc(arc);
  }

  public void removeConvoyeur(Convoyeur convoyeur) {
    elementContainer.removeConvoyeur(convoyeur);
  }

  public void addEntree(Point mousePoint, EquipementModes mode) {

    elementContainer.addElement(mousePoint, mode);
  }

  public void removeEntree(Entree entree) {
    //  elementContainer.removeEntree(entree);
  }

  public void switchSelectionStatus(double x, double y, boolean isShiftDown) {
    this.elementContainer.switchSelectionStatus(x, y, isShiftDown);
  }

  public void updateSelectedItemsPositions(double deltaX, double deltaY) {
    elementContainer.updateSelectedItemsPosition(deltaX, deltaY);
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
  }

  public void setEntreSimulation(Entree p_entree) {
    elementContainer.setEntreSimulation(p_entree);
  }

  public boolean getSimulationAnimation() {
    return elementContainer.getSimulationAnimation();
  }

  public void startSimulation() {
    elementContainer.startSimulation();
  }

  public void closeSimulation() {
    elementContainer.closeSimulation();
  }

  public double getSimulationSpeed() {
    return elementContainer.getSimulationSpeed();
  }

  public void setSimulationSpeed(double newSpeed) {
    elementContainer.setSimulationSpeed(newSpeed);
  }

  public GraphChemins getGraphChemin() {
    return elementContainer.getGraphChemin();
  }

  public void setGraphCheminSimulation(GraphChemins p_chemin) {
    elementContainer.setGraphCheminSimulation(p_chemin);
  }

  public void undo() {}

  public void redo() {}
}
