/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package virtucarriere.Domaine.AffichageUtil;



/** @author vincentmasse */
public class UnitConverter {

  private static float PixelToMeter = (float) 0.005;

  public static double pixelToMeter(double pixel) {
    // TODO calcul à faire selon la dimension de notre fenêtre
    return pixel * PixelToMeter;
  }

  public static double meterToPixel(double meter) {
    // TODO calcul à faire selon la dimension de notre fenêtre
    return meter;
  }
}
