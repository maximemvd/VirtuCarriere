package virtucarriere.Domaine.Carriere.Plan;

import java.util.List;

public interface Graph<End extends Element, Link extends AbstractLien<End>> {

  void addEnd(End end);

  void removeEnd(End end);

  boolean endExist(End end);

  void addLink(Link link);

  void removeLink(Link link);

  boolean linkExist(Link link);

  List<End> getAdjacentsIn(End end);

  List<End> getAdjacentsOut(End end);
}
