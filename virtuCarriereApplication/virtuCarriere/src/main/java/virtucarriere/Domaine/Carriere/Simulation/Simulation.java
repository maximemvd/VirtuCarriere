/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package virtucarriere.Domaine.Carriere.Simulation;

import java.util.ArrayList;

public class Simulation {

  private boolean simulation;

  private String nameSimulation;

  private ArrayList<Camion> camionList;

  public Simulation(String name) {
    this.camionList = new ArrayList<Camion>();
    this.nameSimulation = name;
    this.simulation = false;
  }

  public void addCamion(Camion p_camion) {
    this.camionList.add(p_camion);
  }

  public void removeCamion(Camion p_camion) {
    try {
      this.camionList.remove(p_camion);
    } catch (Exception error) {
      System.out.println(error);
    }
  }

  public void changeName(String p_name) {
    this.nameSimulation = p_name;
  }

  public String getName() {
    return this.nameSimulation;
  }

  public ArrayList<Camion> getCamionList() {
    return this.camionList;
  }

  public void startSimulation() {
    this.start();
    ArrayList<Camion> camionFinish = new ArrayList<Camion>();
    while (this.simulation) {
      for (Camion camionSimulation : this.camionList) {
        System.out.println(camionSimulation);
        for (Node destination : camionSimulation.itineraireCamion) {
          System.out.println(destination);
        }
        camionFinish.add(camionSimulation);
      }
    }
    this.removeCamionUse(camionFinish);
  }

  public void removeCamionUse(ArrayList<Camion> camionUse) {
    for (Camion camionAlreadyUse : camionUse) {
      this.removeCamion(camionAlreadyUse);
    }
  }

  public void start() {
    this.simulation = true;
  }

  public void stopSimulation() {
    this.simulation = false;
  }
}
