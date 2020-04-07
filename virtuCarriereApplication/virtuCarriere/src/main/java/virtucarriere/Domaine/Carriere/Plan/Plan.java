package virtucarriere.Domaine.Carriere.Plan;

import java.awt.Point;

public class Plan {

  GraphConvoyeur equipments = new GraphConvoyeur();
  GraphChemins chemins = new GraphChemins();

  void addArc(Arc arc) {
    chemins.addLink(arc);
  }

  void removeArc(Arc arc) {
    chemins.removeLink(arc);
  }

  void addBroyeur(Broyeur broyeur) {
    addEquipment(broyeur);
  }

  void addConcasseur(Concasseur concasseur) {
    addEquipment(concasseur);
  }

  void addConvoyeur(Convoyeur convoyeur) {
    equipments.addLink(convoyeur);
  }

  void addCrible(Crible crible) {
    addEquipment(crible);
  }

  void addEntree(Entree entree) {
    chemins.addEnd(entree);
  }

  void removeRntree(Entree entree) {
    chemins.removeEnd(entree);
  }

  void addTas(Tas tas) {
    addEquipment(tas);
  }

  void addEquipment(Equipement equipement) {
    // TODO validate dependency
    // TODO validate that nothing is present in chemin graphe
    equipments.addEnd(equipement);
  }

  boolean validateElementPresent(Point point) {
    return false;
  }

  void addNoeud(Noeud noeud) {
    // TODO validate element present
    chemins.addEnd(noeud);
  }

  void removeNoeud(Noeud noeud) {
    chemins.removeEnd(noeud);
  }

  public void switchSelectionStatus(double x, double y) {
    // TODO switch status
    /*
      for (Element item : this.equipementList) {
        if (item.contains(x, y)) {
          item.switchSelectionStatus();
        }
      }

      for (Element item : this.noeudList) {
        if (item.contains(x, y)) {
          item.switchSelectionStatus();
        }
      }

      for (Element item : this.entreeList) {
        if (item.contains(x, y)) {
          item.switchSelectionStatus();
        }
      }

      for (Vehicule item : this.vehiculeList) {
        if (item.contains(x, y)) {
          item.switchSelectionStatus();
        }
      }

      for (Arc item : this.arcList) {
        Noeud starting = item.getStarting();
        Noeud arrival = item.getArrival();

        double xPosStarting = starting.getX();
        double yPosStarting = starting.getY();
        double xPosArrival = arrival.getX();
        double yPosArrival = arrival.getY();

        if (item.containsArc(x, y, xPosStarting, yPosStarting, xPosArrival, yPosArrival)) {
          item.switchSelectionStatus();
        }
      }
    */
  }
}
