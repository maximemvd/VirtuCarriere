/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package virtucarriere.Domaine.Carriere.Plan;

import virtucarriere.Domaine.Carriere.Plan.Coordonnees;
import virtucarriere.Domaine.Carriere.Plan.Element;

abstract class Equipement extends Element{
    
    private double angle;
    
    public Equipement(String type, Coordonnees coordonnees, int width, int length,
            boolean selectionStatus, double angle){
        super(type, coordonnees, width, length, selectionStatus);
        
        this.angle = angle;
    }
    
    public static String equipement() {
        return "First Commits";
    }
    
    public double getAngle(){
        return this.angle;
    }
    
    public void setAngle(double angle){
        this.angle = angle;
    }
    
}
