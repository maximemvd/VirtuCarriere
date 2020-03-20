/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package virtucarriere.Domaine.Carriere.Simulation;

import java.util.List;
import virtucarriere.Domaine.Carriere.Plan.Tas;

public class Vehicule {
    
    private Itineraire route;
    
    public void getShortestPath(Jeton jeton){
        List<Tas> stops = null;
        route = new Itineraire(stops);
    }
    public Itineraire getRoute() {
        return route;
    }
    
}
