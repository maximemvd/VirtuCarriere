/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package virtucarriere.Domaine.Carriere.Plan;

import java.awt.Point;

public class Convoyeur extends AbstractLien<Equipement> {

  private Noeud destination;
  private String name;

  public Convoyeur(
      Point point, int p_width, int p_length, boolean p_selectionStatus, Noeud p_destination) {
    super(point, p_width, p_length, p_selectionStatus);

    this.destination = p_destination;
    this.name = "Convoyeur";
  }

  public void setDestination(Noeud p_destination) {
    this.destination = p_destination;
  }

  public Noeud getDestination() {
    return this.destination;
  }

  public String getName() {
    return name;
  }
}
