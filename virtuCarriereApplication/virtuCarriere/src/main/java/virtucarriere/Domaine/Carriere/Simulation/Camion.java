/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package virtucarriere.Domaine.Carriere.Simulation;

import java.awt.Color;
import java.awt.Point;

public class Camion extends Vehicule {

  private double start;
  private Color color;
  private Jeton jeton;
  private Point point;
  private String name;

  public Camion(Jeton jeton, Point point) {
    super(point);
    this.jeton = jeton;
    this.start = start;
    this.name = "Camion";

    this.color = Color.MAGENTA;
    // createCamion(jeton, start, coordonnees);
  }

  public Camion createCamion(Jeton jeton, Point point) {
    Camion newCamion = new Camion(jeton, point);
    return newCamion;
  };

  public void changeEtat(String etat) {
    jeton.setEtat(etat);
  }

  public String getEtat() {
    return jeton.getEtat();
  }

  public void goTO(Point new_point) {
    this.point = new_point;
  }

  @Override
  public Color getColor() {
    return color;
  }

  public Jeton getJeton() {
    return jeton;
  }

  @Override
  public String getName() {
    return name;
  }

  public void editerParams(Jeton jeton, Point point) {
    this.jeton = jeton;
    this.point = point;
  }
}
