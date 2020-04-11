/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package virtucarriere.Domaine.Carriere.Simulation;

import java.awt.Color;
import java.awt.Point;

public class Camion extends Vehicule {

  private Color color;
  private Jeton jeton;
  private Point point;
  private String name;
  private Facture factureCamion;

  public Camion(Jeton jeton, Point point) {
    super(point);
    this.jeton = jeton;
    this.name = "Camion";
    this.color = Color.MAGENTA;
    // createCamion(jeton, start, coordonnees);
  }

  public void setFacture(Facture p_facture) {
    this.factureCamion = p_facture;
  }

  public Facture getFacture() {
    return factureCamion;
  }

  public void changeEtat(String etat) {
    jeton.setEtat(etat);
  }

  public String getEtat() {
    return jeton.getEtat();
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

  public void editerParams(Jeton jeton) {
    this.jeton = jeton;
  }
}
