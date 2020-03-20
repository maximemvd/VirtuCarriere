/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package virtucarriere.Domaine.Carriere.Plan;

public class Convoyeur extends Equipement{
    
    private Noeud destination;
    
    public Convoyeur(String type, Coordonnees coordonnees, int width, int length,
            boolean selectionStatus, double angle, Noeud destination){
        
        super(type, coordonnees, width, length, selectionStatus, angle);
        
        this.destination = destination;
    }
    
    public void setDestination(Noeud destination){
        this.destination = destination;
    }
    
    public Noeud getDestination(){
        return this.destination;
    }
    
}
