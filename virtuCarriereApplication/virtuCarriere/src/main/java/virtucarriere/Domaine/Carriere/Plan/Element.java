/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package virtucarriere.Domaine.Carriere.Plan;

import java.awt.Color;
import java.awt.Point;

public abstract class Element extends Point {

  private Point point;

  private int width;
  private int length;
  private boolean selectionStatus;

  public Element(Point point, int p_width, int p_length, boolean p_selectionStatus) {
    super(point);
    this.width = p_width;
    this.length = p_length;
    this.selectionStatus = p_selectionStatus;
  }

  public Point getPoint() {
    return point;
  }

  public boolean contains(double p_x, double p_y) {
    return true;
  }

  /*public boolean xIsInsideElementWidth(double p_x) {
      return (this.coordonnees.getX() <= p_x && p_x <= this.coordonnees.getX() + this.width);
    }

    public boolean yIsInsideElementLength(double p_y) {
      return (this.coordonnees.getY() <= p_y && p_y <= this.coordonnees.getY() + this.width);
    }
  */

  public void switchElementStatus() {
    this.selectionStatus = !this.selectionStatus;
  }

  public void unselect() {
    this.selectionStatus = false;
  }

  public boolean isSelected() {
    return this.selectionStatus;
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

  public abstract Color getColor();
}
