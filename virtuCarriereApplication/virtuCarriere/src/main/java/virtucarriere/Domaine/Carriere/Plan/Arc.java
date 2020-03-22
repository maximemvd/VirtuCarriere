/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package virtucarriere.Domaine.Carriere.Plan;

public class Arc extends Element {

  private Noeud starting;
  private Noeud arrival;
  private int cout;

  public Arc(Noeud starting, Noeud arrival) {
    //TODO Valider comment intégrer element
    super(starting.getCoordonnees(), 1, 1, false);

    this.starting = starting;
    this.arrival = arrival;
  }

  public Noeud getArrival(){
    return arrival;
  }
}
