/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package virtucarriere.Domaine.Controller;

import virtucarriere.Domaine.Controller.Controller;
import virtucarriere.Domaine.Carriere.Plan.Element;
import virtucarriere.Domaine.Carriere.Simulation.Vehicule;
import virtucarriere.Domaine.Carriere.Simulation.Jeton;
import virtucarriere.Domaine.Carriere.Simulation.Camion;
import virtucarriere.Domaine.Carriere.Plan.Coordonnees;
import virtucarriere.Domaine.Carriere.Plan.Noeud;
import virtucarriere.Domaine.Carriere.Plan.Equipement;
import java.util.List;
import java.util.LinkedList;


public class ElementContainer {

    private List<Equipement> equipementList;
    
    private List<Noeud> noeudList;

    private List<Camion> vehiculeList;

    public ElementContainer() {
        equipementList = new LinkedList<Equipement>();
        vehiculeList = new LinkedList<Camion>();
        noeudList = new LinkedList<Noeud>();
    }

    public void switchSelectionStatus(double x, double y, boolean isShiftDown) {
        System.out.println(x);
        System.out.println(y);
        System.out.println(isShiftDown);
    }

    public boolean equipementIsEmpty() {
        return equipementList.isEmpty();
    }

    public boolean VehiculeIsEmpty() {
        return vehiculeList.isEmpty();
    }
    
    public boolean noeudIsEmpty()
    {
        return noeudList.isEmpty();
    }

    public List<Equipement> getEquipemenetList() {
        return equipementList;
    }

    public List<Camion> getVehiculeList() {
        return vehiculeList;
    }
    
    public List<Noeud> getNoeudList()
    {
        return noeudList;
    }

    public double getNumberOfEquipementList() {
        return equipementList.size();
    }

    public double getNumberOfVehiculeList() {
        return vehiculeList.size();
    }
    
    public double getNumberOfNoeudList() {
        return noeudList.size();
    }

    public void addEquipement(Equipement p_equipement) {
        try {
        equipementList.add(p_equipement);
        }
        catch (Exception error)
        {
            System.out.println(error);
        }
    }

    public void removeEquipement(Equipement p_equipement) {
        try {
            equipementList.remove(p_equipement);
        } catch (Exception error) {
            System.out.println(error);
        }
    }

    public void addCamion(Camion newCamion) {
        vehiculeList.add(newCamion);
    }

    public void removeCamion(Camion p_camion) {
        try {
            vehiculeList.remove(p_camion);
        } catch (Exception error) {
            System.out.println(error);
        }
    }
    
    public void addNoeud(Noeud p_noeud)
    {
        noeudList.add(p_noeud);
    }
    
    public void removeNoeud(Noeud p_noeud)
    {
        try 
        {
            noeudList.remove(p_noeud);
        }
        catch (Exception error)
        {
            System.out.println(error);
        }
    }

    // public void generateCamionSimulation(Jeton jeton, double depart) {
    //     Camion vehiculePretPourSimulation = vehiculeList.get(0);
    //     System.out.println(vehiculePretPourSimulation);
    //     // appeler fonction pour simulation
    //     this.vehiculeList.remove(vehiculePretPourSimulation);
    // }

    public String askReason() {
        return "La raison";
    }

    // public double getNextPosition() {
    //     double nextPosition = 10;
    //     return nextPosition;
    // }

    public boolean askValidPlace(Coordonnees coordonnee) {
        double x = coordonnee.getX();
        double y = coordonnee.getY();

        if (x < 0 && y < 0)
        {
            return false;
        }
        else
        {
            return true;
        }
    }

    public boolean validanceDependance(String type, Coordonnees coordonnee) {
        return true;
    }
}
