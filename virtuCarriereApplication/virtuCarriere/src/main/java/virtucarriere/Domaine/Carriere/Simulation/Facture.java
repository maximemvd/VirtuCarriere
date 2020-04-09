/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package virtucarriere.Domaine.Carriere.Simulation;

/** @author philippevincent */
public class Facture {

  private final double prixDuMateriaux;

  private final double quantite;

  public Facture(double p_prixDuMateriau, double p_quantite) {
    this.quantite = p_quantite;
    this.prixDuMateriaux = p_prixDuMateriau;
  };

  public double getPrice() {
    return prixDuMateriaux * quantite;
  }

  public double getQuantity() {
    return quantite;
  }

  public double getprixDuMateriaux() {
    return prixDuMateriaux;
  }
}
