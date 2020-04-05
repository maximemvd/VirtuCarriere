/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package virtucarriere.Domaine.Carriere.Simulation;

import java.awt.Color;
import java.awt.Point;

public class Chargeur extends Vehicule {

  private Jeton jetonCourant;
  private Point point;
  private Color color;
  private String name;

  public Chargeur(Point point, boolean p_selectionStatus) {
    super(point, p_selectionStatus);
    this.color = Color.GREEN;
    this.name = "Chargeur";
  };

  @Override
  public Color getColor() {
    return color;
  }

  public void setJeton(Jeton p_jeton) {
    this.jetonCourant = p_jeton;
  }

  public Jeton getJeton() {
    return jetonCourant;
  }

  @Override
  public String getName() {
    return name;
  }

  public void changeDestination(Point p_point) {
    this.point = p_point;
  }
}
