package virtucarriere.Domaine.Carriere.Plan;

import java.awt.Point;

public class Plan {

  GraphConvoyeur equipments = new GraphConvoyeur();
  GraphChemins chemins = new GraphChemins();

  public void addArc(Arc arc) {
    chemins.addLink(arc);
  }

  public void removeArc(Arc arc) {
    chemins.removeLink(arc);
  }

  public void addBroyeur(Point mousePoint) {
    // addEquipment(broyeur);
  }

  public void addConcasseur(Point mousePoint) {
    //  addEquipment(concasseur);
  }

  public void addConvoyeur(Point mousePoint) {
    //   equipments.addLink(convoyeur);
  }

  public void addCrible(Point mousePoint) {
    // addEquipment(crible);
  }

  public void addEntree(Point mousePoint) {
    // chemins.addEnd(entree);
  }

  public void removeRntree(Entree entree) {
    chemins.removeEnd(entree);
  }

  public void addTas(Point tas) {
    // addEquipment(tas);
  }

  public boolean validateElementPresent(Point point) {
    return false;
  }

  public void addNoeud(Point mousePoint) {
    // TODO validate element present
    // chemins.addEnd(mousePoint);
  }

  public Element getElement(Element element) {
    // TODO aller chercher

    return element;
  }

  public void updateSelectedItemsPosition(double deltaX, double deltaY) {

    /*
    for (Element item : this.equipementList) {
      if (item.isSelected()) {
        item.translate(deltaX, deltaY);
      }
    }
    for (Element item : this.noeudList) {
      if (item.isSelected()) {
        item.translate(deltaX, deltaY);
      }
    }

    for (Element item : this.entreeList) {
      if (item.isSelected()) {
        item.translate(deltaX, deltaY);
      }
    }

    for (Vehicule item : this.vehiculeList) {
      if (item.isSelected()) {
        item.translate(deltaX, deltaY);
      }
    }
    */

  }

  public void removeNoeud(Noeud noeud) {
    chemins.removeEnd(noeud);
  }

  public boolean isNoeudPresent(Noeud p_noeud) {

    /*
    for (Noeud item : this.noeudList) {
      if (item.contains(p_noeud.getX(), p_noeud.getY())) {
        return true;
      }
    }
    return false;
    */
    return true;
  }

  public boolean isEquipementPresent(Equipement equipement) {
    // TODO
    return true;
  }

  public void switchSelectionStatus(double x, double y) {
    /*for (Element item : this.equipementList) {
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
    }*/
  }

  public void removePlan(Element element) {
    // TODO implement remove element;
  }
}
