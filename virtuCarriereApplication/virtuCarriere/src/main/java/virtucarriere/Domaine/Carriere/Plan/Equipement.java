/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package virtucarriere.Domaine.Carriere.Plan;

import java.awt.Dimension;
import java.awt.Point;
import java.awt.Rectangle;
import java.util.List;

public abstract class Equipement extends Element {

  private Angle angle;
  private List<Class<? extends Equipement>> dependency;
  private int height;
  private int width;

  public Equipement(
      Point point,
      int p_width,
      int p_length,
      double p_angle,
      List<Class<? extends Equipement>> dependency) {
    super(point);

    this.angle = new Angle(p_angle);
    this.dependency = dependency;
    this.height = p_length;
    this.width = p_width;
  }

  public static String equipement() {
    return "First Commits";
  }

  public double getAngle() {
    return angle.get();
  }

  public void setAngle(double p_angle) {
    angle.set(p_angle);
  }

  public List<Class<? extends Equipement>> getDependency() {
    return dependency;
  }

  @Override
  public boolean contains(double p_x, double p_y) {
    Point upperLeft = new Point((int) getX(), (int) getY());
    Rectangle shape = new Rectangle(upperLeft, new Dimension(height, width));
    return shape.contains(p_x, p_y);
  }

  public int getWidth() {
    return width;
  }

  public void setWidth(int width) {
    this.width = width;
  }

  public int getLength() {
    return height;
  }

  public void setLength(int length) {
    this.height = length;
  }
}
