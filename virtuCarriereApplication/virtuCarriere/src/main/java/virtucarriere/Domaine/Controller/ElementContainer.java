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
        elementList = new ArrayList<Element>();
        vehiculeList = new ArrayList<Camion>();
    }



    public boolean elementIsEmpty() {
        return elementList.isEmpty();
    }

    public boolean VehiculeIsEmpty() {
        return vehiculeList.isEmpty();
    }

    public ArrayList<Element> getElementList() {
        return elementList;
    }

    public ArrayList<Vehicule> getVehiculeList() {
        return elementList;
    }

    public double getNumberOfElementsList() {
        return elementList.size():
    }

    public double getNumberOfVehiculeList() {
        return vehiculeList.size():
    }

    public void addEquipement(Equipement p_equipement)
    {
        elementList.add(p_equipement);
    }

    public void addCamion(Jeton jeton, double start, Coordonnees coordonnees)
    {
        Camion newCamion = new Camion(jeton, start, coordonnees);
        vehiculeList.add(newCamion)
    }

    public void addNoeud(double x, double y)
    {
        Noeud newNoeud = new Noeud(x, y);
        elementList.add(newNoeud);
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

    public boolean validanceDependance(String type, Coordonnees coord)
    {
        return true;
    }
}




