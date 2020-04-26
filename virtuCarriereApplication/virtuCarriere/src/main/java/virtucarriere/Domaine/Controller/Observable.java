/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package virtucarriere.Domaine.Controller;

import java.util.List;
import java.util.ArrayList;
import virtucarriere.Domaine.Carriere.Plan.Element;

/**
 *
 * @author Francis_Boulianne
 */
public interface Observable {
  
  public void addObserver(Observer observer);
  
  public void removeObserver(Observer observer);
  
  public void notifyObservers(String action, Object element);
}
