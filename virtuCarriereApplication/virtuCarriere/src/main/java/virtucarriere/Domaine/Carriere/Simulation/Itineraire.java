/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package virtucarriere.Domaine.Carriere.Simulation;

import java.io.Serializable;
import java.util.List;
import virtucarriere.Domaine.Carriere.Plan.Noeud;

public class Itineraire implements Serializable {
  private List<Noeud> stops;

  Itineraire(List<Noeud> stops) {
    this.stops = stops;
  }
}
