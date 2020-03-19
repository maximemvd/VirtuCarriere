/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package virtucarriere.Domaine.Controller;
import virtucarriere.Domaine.Controller.Controller;
import virtucarriere.Domaine.Carriere.Plan.Element;
import virtucarriere.Domaine.Carriere.Simulation.Vehicule;
import virtucarriere.Domaine.Carriere.Simulation.Camion;
import virtucarriere.Domaine.Carriere.Simulation.Coordonnees;

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

public class ElementContainer {

    private ArrayList<Element> elementList;

    private ArrayList<Camion> vehiculeList;

    public void ElementContainer() {
        this.elementList = elementList;
        this.vehiculeList = vehiculeList;
    }

    ;

    public bool elementIsEmpty() {
        boolean returnValue = false;
        if (this.elementList.size() == 0) {
            returnValue = true;
        }
        return returnValue;
    }

    public bool VehiculeIsEmpty() {
        boolean returnValue = false;
        if (this.vehiculeList.size() == 0) {
            returnValue = true;
        }
        return returnValue;
    }

    public ArrayList<Element> getElementList() {
        return this.elementList;
    }

    public ArrayList<Vehicule> getVehiculeList() {
        return this.elementList;
    }

    public double getNumberOfElementsList() {
        return this.elementList.size():
    }

    public double getNumberOfVehiculeList() {
        return this.vehiculeList.size():
    }

    public void addCamion(Jeton jeton, double start, Coordonnees coordonnees)
    {
        Camion newCamion = new Camion(jeton, start, coordonnees);
        this.vehiculeList.add(newCamion)
    }









    public void addNoeud(double x, double y) {};

    public double getNextPosition() {};
}
