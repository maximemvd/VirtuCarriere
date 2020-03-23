/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package virtucarriere.Domaine.Carriere.Plan;
import java.awt.Color;
import java.awt.Point;

public class Concasseur extends Equipement {
    
    private Color color;

    public Concasseur(Point point, Coordonnees p_coordonnees, int p_width, int p_length,
            boolean p_selectionStatus, double p_angle){
        
        super(point, p_coordonnees, p_width, p_length, p_selectionStatus, p_angle);
        this.color = color;
        
    }
    
        public Color getColor()
    {
        return Color.BLUE;
    }
}
