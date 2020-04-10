/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package virtucarriere.Domaine.Carriere.Plan;

import java.awt.Color;
import java.awt.Point;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Tas extends Equipement {

  private String materialCode;
  private double dimension;
  private Color color;
  private String name;
  private double quantite;

  private List<String> listMateriau;

  // TODO add attribut point de chargement;
  public Tas(Point point, int p_width, int p_length, String materialCode, double dimension) {
    super(point, p_width, p_length, 0, Collections.emptyList());
    this.materialCode = materialCode;
    this.dimension = dimension;
    this.color = Color.DARK_GRAY;
    this.name = "Tas";
    this.listMateriau = new LinkedList<>();
    this.setlistMateriau();
  }

  private void setlistMateriau() {
    this.listMateriau.add("1-110");
    this.listMateriau.add("1-214");
    this.listMateriau.add("1-220");
    this.listMateriau.add("1-228");
    this.listMateriau.add("1-644");
    this.listMateriau.add("1-630");
    this.listMateriau.add("1-695");
  }

  public boolean verifierCodeMateriau(String materiau) {
    int index = 0;
    for (String code : listMateriau) {
      if (!materiau.equals(code)) {
        index++;
      }
    }
    return index == listMateriau.size();
  }

  public List<String> getListMateriau() {
    return listMateriau;
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
