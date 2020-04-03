/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package virtucarriere.Domaine.Carriere.Simulation;

import java.awt.Point;

public class Chargeur extends Vehicule {

  private Point destination;

  public Chargeur(Point p_destination) {
    this.destination = p_destination;
  };

  @Override
  public Point getPoint() {
    return destination;
  }

  public Point getDestination() {
    return this.destination;
  }

  public void changeDestination(Point p_point) {
    this.destination = p_point;
  }
}
