/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package virtucarriere.Domaine.Drawing;
import java.awt.*;
import java.util.ArrayList;
import java.awt.Graphics;
import java.awt.Point;
import virtucarriere.Domaine.Controller.Controller;
import virtucarriere.Domaine.Controller.ElementContainer;
import virtucarriere.Domaine.Carriere.Plan.Element;
import virtucarriere.gui.MainWindow;

public class CarriereDrawer {

    private Controller controller;
    private double zoom;

    public CarriereDrawer(Controller controller)
    {
        this.controller = controller;
    }


    public void draw(Graphics2D g, ArrayList<Element> elementList, double zoom, Point currentMousePoint)
    {
        drawCarriere(g, elementList, zoom, currentMousePoint);
    }


    public void drawCarriere(Graphics2D g, ArrayList<Element>  elementContainer, double zoom, Point mousePoint)
    {
        System.out.println("ici qu'on draw toutes les items");
        System.out.println(g);
        System.out.println(elementContainer);
        System.out.println(zoom);
        System.out.println(mousePoint);
    }

    public void setMeasurementUnitMode(MeasurementUnitMode measurementMode)
    {
        this.measurementMode = measurementMode;
    }

// zoom inspiré de https://stackoverflow.com/questions/13155382/jscrollpane-zoom-relative-to-mouse-position
    public void zoomOut(Point point) {
        this.imagePanel.setZoom(this.imagePanel.getZoom() * 0.9f);
        Point pos = this.getViewport().getViewPosition();

        int newX = (int)(point.x*(0.9f - 1f) + 0.9f*pos.x);
        int newY = (int)(point.y*(0.9f - 1f) + 0.9f*pos.y);
        this.getViewport().setViewPosition(new Point(newX, newY));

        this.imagePanel.revalidate();
        this.imagePanel.repaint();
    }

    public void zoomIn(Point point) {
        this.imagePanel.setZoom(this.imagePanel.getZoom() * 1.1f);
        Point pos = this.getViewport().getViewPosition();

        int newX = (int)(point.x*(1.1f - 1f) + 1.1f*pos.x);
        int newY = (int)(point.y*(1.1f - 1f) + 1.1f*pos.y);
        this.getViewport().setViewPosition(new Point(newX, newY));

        this.imagePanel.revalidate();
        this.imagePanel.repaint();
    }
    
}
