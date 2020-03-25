package virtucarriere.Domaine.Carriere.Plan;

import java.util.List;
import java.util.Vector;

public abstract class AbstractGraph<End extends Element, Link extends AbstractLien<End>>
    implements Graph<End, Link> {

  private Vector<End> ends;
  private Vector<List<AbstractLien<End>>> links;

  @Override
  public void addEnd(End end) {
    if (endExist(end)) {
      throw new RuntimeException("Le Point existe déja");
    }
    ends.add(end);
  }

  @Override
  public void removeEnd(End end) {
    if (endExist(end)) {
      ends.remove(end);
    } else {
      throw new RuntimeException("Ce neud n'existe pas");
    }
  }

  @Override
  public boolean endExist(End end) {
    return ends.contains(end);
  }

  @Override
  public void addLink(Link link) {
    if (linkExist(link)) {
      throw new RuntimeException("Cet arc existe déjà");
    }
  }

  @Override
  public void removeLink(Link link) {
    if (linkExist(link)) {
      links.remove(link);
    } else {
      throw new RuntimeException("Cet arc n'existe pas");
    }
  }

  public boolean linkExist(Link link) {
    return links.contains(link);
  }

  @Override
  public List<Lien<End>> getAdjacents(End noeud) {
    return null;
  }
}
