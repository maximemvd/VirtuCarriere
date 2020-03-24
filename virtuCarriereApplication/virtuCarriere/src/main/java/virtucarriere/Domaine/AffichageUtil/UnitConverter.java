/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package virtucarriere.Domaine.AffichageUtil;

import virtucarriere.gui.MainWindow;
import static virtucarriere.gui.MainWindow.MeasurementUnitMode.IMPERIAL;
import static virtucarriere.gui.MainWindow.MeasurementUnitMode.METRIC;

/**
 *
 * @author vincentmasse
 */
public class UnitConverter {
    
    public static double inchToPixel(double inch){
        //TODO calcul à faire selon la dimension de notre fenêtre
        return inch;
    }
    
    public static double pixelToInch(double pixel){
        //TODO calcul à faire selon la dimension de notre fenêtre
        return pixel;
    }
    
    public static double pixelToMeter(double pixel){
        //TODO calcul à faire selon la dimension de notre fenêtre
        return pixel;
    }
    
    public static double inchToMeter(double inch){
        //TODO calcul à faire selon la dimension de notre fenêtre
        return inch;
    }
    
    public static double meterToInch(double meter){
        //TODO calcul à faire selon la dimension de notre fenêtre
        return meter;
    }
    
    public static double meterToPixel(double meter){
        //TODO calcul à faire selon la dimension de notre fenêtre
        return meter;
    }
     
    
     public static double convertSelectedUnitToPixel(double unit, MainWindow.MeasurementUnitMode mode)
     {
         switch(mode){
             case METRIC:
                 return meterToPixel(unit);
                 
             case IMPERIAL:
                 return inchToPixel(unit);
         }
         return unit;
     }
     
     public static double convertPixelToSelectedUnit(double unit, MainWindow.MeasurementUnitMode mode)
     {
         switch(mode){
             case METRIC:
                 return pixelToMeter(unit);
                 
             case IMPERIAL:
                 return pixelToInch(unit);
         }
         return unit;
     }
    
}
