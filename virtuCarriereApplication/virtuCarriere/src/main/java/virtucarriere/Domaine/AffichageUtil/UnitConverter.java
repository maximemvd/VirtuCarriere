/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package virtucarriere.Domaine.AffichageUtil;
import java.awt.Point;

/** @author vincentmasse */
public class UnitConverter {

  private static float converterUnit = (float) 0.1;

  public static double pixelToMeter(double pixel) {
    // TODO calcul à faire selon la dimension de notre fenêtre
    return pixel * converterUnit;
  }

  public static double meterToPixel(double meter) {
    // TODO calcul à faire selon la dimension de notre fenêtre
    return meter / converterUnit;
  }


  public static float getConverterUnit(){
    return converterUnit;
  }


  public static double ConvertSpeedToKm(double speed, double time){
    double rightSpeed = pixelToMeter(speed);
    double rightTimeSeconde = time / 1000;
    double vitesseMS = rightSpeed / rightTimeSeconde;
    return vitesseMS * 3.6;
  }
}
