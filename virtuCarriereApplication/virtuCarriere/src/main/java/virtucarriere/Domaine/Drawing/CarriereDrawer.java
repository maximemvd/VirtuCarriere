/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package virtucarriere.Domaine.Drawing;

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
import virtucarriere.Domaine.Carriere.Simulation.Jeton;
import virtucarriere.Domaine.Carriere.Simulation.Simulation;
import virtucarriere.Domaine.Carriere.Simulation.Vehicule;
import virtucarriere.Domaine.Controller.Controller;
import virtucarriere.gui.DrawingPanel;
import virtucarriere.gui.MainWindow;

public class CarriereDrawer {

  private final Controller controller;
  private Dimension initialDimension;
  private DrawingPanel drawingPanel;
  private MainWindow.MeasurementUnitMode measurementMode;
  private Element element;
  private Simulation simulation;

  private int radius = 25;
  private HashMap<String, Color> equipementColor = new HashMap<>();

  public CarriereDrawer(Controller controller, Dimension initialDimension, Simulation simulation) {
    this.simulation = simulation;
    this.controller = controller;
    this.initialDimension = initialDimension;
    equipementColor.put(Broyeur.class.getName(), Color.GREEN);
    equipementColor.put(Concasseur.class.getName(), Color.PINK);
    equipementColor.put(Crible.class.getName(), Color.RED);
  }

  public void draw(Graphics2D g2d, double zoom) {
    // faire un switch case ici
    drawEquipement(g2d, zoom);
    drawNoeud(g2d, zoom);
    drawEntree(g2d, zoom);
    drawVehicule(g2d, zoom);
    drawArc(g2d, zoom);
  }

  public void startSimulation(Graphics2D g2d) {
    List<Camion> camions = simulation.getCamionList();
    camions.forEach(
        (camion) -> {
          try {
            // the camion start at the start
            Color camionColor = camion.getColor();
            Point camionPoint = camion.getPoint();
            g2d.setColor(camionColor);
            g2d.fillOval(
                (int) camionPoint.getX() - radius,
                (int) camionPoint.getY() - radius,
                radius * 2,
                radius * 2);
            Thread.sleep(30000); // wait 3 seconds

            // on indique la position la plus proche
            Jeton jeton = camion.getJeton();
            String code = jeton.getCodeProduit();
            Point pointToGo = simulation.indiqueAuCamionEmplacement(code);
            g2d.fillOval(
                (int) pointToGo.getX() - radius,
                (int) pointToGo.getY() - radius,
                radius * 2,
                radius * 2);

            Thread.sleep(30000); // wait 3 seconds

          } catch (InterruptedException e) {
            e.printStackTrace();
          }
        });
  }

  public void drawVehicule(Graphics2D g2d, double zoom) {
    List<Vehicule> vehicules = controller.getVehiculeList();
    g2d.scale(zoom, zoom);
    vehicules.forEach(
        (vehicule) -> {
          Point vehiculePoint = vehicule.getPoint();
          if (vehicule.isSelected()) {
            g2d.setColor(new Color(255, 0, 0));
            int offsetRadius = radius + 2;
            g2d.fillOval(
                (int) vehiculePoint.getX() - offsetRadius,
                (int) vehiculePoint.getY() - offsetRadius,
                offsetRadius * 2,
                offsetRadius * 2);
          }
          Color vehiculeColor = vehicule.getColor();
          g2d.setColor(vehiculeColor);
          g2d.fillOval(
              (int) vehiculePoint.getX() - radius,
              (int) vehiculePoint.getY() - radius,
              radius * 2,
              radius * 2);
        });
    g2d.scale(1 / zoom, 1 / zoom);
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
            int offsetRadius = (radius + 2) / (int) zoom;
            g.fillOval(
                (int) equipementPoint.getX() - offsetRadius,
                (int) equipementPoint.getY() - offsetRadius,
                offsetRadius * 2,
                offsetRadius * 2);
          }
          Color equipementColor = getColor(equipement);
          System.out.println(equipementColor);
          System.out.println(equipementPoint);
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
          Color arcColor = arc.getColor();
          g2d.setColor(arcColor);
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
