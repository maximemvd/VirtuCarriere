/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package virtucarriere.Domaine.Carriere.Plan;

public class Element {
    
    private String type;
    private Coordonnees coordonnees;
    private  int width;
    private int lengt;
    private boolean selectionStatus;
    
    public boolean contains(double x, double y){
        return true;
    }
    
    public boolean xIsInsideElementWidth(double x){
        return true;
    }
    
    public boolean yIsInsideElementLength(double y){
        return true;
    }
    
    public void switchElementStatus(){
        this.selectionStatus = !this.selectionStatus;
    }
    
    public void unselect(){
        this.selectionStatus = false;
    }
    
    public boolean isSelected(){
        return this.selectionStatus;
    }
    
}
