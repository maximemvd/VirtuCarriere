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

  public void draw(Graphics g) {
    // faire un switch case ici
    drawVehicule(g);
    drawEquipement(g);
    drawNoeud(g);
    drawEntree(g);
    drawArc(g);
  }

  public void startSimulation(Graphics g) {
    List<Camion> camions = simulation.getCamionList();
    camions.forEach(
        (camion) -> {
          try {
            // the camion start at the start
            Color camionColor = camion.getColor();
            Point camionPoint = camion.getPoint();
            g.setColor(camionColor);
            g.fillOval(
                (int) camionPoint.getX() - radius,
                (int) camionPoint.getY() - radius,
                radius * 2,
                radius * 2);
            Thread.sleep(30000); // wait 3 seconds

            // on indique la position la plus proche
            Jeton jeton = camion.getJeton();
            String code = jeton.getCodeProduit();
            Point pointToGo = simulation.indiqueAuCamionEmplacement(code);
            g.fillOval(
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

  public void drawVehicule(Graphics g) {
    List<Vehicule> vehicules = controller.getVehiculeList();
    System.out.println(vehicules);
    vehicules.forEach(
        (vehicule) -> {
          Point vehiculePoint = vehicule.getPoint();
          if (vehicule.isSelected()) {
            g.setColor(new Color(255, 0, 0));
            int offsetRadius = radius + 2;
            g.fillOval(
                (int) vehiculePoint.getX() - offsetRadius,
                (int) vehiculePoint.getY() - offsetRadius,
                offsetRadius * 2,
                offsetRadius * 2);
          }
          Color vehiculeColor = vehicule.getColor();
          g.setColor(vehiculeColor);
          g.fillOval(
              (int) vehiculePoint.getX() - radius,
              (int) vehiculePoint.getY() - radius,
              radius * 2,
              radius * 2);
        });
  }

  public void drawCarriere(Graphics g) {
    int width = (int) initialDimension.getWidth() / (int) drawingPanel.getZoom();
    int height = (int) initialDimension.getHeight() / (int) drawingPanel.getZoom();
    g.setColor(Color.ORANGE);
    g.fillRect(0, 0, width, height);
  }

  public void drawEquipement(Graphics g) {
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
          System.out.println(equipementColor);
          System.out.println(equipementPoint);
          g.setColor(equipementColor);
          g.fillOval(
              (int) equipementPoint.getX() - radius,
              (int) equipementPoint.getY() - radius,
              radius * 2,
              radius * 2);
        });
  }

  private Color getColor(Equipement equipement) {
    return equipementColor.get(equipement.getClass().getName());
  }

  public void drawNoeud(Graphics g) {
    List<Noeud> noeuds = controller.getNoeudList();
    noeuds.forEach(
        (noeud) -> {
          Point noeudPoint = noeud.getPoint();
          if (noeud.isSelected()) {
            g.setColor(new Color(255, 0, 0));
            int offsetRadius = radius / 2 + 2;
            g.fillOval(
                (int) noeud.getX() - offsetRadius,
                (int) noeud.getY() - offsetRadius,
                offsetRadius * 2,
                offsetRadius * 2);
          }
          Color noeudColor = noeud.getColor();
          g.setColor(noeudColor);
          g.fillOval(
              (int) noeudPoint.getX() - radius / 2,
              (int) noeudPoint.getY() - radius / 2,
              radius,
              radius);
        });
  }

  public void drawEntree(Graphics g) {
    List<Entree> entrees = controller.getEntreeList();
    entrees.forEach(
        (entree) -> {
          Point entreePoint = entree.getPoint();
          if (entree.isSelected()) {
            g.setColor(new Color(255, 0, 0));
            int offsetRadius = radius + 2;
            g.fillRect(
                (int) entree.getX() - offsetRadius,
                (int) entree.getY() - offsetRadius,
                offsetRadius * 2,
                offsetRadius * 2);
          }
          Color entreeColor = entree.getColor();
          g.setColor(entreeColor);
          g.fillRect(
              (int) entreePoint.getX() - radius,
              (int) entreePoint.getY() - radius,
              radius * 2,
              radius * 2);
        });
  }

  public void drawArc(Graphics g) {
    List<Arc> arcs = controller.getArcList();
    arcs.forEach(
        (arc) -> {
          Noeud startingNoeud = arc.getStarting();
          Noeud arrivalNoeud = arc.getArrival();
          Color arcColor = arc.getColor();

          g.setColor(arcColor);
          g.drawLine(
              (int) startingNoeud.getX(),
              (int) startingNoeud.getY(),
              (int) arrivalNoeud.getX(),
              (int) arrivalNoeud.getY());
        });
  }

  public void setMeasurementUnitMode(MainWindow.MeasurementUnitMode measurementMode) {
    this.measurementMode = measurementMode;
  }
}
