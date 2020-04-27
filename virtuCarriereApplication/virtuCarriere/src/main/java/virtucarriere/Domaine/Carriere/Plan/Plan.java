package virtucarriere.Domaine.Carriere.Plan;

import java.awt.Point;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
import javax.swing.JOptionPane;
import virtucarriere.Domaine.Controller.*;

public class Plan implements Serializable, Observable {

  GraphConvoyeur equipments;
  GraphChemins chemins;
  List<Noeud> noeudsForArcList;
  List<Equipement> equipementForConvList;
  List<AbstractPointChemin> pointsForArcList;
  List<Observer> observerList = new ArrayList<>();

  public Plan() {
    equipments = new GraphConvoyeur();
    chemins = new GraphChemins();
    noeudsForArcList = new LinkedList<>();
    equipementForConvList = new LinkedList<>();
    pointsForArcList = new LinkedList<>();
  }

  public void initObservers(ElementContainer element) {
    equipments.addObserver(element);
    chemins.addObserver(element);
  }

  @Override
  public void notifyObservers(String action, Object element) {
    for (Observer observer : this.observerList) {
      observer.update(action, element);
    }
  }

  @Override
  public void addObserver(Observer observer) {
    this.observerList.add(observer);
  }

  @Override
  public void removeObserver(Observer observer) {
    this.observerList.remove(observer);
  }
  
  public void quickAddNoeud(AbstractPointChemin noeud){
    chemins.addEnd(noeud);
  }
  
  public void quickAddConvoyeur(Convoyeur convoyeur){
    equipments.addLink(convoyeur);
  }

  public void quickAddArc(Arc arc) {
    chemins.addLink(arc);
  }

  public void addArc(Point point) {

    for (AbstractPointChemin noeud : getNoeuds()) {
      if (noeud.contains(point.getX(), point.getY())) {
        pointsForArcList.add(noeud);
        noeud.setSelectionStatus(true);
      }
    }

    if (getPointsForArcList().size() == 2) {
      verifieArc(point);
      for (AbstractPointChemin noeud : getPointsForArcList()) {
        noeud.setSelectionStatus(false);
      }
      getPointsForArcList().clear();
    }
  }

  public void verifieArc(Point point) {
   AbstractPointChemin starting = getPointsForArcList().get(0);
    AbstractPointChemin arrival = getPointsForArcList().get(1);
    if (starting != arrival) {
      try {
        Arc arc = new Arc(starting, arrival);
       // if (intersectAnyForArc(arc)) {
        //  JOptionPane.showMessageDialog(
          //    null, "Cet arc croise un element du plan.", "Attention", JOptionPane.WARNING_MESSAGE);
      //  } else {
          chemins.addLink(arc);
       // }
      } catch (RuntimeException e) {
        JOptionPane.showMessageDialog(
            null, "Cet arc existe déjà.", "Attention", JOptionPane.WARNING_MESSAGE);
      }

    } else {
      JOptionPane.showMessageDialog(
          null,
          "Un arc doit être relié à deux noeuds différents",
          "Attention",
          JOptionPane.WARNING_MESSAGE);
    }
  }

  public void addChemin(Point point) {
    boolean noeudExiste = false;
    for (AbstractPointChemin noeud : getNoeuds()) {
      if (noeud.contains(point.getX(), point.getY())) {
        noeudExiste = true;
      }
    }
    if (!noeudExiste) {
      addNoeud(point);
    }

    for (AbstractPointChemin noeud : getNoeuds()) {
      if (noeud.contains(point.getX(), point.getY())) {
        pointsForArcList.add(noeud);
        noeud.setSelectionStatus(true);
      }
    }

    if (getPointsForArcList().size() == 2) {
      verifieArc(point);
      getPointsForArcList().get(0).setSelectionStatus(false);
      getPointsForArcList().get(1).setSelectionStatus(true);
      getPointsForArcList().remove(0);
    }
  }

  public void removeArc(Arc arc) {
    chemins.removeLink(arc);
  }

  public void removeConvoyeur(Convoyeur convoyeur) {
    equipments.removeLink(convoyeur);
  }

  public void addEquipment(Equipement equipement) {
    equipments.addEnd(equipement);
  }

  public void addBroyeur(Point mousePoint, double angle) {
    Broyeur broyeur = new Broyeur(mousePoint, 1, 1, angle);
    if (intersectAny(broyeur)) {
      JOptionPane.showMessageDialog(
          null, "Attention, un élément est déjà présent à cette position");
    } else {
      addEquipment(broyeur);
    }
  }

  public void addConcasseur(Point mousePoint, double angle) {
    Concasseur concasseur = new Concasseur(mousePoint, angle);
    if (intersectAny(concasseur)) {
      JOptionPane.showMessageDialog(
          null, "Attention, un élément est déjà présent à cette position");
    } else {
      addEquipment(concasseur);
    }
  }

  public void addCrible(Point mousePoint, double angle) {
    Crible crible = new Crible(mousePoint, angle);
    if (intersectAny(crible)) {
      JOptionPane.showMessageDialog(
          null, "Attention, un élément est déjà présent à cette position");
    } else {
      addEquipment(crible);
    }
  }

  public void addTas(Point mousePoint, String code, double angle) {
    Tas tas = new Tas(mousePoint, 1, 1, code, 25, angle);
    Noeud noeud = new Noeud(tas.getPoint());
    tas.setNoeudTas(noeud);
    PointChargement pointChargement = tas.getPointChargement();
    Arc arcAller = new Arc(pointChargement, noeud);
    Arc arcRetour = new Arc(noeud, pointChargement);
    if (!intersectAny(tas)
        && !intersectAny(noeud)
        && !intersectAny(pointChargement)
        && !intersectAny(arcAller)
        && !intersectAny(arcRetour)) {
      addEquipment(tas);
      chemins.addEnd(noeud);
      chemins.addEnd(pointChargement);
      chemins.addLink(arcAller);
      chemins.addLink(arcRetour);
    } else {
      JOptionPane.showMessageDialog(
          null,
          "Il existe déjà un element à cet endroit",
          "Attention",
          JOptionPane.WARNING_MESSAGE);
    }
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
              if ((equipement.getName().equals("Broyeur"))
                  || (equipement.getName().equals("Tas"))) {
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
              if ((equipement.getName().equals("Crible"))
                  || (equipement.getName().equals("Concasseur"))) {
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
              if (equipement.getName().equals("Broyeur")) {
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
              if (equipement.getName().equals("Crible")) {
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
          new Convoyeur(equipementForConvList.get(0), equipementForConvList.get(1));
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

  public void addConvoyeurForPopup(Equipement starting, Equipement arrival) {
    Point point = new Point();
    Convoyeur convoyeur = new Convoyeur(starting, arrival);
    equipments.addLink(convoyeur);
  }

  public void addEntree(Point mousePoint) {
    Entree entree = new Entree(mousePoint, 0);
    chemins.addEnd(entree);
  }

  public void addNoeud(Point mousePoint) {
    Noeud noeud = new Noeud(mousePoint);
    if (isElementPresent(noeud)) {
      JOptionPane.showMessageDialog(
          null, "Attention, un élément est déjà présent à cette position");
    } else if (isArcPresent(noeud)) {
      JOptionPane.showMessageDialog(null, "Attention, un arc est déjà présent à cette position");
    } else {
      chemins.addEnd(noeud);
    }
  }

  public Element getElement(Point point) {
    Element returnElement =
        getAllElements().stream()
            .filter(element -> element.getPoint() == point)
            .findFirst()
            .orElse(null);
    if (returnElement == null) {
      throw new RuntimeException("Aucun element a cette position");
    }
    return returnElement;
  }

  public void updateSelectedItemsPosition(double deltaX, double deltaY) {

    for (Equipement item : getEquipements()) {
      if (item.isSelected()) {
        item.translate(deltaX, deltaY);
        if (item.getName().equals("Tas")) {
          Tas tas = (Tas) item;
          PointChargement pointChargement = tas.getPointChargement();
          pointChargement.translate(deltaX, deltaY);
        }
      }
    }
    for (Element item : getNoeuds()) {
      if (item.isSelected()) {
        item.translate(deltaX, deltaY);
      }
    }
  }

  public void removeNoeud(AbstractPointChemin noeud) {
    chemins.removeEnd(noeud);
  }

  public boolean isNoeudPresent(Noeud p_noeud) {
    return getAllNoeuds().stream()
        .anyMatch(noeud -> noeud.contains(p_noeud.getX(), p_noeud.getY()));
  }

  public boolean isEquipementPresent(Equipement equipement) {
    return getAllEquipments().stream().anyMatch(equipement1 -> equipement1 == equipement);
  }

  public void switchSelectionStatus(double x, double y) {
    getAllElements().stream()
        .filter(element -> element.contains(x, y))
        .forEach(Element::switchSelectionStatus);
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
    Entree entree =
        (Entree)
            chemins.getEnds().stream()
                .filter(abstractPointChemin -> abstractPointChemin instanceof Entree)
                .findFirst()
                .orElse(null);
    return entree;
  }

  public Point getEntreePoint() {
    return getEntree().getPoint();
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

  public List<Noeud> getAllNoeuds() {
    List<Noeud> noeudList = new LinkedList<>();
    for (AbstractPointChemin points : getAllAbstractPointChemin()) {
      if (points.getName().equals("Noeud")) {
        noeudList.add((Noeud) points);
      }
    }
    return noeudList;
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

  public boolean isArcPresent(Element element) {
    for (Arc arc : getAllArcs()) {
      if (arc.contains(element.getX(), element.getY())) {
        return true;
      }
    }
    return false;
  }

  private boolean intersectAny(Element element) {
    return getAllElements().stream().anyMatch(element::intersect);
  }

  private boolean intersectAnyForArc(Arc arc) {
    List<Element> testElements =
        getAllElements().stream()
            .filter(element -> (!element.equals(arc.arrival) && !element.equals(arc.starting)))
            .collect(Collectors.toList());
    return testElements.stream().anyMatch(arc::intersect);
  }
}
