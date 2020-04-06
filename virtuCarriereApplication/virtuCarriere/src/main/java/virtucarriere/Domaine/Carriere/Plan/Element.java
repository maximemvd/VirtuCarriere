/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package virtucarriere.Domaine.Carriere.Plan;

import java.awt.Point;
import java.io.Serializable;

public abstract class Element implements Serializable {

  private Point point;
  private int width;
  private int length;
  private boolean selectionStatus;
  private int radius;

  public Element(Point point, int p_width, int p_length) {
    this.point = point;
    this.width = p_width;
    this.length = p_length;
    this.selectionStatus = false;
    this.radius = 25;
  }

  public Point getPoint() {
    return point;
  }

  public void setPoint(int p_x, int p_y) {
    this.point = new Point(p_x, p_y);
  }

  public double getX() {
    return this.point.getX();
  }

  public double getY() {
    return this.point.getY();
  }

  public boolean contains(double p_x, double p_y) {
    return (xIsInsideElementWidth(p_x) && yIsInsideElementLength(p_y));
  }

  private boolean xIsInsideElementWidth(double p_x) {
    return ((p_x < point.getX() + radius) && (p_x > point.getX() - radius));
  }

  private boolean yIsInsideElementLength(double p_y) {
    return ((p_y < point.getY() + radius) && (p_y > point.getY() - radius));
  }

  public boolean isSelected() {
    return selectionStatus;
  }

  public void switchSelectionStatus() {
    selectionStatus = !selectionStatus;
  }

  public void unselect() {
    selectionStatus = false;
  }

  public int getRadius() {
    return radius;
  }

  public int getWidth() {
    return width;
  }

  public void setWidth(int width) {
    this.width = width;
  }

  public int getLength() {
    return length;
  }

  public void setLength(int length) {
    this.length = length;
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
}
