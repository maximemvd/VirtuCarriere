/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package virtucarriere.Domaine.Carriere.Plan;

import java.awt.Point;
import java.io.Serializable;

public abstract class Element implements Serializable {

  protected Point point;
  private boolean selectionStatus;
  private String name;

  public Element(Point point) {
    this.point = point;
    this.selectionStatus = false;
  }

  public Point getPoint() {
    return point;
  }

  public double getX() {
    return this.point.getX();
  }

  public double getY() {
    return this.point.getY();
  }

  public void setPoint(Point newPoint) {
    this.point = newPoint;
  }

  public abstract boolean contains(double p_x, double p_y);

  public boolean isSelected() {
    return selectionStatus;
  }

  public void switchSelectionStatus() {
    selectionStatus = !selectionStatus;
  }

  public boolean getSelectionStatus() {
    return selectionStatus;
  }

  public void setSelectionStatus(boolean selectionStatus) {
    this.selectionStatus = selectionStatus;
  }

  public void translate(double deltaX, double deltaY) {
    this.point.x = (int) (this.point.getX() + deltaX);
    this.point.y = (int) (this.point.getY() + deltaY);
  }

  public String getName() {
    return name;
  }

  protected void setName(String name) {
    this.name = name;
  }
}
