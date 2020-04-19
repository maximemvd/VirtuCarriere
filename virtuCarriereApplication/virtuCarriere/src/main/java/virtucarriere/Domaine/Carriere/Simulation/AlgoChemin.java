package virtucarriere.Domaine.Carriere.Simulation;

import java.awt.Point;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.Vector;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import virtucarriere.Domaine.Carriere.Plan.AbstractPointChemin;
import virtucarriere.Domaine.Carriere.Plan.Arc;
import virtucarriere.Domaine.Carriere.Plan.Element;
import virtucarriere.Domaine.Carriere.Plan.GraphChemins;

public class AlgoChemin {

  private GraphChemins graphChemins;

  public AlgoChemin(GraphChemins graphChemins) {
    this.graphChemins = graphChemins;
  }

  private List<Element> getElementContains(Point point) {
    return graphChemins.getEnds().stream()
        .filter(abstractPointChemin -> abstractPointChemin.contains(point.getX(), point.getY()))
        .collect(Collectors.toList());
  }

  public Vector<AbstractPointChemin> getShortestPathBetweenTowPoints(Point start, Point end) {
    Stream<Element> startElements = getElementContains(start).stream();
    AbstractPointChemin endElement = (AbstractPointChemin) getElementContains(end).get(0);
    Vector<AbstractPointChemin> result = null;
    if (startElements.anyMatch(element -> element instanceof AbstractPointChemin)) {
      AbstractPointChemin startPoint =
          (AbstractPointChemin)
              startElements
                  .filter(element -> element instanceof AbstractPointChemin)
                  .findFirst()
                  .get();
      result = getShortestPathBetweenTwoNoeuds(startPoint, endElement);
    } else {
      Stream<Element> arcsStart = startElements.filter(element -> element instanceof Arc);
      if (arcsStart.count() > 1) {
        List<AbstractPointChemin> startPoints =
            arcsStart
                .map(element -> (Arc) element)
                .map(Arc::getArrival)
                .collect(Collectors.toList());
        List<Vector<AbstractPointChemin>> possiblePath =
            startPoints.stream()
                .map(startPoint -> getShortestPathBetweenTwoNoeuds(startPoint, endElement))
                .collect(Collectors.toList());
        if (possiblePath.size() > 1) {
          result = null;
        } else {
          result = possiblePath.get(0);
        }
      }
    }
    return result;
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
