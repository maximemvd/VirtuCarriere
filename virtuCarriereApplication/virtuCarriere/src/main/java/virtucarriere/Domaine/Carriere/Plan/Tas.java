/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package virtucarriere.Domaine.Carriere.Plan;

public class Tas extends Noeud {
    
    private String materialCode;
    
    private double dimension;
    
    public Tas(double x, double y, String materialCode, double dimension){
        
        super(x, y);
        
        this.materialCode = materialCode;
        
        this.dimension = dimension;
        
    }
    
}
