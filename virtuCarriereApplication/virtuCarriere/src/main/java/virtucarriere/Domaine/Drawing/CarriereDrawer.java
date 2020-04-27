/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package virtucarriere.Domaine.Drawing;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import virtucarriere.Domaine.AffichageUtil.UnitConverter;
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
    try {
      imageCamion = ImageIO.read(ClassLoader.getSystemResourceAsStream("images/camion.png"));
      imageCamion = ImageIO.read(ClassLoader.getSystemResourceAsStream("images/camion.png"));
      imageCamionSelected =
          ImageIO.read(ClassLoader.getSystemResourceAsStream("images/camionSelected.png"));
      imageChargeur = ImageIO.read(ClassLoader.getSystemResourceAsStream("images/chargeur.png"));
      imageChargeurSelected =
          ImageIO.read(ClassLoader.getSystemResourceAsStream("images/chargeurSelected.png"));
      imageBroyeur = ImageIO.read(ClassLoader.getSystemResourceAsStream("images/broyeur.png"));
      imageBroyeurSelected =
          ImageIO.read(ClassLoader.getSystemResourceAsStream("images/broyeurSelected.png"));
      imageConcasseur =
          ImageIO.read(ClassLoader.getSystemResourceAsStream("images/concasseur.png"));
      imageConcasseurSelected =
          ImageIO.read(ClassLoader.getSystemResourceAsStream("images/concasseurSelected.png"));
      imageCrible = ImageIO.read(ClassLoader.getSystemResourceAsStream("images/crible.png"));
      imageCribleSelected =
          ImageIO.read(ClassLoader.getSystemResourceAsStream("images/cribleSelected.png"));
    } catch (IOException e) {
      throw new RuntimeException("Probleme avec les images");
    }
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
      g2d.drawImage(
          bg, 0, 0, UnitConverter.getLargeurImage(), UnitConverter.getLongueurImage(), null);
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

  public void drawChargeur(Graphics2D g2d, double zoom) throws IOException {
    g2d.scale(zoom, zoom);
    List<Chargeur> chargeurs = controller.getChargeurList();
    chargeurs.forEach(
        (chargeur) -> {
          Point vehiculePoint = chargeur.getPoint();
          if (chargeur.isSelected()) {
            g2d.drawImage(
                imageChargeurSelected,
                (int) vehiculePoint.getX() - 22,
                (int) vehiculePoint.getY() - 19,
                50,
                35,
                null);

          } else {

            g2d.drawImage(
                imageChargeur,
                (int) vehiculePoint.getX() - 22,
                (int) vehiculePoint.getY() - 19,
                50,
                35,
                null);
          }
        });
    g2d.scale(1 / zoom, 1 / zoom);
  }

  // draw Camion is good
  public void drawCamion(Graphics2D g2d, double zoom) {

    g2d.scale(zoom, zoom);
    List<Camion> camions = controller.getCamionList();
    for (Camion camion : camions) {
      Point pointEntree = camion.getPoint();
      int camionPointX = pointEntree.x;
      int camionPointY = pointEntree.y;
      double angle = camion.getAngle();
      double angleRad = Math.toRadians(angle);
      if (camion.isSelected()) {
        imageCamionSelected = rotate(imageCamionSelected, angleRad);
        g2d.drawImage(imageCamionSelected, (camionPointX - 26), camionPointY - 25, 60, 45, null);

      } else {
        imageCamion = rotate(imageCamion, angleRad);
        g2d.drawImage(imageCamion, (camionPointX - 26), camionPointY - 25, 60, 45, null);
      }
    }
    g2d.scale(1 / zoom, 1 / zoom);
  }

  // Code inspiré de https://stackoverflow.com/questions/4156518/rotate-an-image-in-java
  public static BufferedImage rotate(BufferedImage image, double angle) {
    double sin = Math.abs(Math.sin(angle)), cos = Math.abs(Math.cos(angle));
    int w = image.getWidth(), h = image.getHeight();
    int neww = (int) Math.floor(w * cos + h * sin), newh = (int) Math.floor(h * cos + w * sin);
    GraphicsConfiguration gc = getDefaultConfiguration();
    BufferedImage result = gc.createCompatibleImage(neww, newh, Transparency.TRANSLUCENT);
    Graphics2D g = result.createGraphics();
    g.translate((neww - w) / 2, (newh - h) / 2);
    g.rotate(angle, w / 2.0, h / 2.0);
    g.drawRenderedImage(image, null);
    g.dispose();
    return result;
  }

  private static GraphicsConfiguration getDefaultConfiguration() {
    GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
    GraphicsDevice gd = ge.getDefaultScreenDevice();
    return gd.getDefaultConfiguration();
  }

  public void drawEquipement(Graphics2D g, double zoom) {

    g.scale(zoom, zoom);
    List<Equipement> equipements = controller.getEquipementList();
    equipements.forEach(
        (equipement) -> {
          if (equipement.getName().equals("Tas")) {
            Tas tas = (Tas) equipement;
            Point equipementPoint = equipement.getPoint();
            if (equipement.isSelected()) {
              g.setColor(new Color(255, 0, 0));
              int offsetRadius = tas.getDimension() + 2;
              g.fillOval(
                  (int) tas.getX() - offsetRadius,
                  (int) tas.getY() - offsetRadius,
                  offsetRadius * 2,
                  offsetRadius * 2);
            }
            Color equipementColor = getColor(equipement);
            g.setColor(equipementColor);
            g.fillOval(
                (int) equipementPoint.getX() - tas.getDimension(),
                (int) equipementPoint.getY() - tas.getDimension(),
                tas.getDimension() * 2,
                tas.getDimension() * 2);
          } else if (equipement.getName().equals("Broyeur")) {
            Point equipementPoint = equipement.getPoint();
            double angle = equipement.getAngle();
            double angleRad = Math.toRadians(angle);
            if (equipement.isSelected()) {
              imageBroyeurSelected = rotate(imageBroyeurSelected, angleRad);
              g.drawImage(
                  imageBroyeurSelected,
                  (int) (equipementPoint.getX() - 20),
                  (int) equipementPoint.getY() - 28,
                  60,
                  45,
                  null);

            } else {
              imageBroyeur = rotate(imageBroyeur, angleRad);
              g.drawImage(
                  imageBroyeur,
                  (int) (equipementPoint.getX() - 20),
                  (int) equipementPoint.getY() - 28,
                  60,
                  45,
                  null);
            }

          } else if (equipement.getName().equals("Concasseur")) {
            Point equipementPoint = equipement.getPoint();
            double angle = equipement.getAngle();
            double angleRad = Math.toRadians(angle);
            if (equipement.isSelected()) {
              imageConcasseurSelected = rotate(imageConcasseurSelected, angleRad);
              g.drawImage(
                  imageConcasseurSelected,
                  (int) (equipementPoint.getX() - 60),
                  (int) equipementPoint.getY() - 50,
                  130,
                  100,
                  null);

            } else {
              imageConcasseur = rotate(imageConcasseur, angleRad);
              g.drawImage(
                  imageConcasseur,
                  (int) (equipementPoint.getX() - 60),
                  (int) equipementPoint.getY() - 50,
                  130,
                  100,
                  null);
            }
          } else if (equipement.getName().equals("Crible")) {
            Point equipementPoint = equipement.getPoint();
            double angle = equipement.getAngle();
            double angleRad = Math.toRadians(angle);

            if (equipement.isSelected()) {
              imageCribleSelected = rotate(imageCribleSelected, angleRad);
              g.drawImage(
                  imageCribleSelected,
                  (int) (equipementPoint.getX() - 35),
                  (int) equipementPoint.getY() - 28,
                  70,
                  55,
                  null);

            } else {
              imageCrible = rotate(imageCrible, angleRad);
              g.drawImage(
                  imageCrible,
                  (int) (equipementPoint.getX() - 35),
                  (int) equipementPoint.getY() - 28,
                  70,
                  55,
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
    if (entrees != null) {
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
