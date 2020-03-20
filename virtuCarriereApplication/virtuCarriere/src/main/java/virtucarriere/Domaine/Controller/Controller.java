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

public class Controller {

    public double attribute;

    public ElementContainer elementContainer;

    public Controller(ElementContainer elementContainer) {
        this.elementContainer = elementContainer;

    }

    public void Controller() {
        this.attribute = attribute;
        this.elementContainer = elementContainer;
        this.Controller = new Controller();
    }

    public void addNoeud(double x, double y) {


    }

    public void ajouterEquipement(Equipement equipement) { };

    public ElementContainer getElementContainer() {
        return elementContainer;
    }
    
    
    public void draw(Graphics2D g, MainWindow.MeasurementUnitMode measurementUnitMode, DrawingPanel drawingPanel, double zoom, Point currentMousePoint){
        
        
    
    }


}
