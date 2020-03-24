/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package virtucarriere.Domaine.Carriere.Simulation;

import virtucarriere.Domaine.Carriere.Plan.Coordonnees;

public class Chargeur extends Vehicule {

  private Coordonnees destination;

  public Chargeur(Coordonnees p_destination) {
    this.destination = p_destination;
  };

  public Coordonnees getDestination() {
    return this.destination;
  }

  public void changeDestination(Coordonnees p_coordonnees) {
    this.destination = p_coordonnees;
  }
}
