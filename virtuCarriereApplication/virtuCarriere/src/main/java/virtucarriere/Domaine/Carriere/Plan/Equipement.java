/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package virtucarriere.Domaine.Carriere.Plan;

import java.awt.Point;
import java.util.List;

public abstract class Equipement extends Element {

  private Angle angle;
  private List<Class<? extends Equipement>> dependency;

  public Equipement(
      Point point,
      int p_width,
      int p_length,
      double p_angle,
      List<Class<? extends Equipement>> dependency) {

    super(point, p_width, p_length);

    this.angle = new Angle(p_angle);
    this.dependency = dependency;
  }

  public static String equipement() {
    return "First Commits";
  }

  public double getAngle() {
    return angle.get();
  }

  public abstract int getDimension();

  public abstract void setDimension(int newDimension);

  public void setAngle(double p_angle) {
    angle.set(p_angle);
  }

  public abstract PointChargement getPointChargement();

  public List<Class<? extends Equipement>> getDependency() {
    return dependency;
  }
}
