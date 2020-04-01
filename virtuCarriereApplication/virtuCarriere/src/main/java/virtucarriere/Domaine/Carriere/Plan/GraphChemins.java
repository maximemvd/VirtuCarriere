package virtucarriere.Domaine.Carriere.Plan;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.Vector;

public class GraphChemins extends AbstractGraph<Noeud, Arc> {

  public double getCost(Arc arc) {
    return arc.getCost();
  }

  public Vector<Noeud> getShortestPathBetweenTwoNoeuds(Noeud start, Noeud end) {
    Vector<DataDijkstra> result = new Vector<DataDijkstra>();
    List<DataDijkstra> data = new java.util.ArrayList<>(Collections.emptyList());

    ends.forEach(
        treatingEnd -> {
          data.add(new DataDijkstra(treatingEnd, Double.MAX_VALUE));
        });

    data.stream()
        .filter(dataDijkstra -> dataDijkstra.getEnd().equals(start))
        .findFirst()
        .ifPresent(dataDijkstra -> dataDijkstra.setTotalCost(0));

    DataDijkstra treating;
    do {
      treating = data.stream().min(Comparator.comparing(DataDijkstra::getTotalCost)).get();
      data.remove(treating);
      result.add(treating);
      final double[] newCost = new double[1];
      final double[] oldCost = new double[1];
      final double[] linkCost = new double[1];

      List<Noeud> adj = super.getAdjacentsOut(treating.getEnd());
      DataDijkstra finalTreating = treating;
      data.stream()
          .filter(dataDijkstra -> adj.contains(dataDijkstra.getEnd()))
          .findFirst()
          .ifPresent(
              dataDijkstra -> {
                linkCost[0] =
                    super.getLink(finalTreating.getEnd(), dataDijkstra.getEnd()).getCost();
                oldCost[0] = dataDijkstra.getTotalCost();
                newCost[0] = linkCost[0] + finalTreating.getTotalCost();
                if (newCost[0] < oldCost[0]) {
                  dataDijkstra.setTotalCost(newCost[0]);
                  dataDijkstra.setPredecessor(finalTreating.getEnd());
                }
              });

    } while (!data.isEmpty());

    return buildPath(start, end, result);
  }

  private Vector<Noeud> buildPath(Noeud start, Noeud end, Vector<DataDijkstra> afterAlgo) {
    Vector<Noeud> path = new Vector<Noeud>();

    final Noeud[] now = {end};
    Optional<DataDijkstra> treating;
    do {
      treating =
          afterAlgo.stream()
              .filter(dataDijkstra -> dataDijkstra.getEnd().equals(now[0]))
              .findFirst();
      treating.ifPresent(
          dataDijkstra -> {
            path.add(dataDijkstra.getPredecessor());
            now[0] = dataDijkstra.getPredecessor();
          });
    } while (!start.equals(now[0]));

    Collections.reverse(path);
    return path;
  }

  private class DataDijkstra {

    private Noeud predecessor = null;
    private Noeud end;
    private double totalCost;

    public DataDijkstra(Noeud end, double totalCost) {
      this.end = end;
      this.totalCost = totalCost;
    }

    public Noeud getEnd() {
      return end;
    }

    public double getTotalCost() {
      return totalCost;
    }

    public void setTotalCost(double totalCost) {
      this.totalCost = totalCost;
    }

    public void setPredecessor(Noeud end) {
      predecessor = end;
    }

    public Noeud getPredecessor() {
      return predecessor;
    }
  }
}
