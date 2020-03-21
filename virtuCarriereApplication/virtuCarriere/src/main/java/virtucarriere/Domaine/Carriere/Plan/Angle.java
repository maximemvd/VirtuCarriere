/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package virtucarriere.Domaine.Carriere.Plan;

public class Angle {
  private Double degree;

  Angle(double degree){
    if (degree > 360 || degree < 0){
      throw new RuntimeException("L'angle en argument est invalide");
    }
  }

  double get(){
    return this.degree;
  }
}
