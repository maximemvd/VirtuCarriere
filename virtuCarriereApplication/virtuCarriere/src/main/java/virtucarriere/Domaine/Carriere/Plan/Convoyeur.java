/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package virtucarriere.Domaine.Carriere.Plan;

import java.awt.Color;
import java.awt.Point;

public class Convoyeur extends AbstractLien<Equipement> {

  private Equipement arrival;
  private Equipement starting;
  private Color color;
  private String name;

  public Convoyeur(Point point, int p_width, int p_length, Equipement starting, Equipement arrival) {
    super(point, p_width, p_length);

    this.starting = starting;
    this.arrival = arrival;
    this.color = Color.RED;
    this.name = "Convoyeur";
  }

  public void setStarting(Equipement starting) {
    this.starting = starting;
  }

  @Override
  public Equipement getStarting() {
    return this.starting;
  }
  
  public void setArrival(Equipement arrival) {
    this.arrival = arrival;
  }

  @Override
  public Equipement getArrival() {
    return this.arrival;
  }

  public String getName() {
    return name;
  }
}
