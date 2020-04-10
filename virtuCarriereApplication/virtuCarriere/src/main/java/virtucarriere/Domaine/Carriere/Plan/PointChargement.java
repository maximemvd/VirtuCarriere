/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package virtucarriere.Domaine.Carriere.Plan;

import java.awt.Color;
import java.awt.Point;

/** @author philippevincent */
public class PointChargement {

  private Point point;

  private int width;

  private int length;

  private Color color;

  private Noeud noeud;

  public PointChargement(Point p_point) {
    this.point = p_point;
    this.width = 30;
    this.length = 30;
    this.color = Color.PINK;
  }

  public Color getColor() {
    return color;
  }

  public Point getPoint() {
    return point;
  }

  public int getWidth() {
    return width;
  }

  public int getLenght() {
    return length;
  }
}
