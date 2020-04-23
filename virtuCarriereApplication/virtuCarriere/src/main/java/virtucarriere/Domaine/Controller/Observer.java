/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package virtucarriere.Domaine.Controller;

/**
 *
 * @author Francis_Boulianne
 */
public interface Observer {
    
  public void update();
  
  public void setObervable(Observable observable);
    
}
