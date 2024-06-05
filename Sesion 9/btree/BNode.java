import java.util.ArrayList;

public class BNode<E extends Comparable<E>>{
    protected ArrayList<E> keys;
    protected ArrayList<BNode<E>> childs;
    protected int count;
    protected int idNode;
    public static int idNodeStatic = 0;

    public BNode (int n){
        this.keys = new ArrayList<E>(n);
        this.childs = new ArrayList<BNode<E>>(n+1);
        this.count = 0;
        for(int i=0; i < n; i++){
            this.keys.add(null);
            this.childs.add(null);
        }
        idNodeStatic++;
        this.idNode = idNodeStatic;
    }
    //Check if the current node is full
    public boolean nodeFull(int order){
        return (count == order-1);
    }
    //Check if the current node is empty
    public boolean nodeEmpty(){
        return (count == 0);
    }
    //Search for a key in the current node, if found it returns true and
    //the position where it is located, otherwise, returns false and the
    //position of the child where it should descend.
    public boolean searchNode(E x, int[] position){
        if(this.keys.contains(x)){
            int iterator = 0;
            for(E i : this.keys){
                if(x == i){
                    position[0] = iterator;
                    break;
                }
                iterator++;
            }
            return true;
        }else{
            int pos = 0;
            boolean isMinorFlag = true;
            for(E i : this.keys){
                if(i.compareTo(x) > 0){
                    isMinorFlag = false;
                    break;
                }
                pos++;
            }
            if(isMinorFlag){
                position[0] = pos+1;
            }else{
                position[0] = pos;
            }
            return false;
        }
    }
    //Return the keys found in the node.
    public String toString(){
        String str = ""+idNode+": [";
        if(nodeEmpty()){
            str += "null]";
        }else{
            str += this.keys.get(0);
            for(int i = 1; i < this.count; i++){
                str += (", "+this.keys.get(i));
            }
            str += "]";
        }
        return str;
    }
}