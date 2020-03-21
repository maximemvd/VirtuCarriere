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

import java.util.ArrayList;

public class ElementContainer {

    private ArrayList<Element> elementList;

    private ArrayList<Camion> vehiculeList;

    public  ElementContainer() {
        elementList = new ArrayList<Element>();
        vehiculeList = new ArrayList<Camion>();
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

    public ArrayList<Element> getElementList() {
        return elementList;
    }

    public ArrayList<Camion> getVehiculeList() {
        return vehiculeList;
    }

    public double getNumberOfElementsList() {
        return elementList.size();
    }

    public double getNumberOfVehiculeList() {
        return vehiculeList.size();
    }

    public void addElement(Element p_element)
    {
        elementList.add(p_element);
    }

    public void removeElement(Element p_element)
    {
        try 
        {
            elementList.remove(p_element);
        }
        catch(Exception error)
        {
            System.out.println("Element is not in the list");
        }
    }


    public void addCamion(Jeton jeton, double start, Coordonnees coordonnees)
    {
        Camion newCamion = new Camion(jeton, start, coordonnees);
        vehiculeList.add(newCamion);
    }

    public void removeCamion(Camion p_camion)
    {
        try 
        {
            vehiculeList.remove(p_camion);
        }
        catch(Exception error)
        {
            System.out.println("Vehicule is not in the list");
        }
    }

    public void generateCamionSimulation(Jeton jeton, double depart) 
    {
        Camion vehiculePretPourSimulation = vehiculeList.get(0);
        System.out.println(vehiculePretPourSimulation);
        //appeler fonction pour simulation
        vehiculeList.remove(vehiculePretPourSimulation);
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

    public boolean askValidPlace(Coordonnees coordonnee)
    {
        int x = 10;
        if (x < 10)
        { 
            return true;
        }
        else
        {
            return false;
        }
    }

    public boolean validanceDependance(String type, Coordonnees coordonnee)
    {
        return true;
    }
}



