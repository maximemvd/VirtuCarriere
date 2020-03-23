/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package virtucarriere.Domaine.Controller;

import java.awt.Graphics2D;
import virtucarriere.Domaine.Drawing.CarriereDrawer;
import virtucarriere.Domaine.Carriere.Simulation.Camion;
import virtucarriere.Domaine.Carriere.Plan.Element;
import virtucarriere.Domaine.Carriere.Plan.Crible;
import virtucarriere.Domaine.Carriere.Plan.Concasseur;
import virtucarriere.Domaine.Carriere.Plan.Convoyeur;
import virtucarriere.Domaine.Carriere.Plan.Broyeur;
import virtucarriere.Domaine.Carriere.Plan.Noeud;
import virtucarriere.Domaine.Carriere.Plan.Coordonnees;
import java.util.ArrayList;
import virtucarriere.gui.MainWindow.MeasurementUnitMode;
import java.awt.Point;
import virtucarriere.gui.DrawingPanel;
import java.util.List;

public class Controller {

    private double attribute;

    private ElementContainer elementContainer;
    private CarriereDrawer carriereDrawer;

    private ArrayList<ElementContainer> containerList;
    
     public enum ElementModes 
     {
         CONCASSEUR, CRIBLE, BROYEUR, CONVOYEUR
     }

    private int undoRedo;

    public Controller(ElementContainer elementContainer) {
        this.elementContainer = elementContainer;
        // peut etre rajouter la fonction addElementContainer ici
        // modifier la variable undoRedo chaque fois qu'on appel le controleur
    }
    
   

    public Controller() {
        elementContainer = new ElementContainer();
    //    this.containerList = new ArrayList<ElementContainer>();
      //  this.undoRedo = -1;
    }

    public void setElement(ElementContainer elementContainer) {
        this.elementContainer = elementContainer;
    }
    
    public void addCrible(Point mousePoint)
    {
        Coordonnees p = new Coordonnees(0, 0);
        Crible newCrible = new Crible(mousePoint, p, 2, 2, true, 2);
        elementContainer.addElement(newCrible);
    }
    
     public void addConcasseur(Point mousePoint)
    {
        Coordonnees p = new Coordonnees(0, 0);
        Concasseur newConcasseur = new Concasseur(mousePoint, p, 2, 2, true, 2);
        elementContainer.addElement(newConcasseur);
    }
     
         public void addBroyeur(Point mousePoint)
    {
        Coordonnees p = new Coordonnees(0, 0);
        Concasseur newBroyeur = new Concasseur(mousePoint, p, 2, 2, true, 2);
        elementContainer.addElement(newBroyeur);
    }
         
       public void addConvoyeur(Point mousePoint)
    {
        Coordonnees p = new Coordonnees(0, 0);
        Noeud noeud = new Noeud(0, 0);
        Convoyeur newConvoyeur = new Convoyeur(mousePoint, p, 2, 2, true, 2, noeud);
        elementContainer.addElement(newConvoyeur);
    }
    
    public void addElements(ElementModes mode, Point mousePoint)
    {
        if (mode == ElementModes.CONCASSEUR)
        {
            addConcasseur(mousePoint);
        }
        if (mode == ElementModes.CRIBLE)
        {
            addCrible(mousePoint);
        }
        if (mode == ElementModes.CONVOYEUR)
        {
            addConvoyeur(mousePoint);
        }
         if (mode == ElementModes.BROYEUR)
        {
            addBroyeur(mousePoint);
        }
        
    }

    private ArrayList<ElementContainer> getContainerList() {
        return containerList;
    }

    public void undo() {
        if (undoRedo <= 0) {
            return;
        }
        this.undoRedo--;
        this.setElement(this.containerList.get(this.undoRedo));
    }

    public void redo() {
        if (this.undoRedo == this.containerList.size() - 1) {
            return;
        }
        this.undoRedo++;
        this.setElement((this.containerList.get(this.undoRedo)));
    }

    public void switchSelectionStatus(double x, double y, boolean isShiftDown) {
        this.elementContainer.switchSelectionStatus(x, y, isShiftDown);
    }

    public ElementContainer getElementContainer() {
        return elementContainer;
    }

    public List<Element> getElementArrayList() {
        return elementContainer.getElementList();
    }

    public List<Camion> getCamionArrayList() {
        return elementContainer.getVehiculeList();
    }


    public void draw(Graphics2D g, MeasurementUnitMode measurementUnitMode, DrawingPanel drawingPanel, double zoom, Point currentMousePoint) {
        
        ArrayList<ElementContainer> containers = getContainerList();

        if (carriereDrawer == null) {
           // carriereDrawer = new CarriereDrawer(this);
        }
        carriereDrawer.setMeasurementUnitMode(measurementUnitMode);
        carriereDrawer.draw(g);
    }

}
