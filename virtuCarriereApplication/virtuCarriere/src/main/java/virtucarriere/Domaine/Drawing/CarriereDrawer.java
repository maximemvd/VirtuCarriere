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

    private final Controller controller;
    private double zoom;
    private Dimension initialDimension;
    private MainWindow.MeasurementUnitMode measurementMode;

    public CarriereDrawer(Controller controller) {
        this.controller = controller;
    }

    public void draw(Graphics2D g, ArrayList<ElementContainer> elementList, double zoom, Point currentMousePoint) {
        drawCarriere(g, elementList, zoom, currentMousePoint);
    }

    public void drawCarriere(Graphics2D g, ArrayList<ElementContainer> elementContainer, double zoom,
            Point mousePoint) {
        System.out.println("ici qu'on draw toutes les items");
        System.out.println(g);
        System.out.println(elementContainer);
        System.out.println(zoom);
        System.out.println(mousePoint);
    }

    public void setMeasurementUnitMode(MainWindow.MeasurementUnitMode measurementMode) {

        this.measurementMode = measurementMode;
    }

}
