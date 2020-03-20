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
import java.io.Serializable;
import javax.swing.JPanel;
        

/**
 *
 * @author maximemivilledeschenes
 */
public class DrawingPanel extends JPanel implements Serializable{
    
    public Dimension initialDimension;
    private MainWindow mainWindow;
    
    private Boolean grilleActivee = false;
    private double zoom = 1d;
    
    private double gapGrille = 100d;


    
    public DrawingPanel(){
    }
    
    public DrawingPanel(MainWindow mainWindow){
        this.mainWindow = mainWindow;
        
        int width = mainWindow.getMainScrollPaneDimension().width;
        int height = mainWindow.getMainScrollPaneDimension().height;
        
        setPreferredSize(new Dimension(width,height));
        setVisible(true);
        this.initialDimension = new Dimension(width,height);
        setBackground(Color.WHITE);
    
    }
    
    @Override
    protected void paintComponent(Graphics g){
        
        if (mainWindow != null) {
            
            super.paintComponent(g);
            Graphics2D g2d = (Graphics2D) g;
            
            
            if (grilleActivee == true){
                
                g2d.scale(zoom, zoom);
                g2d.setPaint(Color.LIGHT_GRAY);
                g2d.setStroke(new BasicStroke(0.25f / (float)getZoom()));
                Dimension ajustingDimension = new Dimension(this.getWidth(), this.getHeight());
                if (zoom >= 1) {
                    for (int row = 1; row <= ajustingDimension.getHeight() / this.gapGrille; row++) {
                        g2d.drawLine(0, (int) (row * this.gapGrille), (int)ajustingDimension.getWidth(), (int) (row * this.gapGrille));
                    }
                    for (int col = 1; col <= (int)ajustingDimension.getWidth() / this.gapGrille; col++) {
                        g2d.drawLine((int) (col * this.gapGrille), 0, (int) (col * this.gapGrille), (int)ajustingDimension.getHeight());
                    }
                }
                else if (zoom < 1) {
                    for (int row = 1; row <= (int)ajustingDimension.getHeight()/ this.gapGrille / (zoom) ; row++) {
                        g2d.drawLine(0, (int) (row * this.gapGrille), (int)(ajustingDimension.getWidth() / zoom), (int) (row * this.gapGrille));
                    }
                    
                    for (int col = 1; col <= ((int)ajustingDimension.getWidth() / this.gapGrille) / (zoom); col++) {
                        g2d.drawLine((int) ((col) * this.gapGrille), 0, (int) ((col) * this.gapGrille), (int)(ajustingDimension.getHeight() / zoom));
                    }
                }
                g2d.scale(1/zoom, 1/zoom);
            }
            mainWindow.draw(g2d, this, zoom);
        }
                
     }
    
    
    public double getZoom() {
        return this.zoom;
    }
    
    public void setZoom(double zoom) {
        this.zoom = zoom;
    }
    
    public void setGridLines() {
        initialDimension = mainWindow.getMainScrollPaneDimension();
        this.grilleActivee = !grilleActivee;
        this.repaint();
    }
    
    public double getGapGrille() {
        return gapGrille;
    }
            
   }
        
    
 