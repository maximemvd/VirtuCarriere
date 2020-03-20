/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package virtucarriere.Domaine.Controller;


import java.awt.Graphics2D;
import java.awt.Point;
import virtucarriere.Domaine.Carriere.Plan.Equipement;
import virtucarriere.gui.DrawingPanel;
import virtucarriere.gui.MainWindow;
import virtucarriere.Domaine.Drawing.CarriereDrawer;
import virtucarriere.Domaine.Carriere.Simulation.Camion;
import virtucarriere.Domaine.Carriere.Simulation.Jeton;
import virtucarriere.Domaine.Carriere.Plan.Element;
import java.util.ArrayList;
import virtucarriere.gui.MainWindow.MeasurementUnitMode;


public class Controller {

    private double attribute;

    private ElementContainer elementContainer;

    private ArrayList<Element> elementList;

    private ArrayList<Camion> camionArrayList;


    public Controller(ElementContainer elementContainer) {
        this.elementContainer = elementContainer;
        // peut etre rajouter la fonction addElementContainer ici
    }

    public Controller() {
        elementContainer = new ElementContainer();
        elementList = new ArrayList<Element>();
        camionArrayList = new ArrayList<Camion>();
    }


    public void switchSelectionStatus(double x, double y, boolean isShiftDown) {
        elementContainer.switchSelectionStatus(x, y, isShiftDown);
    }


    public void addNoeud(double x, double y) {
// on peux pas ajouter de noeud parce qu'ils sont pas un element
    }

    public void generateCamion(Jeton jeton, double depart) 
    {

    }

    public void ajouterEquipement(Equipement equipement) { 
        elementList.add(equipement);
    };

    public void ajouterCamion(Camion p_camion)
    {
        camionArrayList.add(p_camion);
    }

    public ElementContainer getElementContainer() {
        return elementContainer;
    }
    
    
    public void draw(Graphics2D g, MainWindow.MeasurementUnitMode measurementUnitMode, DrawingPanel drawingPanel, double zoom, Point currentMousePoint){
        
        
    
    }

    public ArrayList<Element> getElementsList() {
        return elementList;
    }

    public ArrayList<Camion> getCamionList() {
        return camionArrayList;
    }

    public void draw(Graphics2D g, double zoom,  Point mousePoint, CarriereDrawer carriereDrawer,  MeasurementUnitMode measurementUnitMode)
     {
        ArrayList<Element> elementList = getElementsList();

        if (carriereDrawer == null)
        {
            carriereDrawer = new CarriereDrawer(this);
        }

        carriereDrawer.setMeasurementUnitMode(measurementUnitMode);
        carriereDrawer.draw(g, elementList, zoom, mousePoint);
     }


}
