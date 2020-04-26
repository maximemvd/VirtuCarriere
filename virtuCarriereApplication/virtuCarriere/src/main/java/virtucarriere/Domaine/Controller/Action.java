/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package virtucarriere.Domaine.Controller;

import java.io.Serializable;
import virtucarriere.Domaine.Carriere.Plan.Element;

/**
 *
 * @author Francis_Boulianne
 */
public class Action implements Serializable {
    
  private String action;
  private Object element;
  
  public Action(String p_action, Object p_element){
      this.action = p_action;
      this.element = p_element;
  }
  
  public String getAction(){
      return this.action;
  }
  
  public Object getElement(){
      return this.element;
  }
    
}
