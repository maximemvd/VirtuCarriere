/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package virtucarriere.Domaine.Carriere.Simulation;

import java.awt.Color;
import java.awt.Point;

public class Chargeur extends Vehicule {

  private Point point;
  private Color color;

  public Chargeur(Point point) {
    super(point);
    this.color = Color.GREEN;
  };

  public Color getColor() {
    return color;
  }

  public void changeDestination(Point p_point) {
    this.point = p_point;
  }
}
