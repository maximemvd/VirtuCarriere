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
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import javax.swing.*;
import javax.swing.filechooser.FileSystemView;
import virtucarriere.Domaine.Carriere.Plan.*;
import virtucarriere.Domaine.Carriere.Simulation.Camion;
import virtucarriere.Domaine.Carriere.Simulation.Chargeur;
import virtucarriere.Domaine.Carriere.Simulation.Facture;

public class Controller implements Serializable, Observer {

  private ElementContainer elementContainer;

  private int undoRedoPointer = -1;
  private List<Action> elementStack = new ArrayList<>();
  private boolean needToDeleteElements = true;

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
  
  public void initObserver(){
    elementContainer.initObserver(this);
  }
  
  @Override
  public void update(String action, Element element){
      System.out.print("Salut");
    Action nouvelleAction = new Action(action, element);
    addElementToStack(nouvelleAction);
  }

  public void addElementToStack(Action nouvelleAction) {
    if (needToDeleteElements){
      deleteElementsAfterPointer(undoRedoPointer);
      this.elementStack.add(nouvelleAction);
      undoRedoPointer++;
    }
    needToDeleteElements = true;
  }

  public void deleteElementsAfterPointer(int Pointer) {
    if (elementStack.size() < 0) {
      return;
    }
    for (int i = elementStack.size() - 1; i > Pointer; i--) {
      elementStack.remove(i);
    }
  }

  public void undo() {
    if (undoRedoPointer <= 0) {
      return;
    }
    if (elementStack.get(undoRedoPointer).getAction().equals("add")){
      needToDeleteElements = false;
      
      if (elementStack.get(undoRedoPointer).getElement().getName().equals("Noeud")) {
        elementContainer.removeNoeud((Noeud) elementStack.get(undoRedoPointer).getElement());
      }
      
      else if (elementStack.get(undoRedoPointer).getElement().getName().equals("Arc")) {
        elementContainer.removeArc((Arc) elementStack.get(undoRedoPointer).getElement());
      }
      
      else {
        elementContainer.removeEquipement((Equipement) elementStack.get(undoRedoPointer).getElement());
      }
    }
    
    else {
      needToDeleteElements = false;
      
      if (elementStack.get(undoRedoPointer).getElement().getName().equals("Noeud")) {
        elementContainer.addElement(elementStack.get(undoRedoPointer).getElement().getPoint(),
                                    EquipementModes.NOEUD,
                                    0.0);
      }
      
      else if (elementStack.get(undoRedoPointer).getElement().getName().equals("Arc")) {
        elementContainer.addArc(new Point((int)((Arc)elementStack.get(undoRedoPointer).getElement()).getArrival().getX(),
                                (int)((Arc)elementStack.get(undoRedoPointer).getElement()).getArrival().getX()));
      }
      
      else {
        elementContainer.addEquipement((Equipement) elementStack.get(undoRedoPointer).getElement());
      }
        
    }
    undoRedoPointer--;
  }

  public void redo() {
    if (undoRedoPointer == elementStack.size() - 1) return;
    
    undoRedoPointer++;
    
    if (elementStack.get(undoRedoPointer).getAction().equals("add")){
      needToDeleteElements = false;
      
      if (elementStack.get(undoRedoPointer).getElement().getName().equals("Noeud")) {
        elementContainer.addElement(elementStack.get(undoRedoPointer).getElement().getPoint(),
                                    EquipementModes.NOEUD,
                                    0.0);
      }
      
      else if (elementStack.get(undoRedoPointer).getElement().getName().equals("Arc")) {
        elementContainer.addArc(new Point((int)((Arc)elementStack.get(undoRedoPointer).getElement()).getStarting().getX(),
                                (int)((Arc)elementStack.get(undoRedoPointer).getElement()).getStarting().getX()));
        elementContainer.addArc(new Point((int)((Arc)elementStack.get(undoRedoPointer).getElement()).getArrival().getX(),
                                (int)((Arc)elementStack.get(undoRedoPointer).getElement()).getArrival().getX()));
      }
      
      else {
        elementContainer.addEquipement((Equipement) elementStack.get(undoRedoPointer).getElement());
      }
    }
    
    else {
      needToDeleteElements = false;
      
      if (elementStack.get(undoRedoPointer).getElement().getName().equals("Noeud")) {
        elementContainer.removeNoeud((Noeud) elementStack.get(undoRedoPointer).getElement());
      }
      
      else if (elementStack.get(undoRedoPointer).getElement().getName().equals("Arc")) {
        elementContainer.removeArc((Arc) elementStack.get(undoRedoPointer).getElement());
      }
      
      else {
        elementContainer.removeEquipement((Equipement) elementStack.get(undoRedoPointer).getElement());
      }
        
    }
  }

  // méthode copy inspirée de http://javatechniques.com/blog/faster-deep-copies-of-java-objects/
  public static Object copy(Object orig) {
    Object obj = null;
    try {
      // Write the object out to a byte array
      ByteArrayOutputStream bos = new ByteArrayOutputStream();
      ObjectOutputStream out = new ObjectOutputStream(bos);
      out.writeObject(orig);
      out.flush();
      out.close();

      // Make an input stream from the byte array and read
      // a copy of the object back in.
      ObjectInputStream in = new ObjectInputStream(new ByteArrayInputStream(bos.toByteArray()));
      obj = in.readObject();
    } catch (IOException e) {
      e.printStackTrace();
    } catch (ClassNotFoundException cnfe) {
      cnfe.printStackTrace();
    }
    return obj;
  }
  //

  public URL getUrlBackground() {
    return elementContainer.getBackGroundUrl();
  }

  public void setUrlBackground(URL p_url) {
    elementContainer.setUrlBackGround(p_url);
  }

  public List<Noeud> getNoeudForArcList() {
    return elementContainer.getNoeudForArcList();
  }

  public void setElement(ElementContainer elementContainer) {
    this.elementContainer = elementContainer;
  }

  public void addConvoyeur(Point mousePoint, EquipementModes modes, double angle) {
    elementContainer.addElement(mousePoint, modes, angle);
  }

  public void addConvoyeurForPopup(Equipement firstEquipement, Equipement secondEquipement) {
    elementContainer.addConvoyeurForPopup(firstEquipement, secondEquipement);
  }

  public void addCrible(Point mousePoint, EquipementModes modes, double angle) {
    elementContainer.addElement(mousePoint, modes, angle);
  }

  public void addConcasseur(Point mousePoint, EquipementModes modes, double angle) {
    elementContainer.addElement(mousePoint, modes, angle);
  }

  public void addBroyeur(Point mousePoint, EquipementModes modes, double angle) {
    elementContainer.addElement(mousePoint, modes, angle);
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

  public void addCamion(Point point, String client, String produit, double qte, int temps) {
    elementContainer.addCamion(point, client, produit, qte, temps);
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

  public void clearEquipementConv() {
    elementContainer.clearEquipementConv();
  }

  public Chargeur choisirChargeurCorrespondant(Tas tas) {
    return elementContainer.trouverChargeurCorrespondant(tas);
  }

  public Vector<AbstractPointChemin> ChargeurCheminToPath(
      Chargeur p_chargeur, Tas p_tas, List<Noeud> listeNoeud) {
    return elementContainer.ChargeurCheminToPath(p_chargeur, p_tas, listeNoeud);
  }

  public boolean verificationJeton(Camion p_camion, Chargeur p_chargeur) {
    return elementContainer.verificationJeton(p_camion, p_chargeur);
  }

  public void removeEquipement(Equipement equipement) {
    elementContainer.removeEquipement(equipement);
  }

  public void addEquipement(EquipementModes mode, Point mousePoint, double angle) {
    if (null != mode)
      switch (mode) {
        case CONVOYEUR:
          addConvoyeur(mousePoint, mode, angle);
          break;
        case CONCASSEUR:
          addConcasseur(mousePoint, mode, angle);
          break;
        case CRIBLE:
          addCrible(mousePoint, mode, angle);
          break;
        case BROYEUR:
          addBroyeur(mousePoint, mode, angle);
          break;
        case NOEUD:
          addNoeud(mousePoint, mode, angle);
          break;
        case TAS:
          // addTas(mousePoint);
          break;
        case ENTREE:
          addEntree(mousePoint, mode, angle);
          break;
        default:
          break;
      }
  }

  public void addTas(Point mousePoint, String code, double angle) {
    elementContainer.addTas(mousePoint, code, angle);
  }

  public void addNoeud(Point mousePoint, EquipementModes mode, double angle) {
    elementContainer.addElement(mousePoint, mode, angle);
  }

  public List<Noeud> getAllNoeuds() {
    return elementContainer.getAllNoeuds();
  }

  public void changementSelectionStatus(double x, double y) {
    this.elementContainer.changementSelectionStatus(x, y);
  }

  public void addChemin(Point point) {
    elementContainer.addChemin(point);
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

  public void addEntree(Point mousePoint, EquipementModes mode, double angle) {
    if (elementContainer.getEntree() != null) {
      // TODO modifier emplacement de l'entrée
    } else {
      elementContainer.addElement(mousePoint, mode, angle);
    }
  }

  public void removeEntree(Entree entree) {
    //  elementContainer.removeEntree(entree);
  }

  public void switchSelectionStatus(double x, double y, boolean isShiftDown) {
    this.elementContainer.switchSelectionStatus(x, y, isShiftDown);
  }

  public void addArc(Point point) {
    this.elementContainer.addArc(point);
  }

  public List<AbstractPointChemin> getPointsForArcList() {
    return elementContainer.getPointsForArcList();
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
      this.elementContainer = new ElementContainer();
      elementContainer.addObserver(this);
    }
    if (choix == 1) {
      this.elementContainer = new ElementContainer();
      elementContainer.addObserver(this);
    }
  }


  public GraphChemins getGraphChemin() {
    return elementContainer.getGraphChemin();
  }

  public boolean validateDependencies() {
    return elementContainer.validateDependencies();
  }

  public void setGraphCheminSimulation(GraphChemins p_chemin) {
    elementContainer.setGraphCheminSimulation(p_chemin);
  }
}
