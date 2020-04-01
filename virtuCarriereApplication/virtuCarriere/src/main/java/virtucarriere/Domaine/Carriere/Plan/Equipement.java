/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package virtucarriere.Domaine.Carriere.Plan;

import java.awt.Color;
import java.awt.Point;
import java.util.List;

public abstract class Equipement extends Element {

  private Angle angle;
  private List<Class<? extends Equipement>> dependency;

  public Equipement(
      Point point, int p_width, int p_length, boolean p_selectionStatus, double p_angle) {

    super(point, p_width, p_length, p_selectionStatus);

    this.angle = new Angle(p_angle);
    this.dependency = dependency;
  }

  public static String equipement() {
    return "First Commits";
  }

  public double getAngle() {
    return angle.get();
  }

  public abstract Color getColor();

  public void setAngle(double p_angle) {
    angle.set(p_angle);
  }

  public abstract String getName();
}
