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
    private int length;
    private boolean selectionStatus;
    
    public Element(String type, Coordonnees coordonnees, int width, int length,
            boolean selectionStatus){
        
        this.type = type;
        this.coordonnees = coordonnees;
        this.width = width;
        this.length = length;
        this.selectionStatus = selectionStatus;
    }
    
    public boolean contains(double x, double y){
        return true;
    }
    
    public boolean xIsInsideElementWidth(double x){
        return (this.coordonnees.getX() <= x && x <= this.coordonnees.getX() + this.width);
    }
    
    public boolean yIsInsideElementLength(double y){
        return (this.coordonnees.getY() <= y && y <= this.coordonnees.getY() + this.width);
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
    
    public String getType(){
        return this.type;
    }
    
    public void setType(String type){
        this.type = type;
    }
    
    public String getCoordonnees(){
        return this.coordonnees.toString();
    }
    
    public void setCoordonnees(Coordonnees coordonnees){
        this.coordonnees = coordonnees;
    }
    
    public int getWidth(){
        return this.width;
    }
    
    public void setWidth(int width){
        this.width = width;
    }
    
    public int getLength(){
        return this.length;
    }
    
    public void setLength(int length){
        this.length = length;
    }
    
    public boolean getSelectionStatus(){
        return this.selectionStatus;
    }
    
    public void setSelectionStatus(boolean selectionStatus){
        this.selectionStatus = selectionStatus;
    }
    
}
