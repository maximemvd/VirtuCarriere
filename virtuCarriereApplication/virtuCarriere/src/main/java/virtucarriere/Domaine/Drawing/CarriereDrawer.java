/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package virtucarriere.Domaine.Drawing;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import virtucarriere.Domaine.Controller.Controller;
import virtucarriere.Domaine.Controller.Controller.ElementModes;
import virtucarriere.Domaine.Controller.ElementContainer;
import virtucarriere.Domaine.Carriere.Plan.Element;
import virtucarriere.Domaine.Carriere.Simulation.Camion;
import virtucarriere.gui.MainWindow;
import java.awt.Dimension;
import java.util.List;

public class CarriereDrawer {

    private final  Controller controller;
   // private double zoom;
    private Dimension initialDimension;
    private MainWindow.MeasurementUnitMode measurementMode;
    
    private int radius = 50;

    public CarriereDrawer(Controller controller, Dimension initialDimension) {
        this.controller = controller;
        this.initialDimension = initialDimension;
    }

    public void draw(Graphics g) {
        drawCarriere(g);
        drawElement(g);
        drawCamion(g);
    }

    public void drawCarriere(Graphics g) 
    {
    int width = (int) initialDimension.getWidth();
    int height = (int) initialDimension.getHeight();
    g.setColor(new Color(140,98,57));
    g.fillRect(width/4, (int)(height/1.75), width/2, height/4);
    }
    
    public void drawElement(Graphics g)
    {
        List<Element> element = controller.getElementArrayList();
        element.forEach((elements) -> {
            Point elementPoint = elements.getPoint();
            Color color = elements.getColor();
            g.setColor(color);
            g.fillOval((int)elementPoint.getX()-radius,(int)elementPoint.getY()-radius, radius*2, radius*2);
        });
    }
    
    public void drawCamion(Graphics g)
    {
        List<Camion> camions = controller.getCamionArrayList();
            camions.forEach((camion) -> {
           // Point elementPoint = camion.getRoute();
            Color color = Color.YELLOW;
            g.setColor(color);
           // g.fillOval((int)elementPoint.getX()-radius,(int)elementPoint.getY()-radius, radius*2, radius*2);
        });
       
    }

    public void setMeasurementUnitMode(MainWindow.MeasurementUnitMode measurementMode) {

        this.measurementMode = measurementMode;
    }

}
