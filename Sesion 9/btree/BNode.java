/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package test;

/**
 *
 * @author Asus
 */
import java.util.ArrayList;

public class BNode<E extends Comparable<E>> {

    private static int nextId = 0; // static variable to keep track of the next ID
    protected int idNode; // unique ID for each node
    protected ArrayList<E> keys;
    protected ArrayList<BNode<E>> childs;
    protected int count;
    protected BNode<E> parent; // parent node reference

    public BNode(int n) {
        this.idNode = nextId++;
        this.keys = new ArrayList<>(n);
        this.childs = new ArrayList<>(n + 1); // +1 to hold n+1 children
        this.count = 0;
        this.parent = null; // initialize parent as null
        for (int i = 0; i < n; i++) {
            this.keys.add(null);
            this.childs.add(null);
        }
        this.childs.add(null); // extra child for n+1 children
    }

    // Check if the current node is full
    public boolean nodeFull(int maxKeys) {
        return this.count == maxKeys;
    }

    // Check if the current node is empty
    public boolean nodeEmpty() {
        return this.count == 0;
    }

    // Search for a key in the current node
    public boolean searchNode(E key, int[] pos) {
        pos[0] = 0;
        while (pos[0] < this.count && key.compareTo(this.keys.get(pos[0])) > 0) {
            pos[0]++;
        }
        return pos[0] < this.count && key.compareTo(this.keys.get(pos[0])) == 0;
    }

    // Return the keys found in the node, including the idNode
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Node ID: ").append(this.idNode).append(" Keys: ");
        for (int i = 0; i < this.count; i++) {
            sb.append(this.keys.get(i)).append(" ");
        }
        return sb.toString();
    }
}
