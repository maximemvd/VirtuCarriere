/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package virtucarriere.Domaine.Carriere.Plan;

import java.awt.Color;
import java.awt.Point;

public class Noeud extends AbstractPointChemin {
  public Noeud(Point point, int p_width, int p_length) {
    super(point, p_width, p_length, Color.CYAN);
    setName("Noeud");
  }
}
