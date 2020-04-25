/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package virtucarriere.Domaine.Carriere.Plan;

import java.awt.Color;
import java.awt.Point;
import java.util.Objects;

public class Convoyeur extends AbstractLien<Equipement> {

  private Color color;
  private Noeud noeud;

  public Convoyeur(Equipement starting, Equipement arrival) {
    super(starting, arrival);

    this.color = Color.YELLOW;
    setName("Convoyeur");
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

  public Noeud getNoeud() {
    return noeud;
  }

  public void setNoeud(Noeud newNoeud) {
    this.noeud = newNoeud;
  }

  @Override
  public Equipement getArrival() {
    return this.arrival;
  }

  public Point middlePointOfConvoyeur(int x1, int y1, int x2, int y2) {
    return new Point((x1 + x2) / 2, (y1 + y2) / 2);
  }

  @Override
  public int hashCode() {
    return Objects.hash(starting, arrival);
  }

  public Color getColor() {
    return this.color;
  }
}
