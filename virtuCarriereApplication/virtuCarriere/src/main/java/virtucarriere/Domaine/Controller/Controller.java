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
import java.util.ArrayList;
import virtucarriere.gui.MainWindow.MeasurementUnitMode;
import java.awt.Point;
import virtucarriere.gui.DrawingPanel;

public class Controller {

    private double attribute;

    private ElementContainer elementContainer;
    private CarriereDrawer carriereDrawer;

    private ArrayList<ElementContainer> containerList;

    private int undoRedo;

    public Controller(ElementContainer elementContainer) {
        this.elementContainer = elementContainer;
        // peut etre rajouter la fonction addElementContainer ici
        // modifier la variable undoRedo chaque fois qu'on appel le controleur
    }

    public Controller() {
        this.elementContainer = new ElementContainer();
        this.containerList = new ArrayList<ElementContainer>();
        this.undoRedo = -1;
    }

    public void setElement(ElementContainer elementContainer) {
        this.elementContainer = elementContainer;
    }

    private ArrayList<ElementContainer> getContainerList() {
        return this.containerList;
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
        return this.elementContainer;
    }

    public ArrayList<Element> getElemeneArrayList() {
        return this.elementContainer.getElementList();
    }

    public ArrayList<Camion> getCamionArrayList() {
        return this.elementContainer.getVehiculeList();
    }


    public void draw(Graphics2D g, MeasurementUnitMode measurementUnitMode, DrawingPanel drawingPanel, double zoom, Point currentMousePoint) {
        
        ArrayList<ElementContainer> containers = getContainerList();

        if (carriereDrawer == null) {
            carriereDrawer = new CarriereDrawer(this);
        }
        carriereDrawer.setMeasurementUnitMode(measurementUnitMode);
        carriereDrawer.draw(g, containers, zoom, currentMousePoint);
    }

}
