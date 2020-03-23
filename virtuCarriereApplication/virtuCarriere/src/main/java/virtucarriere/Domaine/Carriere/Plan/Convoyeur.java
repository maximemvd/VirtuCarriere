/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package virtucarriere.Domaine.Carriere.Plan;
 import java.awt.Point;
 import java.awt.Color;

public class Convoyeur extends Equipement{
    
    private Noeud destination;
    
    private Color color;
    
    public Convoyeur(Point point, Coordonnees p_coordonnees, int p_width, int p_length,
            boolean p_selectionStatus, double p_angle, Noeud p_destination){
        
        super(point, p_coordonnees, p_width, p_length, p_selectionStatus, p_angle);
        
        this.destination = p_destination;
        this.color = Color.ORANGE;
    }
    
    public void setDestination(Noeud p_destination){
        this.destination = p_destination;
    }
    
    public Noeud getDestination(){
        return this.destination;
    }
    
    public Color getColor()
    {
        return Color.PINK;
    }
    
}
