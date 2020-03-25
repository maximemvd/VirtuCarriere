/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package virtucarriere.Domaine.Carriere.Plan;

import java.awt.Point;

public class Tas extends Noeud {

  private String materialCode;
  private double dimension;

  public Tas(
      Point point,
      int p_width,
      int p_length,
      boolean p_selectionStatus,
      String materialCode,
      double dimension) {
    super(point, p_width, p_length, p_selectionStatus);
    this.materialCode = materialCode;
    this.dimension = dimension;
  }
}
