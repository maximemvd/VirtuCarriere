/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package virtucarriere.Domaine.Carriere.Plan;

public class Catalogue {

  private String code;
  private String description;
  private double price;

  public Catalogue(String code, String description, double price) {
    this.code = code;
    this.description = description;
    this.price = price;
  }

  public String getCode() {
    return code;
  }

  public String getDescription() {
    return description;
  }

  public double getPrice() {
    return price;
  }
}
