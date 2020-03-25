/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package virtucarriere.Domaine.Carriere.Simulation;

import java.util.ArrayList;
import virtucarriere.Domaine.Carriere.Plan.OutdatedCoordonnees;

public class Camion extends Vehicule {

  ArrayList<Node> itineraireCamion;

  private double start;

  private Jeton jeton;

  private OutdatedCoordonnees outdatedCoordonnees;

  public Camion() {};

  public Camion(Jeton jeton, double start, OutdatedCoordonnees outdatedCoordonnees) {
    this.itineraireCamion = new ArrayList<Node>();
    this.jeton = jeton;
    this.start = start;
    this.outdatedCoordonnees = outdatedCoordonnees;
    // createCamion(jeton, start, coordonnees);
  }

  public Camion createCamion(Jeton jeton, double start, OutdatedCoordonnees outdatedCoordonnees) {
    Camion newCamion = new Camion(jeton, start, outdatedCoordonnees);
    return newCamion;
  };

  public ArrayList<Node> getItineaireList() {
    return this.itineraireCamion;
  }

  public void addDestination(Node p_node) {
    this.itineraireCamion.add(p_node);
  };

  public void removeDestination(Node p_node) {
    try {
      this.itineraireCamion.remove(p_node);
    } catch (Exception e) {
      System.out.println(e);
    }
  }

  public void editerParams(Jeton jeton, double start, OutdatedCoordonnees outdatedCoordonnees) {
    this.jeton = jeton;
    this.start = start;
    this.outdatedCoordonnees = outdatedCoordonnees;
  }

  public void Simulation() {
    for (Node i : this.itineraireCamion) {
      System.out.println(i);
      // call getShortestPath
    }
  }
}
