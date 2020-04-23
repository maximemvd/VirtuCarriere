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
  private int dimension;
  private Color color;
  private double quantite;
  private Point point;

  private Noeud noeudTas;

  private PointChargement pointChargement;

  private List<String> listMateriau;

  // TODO add attribut point de chargement;
  public Tas(Point point, int p_width, int p_length, String materialCode, int dimension) {
    super(point, p_width, p_length, 0, Collections.emptyList());
    this.point = point;
    this.materialCode = materialCode;
    this.dimension = dimension;
    this.color = Color.DARK_GRAY;
    setName("Tas");
    this.listMateriau = new LinkedList<>();
    this.setlistMateriau();
    Point newPoint = new Point(point.x - 55, point.y + 6);
    this.pointChargement = new PointChargement(newPoint, 3, 3);
  }

  public void setDimension(int newDimension) {
    this.dimension = newDimension;
  }

  public int getDimension() {
    return dimension;
  }

  public void setNoeudTas(Noeud new_noeud) {
    this.noeudTas = new_noeud;
  }

  public Noeud getNoeud() {
    return noeudTas;
  }

  @Override
  public void setPoint(int p_x, int p_y) {
    point = new Point(p_x, p_y);
    Point newPoint = new Point(p_x - 25, p_y + 15);
    this.pointChargement = new PointChargement(newPoint, 3, 3);
  }

  public void setPointChargement(int p_x, int p_y) {
    Point newPoint = new Point(p_x - 25, p_y + 15);
    this.pointChargement = new PointChargement(newPoint, 3, 3);
  }

  public PointChargement getPointChargement() {
    return pointChargement;
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

  @Override
  public String getMaterialCode() {
    return materialCode;
  }

  public double getQuantite() {
    return quantite;
  }

  @Override
  public void setMaterialCode(String newCode) {
    this.materialCode = newCode;
  }
}
