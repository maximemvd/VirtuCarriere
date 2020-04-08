/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package virtucarriere.Domaine.Carriere.Plan;

import java.awt.Color;
import java.awt.Point;
import java.util.Collections;

public class Tas extends Equipement {

  private String materialCode;
  private double dimension;
  private Color color;
  private String name;
  private double quantite;

  // TODO add attribut point de chargement;
  public Tas(Point point, int p_width, int p_length, String materialCode, double dimension) {
    super(point, p_width, p_length, 0, Collections.emptyList());
    this.materialCode = materialCode;
    this.dimension = dimension;
    this.color = Color.BLACK;
    this.name = "Tas";
  }

  public Color getColor() {
    return color;
  }

  public String getName() {
    return name;
  }

  public String getMaterialCode() {
    return materialCode;
  }

  public double getQuantite() {
    return quantite;
  }
}
