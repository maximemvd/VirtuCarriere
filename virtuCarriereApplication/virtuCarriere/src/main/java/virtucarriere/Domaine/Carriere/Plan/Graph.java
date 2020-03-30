package virtucarriere.Domaine.Carriere.Plan;

import java.util.List;

public interface Graph<End extends Element, Link extends AbstractLien<End>> {

  void addEnd(End end);

  void removeEnd(End end);

  boolean endExist(End end);

  void addLink(Link link);

  void removeLink(Link link);

  boolean linkExist(Link link);

  List<AbstractLien<End>> getAdjacentsIn(End end);

  List<AbstractLien<End>> getAdjacentsOut(End end);
}
