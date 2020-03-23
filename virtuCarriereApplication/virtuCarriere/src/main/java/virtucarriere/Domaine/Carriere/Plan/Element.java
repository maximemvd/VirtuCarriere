/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package virtucarriere.Domaine.Carriere.Plan;

public class Element {

    private Coordonnees coordonnees;
    private int width;
    private int length;
    private boolean selectionStatus;

    public Element(Coordonnees p_coordonnees, int p_width, int p_length, boolean p_selectionStatus) {

        this.coordonnees = p_coordonnees;
        this.width = p_width;
        this.length = p_length;
        this.selectionStatus = p_selectionStatus;
    }

    public boolean contains(double p_x, double p_y) {
        return true;
    }

    public boolean xIsInsideElementWidth(double p_x) {
        return (this.coordonnees.getX() <= p_x && p_x <= this.coordonnees.getX() + this.width);
    }

    public boolean yIsInsideElementLength(double p_y) {
        return (this.coordonnees.getY() <= p_y && p_y <= this.coordonnees.getY() + this.width);
    }

    public void switchElementStatus() {
        this.selectionStatus = !this.selectionStatus;
    }

    public void unselect() {
        this.selectionStatus = false;
    }

    public boolean isSelected() {
        return this.selectionStatus;
    }

    public String getCoordonnees() {
        return this.coordonnees.toString();
    }

    public void setCoordonnees(Coordonnees coordonnees) {
        this.coordonnees = coordonnees;
    }

    public int getWidth() {
        return this.width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getLength() {
        return this.length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public boolean getSelectionStatus() {
        return this.selectionStatus;
    }

    public void setSelectionStatus(boolean selectionStatus) {
        this.selectionStatus = selectionStatus;
    }

}
