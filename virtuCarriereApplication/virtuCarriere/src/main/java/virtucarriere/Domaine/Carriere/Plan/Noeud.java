/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package virtucarriere.Domaine.Carriere.Plan;

public class Noeud {
  private Coordonnees coordonnees;

  public Noeud(double x, double y) {
    coordonnees = new Coordonnees(x, y);
  }

  public Coordonnees getCoordonnees() {
    return coordonnees;
  }
}
