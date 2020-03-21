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
import virtucarriere.gui.MainWindow;
import java.awt.Point;
import virtucarriere.gui.DrawingPanel;


public class Controller {

    private double attribute;

    private ElementContainer elementContainer;

    private ArrayList<ElementContainer> containerList;

    private int undoRedo = -1;


    public Controller(ElementContainer elementContainer) {
        this.elementContainer = elementContainer;
        // peut etre rajouter la fonction addElementContainer ici
        //modifier la variable undoRedo chaque fois qu'on appel le controleur
    }

    public Controller() {
        elementContainer = new ElementContainer();
        containerList = new ArrayList<ElementContainer>();
    }

    public void setElement(ElementContainer elementContainer)
    {
        this.elementContainer = elementContainer;
    }

    private ArrayList<ElementContainer> getContainerList()
    {
        return containerList;
    }

    public void undo()
    {
        if (undoRedo <= 0)
        {
            return;
        }
        undoRedo--;
        setElement(containerList.get(undoRedo));
    } 

    public void redo()
    {
        if (undoRedo == containerList.size() - 1) {
            return;
        }
        undoRedo++;
        setElement((containerList.get(undoRedo)));
    }


    public void switchSelectionStatus(double x, double y, boolean isShiftDown) {
        elementContainer.switchSelectionStatus(x, y, isShiftDown);
    }



    public ElementContainer getElementContainer() {
        return elementContainer;
    }

    public ArrayList<Element> getElemeneArrayList() 
    {
        return elementContainer.getElementList();
    }

    public ArrayList<Camion> getCamionArrayList() 
    {
        return elementContainer.getVehiculeList();
    }
    
    
    public void draw(Graphics2D g, MainWindow.MeasurementUnitMode measurementUnitMode, DrawingPanel drawingPanel, double zoom, Point currentMousePoint){
        
        
    }



    public void draw(Graphics2D g, double zoom,  Point mousePoint, CarriereDrawer carriereDrawer,  MeasurementUnitMode measurementUnitMode)
     {
        ArrayList<ElementContainer> containers = getContainerList();

        if (carriereDrawer == null)
        {
            carriereDrawer = new CarriereDrawer(this);
        }

        carriereDrawer.setMeasurementUnitMode(measurementUnitMode);
        carriereDrawer.draw(g, containers, zoom, mousePoint);
     }


}
