package btree;
import java.util.ArrayList;

public class BNode<E extends Comparable<E>> {

    private static int nextId = 0;
    protected int idNode;
    protected ArrayList<E> keys;
    protected ArrayList<BNode<E>> childs;
    protected int count;
    protected BNode<E> parent;

    public BNode(int n) {
        this.idNode = nextId++;
        this.keys = new ArrayList<>(n);
        this.childs = new ArrayList<>(n + 1);
        this.count = 0;
        this.parent = null;
        for (int i = 0; i < n; i++) {
            this.keys.add(null);
            this.childs.add(null);
        }
        this.childs.add(null);
    }

    public boolean nodeFull(int maxKeys) {
        return this.count == maxKeys;
    }

    public boolean nodeEmpty() {
        return this.count == 0;
    }

    public boolean searchNode(E key, int[] pos) {
        pos[0] = 0;
        while (pos[0] < this.count && key.compareTo(this.keys.get(pos[0])) > 0) {
            pos[0]++;
        }
        return pos[0] < this.count && key.compareTo(this.keys.get(pos[0])) == 0;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Node ID: ").append(this.idNode).append(" Keys: ");
        for (int i = 0; i < this.count; i++) {
            sb.append(this.keys.get(i)).append(" ");
        }
        return sb.toString();
    }
}
