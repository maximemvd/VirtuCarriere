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

    public Camion() {};

    public Camion(Jeton jeton,double start, Coordonnees coordonnees) 
    {
        createCamion(jeton, start, coordonnees);
    }

    public void createCamion(Jeton jeton,double start, Coordonnees coordonnees) 
    {
        
    };

    public void addDestination(Node p_node)
    {
        itineraireCamion.add(p_node);
    };

}
