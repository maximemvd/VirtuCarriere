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
import virtucarriere.Domaine.Carriere.Plan.Tas;
import virtucarriere.Domaine.Carriere.Plan.Equipement;
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
    
    private int undoRedo;

    private ElementContainer elementContainer;
    
     public enum EquipementModes 
     {
         CONCASSEUR, CRIBLE, BROYEUR, CONVOYEUR
     }
     
     public enum NoeudModes
     {
         NOEUD, TAS
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
    
    public void addCrible(Point mousePoint)
    {
        Coordonnees p = new Coordonnees(0, 0);
        Crible newCrible = new Crible(mousePoint, p, 2, 2, true, 2);
        elementContainer.addEquipement(newCrible);
    }
    
     public void addConcasseur(Point mousePoint)
    {
        Coordonnees p = new Coordonnees(0, 0);
        Concasseur newConcasseur = new Concasseur(mousePoint, p, 2, 2, true, 2);
        elementContainer.addEquipement(newConcasseur);
    }
     
         public void addBroyeur(Point mousePoint)
    {
        Coordonnees p = new Coordonnees(0, 0);
        Broyeur newBroyeur = new Broyeur(mousePoint, p, 2, 2, true, 2);
        elementContainer.addEquipement(newBroyeur);
    }
         
       public void addConvoyeur(Point mousePoint)
    {
        Coordonnees p = new Coordonnees(0, 0);
        Noeud noeud = new Noeud(0, 0);
        Convoyeur newConvoyeur = new Convoyeur(mousePoint, p, 2, 2, true, 2, noeud);
        elementContainer.addEquipement(newConvoyeur);
    }
    
    public void addEquipement(EquipementModes mode, Point mousePoint)
    {
        if (mode == EquipementModes.CONCASSEUR)
        {
            addConcasseur(mousePoint);
        }
        if (mode == EquipementModes.CRIBLE)
        {
            addCrible(mousePoint);
        }
        if (mode == EquipementModes.CONVOYEUR)
        {
            addConvoyeur(mousePoint);
        }
         if (mode == EquipementModes.BROYEUR)
        {
            addBroyeur(mousePoint);
        }
    }
    
    public void addNoeud(NoeudModes mode, Point mousePoint)
    {
        if (mode == NoeudModes.TAS)
        {
            addTas(mousePoint);
        }
        if (mode == NoeudModes.NOEUD)
        {
            ajoutNoeud(mousePoint);
        }
    }
    
    public void addTas(Point mousePoint)
    {
        System.out.print("hey");
    }
    
    public void ajoutNoeud(Point mousePoint)
    {
        System.out.print("hey");
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
    
    public List<Noeud> getNoeudList()
    {
        return elementContainer.getNoeudList();
    }

}
