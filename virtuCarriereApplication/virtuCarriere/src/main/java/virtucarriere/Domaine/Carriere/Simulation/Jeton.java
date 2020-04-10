/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package virtucarriere.Domaine.Carriere.Simulation;

import java.io.Serializable;

public class Jeton implements Serializable {
  private String codeProduit;
  private String etat;
  private double quantite;
  private String referenceClient;

  public Jeton(String referenceClient, String codeProduit, double quantite) {
    this.referenceClient = referenceClient;
    this.codeProduit = codeProduit;
    this.quantite = quantite;
    this.etat = "ATTENTE";
  }

  public String getRefClient() {
    return referenceClient;
  }

  public String getCodeProduit() {
    return codeProduit;
  }

  public void setCodeProduit(String p_code) {
    this.codeProduit = p_code;
  }

  public String getEtat() {
    return etat;
  }

  public void setEtat(String p_etat) {
    if (!"ATTENTE".equals(p_etat)
        && !"LIVRER".equals(p_etat)
        && !"FACTURE".equals(p_etat)
        && !"ENCOURS".equals(p_etat)
        && !"PAYER".equals(p_etat)) {
      return;
    }

    this.etat = p_etat;
  }

  public double getQuantite() {
    return quantite;
  }

  public void setQuantite(double quantite) {
    this.quantite = quantite;
  }
}
