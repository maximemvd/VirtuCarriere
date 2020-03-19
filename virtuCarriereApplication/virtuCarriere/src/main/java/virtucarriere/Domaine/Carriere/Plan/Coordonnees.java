/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package virtucarriere.Domaine.Carriere.Plan;

public class Coordonnees {
    
    private double x;
    private double y;
    
    public Coordonnees(double abscisse, double ordonnee) {
        this.x = abscisse;
        this.y = ordonnee;
    }
    
    public double getX(){
        return this.x;
    }
    
    public double getY(){
        return this.y;
    }
    
    public String toString(){
        return String.valueOf(this.x) + ", " + String.valueOf(this.y);
    }
    
}
