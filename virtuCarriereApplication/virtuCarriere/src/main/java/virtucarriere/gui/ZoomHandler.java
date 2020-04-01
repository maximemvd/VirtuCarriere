/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package virtucarriere.gui;

import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import java.awt.geom.Point2D;

/** @author maximemivilledeschenes */
public class ZoomHandler implements MouseWheelListener {
  double scale = 1.0;

  public void mouseWheelMoved(MouseWheelEvent e) {
    if (e.getScrollType() == MouseWheelEvent.WHEEL_UNIT_SCROLL) {

      Point2D p1 = e.getPoint();
      Point2D p2 = null;
    }
  }
}
