package virtucarriere.Domaine.Carriere.Plan;

import java.awt.Point;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
import javax.swing.JOptionPane;

public class Plan implements Serializable {

  GraphConvoyeur equipments;
  GraphChemins chemins;
  List<Noeud> noeudsForArcList;
  List<Equipement> equipementForConvList;
  List<AbstractPointChemin> pointsForArcList;

  private Entree entree;

  public Plan() {
    entree = new Entree(new Point(300, 300), 100, 100, 0);
    equipments = new GraphConvoyeur();
    chemins = new GraphChemins();
    noeudsForArcList = new LinkedList<Noeud>();
    equipementForConvList = new LinkedList<Equipement>();
    pointsForArcList = new LinkedList<>();
  }

  public void addArc(Arc arc) {
    chemins.addLink(arc);
  }

  public void removeArc(Arc arc) {
    chemins.removeLink(arc);
  }

  public void removeConvoyeur(Convoyeur convoyeur) {
    equipments.removeLink(convoyeur);
  }

  public void noeudSelection(double x, double y) {
    for (AbstractPointChemin noeud : getNoeuds()) {
      if (noeud.contains(x, y)) {
        pointsForArcList.add(noeud);
        noeud.setSelectionStatus(true);
      }
    }
  }

  public void addEquipment(Equipement equipement) {
    equipments.addEnd(equipement);
  }

  public void addBroyeur(Point mousePoint) {
    Broyeur broyeur = new Broyeur(mousePoint, 1, 1, 0);
    if (isElementPresent(broyeur)) {
      JOptionPane.showMessageDialog(
          null, "Attention, un élément est déjà présent à cette position");
    } else {
      addEquipment(broyeur);
    }
  }

  public void addConcasseur(Point mousePoint) {
    Concasseur concasseur = new Concasseur(mousePoint, 1, 1, 0);
    if (isElementPresent(concasseur)) {
      JOptionPane.showMessageDialog(
          null, "Attention, un élément est déjà présent à cette position");
    } else {
      addEquipment(concasseur);
    }
  }

  public void addCrible(Point mousePoint) {
    Crible crible = new Crible(mousePoint, 1, 1, 0);
    if (isElementPresent(crible)) {
      JOptionPane.showMessageDialog(
          null, "Attention, un élément est déjà présent à cette position");
    } else {
      addEquipment(crible);
    }
  }

  public void addTas(Point mousePoint, String code) {
    Tas tas = new Tas(mousePoint, 1, 1, code, 1);
    Noeud noeud = new Noeud(tas.getPoint(), 3, 3);
    chemins.addEnd(noeud);
    addEquipment(tas);
    PointChargement pointChargement = tas.getPointChargement();
    chemins.addEnd(pointChargement);

    Arc arc = new Arc(mousePoint, 3, 3, pointChargement, noeud);
    chemins.addLink(arc);
  }

  public void clearEquipementConv() {
    this.equipementForConvList.clear();
  }

  public void addConvoyeur(Point mousePoint) {
    for (Element equipement : getEquipements()) {
      if (equipement.contains(mousePoint.getX(), mousePoint.getY())) {

        // Si la liste est vide, on ajoute simplement element
        if (equipementForConvList.isEmpty()) {
          equipementForConvList.add((Equipement) equipement);
          equipement.setSelectionStatus(true);
        }

        // Sil y a deja un element, on verifie si on peut ajouter un convoyeur a celui ci
        else if (equipementForConvList.size() == 1) {

          String actualEquipement = equipementForConvList.get(0).getName();

          switch (actualEquipement) {
            case "Crible":
              if ((((Equipement) equipement).getName().equals("Broyeur"))
                  || (((Equipement) equipement).getName().equals("Tas"))) {
                equipementForConvList.add((Equipement) equipement);
                equipement.setSelectionStatus(true);
              } else {
                JOptionPane.showMessageDialog(
                    null,
                    "Un crible doit être reliée à un broyeur ou un tas.",
                    "Attention",
                    JOptionPane.WARNING_MESSAGE);
              }
              break;

            case "Broyeur":
              if ((((Equipement) equipement).getName().equals("Crible"))
                  || (((Equipement) equipement).getName().equals("Concasseur"))) {
                equipementForConvList.add((Equipement) equipement);
                equipement.setSelectionStatus(true);
              } else {
                JOptionPane.showMessageDialog(
                    null,
                    "Un broyeur doit être relié à un crible ou un concasseur.",
                    "Attention",
                    JOptionPane.WARNING_MESSAGE);
              }
              break;

            case "Concasseur":
              if (((Equipement) equipement).getName().equals("Broyeur")) {
                equipementForConvList.add((Equipement) equipement);
                equipement.setSelectionStatus(true);
              } else {
                JOptionPane.showMessageDialog(
                    null,
                    "Un concasseur doit être relié à un broyeur.",
                    "Attention",
                    JOptionPane.WARNING_MESSAGE);
              }
              break;
            case "Tas":
              if (((Equipement) equipement).getName().equals("Crible")) {
                equipementForConvList.add((Equipement) equipement);
                equipement.setSelectionStatus(true);
              } else {
                JOptionPane.showMessageDialog(
                    null,
                    "Un tas doit être relié à un crible.",
                    "Attention",
                    JOptionPane.WARNING_MESSAGE);
              }
            default:
              break;
          }
        }
      }
    }

    if (equipementForConvList.size() == 2) {
      Convoyeur convoyeur =
          new Convoyeur(
              mousePoint, 5, 5, equipementForConvList.get(0), equipementForConvList.get(1));
      try {
        equipments.getLink(convoyeur.getArrival(), convoyeur.getStarting());
        JOptionPane.showMessageDialog(
            null,
            "Un convoyeur est déjà à cet emplacement.",
            "Attention",
            JOptionPane.WARNING_MESSAGE);
      } catch (RuntimeException e) {
        try {
          equipments.getLink(convoyeur.getStarting(), convoyeur.getArrival());
          JOptionPane.showMessageDialog(
              null,
              "Un convoyeur est déjà à cet emplacement.",
              "Attention",
              JOptionPane.WARNING_MESSAGE);
        } catch (RuntimeException er) {
          equipments.addLink(convoyeur);
        }
      }

      for (Equipement equipement : equipementForConvList) {
        equipement.switchSelectionStatus();
      }
      equipementForConvList.clear();
    }
  }

  public void addEntree(Point mousePoint) {
    entree = new Entree(mousePoint, 100, 100, 0);
    chemins.addEnd(entree);
  }

  public void addNoeud(Point mousePoint) {
    Noeud noeud = new Noeud(mousePoint, 3, 3);
    if (isElementPresent(noeud)) {
      JOptionPane.showMessageDialog(
          null, "Attention, un élément est déjà présent à cette position");
    } else {
      chemins.addEnd(noeud);
    }
  }

  public Element getElement(Element element) {
    // TODO aller chercher

    return element;
  }

  public Element getElement(Point point) {
    Element returnElement =
        getAllElements().stream()
            .filter(element -> element.getPoint() == point)
            .findFirst()
            .orElse(null);
    if (returnElement == null) throw new RuntimeException("Aucun element a cette position");
    return returnElement;
  }

  public void deleteSelected() {
    // TODO delete les éléments sélectionnés
  }

  public void updateSelectedItemsPosition(double deltaX, double deltaY) {

    for (Equipement item : getEquipements()) {
      if (item.isSelected()) {
        item.translate(deltaX, deltaY);
        if (item.getName().equals("Tas")) {
          PointChargement pointChargement = item.getPointChargement();
          pointChargement.translate(deltaX, deltaY);
        }
      }
    }
    for (Element item : getNoeuds()) {
      if (item.isSelected()) {
        item.translate(deltaX, deltaY);
      }
    }

    if (entree.isSelected()) {
      entree.translate(deltaX, deltaY);
    }
  }

  public void removeNoeud(AbstractPointChemin noeud) {
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
    for (Element item : getEquipements()) {
      if (item.contains(x, y)) {
        item.switchSelectionStatus();
      }
    }

    for (Element item : getNoeuds()) {
      if (item.contains(x, y)) {
        item.switchSelectionStatus();
      }
    }

    if (entree.contains(x, y)) {
      entree.switchSelectionStatus();
    }

    for (List<Arc> listOfArc : getArcs()) {
      for (Arc item : listOfArc) {
        AbstractPointChemin starting = item.getStarting();
        AbstractPointChemin arrival = item.getArrival();

        double xPosStarting = starting.getX();
        double yPosStarting = starting.getY();
        double xPosArrival = arrival.getX();
        double yPosArrival = arrival.getY();

        if (item.containsArc(x, y, xPosStarting, yPosStarting, xPosArrival, yPosArrival)) {
          item.switchSelectionStatus();
        }
      }
    }

    for (List<Convoyeur> listOfConvoyeur : getConvoyeurs()) {
      for (Convoyeur item : listOfConvoyeur) {
        Equipement starting = item.getStarting();
        Equipement arrival = item.getArrival();

        double xPosStarting = starting.getX();
        double yPosStarting = starting.getY();
        double xPosArrival = arrival.getX();
        double yPosArrival = arrival.getY();

        if (item.containsConvoyeur(x, y, xPosStarting, yPosStarting, xPosArrival, yPosArrival)) {
          item.switchSelectionStatus();
        }
      }
    }
  }

  public void removePlan(Element element) {
    // TODO implement remove element;
  }

  public void removeElement(Element element) {}

  public void removeEquipement(Equipement equipement) {
    equipments.removeEnd(equipement);
  }

  public List<Equipement> getEquipements() {
    return equipments.getEnds();
  }

  public ArrayList<List<Convoyeur>> getConvoyeurs() {
    return equipments.getLinks();
  }

  public List<AbstractPointChemin> getNoeuds() {
    return chemins.getEnds();
  }

  public ArrayList<List<Arc>> getArcs() {
    return chemins.getLinks();
  }

  public List<Noeud> getNoeudForArcList() {
    return this.noeudsForArcList;
  }

  public List<AbstractPointChemin> getPointsForArcList() {
    return this.pointsForArcList;
  }

  public Entree getEntree() {
    return entree;
  }

  public Point getEntreePoint() {
    return entree.getPoint();
  }

  public List<Element> getSelected() {
    return getAllElements().stream()
        .filter(Element::getSelectionStatus)
        .collect(Collectors.toList());
  }

  public List<Element> getAllElements() {
    List<Element> elements = new ArrayList<>();
    elements.addAll(getAllEquipments());
    elements.addAll(getAllConvoyeur());
    elements.addAll(getAllAbstractPointChemin());
    elements.addAll(getAllArcs());
    return elements;
  }

  public List<Equipement> getAllEquipments() {
    return equipments.getEnds();
  }

  public List<Convoyeur> getAllConvoyeur() {
    return equipments.getLinks().stream().flatMap(List::stream).collect(Collectors.toList());
  }

  public List<AbstractPointChemin> getAllAbstractPointChemin() {
    return chemins.getEnds();
  }

  public List<Arc> getAllArcs() {
    return chemins.getLinks().stream().flatMap(List::stream).collect(Collectors.toList());
  }

  public GraphChemins GetGraphChemins() {
    return chemins;
  }

  public boolean validateDependencies() {
    return equipments.validateDependencies();
  }

  public boolean isElementPresent(Element element) {
    List<Element> allElements = getAllElements();
    return allElements.stream()
        .anyMatch(element1 -> element.contains(element1.getX(), element1.getY()));
  }
}
