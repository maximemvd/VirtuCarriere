package virtucarriere.Domaine.Carriere.Plan;

public class Plan {
  GraphConvoyeur equipments = new GraphConvoyeur();
  GraphChemins chemins = new GraphChemins();

  void addArc(Arc arc) {
    chemins.addLink(arc);
  };

  void addBroyeur(Broyeur broyeur) {
    equipments.addEnd(broyeur);
  };

  void addConcasseur(Concasseur concasseur) {
    equipments.addEnd(concasseur);
  };

  void addConvoyeur(Convoyeur convoyeur) {
    equipments.addLink(convoyeur);
  };

  void addCrible(Crible crible) {
    equipments.addEnd(crible);
  };

  void addEntree(Entree entree) {
    chemins.addEnd(entree);
  };

  void addNoeud(Noeud noeud) {
    chemins.addEnd(noeud);
  };

  void addTas(Tas tas) {
    equipments.addEnd(tas);
  };
}
