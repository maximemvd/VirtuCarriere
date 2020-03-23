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
import java.io.Serializable;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;
import virtucarriere.Domaine.Drawing.CarriereDrawer;
        

/**
 *
 * @author maximemivilledeschenes
 */
public class DrawingPanel extends JPanel implements Serializable{
    
    public Dimension initialDimension; // ok
    private MainWindow mainWindow; // ok
    private CarriereDrawer carriereDrawer;

    private boolean grilleActivee = false;
    private double zoom = 1d;
    
    private double gapGrille = 100d;
    final double ZoomFactor = 1.05;


    
    public DrawingPanel(){
    }
    
    public DrawingPanel(MainWindow mainWindow){
        this.mainWindow = mainWindow;
         setBorder(new javax.swing.border.BevelBorder(BevelBorder.LOWERED));
        int width = mainWindow.getMainScrollPaneDimension().width;
        int height = mainWindow.getMainScrollPaneDimension().height;
        
        setPreferredSize(new Dimension(width,1));
        setVisible(true);
        initialDimension = new Dimension(width,height);
        setBackground(Color.WHITE);
    
    }
    
    @Override
    protected void paintComponent(Graphics g){
        
        if (mainWindow != null) {
            
            super.paintComponent(g);
            //Graphics2D g2d = (Graphics2D) g;
            CarriereDrawer newCarriere = new CarriereDrawer(mainWindow.controller, initialDimension);
            newCarriere.draw(g);
        }
                
     }
    
    
    public double getZoom() {
        return this.zoom;
    }
    
    public void setZoom(double zoom) {
        this.zoom = zoom;
    }

    public MainWindow getMainWindow() {
        return mainWindow;
    }

    public void setMainWindow(MainWindow mainWindow) {
        this.mainWindow = mainWindow;
    }

    public Dimension getInitialDimension() {
        return initialDimension;
    }
    
    public void setGridLines() {
        initialDimension = mainWindow.getMainScrollPaneDimension();
        this.grilleActivee = !grilleActivee;
        this.repaint();
    }
    
    public double getGapGrille() {
        return this.gapGrille;
    }
    
    
    // zoom inspiré de https://stackoverflow.com/questions/13155382/jscrollpane-zoom-relative-to-mouse-position

    public void zoomIn(Point point) {
        this.setZoom(getZoom() * ZoomFactor);
        Point pos = mainWindow.getMainScrollPane().getViewport().getViewPosition();

        int newX = (int)(point.x*(1.1f - 1f) + ZoomFactor * pos.x);
        int newY = (int)(point.y*(1.1f - 1f) + ZoomFactor * pos.y);
        Point newPoint = new Point(newX, newY);
        mainWindow.setMainScrollPanePosition(newPoint);
        setDrawingPanelDimensions();

        revalidate();
        repaint();
    }
    
    public void zoomOut(Point point) {
        this.setZoom(getZoom() / ZoomFactor);
        Point pos = mainWindow.getMainScrollPane().getViewport().getViewPosition();

        int newX = (int)(point.x*(0.9f - 1f) + pos.x / ZoomFactor);
        int newY = (int)(point.y*(0.9f - 1f) + pos.y / ZoomFactor);
        Point newPoint = new Point(newX, newY);
        mainWindow.setMainScrollPanePosition(newPoint);
        setDrawingPanelDimensions();

        revalidate();
        repaint();
    }

    public void setDrawingPanelDimensions() {
        Dimension dimension = new Dimension((int)initialDimension.getWidth(), (int)initialDimension.getHeight());
        this.setPreferredSize(new Dimension((int)(dimension.getWidth() * zoom), (int)(dimension.getHeight() * zoom)));
        revalidate();
    }

    public void setGapGrille(double newGapGrille) {
        this.gapGrille = newGapGrille;
    }
    
    public boolean getGridlines() {
        return this.grilleActivee;
    }
    
   }

        
    
 