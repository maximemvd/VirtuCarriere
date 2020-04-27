/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package virtucarriere.gui;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.io.IOException;
import java.io.Serializable;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;
import virtucarriere.Domaine.Drawing.CarriereDrawer;

/** @author maximemivilledeschenes */
public class DrawingPanel extends JPanel implements Serializable {

  public Dimension initialDimension;
  private MainWindow mainWindow;

  private CarriereDrawer carriereDrawer;

  public Graphics graphics;

  private double mouseX;
  private double mouseY;

  private boolean grilleActivee = false;
  private double zoom = 1d;

  private double gapGrille = 150d;
  final double ZoomFactor = 1.03;

  public DrawingPanel() {}

  public DrawingPanel(MainWindow mainWindow) {
    this.mainWindow = mainWindow;
    setBorder(new javax.swing.border.BevelBorder(BevelBorder.LOWERED));
    int width = mainWindow.getMainScrollPaneDimension().width;
    int height = mainWindow.getMainScrollPaneDimension().height;
    setPreferredSize(new Dimension(width, height));
    setVisible(true);
    this.initialDimension = new Dimension(1700, 1200);
  }

  @Override
  protected void paintComponent(Graphics g) {

    if (mainWindow != null) {

      super.paintComponent(g);
      graphics = g;
      carriereDrawer = new CarriereDrawer(mainWindow.controller, initialDimension);
      Graphics2D g2d = (Graphics2D) g;

      try {
        carriereDrawer.draw(g2d, zoom);
      } catch (IOException e) {
        e.printStackTrace();
      }

      if (grilleActivee) {

        g2d.scale(zoom, zoom);
        g2d.setPaint(Color.LIGHT_GRAY);
        g2d.setStroke(new BasicStroke(0.25f / (float) getZoom()));
        Dimension ajustingDimension = new Dimension(this.getWidth(), this.getHeight());
        if (zoom >= 1) {
          for (int row = 1; row <= ajustingDimension.getHeight() / this.gapGrille; row++) {
            g2d.drawLine(
                0,
                (int) (row * this.gapGrille),
                (int) ajustingDimension.getWidth(),
                (int) (row * this.gapGrille));
          }

          for (int col = 1; col <= (int) ajustingDimension.getWidth() / this.gapGrille; col++) {
            g2d.drawLine(
                (int) (col * this.gapGrille),
                0,
                (int) (col * this.gapGrille),
                (int) ajustingDimension.getHeight());
          }
        } else if (zoom < 1) {
          for (int row = 1;
              row <= (int) ajustingDimension.getHeight() / this.gapGrille / (zoom);
              row++) {
            g2d.drawLine(
                0,
                (int) (row * this.gapGrille),
                (int) (ajustingDimension.getWidth() / zoom),
                (int) (row * this.gapGrille));
          }

          for (int col = 1;
              col <= ((int) ajustingDimension.getWidth() / this.gapGrille) / (zoom);
              col++) {
            g2d.drawLine(
                (int) ((col) * this.gapGrille),
                0,
                (int) ((col) * this.gapGrille),
                (int) (ajustingDimension.getHeight() / zoom));
          }
        }
        g2d.scale(1 / zoom, 1 / zoom);
      }
    // draw mouse coordinates
    g.setColor(Color.black);
    String s = " \n " + " " + (int) (mouseX / zoom) + ", " + (int) (mouseY / zoom);
    g.drawString(s, (int) mouseX, (int) mouseY);
    }
  }

  public void setMouseX(double x) {
    this.mouseX = x;
  }

  public void setMouseY(double y) {
    this.mouseY = y;
  }

  public double getZoom() {
    return this.zoom;
  }

  public void setZoom(double zoom) {
    this.zoom = zoom;
  }

  public MainWindow getMainWindow() {
    return this.mainWindow;
  }

  public void setMainWindow(MainWindow mainWindow) {
    this.mainWindow = mainWindow;
  }

  public Dimension getInitialDimension() {
    return initialDimension;
  }

  public void setGridLines() {
    initialDimension = mainWindow.getMainScrollPaneDimension();
    grilleActivee = !grilleActivee;
    repaint();
  }

  public double getGapGrille() {
    return this.gapGrille;
  }

  // zoom inspiré de
  // https://stackoverflow.com/questions/13155382/jscrollpane-zoom-relative-to-mouse-position

  public void zoomIn(Point point) {
    this.setZoom(getZoom() * ZoomFactor);
    Point pos = mainWindow.getMainScrollPane().getViewport().getViewPosition();

    int newX = (int) (point.x * (1.1f - 1f) + ZoomFactor * pos.x);
    int newY = (int) (point.y * (1.1f - 1f) + ZoomFactor * pos.y);
    Point newPoint = new Point(newX, newY);
    //setMouseX(newX);
    //setMouseY(newY);
    mainWindow.getMainScrollPane().getViewport().setViewPosition(newPoint);
    setDrawingPanelDimensions();
    revalidate();
    repaint();
  }

  public void zoomOut(Point point) {
    this.setZoom(getZoom() / ZoomFactor);
    Point pos = mainWindow.getMainScrollPane().getViewport().getViewPosition();

    int newX = (int) (point.x * (0.9f - 1f) + pos.x / ZoomFactor);
    int newY = (int) (point.y * (0.9f - 1f) + pos.y / ZoomFactor);

    Point newPoint = new Point(newX, newY);
    mainWindow.getMainScrollPane().getViewport().setViewPosition(newPoint);
   // setMouseX(newX);
    //setMouseY(newY);
   // mainWindow.setMainScrollPanePosition(newPoint);
    setDrawingPanelDimensions();

    revalidate();
    repaint();
  }

  public void setDrawingPanelDimensions() {
    Dimension dimension =
        new Dimension((int) initialDimension.getWidth(), (int) initialDimension.getHeight());
    this.setPreferredSize(
        new Dimension((int) (dimension.getWidth() * zoom), (int) (dimension.getHeight() * zoom)));
    revalidate();
  }

  public void setGapGrille(double newGapGrille) {
    this.gapGrille = newGapGrille;
  }

  public boolean getGridlines() {
    return this.grilleActivee;
  }
}
