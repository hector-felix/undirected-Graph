/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csc401finishedprob6;

/**
 *
 * @author Hector Felix
 */
public class UndirectedGraph {

    private DHArrayList<Node> vertexList;

    UndirectedGraph() {
        this.vertexList = new DHArrayList<>();
    }

    public DHArrayList<Node> getVertexList() {
        return vertexList;
    }

    public void setVertexList(DHArrayList<Node> vertexList) {
        this.vertexList = vertexList;
    }

    public static void bfs(Node node) {
        Node parent;
        Node previousNode;
        if (node == null) {
            return;
        }
        DHArrayList<Node> runningQueue = new DHArrayList<>();
        runningQueue.add(node);
        runningQueue.add(null);
        node.visited = true;
        parent = null;
        previousNode = null;
        while (!runningQueue.isEmpty()) {
            Node currentNode = runningQueue.removeFirst();
            //System.out.println("test " + currentNode);
            if (currentNode == null) {
                parent = previousNode;
                System.out.println();
                if (runningQueue.isEmpty()) {
                    return;
                }
                currentNode = runningQueue.removeFirst();
            }

            if (currentNode != null && parent != null) {
                System.out.print(currentNode.getData() + "(" + parent.getData() + ") ");
                DHArrayList<Node> connectedNodesList = currentNode.getConnectedList();
                for (int i = 0; i < connectedNodesList.getSize(); i++) {
                    Node checkNode = connectedNodesList.get(i);
                    if (checkNode != null && !checkNode.visited) {
                        runningQueue.add(checkNode);
                        checkNode.visited = true;
                    }
                }
                previousNode = currentNode;
                runningQueue.add(null);
            } else {
                if (currentNode != null) {
                    System.out.print(currentNode.getData());
                    DHArrayList<Node> nextNodes = currentNode.getConnectedList();
                    for (int i = 0; i < nextNodes.getSize(); i++) {
                        Node n = nextNodes.get(i);
                        if (n != null && !n.visited) {
                            runningQueue.add(n);
                            n.visited = true;
                        }
                    }
                    previousNode = currentNode;
                    runningQueue.add(null);
                }

            }

        }
    }

    @Override
    public String toString() {
        String s = "Edge List: {";
        int edgeListSize;
//        System.out.println(vertexList.get(0).getConnectedList());

        for (int i = 0; i < vertexList.getSize(); i++) {
            edgeListSize = vertexList.get(i).getConnectedList().getSize();
            for (int j = 0; j < edgeListSize; j++) {
                if (vertexList.get(i).getData() != vertexList.get(j).getData()) {
                    //System.out.println("I=" + i);
                    s += "(" + vertexList.get(i).getData() + "," + vertexList.get(i).getConnectedList().get(j).getData() + ")";
                    //s += "(" + vertexList.get(i).getData() + "," + vertexList.get(j).getData() + ")";

                    if (j != edgeListSize - 1) {
                        s += ",";
                    }
                }
            }
        }
        return s + "}\n";
    }
}
