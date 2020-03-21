/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package virtucarriere.Domaine.Carriere.Simulation;
import java.util.ArrayList;
import virtucarriere.Domaine.Carriere.Simulation.Camion;

public class Simulation {

    private String nameSimulation;

    private  ArrayList<Camion> camionList;

    public Simulation(String name)
    {
        this.camionList = new ArrayList<Camion>();
        this.nameSimulation = name;
    }

    public void addCamion(Camion p_camion)
    {
        this.camionList.add(p_camion);
    }

    public void removeCamion(Camion p_camion)
    {
        try
        {
            this.camionList.remove(p_camion);
        }
        catch (Exception error)
        {
            System.out.println(error);
        }
    }

    public void changeName(String p_name)
    {
        this.nameSimulation = p_name;
    }

    public String getName()
    {
        return this.nameSimulation;
    }

    public ArrayList<Camion> getCamionList()
        {
            return this.camionList;
        }
}
