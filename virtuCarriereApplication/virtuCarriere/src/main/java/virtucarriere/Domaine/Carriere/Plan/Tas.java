/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package virtucarriere.Domaine.Carriere.Plan;

import static java.lang.Math.cos;
import static java.lang.Math.sin;
import static java.lang.Math.toRadians;

import java.awt.Color;
import java.awt.Point;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Tas extends Equipement {

  private String materialCode;
  private int dimension;
  private Color color;
  private double quantite;
  private Noeud noeudTas;
  private PointChargement pointChargement;

  private List<String> listMateriau;

  public Tas(
      Point point, int p_width, int p_length, String materialCode, int dimension, double angle) {
    super(point, p_width, p_length, angle, Collections.emptyList());
    this.materialCode = materialCode;
    this.dimension = dimension;
    this.color = Color.DARK_GRAY;
    setName("Tas");
    this.listMateriau = new LinkedList<>();
    this.setlistMateriau();
    createPointChargement();
  }

  private void createPointChargement() {
    this.pointChargement = new PointChargement(getNewPointPointChargement());
  }

  private Point getNewPointPointChargement() {
    List<Double> decalage = decalage();
    Point newPoint =
        new Point((int) (point.x + decalage.get(0)), (int) (point.y + decalage.get(1)));
    return newPoint;
  }

  @Override
  public boolean contains(double p_x, double p_y) {
    return (xIsInsideElementWidth(p_x) && yIsInsideElementLength(p_y));
  }

  private boolean xIsInsideElementWidth(double p_x) {
    return ((p_x < point.getX() + dimension) && (p_x > point.getX() - dimension));
  }

  private boolean yIsInsideElementLength(double p_y) {
    return ((p_y < point.getY() + dimension) && (p_y > point.getY() - dimension));
  }

  private List<Double> decalage() {
    int offset = 20;
    double distance = dimension + offset;
    double angleRadian = toRadians(getAngle());
    double decalageX = distance * cos(angleRadian);
    double decalageY = distance * sin(angleRadian);
    return Arrays.asList(decalageX, decalageY);
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
  public void setPoint(Point newPoint) {
    this.point = newPoint;
    pointChargement.setPoint(getNewPointPointChargement());
  }

  @Override
  public void setAngle(double p_angle) {
    super.setAngle(p_angle);
    pointChargement.setPoint(getNewPointPointChargement());
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

  public Color getColor() {
    return color;
  }

  public String getMaterialCode() {
    return materialCode;
  }

  public void setMaterialCode(String newCode) {
    this.materialCode = newCode;
  }
}
