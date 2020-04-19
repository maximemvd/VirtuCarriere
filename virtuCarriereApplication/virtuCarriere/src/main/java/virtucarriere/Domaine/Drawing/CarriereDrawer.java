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
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import virtucarriere.Domaine.Carriere.Plan.*;
import virtucarriere.Domaine.Carriere.Simulation.Camion;
import virtucarriere.Domaine.Carriere.Simulation.Chargeur;
import virtucarriere.Domaine.Controller.Controller;

public class CarriereDrawer {

  private final Controller controller;
  private Dimension initialDimension;
  private BufferedImage imageCamion;
  private BufferedImage imageCamionSelected;
  private BufferedImage imageChargeur;
  private BufferedImage imageChargeurSelected;
  private BufferedImage imageBroyeur;
  private BufferedImage imageBroyeurSelected;
  private BufferedImage imageConcasseur;
  private BufferedImage imageConcasseurSelected;
  private BufferedImage imageCrible;
  private BufferedImage imageCribleSelected;

  private int radius = 25;
  private HashMap<String, Color> equipementColor = new HashMap<>();

  public CarriereDrawer(Controller controller, Dimension initialDimension) {
    this.controller = controller;
    this.initialDimension = initialDimension;
    equipementColor.put(Broyeur.class.getName(), Color.GREEN);
    equipementColor.put(Concasseur.class.getName(), Color.PINK);
    equipementColor.put(Crible.class.getName(), Color.RED);
    equipementColor.put(Tas.class.getName(), Color.DARK_GRAY);
  }

  public void draw(Graphics2D g2d, double zoom) throws IOException {
    if (controller.getUrlBackground() != null) {
      drawImage(g2d, zoom);
    }
    drawEquipement(g2d, zoom);
    drawNoeud(g2d, zoom);
    drawEntree(g2d, zoom);
    drawArc(g2d, zoom);
    drawConvoyeur(g2d, zoom);
    drawCamion(g2d, zoom);
    drawChargeur(g2d, zoom);
    drawPointChargement(g2d, zoom);
  }

  public void drawImage(Graphics2D g2d, double zoom) {
    try {
      g2d.scale(zoom, zoom);
      final BufferedImage bg = ImageIO.read(controller.getUrlBackground());
      g2d.drawImage(bg, 0, 0, 1700, 1200, null);
      g2d.scale(1 / zoom, 1 / zoom);
    } catch (MalformedURLException ex) {
      Logger.getLogger(CarriereDrawer.class.getName()).log(Level.SEVERE, null, ex);
    } catch (IOException ex) {
      Logger.getLogger(CarriereDrawer.class.getName()).log(Level.SEVERE, null, ex);
    }
  }

  public void drawPointChargement(Graphics2D g2d, double zoom) {
    g2d.scale(zoom, zoom);
    List<Equipement> equipements = controller.getEquipementList();

    List<PointChargement> listePointChargement = new LinkedList<>();

    for (Equipement equipement : equipements) {
      if (equipement.getName().equals("Tas")) {
        Tas tas = (Tas) equipement;
        listePointChargement.add(tas.getPointChargement());
      }
    }

    g2d.scale(1 / zoom, 1 / zoom);
  }

  // drawChargeur is good
  public void drawChargeur(Graphics2D g2d, double zoom) throws IOException {

    try {
      imageChargeur = ImageIO.read(new File("ressources/images/chargeur.png"));
      imageChargeurSelected = ImageIO.read(new File("ressources/images/chargeurSelected.png"));

    } catch (IOException e) {
    }

    g2d.scale(zoom, zoom);
    List<Chargeur> chargeurs = controller.getChargeurList();
    chargeurs.forEach(
        (chargeur) -> {
          Point vehiculePoint = chargeur.getPoint();
          if (chargeur.isSelected()) {
            g2d.drawImage(
                imageChargeurSelected,
                (int) vehiculePoint.getX() - 50,
                (int) vehiculePoint.getY() - 33,
                100,
                65,
                null);

          } else {

            g2d.drawImage(
                imageChargeur,
                (int) vehiculePoint.getX() - 50,
                (int) vehiculePoint.getY() - 33,
                100,
                65,
                null);
          }
        });
    g2d.scale(1 / zoom, 1 / zoom);
  }

  // draw Camion is good
  public void drawCamion(Graphics2D g2d, double zoom) {
    try {
      imageCamion = ImageIO.read(new File("ressources/images/camion.png"));
      imageCamionSelected = ImageIO.read(new File("ressources/images/camionSelected.png"));
    } catch (IOException e) {
    }

    g2d.scale(zoom, zoom);
    List<Camion> camions = controller.getCamionList();
    int numberOfCLient = camions.size();
    for (Camion camion : camions) {
      Point pointEntree = camion.getPoint();
      int camionPointX = pointEntree.x;
      int camionPointY = pointEntree.y;
      if (camion.isSelected()) {
        g2d.drawImage(imageCamionSelected, (camionPointX - 50), camionPointY - 33, 100, 65, null);

      } else {
        g2d.drawImage(imageCamion, (camionPointX - 50), camionPointY - 33, 100, 65, null);
        /*
        Color couleurCamion = Color.YELLOW;
        g2d.setColor(couleurCamion);
        g2d.fillRoundRect(
            camionPointX - radius, camionPointY - radius, radius * 2, radius * 2, radius, radius);

         */
      }
    }
    g2d.scale(1 / zoom, 1 / zoom);
  }

  public void drawEquipement(Graphics2D g, double zoom) {
    try {
      imageBroyeur = ImageIO.read(new File("ressources/images/broyeur.png"));
      imageBroyeurSelected = ImageIO.read(new File("ressources/images/broyeurSelected.png"));
      imageConcasseur = ImageIO.read(new File("ressources/images/concasseur.png"));
      imageConcasseurSelected = ImageIO.read(new File("ressources/images/concasseurSelected.png"));
      imageCrible = ImageIO.read(new File("ressources/images/crible.png"));
      imageCribleSelected = ImageIO.read(new File("ressources/images/cribleSelected.png"));
    } catch (IOException e) {
    }

    g.scale(zoom, zoom);
    List<Equipement> equipements = controller.getEquipementList();
    equipements.forEach(
        (equipement) -> {
          if (equipement.getName().equals("Tas")) {
            Point equipementPoint = equipement.getPoint();
            if (equipement.isSelected()) {
              g.setColor(new Color(255, 0, 0));
              int offsetRadius = equipement.getDimension() + 2;
              g.fillOval(
                  (int) equipementPoint.getX() - offsetRadius,
                  (int) equipementPoint.getY() - offsetRadius,
                  offsetRadius * 2,
                  offsetRadius * 2);
            }
            Color equipementColor = getColor(equipement);
            g.setColor(equipementColor);
            g.fillOval(
                (int) equipementPoint.getX() - equipement.getDimension(),
                (int) equipementPoint.getY() - equipement.getDimension(),
                equipement.getDimension() * 2,
                equipement.getDimension() * 2);
          } else if (equipement.getName().equals("Broyeur")) {
            Point equipementPoint = equipement.getPoint();

            if (equipement.isSelected()) {
              g.drawImage(
                  imageBroyeurSelected,
                  (int) (equipementPoint.getX() - 50),
                  (int) equipementPoint.getY() - 33,
                  100,
                  65,
                  null);

            } else {

              g.drawImage(
                  imageBroyeur,
                  (int) (equipementPoint.getX() - 50),
                  (int) equipementPoint.getY() - 33,
                  100,
                  65,
                  null);
            }

          } else if (equipement.getName().equals("Concasseur")) {
            Point equipementPoint = equipement.getPoint();

            if (equipement.isSelected()) {
              g.drawImage(
                  imageConcasseurSelected,
                  (int) (equipementPoint.getX() - 50),
                  (int) equipementPoint.getY() - 33,
                  100,
                  65,
                  null);

            } else {
              g.drawImage(
                  imageConcasseur,
                  (int) (equipementPoint.getX() - 50),
                  (int) equipementPoint.getY() - 33,
                  100,
                  65,
                  null);
            }
          } else if (equipement.getName().equals("Crible")) {
            Point equipementPoint = equipement.getPoint();

            if (equipement.isSelected()) {
              g.drawImage(
                  imageCribleSelected,
                  (int) (equipementPoint.getX() - 50),
                  (int) equipementPoint.getY() - 33,
                  100,
                  65,
                  null);

            } else {
              g.drawImage(
                  imageCrible,
                  (int) (equipementPoint.getX() - 50),
                  (int) equipementPoint.getY() - 33,
                  100,
                  65,
                  null);
            }
          } else {
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
          }
        });
    g.scale(1 / zoom, 1 / zoom);
  }

  private Color getColor(Equipement equipement) {
    return equipementColor.get(equipement.getClass().getName());
  }

  public void drawNoeud(Graphics2D g2d, double zoom) {
    g2d.scale(zoom, zoom);
    List<AbstractPointChemin> noeuds = controller.getNoeudList();
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

    Entree entrees = controller.getEntree();
    Point entreePoint = entrees.getPoint();
    if (entrees.isSelected()) {
      g2d.setColor(new Color(255, 0, 0));
      int offsetRadius = radius + 2;
      g2d.fillRect(
          (int) entrees.getPoint().x - offsetRadius,
          (int) entrees.getPoint().y - offsetRadius,
          offsetRadius * 2,
          offsetRadius * 2);
    }
    Color entreeColor = entrees.getColor();
    g2d.setColor(entreeColor);
    g2d.fillRect(
        (int) entreePoint.getX() - radius,
        (int) entreePoint.getY() - radius,
        radius * 2,
        radius * 2);

    g2d.scale(1 / zoom, 1 / zoom);
  }

  public void drawArc(Graphics2D g2d, double zoom) {
    g2d.scale(zoom, zoom);
    ArrayList<List<Arc>> arcs = controller.getArcList();
    arcs.forEach(
        (arcc) -> {
          arcc.forEach(
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
        });
    g2d.scale(1 / zoom, 1 / zoom);
  }

  public void drawConvoyeur(Graphics2D g2d, double zoom) {
    g2d.scale(zoom, zoom);
    ArrayList<List<Convoyeur>> convoyeurs = controller.getConvoyeurList();
    convoyeurs.forEach(
        (convoyeur) -> {
          convoyeur.forEach(
              (conv) -> {
                if (conv.isSelected()) {
                  g2d.setColor(new Color(255, 0, 0));
                  g2d.setStroke(new BasicStroke(7));
                  g2d.drawLine(
                      (int) conv.getStarting().getX(),
                      (int) conv.getStarting().getY(),
                      (int) conv.getArrival().getX(),
                      (int) conv.getArrival().getY());
                }
                Color convColor = conv.getColor();
                g2d.setColor(convColor);
                g2d.setStroke(new BasicStroke(5));
                g2d.drawLine(
                    (int) conv.getStarting().getX(),
                    (int) conv.getStarting().getY(),
                    (int) conv.getArrival().getX(),
                    (int) conv.getArrival().getY());
              });
        });
    g2d.scale(1 / zoom, 1 / zoom);
  }
}
