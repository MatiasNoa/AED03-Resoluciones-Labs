/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package graphlink;

/**
 *
 * @author Asus
 */
public class Edge<E extends Comparable<E>> {

    private Vertex<E> destinyReference;
    private int weight;

    public Edge(Vertex<E> destinyReference) {
        this(destinyReference, -1);
    }

    public Edge(Vertex<E> destinyReference, int weight) {
        this.destinyReference = destinyReference;
        this.weight = weight;
    }

    public Vertex<E> getDestinyReference() {
        return destinyReference;
    }

    public int getWeight() {
        return weight;
    }

    public boolean equals(Object o) {
        if (o instanceof Edge<?>) {
            Edge<E> e = (Edge<E>) o;
            return this.destinyReference.equals(e.destinyReference);
        }
        return false;
    }

    @Override
    public String toString() {
        if (this.weight > -1) {
            return destinyReference.getData() + " [" + this.weight + "], ";
        } else {
            return destinyReference.getData() + ", ";
        }
    }
}
