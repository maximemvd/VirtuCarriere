package virtucarriere.Domaine.Carriere.Simulation;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.Vector;
import virtucarriere.Domaine.Carriere.Plan.AbstractPointChemin;
import virtucarriere.Domaine.Carriere.Plan.GraphChemins;

public class AlgoChemin {

  private GraphChemins graphChemins;

  public AlgoChemin(GraphChemins graphChemins) {
    this.graphChemins = graphChemins;
  }

  public void setGraph(GraphChemins p_graphChemin) {
    graphChemins = p_graphChemin;
  }

  public Vector<AbstractPointChemin> getShortestPathBetweenTwoNoeuds(
      AbstractPointChemin start, AbstractPointChemin end) {
    Vector<DataDijkstra> result = new Vector<DataDijkstra>();
    List<DataDijkstra> data = new java.util.ArrayList<>(Collections.emptyList());

    graphChemins
        .getEnds()
        .forEach(
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
      List<AbstractPointChemin> adj = graphChemins.getAdjacentsOut(treating.getEnd());
      DataDijkstra finalTreating = treating;
      data.stream()
          .filter(dataDijkstra -> adj.contains(dataDijkstra.getEnd()))
          .forEach(
              (dataDijkstra -> {
                linkCost[0] =
                    graphChemins.getLink(finalTreating.getEnd(), dataDijkstra.getEnd()).getCost();
                oldCost[0] = dataDijkstra.getTotalCost();
                newCost[0] = linkCost[0] + finalTreating.getTotalCost();
                if (newCost[0] < oldCost[0]) {
                  dataDijkstra.setTotalCost(newCost[0]);
                  dataDijkstra.setPredecessor(finalTreating.getEnd());
                }
              }));

    } while (!data.isEmpty());

    DataDijkstra endOfPath =
        result.stream().filter(dataDijkstra -> dataDijkstra.getEnd().equals(end)).findFirst().get();
    if (endOfPath.getTotalCost() == Double.MAX_VALUE) {
      throw new RuntimeException("Aucun chemin n'existe entre ces deux noeuds");
    }

    return buildPath(start, end, result);
  }

  private Vector<AbstractPointChemin> buildPath(
      AbstractPointChemin start, AbstractPointChemin end, Vector<DataDijkstra> afterAlgo) {
    Vector<AbstractPointChemin> path = new Vector<>();

    final AbstractPointChemin[] now = {end};
    path.add(end);
    Optional<DataDijkstra> treating =
        afterAlgo.stream().filter(dataDijkstra -> dataDijkstra.getEnd().equals(now[0])).findFirst();
    do {
      treating.ifPresent(
          dataDijkstra -> {
            path.add(dataDijkstra.getPredecessor());
            now[0] = dataDijkstra.getPredecessor();
          });
      treating =
          afterAlgo.stream()
              .filter(dataDijkstra -> dataDijkstra.getEnd().equals(now[0]))
              .findFirst();
    } while (!start.equals(treating.get().getEnd()));

    Collections.reverse(path);
    return path;
  }

  private static class DataDijkstra {

    private AbstractPointChemin predecessor = null;
    private AbstractPointChemin end;
    private double totalCost;

    public DataDijkstra(AbstractPointChemin end, double totalCost) {
      this.end = end;
      this.totalCost = totalCost;
    }

    public AbstractPointChemin getEnd() {
      return end;
    }

    public double getTotalCost() {
      return totalCost;
    }

    public void setTotalCost(double totalCost) {
      this.totalCost = totalCost;
    }

    public void setPredecessor(AbstractPointChemin end) {
      predecessor = end;
    }

    public AbstractPointChemin getPredecessor() {
      return predecessor;
    }
  }
}
