/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package virtucarriere.Domaine.Carriere.Simulation;

import java.awt.Color;
import java.awt.Point;
import java.util.List;
import virtucarriere.Domaine.Carriere.Plan.Noeud;

public abstract class Vehicule {

  private Color color;

  private Itineraire route;

  public Vehicule() {};

  public void getShortestPath(Jeton jeton) {
    List<Noeud> start;
    List<Noeud> result;
  }

  public Itineraire getRoute() {
    return route;
  }

  public abstract Point getPoint();

  public Color getColor() {
    return Color.MAGENTA;
  }
}
