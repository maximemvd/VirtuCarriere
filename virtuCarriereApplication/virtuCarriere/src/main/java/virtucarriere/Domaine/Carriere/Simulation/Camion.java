/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package virtucarriere.Domaine.Carriere.Simulation;

import java.util.ArrayList;

import virtucarriere.Domaine.Carriere.Plan.Coordonnees;
import virtucarriere.Domaine.Carriere.Simulation.Jeton;

public class Camion extends Vehicule {

    ArrayList<Node> itineraireCamion;

    private double start;

    private Jeton jeton;

    private Coordonnees coordonnees;

    public Camion() {};

    public Camion(Jeton jeton,double start, Coordonnees coordonnees) 
    {
        itineraireCamion = new ArrayList<Node>();
        this.jeton = jeton;
        this.start = start;
        this.coordonnees = coordonnees;
        //createCamion(jeton, start, coordonnees);
    }

    public Camion createCamion(Jeton jeton,double start, Coordonnees coordonnees) 
    {
        Camion newCamion = new Camion(jeton, start, coordonnees);
        return newCamion;
    };

    public ArrayList<Node> getItineaireList()
    {
        return itineraireCamion;
    }

    public void addDestination(Node p_node)
    {
        itineraireCamion.add(p_node);
    };

    public void removeDestination(Node p_node)
    {
        try 
        {
            itineraireCamion.remove(p_node);
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }

    public void editerParams(Jeton jeton,double start, Coordonnees coordonnees)
    {
        this.jeton = jeton;
        this.start = start;
        this.coordonnees = coordonnees;
    }

    public void Simulation()
    {
        for (Node i: itineraireCamion)
        {
            System.out.println(i);
            //call getShortestPath
        }
        
    }

    

}
