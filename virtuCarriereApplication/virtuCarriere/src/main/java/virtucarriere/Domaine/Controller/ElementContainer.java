/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package virtucarriere.Domaine.Controller;
import virtucarriere.Domaine.Controller.Controller

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

public class ElementContainer {

    private ArrayList<Carriere> elementList;

    public void ElementContainer() {};

    public bool isEmpty() {
        boolean returnValue = false;
        if (elementList.size() == 0) {
            returnValue = true;
        }
        return returnValue;
    }

    public void addEquipement() {
    };



    public List getElementList() {
        return elementList;
    }

    public void setElementList(List elementList) {
        this.elementList = elementList;
    }

    public double getNumberOfElementsList()
    {
        return elementList.size();
    }

    public void addNoeud(double x, double y) {};

    public double getNextPosition() {};
}
