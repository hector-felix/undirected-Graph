package csc401finishedprob6;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Hector Felix
 */
//Node structure of graph
class Node {
    private int data;
    
    private DHArrayList<Node> connectedList;
    
    boolean visited; //set node to visited for BFS

    Node(int data) {
        this.data = data;
        this.connectedList = new DHArrayList<>();
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public DHArrayList<Node> getConnectedList() {
        return connectedList;
    }

    public void setConnectedList(DHArrayList<Node> connectedList) {
        this.connectedList = connectedList;
    }

    @Override
    public String toString() {
        return "(" + this.data+")";
    }
}
