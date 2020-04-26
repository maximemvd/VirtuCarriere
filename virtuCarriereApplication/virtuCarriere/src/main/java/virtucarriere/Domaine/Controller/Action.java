/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package virtucarriere.Domaine.Controller;

import virtucarriere.Domaine.Carriere.Plan.Element;

/**
 *
 * @author Francis_Boulianne
 */
public class Action {
    
  private String action;
  private Element element;
  
  public Action(String p_action, Element p_element){
      this.action = p_action;
      this.element = p_element;
  }
  
  public String getAction(){
      return this.action;
  }
  
  public Element getElement(){
      return this.element;
  }
    
}
