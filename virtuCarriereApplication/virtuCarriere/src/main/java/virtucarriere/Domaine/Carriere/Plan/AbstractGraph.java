package virtucarriere.Domaine.Carriere.Plan;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.Vector;
import java.util.stream.Collectors;

public abstract class AbstractGraph<End extends Element, Link extends AbstractLien<End>>
    implements Graph<End, Link> {

  protected Vector<End> ends;
  protected Vector<List<AbstractLien<End>>> links;

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
  public List<End> getAdjacentsIn(End end) {
    List<End> adjacentsIn = Collections.emptyList();
    links.forEach(
        l_link ->
            l_link.stream()
                .map(
                    link -> {
                      End endLink = link.getArrival();
                      if (endLink == end) {
                        adjacentsIn.add(link.getStarting());
                      }
                      return null;
                    }));
    return adjacentsIn;
  }

  @Override
  public List<End> getAdjacentsOut(End end) {
    int index = ends.indexOf(end);

    return links.elementAt(index).stream()
        .map(AbstractLien::getArrival)
        .collect(Collectors.toList());
  }

  protected Link getLink(End start, End end) {
    int index = ends.indexOf(start);
    Optional<Link> result =
        (Optional<Link>)
            links.elementAt(index).stream()
                .filter(endAbstractLien -> endAbstractLien.getArrival().equals(end))
                .findFirst();
    if (!result.isPresent()) {
      throw new RuntimeException("Le lien n'existe pas");
    }
    return result.get();
  }
}
