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
 

import java.util.ArrayList;

public class ElementContainer {

    private List<Element> elementList;

    private List<Camion> vehiculeList;

    public ElementContainer() {
        elementList = new LinkedList<Element>();
        vehiculeList = new LinkedList<Camion>();
    }

    public void switchSelectionStatus(double x, double y, boolean isShiftDown) {
        System.out.println(x);
        System.out.println(y);
        System.out.println(isShiftDown);
    }

    public boolean elementIsEmpty() {
        return elementList.isEmpty();
    }

    public boolean VehiculeIsEmpty() {
        return vehiculeList.isEmpty();
    }

    public List<Element> getElementList() {
        return elementList;
    }

    public List<Camion> getVehiculeList() {
        return vehiculeList;
    }

    public double getNumberOfElementsList() {
        return elementList.size();
    }

    public double getNumberOfVehiculeList() {
        return vehiculeList.size();
    }

    public void addElement(Element p_element) {
        try {
        elementList.add(p_element);
        }
        catch (Exception error)
        {
            System.out.println(error);
        }
    }

    public void removeElement(Element p_element) {
        try {
            elementList.remove(p_element);
        } catch (Exception error) {
            System.out.println("Element is not in the list");
        }
    }

    public void addCamion(Camion newCamion) {
        vehiculeList.add(newCamion);
    }

    public void removeCamion(Camion p_camion) {
        try {
            vehiculeList.remove(p_camion);
        } catch (Exception error) {
            System.out.println("Vehicule is not in the list");
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
