/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package virtucarriere.Domaine.Drawing;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Point;
import java.util.HashMap;
import java.util.List;
import virtucarriere.Domaine.Carriere.Plan.Arc;
import virtucarriere.Domaine.Carriere.Plan.Broyeur;
import virtucarriere.Domaine.Carriere.Plan.Concasseur;
import virtucarriere.Domaine.Carriere.Plan.Crible;
import virtucarriere.Domaine.Carriere.Plan.Element;
import virtucarriere.Domaine.Carriere.Plan.Entree;
import virtucarriere.Domaine.Carriere.Plan.Equipement;
import virtucarriere.Domaine.Carriere.Plan.Noeud;
import virtucarriere.Domaine.Carriere.Simulation.Camion;
import virtucarriere.Domaine.Carriere.Simulation.Chargeur;
import virtucarriere.Domaine.Controller.Controller;
import virtucarriere.gui.DrawingPanel;
import virtucarriere.gui.MainWindow;

public class CarriereDrawer {

  private final Controller controller;
  private Dimension initialDimension;
  private DrawingPanel drawingPanel;
  private MainWindow.MeasurementUnitMode measurementMode;
  private Element element;

  private int radius = 25;
  private HashMap<String, Color> equipementColor = new HashMap<>();

  public CarriereDrawer(Controller controller, Dimension initialDimension) {
    this.controller = controller;
    this.initialDimension = initialDimension;
    equipementColor.put(Broyeur.class.getName(), Color.GREEN);
    equipementColor.put(Concasseur.class.getName(), Color.PINK);
    equipementColor.put(Crible.class.getName(), Color.RED);
  }

  public void draw(Graphics2D g2d, double zoom) {
    drawEquipement(g2d, zoom);
    drawNoeud(g2d, zoom);
    drawEntree(g2d, zoom);
    drawArc(g2d, zoom);
    drawChargeur(g2d, zoom);
    drawCamion(g2d, zoom);
  }

  public void drawChargeur(Graphics2D g2d, double zoom) {
    g2d.scale(zoom, zoom);
    List<Chargeur> chargeurs = controller.getChargeurList();
    chargeurs.forEach(
        (chargeur) -> {
          Point vehiculePoint = chargeur.getPoint();
          if (chargeur.isSelected()) {
            g2d.setColor(new Color(255, 0, 0));
            int offsetRadius = radius + 2;
            g2d.fillOval(
                (int) vehiculePoint.getX() - offsetRadius,
                (int) vehiculePoint.getY() - offsetRadius,
                offsetRadius * 2,
                offsetRadius * 2);
          }
          Color vehiculeColor = Color.GREEN;
          g2d.setColor(vehiculeColor);
          g2d.fillOval(
              (int) vehiculePoint.getX() - radius,
              (int) vehiculePoint.getY() - radius,
              radius * 2,
              radius * 2);
        });
    g2d.scale(1 / zoom, 1 / zoom);
  }

  public void drawCamion(Graphics2D g2d, double zoom) {
    List<Camion> camions = controller.getCamionList();
    int numberOfCLient = camions.size();
    camions.forEach(
        (camion) -> {
          Point pointEntree = controller.getEntreePoint();
          int camionPointX = pointEntree.x - (100 * numberOfCLient);
          int camionPointY = pointEntree.y;
          if (camion.isSelected()) {
            g2d.setColor(new Color(255, 0, 0));
            int offsetRadius = radius + 2;
            g2d.fillOval(
                (int) camionPointX - offsetRadius,
                (int) camionPointY - offsetRadius,
                offsetRadius * 2,
                offsetRadius * 2);
          }
          Color couleurCamion = Color.YELLOW;
          g2d.setColor(couleurCamion);
          g2d.fillRoundRect(
              camionPointX - radius,
              camionPointY - radius,
              radius * 2,
              radius * 2,
              radius * 2,
              radius * 2);
        });
  }

  public void startSimulation(Graphics2D g2d, double zoom) {
    drawCamion(g2d, zoom);
    drawChargeur(g2d, zoom);
  }

  public void drawCarriere(Graphics2D g2d) {
    int width = (int) initialDimension.getWidth() / (int) drawingPanel.getZoom();
    int height = (int) initialDimension.getHeight() / (int) drawingPanel.getZoom();
    g2d.setColor(Color.ORANGE);
    g2d.fillRect(0, 0, width, height);
  }

  public void drawEquipement(Graphics2D g, double zoom) {
    g.scale(zoom, zoom);
    List<Equipement> equipements = controller.getEquipementList();
    equipements.forEach(
        (equipement) -> {
          Point equipementPoint = equipement.getPoint();
          if (equipement.isSelected()) {
            g.setColor(new Color(255, 0, 0));
            int offsetRadius = radius + 2;
            g.fillOval(
                (int) equipementPoint.getX() - offsetRadius,
                (int) equipementPoint.getY() - offsetRadius,
                offsetRadius * 2,
                offsetRadius * 2);
          }
          Color equipementColor = getColor(equipement);
          g.setColor(equipementColor);
          g.fillOval(
              (int) equipementPoint.getX() - radius,
              (int) equipementPoint.getY() - radius,
              radius * 2,
              radius * 2);
        });
    g.scale(1 / zoom, 1 / zoom);
  }

  private Color getColor(Equipement equipement) {
    return equipementColor.get(equipement.getClass().getName());
  }

  public void drawNoeud(Graphics2D g2d, double zoom) {
    g2d.scale(zoom, zoom);
    List<Noeud> noeuds = controller.getNoeudList();
    noeuds.forEach(
        (noeud) -> {
          Point noeudPoint = noeud.getPoint();
          if (noeud.isSelected()) {
            g2d.setColor(new Color(255, 0, 0));
            int offsetRadius = radius / 2 + 2;
            g2d.fillOval(
                (int) noeud.getX() - offsetRadius,
                (int) noeud.getY() - offsetRadius,
                offsetRadius * 2,
                offsetRadius * 2);
          }
          Color noeudColor = noeud.getColor();
          g2d.setColor(noeudColor);
          g2d.fillOval(
              (int) noeudPoint.getX() - radius / 2,
              (int) noeudPoint.getY() - radius / 2,
              radius,
              radius);
        });
    g2d.scale(1 / zoom, 1 / zoom);
  }

  public void drawEntree(Graphics2D g2d, double zoom) {
    g2d.scale(zoom, zoom);
    List<Entree> entrees = controller.getEntreeList();
    entrees.forEach(
        (entree) -> {
          Point entreePoint = entree.getPoint();
          if (entree.isSelected()) {
            g2d.setColor(new Color(255, 0, 0));
            int offsetRadius = radius + 2;
            g2d.fillRect(
                (int) entree.getX() - offsetRadius,
                (int) entree.getY() - offsetRadius,
                offsetRadius * 2,
                offsetRadius * 2);
          }
          Color entreeColor = entree.getColor();
          g2d.setColor(entreeColor);
          g2d.fillRect(
              (int) entreePoint.getX() - radius,
              (int) entreePoint.getY() - radius,
              radius * 2,
              radius * 2);
        });
    g2d.scale(1 / zoom, 1 / zoom);
  }

  public void drawArc(Graphics2D g2d, double zoom) {
    g2d.scale(zoom, zoom);
    List<Arc> arcs = controller.getArcList();
    arcs.forEach(
        (arc) -> {
          if (arc.isSelected()) {
            g2d.setColor(new Color(255, 0, 0));
            g2d.setStroke(new BasicStroke(7));
            g2d.drawLine(
                (int) arc.getStarting().getX(),
                (int) arc.getStarting().getY(),
                (int) arc.getArrival().getX(),
                (int) arc.getArrival().getY());
          }
          Color arcColor = arc.getColor();
          g2d.setColor(arcColor);
          g2d.setStroke(new BasicStroke(5));
          g2d.drawLine(
              (int) arc.getStarting().getX(),
              (int) arc.getStarting().getY(),
              (int) arc.getArrival().getX(),
              (int) arc.getArrival().getY());
        });
    g2d.scale(1 / zoom, 1 / zoom);
  }

  public void setMeasurementUnitMode(MainWindow.MeasurementUnitMode measurementMode) {
    this.measurementMode = measurementMode;
  }
}
