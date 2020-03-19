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
import virtucarriere.Domaine.Carriere.Plan.Noeud;

import java.util.Arrays;
import java.util.List;
import java.util.String;
import java.util.ArrayList;

public class ElementContainer {

    private ArrayList<Element> elementList;

    private ArrayList<Camion> vehiculeList;

    public void ElementContainer() {
        this.elementList = new ArrayList<Element>();
        this.vehiculeList = new ArrayList<Camion>();
    }

    ;

    public boolean elementIsEmpty() {
        boolean returnValue = false;
        if (this.elementList.size() == 0) {
            returnValue = true;
        }
        return returnValue;
    }

    public boolean VehiculeIsEmpty() {
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

    public void addEquipement(Equipement p_equipement)
    {
        this.elementList.add(p_equipement);
    }

    public void addCamion(Jeton jeton, double start, Coordonnees coordonnees)
    {
        Camion newCamion = new Camion(jeton, start, coordonnees);
        this.vehiculeList.add(newCamion)
    }

    public void addNoeud(double x, double y)
    {
     Noeud newNoeud = new Noeud(x, y);
     this.elementList.add(newNoeud);
    }

    public String askReason()
    {
        return "La raison";
    }

    public double getNextPosition()
    {
        // on appel une fonction de vehicule ici
        double nextPosition = 10;
        return nextPosition;
    }

    public boolean askValidPlace(Coordonnees coord)
    {
        if (coord)
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    public boolean validanceDependanceType()
    {
        return true;
    }






}




