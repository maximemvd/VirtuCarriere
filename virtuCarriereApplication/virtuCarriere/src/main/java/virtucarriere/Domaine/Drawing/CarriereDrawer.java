/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package virtucarriere.Domaine.Drawing;
import javax.swing.*;
import java.awt.*;
import java.awt.geom.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.awt.Graphics;

public class CarriereDrawer {


    public CarriereDrawer(Controller controller) {
        this.controller = controller;
    }

    public void drawCarriere(Graphics g, ElementContainer elementContainer, double zoom, MousePoint mousePoint);



// zoom inspiré de https://stackoverflow.com/questions/13155382/jscrollpane-zoom-relative-to-mouse-position
    public void zoomOut(Coordoonees point) {
        this.imagePanel.setZoom(this.imagePanel.getZoom() * 0.9f);
        Point pos = this.getViewport().getViewPosition();

        int newX = (int)(point.x*(0.9f - 1f) + 0.9f*pos.x);
        int newY = (int)(point.y*(0.9f - 1f) + 0.9f*pos.y);
        this.getViewport().setViewPosition(new Point(newX, newY));

        this.imagePanel.revalidate();
        this.imagePanel.repaint();
    }

    public void zoomIn(Coordoones point) {
        this.imagePanel.setZoom(this.imagePanel.getZoom() * 1.1f);
        Point pos = this.getViewport().getViewPosition();

        int newX = (int)(point.x*(1.1f - 1f) + 1.1f*pos.x);
        int newY = (int)(point.y*(1.1f - 1f) + 1.1f*pos.y);
        this.getViewport().setViewPosition(new Point(newX, newY));

        this.imagePanel.revalidate();
        this.imagePanel.repaint();
    }
    
}
