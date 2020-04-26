/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package virtucarriere.Domaine.Carriere.Plan;

import java.awt.Color;
import java.awt.Point;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Crible extends Equipement {

  private Color color;
  private static List<Class<? extends Equipement>> dependency =
      new ArrayList<Class<? extends Equipement>>(Collections.singleton(Tas.class));

  public Crible(Point point, double p_angle) {

    super(point, 65, 40, p_angle = 0, dependency);

    setName("Crible");
  }
}
