/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package virtucarriere.Domaine.Carriere.Simulation;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.Rectangle;

public class Camion extends Vehicule {

  private Color color;
  private Jeton jeton;
  private Point point;
  private String name;
  private Facture factureCamion;
  private int tempsAttente;

  public Camion(Jeton jeton, Point point, double p_angle, int p_tempsAttente) {
    super(point, p_angle = 0);
    this.jeton = jeton;
    this.name = "Camion";
    this.color = Color.MAGENTA;
    this.tempsAttente = p_tempsAttente;
  }

  public int getTempsAttente() {
    return tempsAttente;
  }

  public void setTempsAttente(int p_temps) {
    this.tempsAttente = p_temps;
    Point upperLeft = new Point((int) (getX() - 2), (int) (getY() - 2));
    Rectangle shape = new Rectangle(upperLeft, new Dimension(2, 2));
    setShape(shape);
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

  public void payeFacture() {
    System.out.println("Le camion paye la facture");
    this.factureCamion = null;
  }

  public boolean verifierFacturePayer() {
    boolean returnValue = false;
    if (factureCamion == null) {
      return true;
    }
    return returnValue;
  }
}
