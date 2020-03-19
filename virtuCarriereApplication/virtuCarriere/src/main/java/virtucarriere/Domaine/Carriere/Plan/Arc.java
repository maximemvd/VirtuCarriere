/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package virtucarriere.Domaine.Carriere.Plan;

public class Arc {
    private Coordonnees starting;
    private Coordonnees arrival;

    public Arc(Coordonnees starting, Coordonnees arrival){
        //TODO ajouter verification que les deux coordonnees contiennent des objets
        this.starting = starting;
        this.arrival = arrival;
    }
}
