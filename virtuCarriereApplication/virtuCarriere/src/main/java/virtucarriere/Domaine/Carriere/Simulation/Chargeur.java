/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package virtucarriere.Domaine.Carriere.Simulation;

import virtucarriere.Domaine.Carriere.Plan.OutdatedCoordonnees;

public class Chargeur extends Vehicule {

  private OutdatedCoordonnees destination;

  public Chargeur(OutdatedCoordonnees p_destination) {
    this.destination = p_destination;
  };

  public OutdatedCoordonnees getDestination() {
    return this.destination;
  }

  public void changeDestination(OutdatedCoordonnees p_Outdated_coordonnees) {
    this.destination = p_Outdated_coordonnees;
  }
}
