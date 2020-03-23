/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package virtucarriere.Domaine.Carriere.Plan;
 import java.awt.Point;

public class Arc extends Element {

  private Noeud starting;
  private Noeud arrival;
  private int cout;

  public Arc(Point point, Noeud starting, Noeud arrival) {
    //TODO Valider comment intégrer element
    super(point, starting.getCoordonnees(), 1, 1, false);

    this.starting = starting;
    this.arrival = arrival;
  }

  public Noeud getArrival(){
    return arrival;
  }
}
