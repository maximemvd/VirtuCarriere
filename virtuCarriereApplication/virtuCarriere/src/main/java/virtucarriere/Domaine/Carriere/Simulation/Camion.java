/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package virtucarriere.Domaine.Carriere.Simulation;

import java.awt.Color;
import java.awt.Point;
import java.util.ArrayList;

public class Camion extends Vehicule {

  ArrayList<Node> itineraireCamion;

  private double start;

  private Color color;

  private Jeton jeton;

  private Point point;

  public Camion(Jeton jeton, double start, Point point) {
    super(point);
    this.itineraireCamion = new ArrayList<Node>();
    this.jeton = jeton;
    this.start = start;

    this.color = Color.MAGENTA;
    // createCamion(jeton, start, coordonnees);
  }

  public Camion createCamion(Jeton jeton, double start, Point point) {
    Camion newCamion = new Camion(jeton, start, point);
    return newCamion;
  };

  @Override
  public Color getColor() {
    return color;
  }

  public ArrayList<Node> getItineaireList() {
    return itineraireCamion;
  }

  public void addDestination(Node p_node) {
    itineraireCamion.add(p_node);
  };

  public void removeDestination(Node p_node) {
    try {
      itineraireCamion.remove(p_node);
    } catch (Exception e) {
      System.out.println(e);
    }
  }

  public void editerParams(Jeton jeton, double start, Point point) {
    this.jeton = jeton;
    this.start = start;
    this.point = point;
  }

  public void Simulation() {
    for (Node i : this.itineraireCamion) {
      System.out.println(i);
      // call getShortestPath
    }
  }
}
