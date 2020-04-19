/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package virtucarriere.Domaine.Carriere.Simulation;

import java.awt.Color;
import java.awt.Point;
import java.io.Serializable;
import java.util.List;
import virtucarriere.Domaine.Carriere.Plan.Noeud;

public abstract class Vehicule implements Serializable {

  private Color color;

  private Itineraire route;

  private Point point;
  private boolean selectionStatus;
  private int radius;

  public Vehicule(Point point) {
    this.point = point;
    this.selectionStatus = false;
    this.radius = 45;
  };

  public void getShortestPath(Jeton jeton) {
    List<Noeud> start;
    List<Noeud> result;
  }

  public boolean contains(double p_x, double p_y) {
    return (xIsInsideElementWidth(p_x) && yIsInsideElementLength(p_y));
  }

  public void setPoint(Point newPoint) {
    this.point = newPoint;
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
    this.selectionStatus = !this.selectionStatus;
  }

  public double getX() {
    return this.point.getX();
  }

  public double getY() {
    return this.point.getY();
  }

  public void unselect() {
    this.selectionStatus = false;
  }

  public Itineraire getRoute() {
    return route;
  }

  public Point getPoint() {
    return point;
  }

  public void translate(double deltaX, double deltaY) {
    this.point.x = (int) (this.point.getX() + deltaX);
    this.point.y = (int) (this.point.getY() + deltaY);
  }

  public abstract Color getColor();

  public abstract String getName();
}
