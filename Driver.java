/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csc401finishedprob6;

import java.util.Scanner;

/**
 *
 * @author Hector Felix
 */
public class Driver {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        UndirectedGraph ug = new UndirectedGraph();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the Number of Nodes:");
        int n = sc.nextInt();
        
        for (int i = 1; i <= n; i++) { // created node vertex
            Node vertexNode = new Node(i); // create node for ug
            ug.getVertexList().add(vertexNode); // add new node to ug
        }

        DHArrayList<Node> al = ug.getVertexList();
        for (int i = 0; i < al.getSize(); i++) {
            Node vNode1 = al.get(i);
            for (int j = 0; j < al.getSize(); j++) {
                Node vNode2 = al.get(j);
                if (!vNode1.equals(vNode2)) {
                    int rand = (int) (Math.random() * 4);
                    if (rand < 1) {
                        vNode1.getConnectedList().add(vNode2); // adding to show they are connected to one another
                        vNode2.getConnectedList().add(vNode1);
                    }
                }
            }
        }
        
        

//     System.out.println(al);
//     System.out.println(ug);
//     System.out.println(gn1);
//     System.out.println(gn2);
        
        System.out.println("Enter Starting Vertex:");
        int start = sc.nextInt();
        System.out.println("~-~-~-~-~-~-~-~");
        Node initialVertex = null;
        for (int i = 0; i < al.getSize(); i++) { // match entered starting node to node in undirected graph
            Node vNode = al.get(i);
           if (start == vNode.getData()) {
                initialVertex = vNode;
                break;
            }
        }
        
        String nodeList = "";
        for (int i = 1; i <= n; i++) {
            if (i < n) {
                nodeList += i + ",";
            } else {
                nodeList += i;
            }
        }

        System.out.println("Node List: {" + nodeList + "}");
        System.out.println(ug);
        //System.out.println(al);
        
        UndirectedGraph.bfs(initialVertex);
    }
}
