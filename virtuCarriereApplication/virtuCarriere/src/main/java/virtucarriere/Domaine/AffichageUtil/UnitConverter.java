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

  private static int longueurImage;

  private static int largeurImage;

  public static void setLargeurImage(int p_size)
  {
    largeurImage = p_size;
  }

  public static void  setLongueurImage(int p_size)
  {
    longueurImage = p_size;
  }

  public static int getLongueurImage() {
    return longueurImage;
  }

  public static int getLargeurImage(){
    return largeurImage;
  }

  public static double pixelToMeter(double pixel) {
    return pixel * converterUnit;
  }

  public static double ConvertSpeedToKm(double speed, double time){
    double rightSpeed = pixelToMeter(speed);
    double rightTimeSeconde = time / 1000;
    double vitesseMS = rightSpeed / rightTimeSeconde;
    return (vitesseMS * 3.6);
  }

}
