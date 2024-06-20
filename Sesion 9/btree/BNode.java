
import java.util.ArrayList;

public class BNode<E extends Comparable<E>> {
    protected ArrayList<E> keys; //ArrayList de las claves de un nodo
    protected ArrayList<BNode<E>> childs; //Los hijos de un nodo
    protected int count; //Verifica cuantas claves eagrego al nodo
    protected int idNode; //El identificador de cada nodo
    public static int nro = 0; //Atributo estatico

    public BNode(int n) { //El constructor recibe el orden del arbol
        this.keys = new ArrayList<>(n); //Se crea un ArrayList de ese orden con un espacio extra para desplazamiento
        this.childs = new ArrayList<>(n+1); //Se crea un ArrayList de ese orden con un espacio extra para los hijos
        this.count = 0; //Como se crea se inicializa en 0
        for (int i = 0; i < n; i++) { //Hasta el orden n se crean claves nulas
            this.keys.add(null);
            this.childs.add(null);
        }
        this.idNode = nro + 1; //Se incrementa para el identificador de cada nodo
        nro++;
    }
    //Verifica si el nodo actual esta lleno
    public boolean nodeFull(int nodoLleno) { //Si el nodo esta lleno retorna true
        return this.count == nodoLleno;
    }

    //Verifica si el nodo actual esta vacio
    public boolean nodeEmpty() { //Si el nodo esta vacio retorna true
        return this.count == 0;
    }

    //Metodo para buscar una clave en el nodo actual, si se encuentra retornar true y la posicion
    //donde esta localizada, de lo contrario, retornar false y la posicion del hijo donde debe descender
    public boolean searchNode(E keys, int[] pos) { //Recibe la clave a buscar y una referencia de una posicion
        for(int i = 0; i < this.count; i++) { //Se recorre hasta la ultima posicion de la clave agregada
            pos[0] = i; //Pos se guarda segun i
            if(keys.compareTo(this.keys.get(i)) == 0) { //Si es igual se retorna true y la pos queda referenciada
                return true;
            }
            if(keys.compareTo(this.keys.get(i)) < 0) { //Si es menor retorna false
                return false;
            }
        }
        pos[0] += 1; //Si es mayor la clave quie se desea buscar pos sera +1
        return false; //Se retorna falso
    }

    //Retorna las claves encontrada en el nodo
    @Override
    public String toString() {
        String result = this.idNode + "\t\t\t" + "(";
        int i;
        for (i = 0; i <= this.count; i++) {
            if (i < this.count-1){
                result += this.keys.get(i) + ",";
            }
            else break;
        }
        result += this.keys.get(i) + ")";
        return result;
    }
}
