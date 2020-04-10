/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package virtucarriere.Domaine.Carriere.Simulation;

import java.io.Serializable;

/** @author philippevincent */
public class Facture implements Serializable {

  private final String codeMateriau;

  private final double quantite;

  public Facture(String p_codeDuMateriau, double p_quantite) {
    this.quantite = p_quantite;
    this.codeMateriau = p_codeDuMateriau;
  };

  public double getQuantite() {
    return quantite;
  }

  public String getCodeProduit() {
    return codeMateriau;
  }

  public double getPrice() {

    double prixMateriau = 0;

    if ("1-214".equals(codeMateriau) || "1-110".equals(codeMateriau)) {
      prixMateriau = 20.15;
    }

    if ("1-220".equals(codeMateriau) || "1-228".equals(codeMateriau)) {
      prixMateriau = 15.90;
    }

    if ("1-644".equals(codeMateriau)) {
      prixMateriau = 15;
    }

    if ("1-630".equals(codeMateriau) || "1-695".equals(codeMateriau)) {
      prixMateriau = 20.90;
    }
    return prixMateriau * quantite;
  }
}
