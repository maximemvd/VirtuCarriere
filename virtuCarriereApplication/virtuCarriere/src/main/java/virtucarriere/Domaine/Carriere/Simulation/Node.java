/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package virtucarriere.Domaine.Carriere.Simulation;

public class Node {
    private int cost;
    private int numberNode;

    public Node() {
    };

    public Node(int numberNode, int cost) {
        this.numberNode = numberNode;
        this.cost = cost;
    }

    public int compare(Node nodeA, Node NodeB) {
        System.out.println(nodeA.numberNode);
        System.out.println(NodeB.numberNode);

        if (nodeA.cost < NodeB.cost) {
            return -1;
        }
        if (nodeA.cost > NodeB.cost) {
            return 1;
        } else {
            return 0;
        }
    }

}
