/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package virtucarriere.Domaine.Carriere.Plan;

import java.io.Serializable;

public class Angle implements Serializable {
  private double degree;

  public Angle(double degree) {
    if (degree > 360 || degree < 0) {
      throw new RuntimeException("L'angle est invalide");
    }
    this.degree = degree;
  }

  public double get() {
    return this.degree;
  }

  public void set(double degree) {
    this.degree = degree;
  }
}
