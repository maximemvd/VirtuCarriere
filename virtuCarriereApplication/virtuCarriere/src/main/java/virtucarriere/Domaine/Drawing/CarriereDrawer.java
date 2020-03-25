/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package virtucarriere.Domaine.Drawing;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.util.List;
import virtucarriere.Domaine.Carriere.Plan.Equipement;
import virtucarriere.Domaine.Carriere.Plan.Noeud;
import virtucarriere.Domaine.Controller.Controller;
import virtucarriere.gui.MainWindow;

public class CarriereDrawer {

  private final Controller controller;
  private Dimension initialDimension;
  private MainWindow.MeasurementUnitMode measurementMode;

  private int radius = 25;

  public CarriereDrawer(Controller controller, Dimension initialDimension) {
    this.controller = controller;
    this.initialDimension = initialDimension;
  }

  public void draw(Graphics g) {
    drawCarriere(g);
    drawEquipement(g);
    drawNoeud(g);
  }

  public void drawCarriere(Graphics g) {
    int width = (int) initialDimension.getWidth();
    int height = (int) initialDimension.getHeight();
    g.setColor(Color.ORANGE);
    g.fillRect(0, 0, width, height);
  }

  public void drawEquipement(Graphics g) {
    List<Equipement> equipements = controller.getEquipementList();
    equipements.forEach(
        (equipement) -> {
          Point equipementPoint = equipement.getPoint();
          Color equipementColor = equipement.getColor();
          g.setColor(equipementColor);
          g.fillOval(
              (int) equipementPoint.getX() - radius,
              (int) equipementPoint.getY() - radius,
              radius * 2,
              radius * 2);
        });
  }

  public void drawCamion(Graphics g) {};

  public void drawNoeud(Graphics g) {
    List<Noeud> noeuds = controller.getNoeudList();
    noeuds.forEach(
        (noeud) -> {
          System.out.print("hello my great Friends");
          System.out.print(noeud.getPoint());
          System.out.print(noeud.getColor());
          System.out.print("hello my great Friends");
          Point noeudPoint = noeud.getPoint();
          Color noeudColor = noeud.getColor();
          g.setColor(noeudColor);
          g.fillOval(
              (int) noeudPoint.getX() - radius,
              (int) noeudPoint.getY() - radius,
              radius * 2,
              radius * 2);
        });
  }

  public void setMeasurementUnitMode(MainWindow.MeasurementUnitMode measurementMode) {
    this.measurementMode = measurementMode;
  }
}
