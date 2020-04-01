/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package virtucarriere.Domaine.Carriere.Plan;

import java.awt.Color;
import java.awt.Point;

public abstract class Element {

  private Point point;
  private int width;
  private int length;
  private boolean selectionStatus;
  private int radius;

  public Element(Point point, int p_width, int p_length, boolean p_selectionStatus) {
    this.point = point;
    this.width = p_width;
    this.length = p_length;
    this.selectionStatus = false;
    this.radius = 50;
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
    return ((p_x < point.getX() + (getWidth() / 2)) && (p_x > point.getX() - (getWidth() / 2)));
  }

  private boolean yIsInsideElementLength(double p_y) {
    return ((p_y < point.getY() + (getLength() / 2)) && (p_y > point.getY() - (getLength() / 2)));
  }

  public boolean isSelected() {
    return this.selectionStatus;
  }

  public void switchSelectionStatus() {
    this.selectionStatus = !this.selectionStatus;
  }

  public void unselect() {
    this.selectionStatus = false;
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
