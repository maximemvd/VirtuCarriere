package virtucarriere.Domaine.Carriere.Plan;

import java.awt.Point;
import java.util.List;

public interface Graphe<End extends Point, Link extends AbstractLien<End>> {

  void addEnd(End end);

  void removeEnd(End end);

  boolean endExist(End end);

  void addLink(Link link);

  void removeLink(Link link);

  boolean linkExist(Link link);

  List<Lien<Point>> getAdjacents(End noeud);
}
