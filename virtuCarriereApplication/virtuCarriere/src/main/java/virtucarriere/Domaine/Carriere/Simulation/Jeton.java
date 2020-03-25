/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package virtucarriere.Domaine.Carriere.Simulation;

import virtucarriere.Domaine.Carriere.Plan.OutdatedCoordonnees;

public class Jeton {
  private String code;
  private Boolean etat;
  private OutdatedCoordonnees destination;
  private int quantite;

  public Jeton(String code, Boolean etat, OutdatedCoordonnees destination, int quantite) {
    this.code = code;
    this.etat = etat;
    this.destination = destination;
    this.quantite = quantite;
  }

  public String getCode() {
    return code;
  }

  public Boolean getEtat() {
    return etat;
  }

  public void setEtat(Boolean etat) {
    this.etat = etat;
  }

  public OutdatedCoordonnees getDestination() {
    return destination;
  }

  public void setDestination(OutdatedCoordonnees destination) {
    this.destination = destination;
  }

  public int getQuantite() {
    return quantite;
  }

  public void setQuantite(int quantite) {
    this.quantite = quantite;
  }
}
