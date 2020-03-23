/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package virtucarriere.Domaine.Carriere.Plan;

import virtucarriere.Domaine.Carriere.Plan.Coordonnees;
import virtucarriere.Domaine.Carriere.Plan.Element;

public abstract class Equipement extends Element{
    
    private double angle;
    
    public Equipement(Coordonnees p_coordonnees, int p_width, int p_length,
            boolean p_selectionStatus, double p_angle){
        super(p_coordonnees, p_width, p_length, p_selectionStatus);
        
        this.angle = p_angle;
    }
    
    public static String equipement() {
        return "First Commits";
    }
    
    public double getAngle(){
        return this.angle;
    }
    
    public void setAngle(double p_angle){
        this.angle = p_angle;
    }
    
}
