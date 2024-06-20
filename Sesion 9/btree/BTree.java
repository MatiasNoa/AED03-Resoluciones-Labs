
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class BTree<E extends Comparable<E>> {
    private BNode<E> root; // La raiz del arbol
    private int orden; // Orden del arbol
    private boolean up; // Verifica si pudo haber cambios en el nodo padre
    private BNode<E> nDes; // Nodo adicional para los cambios

    public BTree(int orden) {
        this.orden = orden;
        this.root = null; // Inicializa la raíz como nula al crear el árbol
    }

    public boolean isEmpty() {
        return this.root == null; // Verifica si el árbol está vacío
    }

    // Método insert
    public void insert(E cl) { // Recibe la clave a insertar
        this.up = false; // Inicializa la variable de cambio a falso
        E mediana;
        BNode<E> pnew; // Se crea un nodo para los cambios
        mediana = push(this.root, cl); // Busca la mediana en el nodo raíz al insertar la clave
        if (up) { // Si hubo cambio
            pnew = new BNode<E>(this.orden); // Instancia un nuevo nodo
            pnew.count = 1; // Incrementa el contador ya que se insertó una clave
            pnew.keys.set(0, mediana); // Inserta la mediana en la posición 0
            pnew.childs.set(0, this.root); // Inserta los elementos de la raíz en el hijo 0
            pnew.childs.set(1, nDes); // Inserta los hijos divididos en la siguiente posición
            this.root = pnew; // La nueva raíz es la mediana insertada anteriormente
        }
    }

    // Método para insertar la mediana
    private E push(BNode<E> actual, E cl) {
        int[] pos = new int[1]; // Arreglo para la posición de la clave
        E mediana;
        if (actual == null) { // Si el nodo actual es nulo
            up = true; // Hubo cambio
            nDes = null; // Nodo adicional es nulo
            return cl; // Retorna la clave
        } else {
            boolean fl;
            fl = actual.searchNode(cl, pos); // Busca la clave en el nodo actual
            if (fl) { // Si encuentra la clave
                System.out.println("Item duplicado"); // Muestra mensaje de duplicado
                up = false; // No hubo cambio
                return null; // Retorna nulo
            }
            mediana = push(actual.childs.get(pos[0]), cl); // Llama recursivamente para buscar la mediana
            if (up) { // Si hubo cambio
                if (actual.nodeFull(this.orden - 1)) // Si el nodo está lleno
                    mediana = dividedNode(actual, mediana, pos[0]); // Divide el nodo por la mediana
                else {
                    up = false; // No hubo cambio
                    putNode(actual, mediana, nDes, pos[0]); // Inserta la clave en el nodo actual
                }
            }
            return mediana; // Retorna la mediana
        }
    }

    // Método para insertar las claves en los nodos hijos
    private void putNode(BNode<E> actual, E cl, BNode<E> rd, int k) {
        int i;
        for (i = actual.count - 1; i >= k; i--) { // Desplaza las claves hacia la derecha para insertar espacio
            actual.keys.set(i + 1, actual.keys.get(i)); // Copia la clave
            actual.childs.set(i + 2, actual.childs.get(i + 1)); // Copia el hijo
        }
        actual.keys.set(k, cl); // Inserta la clave en la posición k
        actual.childs.set(k + 1, rd); // Inserta el hijo en la siguiente posición
        actual.count++; // Incrementa el contador del nodo actual
    }

    // Método para dividir el nodo por su mediana
    private E dividedNode(BNode<E> actual, E cl, int k) {
        BNode<E> rd = nDes; // Nodo derecho
        int i, posMdna;
        posMdna = (k <= this.orden / 2) ? this.orden / 2 : (this.orden / 2) + 1; // Calcula la posición de la mediana
        nDes = new BNode<>(this.orden); // Crea un nuevo nodo adicional
        for (i = posMdna; i < this.orden - 1; i++) { // Recorre las claves para dividir el nodo
            nDes.keys.set(i - posMdna, actual.keys.get(i)); // Copia la clave
            nDes.childs.set(i - posMdna + 1, actual.childs.get(i + 1)); // Copia el hijo
        }
        nDes.count = (this.orden - 1) - posMdna; // Actualiza el contador del nodo adicional
        actual.count = posMdna; // Actualiza el contador del nodo actual
        if (k <= this.orden / 2)
            putNode(actual, cl, rd, k); // Inserta la clave en el nodo actual
        else
            putNode(nDes, cl, rd, k - posMdna); // Inserta la clave en el nodo adicional
        E median = actual.keys.get(actual.count - 1); // Obtiene la mediana
        nDes.childs.set(0, actual.childs.get(actual.count)); // Copia el hijo del nodo actual
        actual.count--; // Decrementa el contador del nodo actual
        return median; // Retorna la mediana
    }

    // Método Search
    public void search(E cl) {
        int[] pos = new int[1]; // Arreglo para la posición de la clave
        if (search(cl, this.root, pos)) return; // Llama al método search con la clave, la raíz y la posición
        else System.out.println("No existe la clave"); // Si no encuentra la clave, muestra mensaje
    }

    private boolean search(E cl, BNode<E> actual, int[] pos) {
        boolean fl;
        if (actual == null) { // Si el nodo actual es nulo
            return false; // Retorna falso
        } else {
            fl = actual.searchNode(cl, pos); // Llama al método searchNode del BNode
            if (fl) { // Si encuentra la clave
                System.out.println(cl + " se encuentra en el nodo " + actual.idNode + " en la posicion " + pos[0]);
                return true; // Retorna verdadero
            } else {
                return search(cl, actual.childs.get(pos[0]), pos); // Llama recursivamente al método search con la clave y la posición del hijo
            }
        }
    }

    // Método Remove
    public void remove(E cl) {
        if (this.root == null) // Si el árbol está vacío
            System.out.println("El arbol esta vacio");

        if (remove(cl, this.root)) // Llama al método remove con la clave y la raíz
            System.out.println("La clave " + cl + " se ha eliminado");
        else
            System.out.println("No existe la clave en el arbol");

        if (this.root.count == 0) { // Si el contador de la raíz es cero
            if (this.root.childs.get(0) == null)
                this.root = null; // La raíz es nula
            else
                this.root = this.root.childs.get(0); // La raíz es el hijo
        }
    }

    private boolean remove(E cl, BNode<E> actual) {
        int[] pos = new int[1]; // Arreglo para la posición de la clave
        boolean fl;
        if (actual == null) { // Si el nodo actual es nulo
            return false; // No existe la clave en el árbol
        } else {
            fl = actual.searchNode(cl, pos); // Busca la clave en el nodo actual
            if (fl) { // Si encuentra la clave
                if (actual.childs.get(pos[0]) == null) { // Si es un nodo hoja
                    removeKey(actual, pos[0]); // Elimina la clave
                    return true; // Retorna verdadero
                } else { // Si no es un nodo hoja
                    E pred = getPredecessor(actual, pos[0]); // Busca el predecesor
                    actual.keys.set(pos[0], pred); // Reemplaza la clave con el predecesor
                    boolean isremove = remove(pred, actual.childs.get(pos[0])); // Llama recursivamente para eliminar
                    if (actual.childs.get(pos[0]).count < (orden - 1) / 2 || actual.childs.get(pos[0] + 1).count < (orden - 1) / 2)
                        //verificar si los hijos del nodo actual (actual) cumplen con la propiedad de mínimos claves requeridas en un árbol B
                        fix(actual, pos[0]); // Llama al método fix para reestructurar el árbol
                    return isremove; // Retorna el resultado de la eliminación
                }
            } else {
                if (actual.childs.get(pos[0]) == null) {
                    return false; // No existe la clave en el árbol
                } else {
                    boolean isDeleted = remove(cl, actual.childs.get(pos[0])); // Busca la clave entre los hijos recursivamente
                    if (actual.childs.get(pos[0]).count < (orden - 1) / 2) { // Si no cumple con la capacidad mínima
                        fix(actual, pos[0]); // Llama al método fix para reestructurar el árbol
                    }
                    return isDeleted; // Retorna el resultado de la eliminación
                }
            }
        }
    }

    // Método para eliminar la clave del nodo
    private void removeKey(BNode<E> actual, int index) {
        for (int i = index; i < actual.count - 1; i++) { // Recorre las claves desde la posición hasta el final
            actual.keys.set(i, actual.keys.get(i + 1)); // Desplaza las claves hacia la izquierda
        }
        actual.keys.set(actual.count - 1, null); // Deja vacío el espacio
        actual.count--; // Decrementa el contador del nodo actual
    }

    // Método para obtener el predecesor
    private E getPredecessor(BNode<E> actual, int index) {
        BNode<E> current = actual.childs.get(index); // Obtiene el nodo actual
        while (current.childs.get(current.count) != null) // Recorre las claves del hijo hasta el último
            current = current.childs.get(current.count); // Actualiza el nodo actual
        return current.keys.get(current.count - 1); // Retorna la última clave del lado izquierdo
    }

    // Método para reestructurar el árbol
    private void fix(BNode<E> parent, int index) {
        if (index > 0 && parent.childs.get(index - 1).count > (orden - 1) / 2) // Si existe un hermano izquierdo
            borrowFromLeft(parent, index); // Llama al método borrowFromLeft para redistribuir a la izquierda
        else if (index <= 0 && parent.childs.get(index + 1).count > (orden - 1) / 2)
            borrowFromRight(parent, index); // Llama al método borrowFromRight para redistribuir a la derecha
        else {
            if (index > 0)
                merge(parent, index - 1); // Llama al método merge para fusionar con el hermano izquierdo
            else
                merge(parent, index); // Llama al método merge para fusionar con el hermano derecho
        }
    }

    // Método para redistribuir a la izquierda
    private void borrowFromLeft(BNode<E> parent, int index) {
        BNode<E> left = parent.childs.get(index - 1); // Obtiene el nodo hermano izquierdo
        BNode<E> current = parent.childs.get(index); // Obtiene el nodo derecho
        for (int i = current.count - 1; i >= 0; i--) // Desplaza las claves a la derecha dentro del nodo
            current.keys.set(i + 1, current.keys.get(i)); // Mueve la clave en la posición 'i' a la posición 'i + 1'
        current.keys.set(0, parent.keys.get(index - 1)); // Inserta la clave del padre en la posición 0
        parent.keys.set(index - 1, left.keys.get(left.count - 1)); // Inserta la clave del hermano izquierdo en el padre
        left.keys.set(left.count - 1, null); // Deja vacío el espacio
        if (left.childs.get(left.count) != null) { // Si el hermano izquierdo tiene hijos
            for (int i = current.count; i >= 0; i--)
                current.childs.set(i + 1, current.childs.get(i)); // Desplaza los hijos a la derecha dentro del nodo
            current.childs.set(0, left.childs.get(left.count)); // Inserta el hijo del hermano izquierdo en la posición 0
            left.childs.set(left.count, null); // Deja vacío el espacio
        }
        current.count++; // Incrementa el contador del nodo actual
        left.count--; // Decrementa el contador del hermano izquierdo
    }

    // Método para redistribuir a la derecha
    private void borrowFromRight(BNode<E> parent, int index) {
        BNode<E> right = parent.childs.get(index + 1); // Obtiene el nodo hermano derecho
        BNode<E> current = parent.childs.get(index); // Obtiene el nodo izquierdo
        current.keys.set(current.count, parent.keys.get(index)); // Inserta la clave del padre en la posición actual
        parent.keys.set(index, right.keys.get(0)); // Inserta la clave del hermano derecho en el padre
        right.keys.set(0, null); // Deja vacío el espacio
        for (int i = 0; i < right.count; i++) // Recorre las claves del hermano derecho
            right.keys.set(i, right.keys.get(i + 1)); // Desplaza las claves a la izquierda
        if (right.childs.get(right.count) != null) { // Si el hermano derecho tiene hijos
            for (int i = current.count; i >= 0; i--)
                current.childs.set(i + 1, current.childs.get(i)); // Desplaza los hijos a la derecha dentro del nodo
            current.childs.set(0, right.childs.get(right.count)); // Inserta el hijo del hermano derecho en la posición 0
            right.childs.set(right.count, null); // Deja vacío el espacio
        }
        current.count++; // Incrementa el contador del nodo actual
        right.count--; // Decrementa el contador del hermano derecho
    }

    // Método para fusionar nodos
    private void merge(BNode<E> parent, int index) {
        BNode<E> left = parent.childs.get(index); // Obtiene el nodo hermano izquierdo
        BNode<E> current = parent.childs.get(index + 1); // Obtiene el nodo derecho
        left.keys.set(left.count, parent.keys.get(index)); // Inserta la clave del padre en el nodo izquierdo
        for (int i = 0; i <= current.count - 1; i++) // Recorre las claves del nodo derecho
            left.keys.set(left.count + i + 1, current.keys.get(i)); // Copia las claves al nodo izquierdo
        if (current.childs.get(current.count) != null) { // Si el nodo derecho tiene hijos
            for (int i = 0; i <= current.count; i++)
                left.childs.set(left.count + i + 1, current.childs.get(i)); // Copia los hijos al nodo izquierdo
        }
        for (int i = index + 1; i < parent.count; i++) {
            parent.keys.set(i - 1, parent.keys.get(i)); // Desplaza las claves del padre a la izquierda
            parent.childs.set(i, parent.childs.get(i + 1)); // Desplaza los hijos del padre a la izquierda
        }
        left.count += current.count + 1; // Actualiza el contador del nodo izquierdo
        parent.count--; // Decrementa el contador del padre
        current = null; // Elimina el nodo derecho
    }

    // Método estático para construir el árbol B a partir de un archivo
    public static BTree<Integer> building_Btree(String fileName) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(fileName)); // Lee el archivo
        int orden = Integer.parseInt(reader.readLine().trim()); // Lee el orden del árbol
        BTree<Integer> bTree = new BTree<>(orden); // Crea un nuevo árbol B de enteros con el orden especificado

        String line;
        while ((line = reader.readLine()) != null) { // Lee cada línea del archivo
            String[] parts = line.split(","); // Divide la línea por comas
            int idNodo = Integer.parseInt(parts[1]); // Obtiene el ID del nodo
            BNode<Integer> node = new BNode<>(orden); // Crea un nuevo nodo con el orden especificado
            for (int i = 2; i < parts.length; i++) {
                int key = Integer.parseInt(parts[i].trim()); // Obtiene la clave del nodo
                node.keys.set(i - 2, key); // Agrega la clave al nodo
                bTree.insert(key); // Inserta la clave en el árbol B
            }
        }

        reader.close(); // Cierra el lector de archivos
        return bTree; // Retorna el árbol B construido
    }

    @Override
    public String toString() {
        String s = ""; // Inicializa la cadena de retorno
        String concat = ""; // Inicializa la cadena de concatenación
        if (isEmpty()) {
            s += "BTree is empty..."; // Agrega un mensaje de árbol vacío si está vacío
        } else {
            s = "Id.Nodo\t\tClaves Nodo\t\tId.Padre\t\tId.Hijos\n"; // Encabezados de las columnas
            s += writeTree(this.root, null, concat); // Llama al método writeTree para escribir el árbol
        }
        return s; // Retorna la representación en cadena del árbol B
    }

    // Método recursivo para escribir el árbol en forma de cadena
    private String writeTree(BNode<E> actual, BNode<E> parent, String concat) {
        concat += actual + "\t\t\t"; // Concatena el nodo actual
        if (parent == null) {
            concat += "--"; // Si no hay padre, agrega guiones
        } else {
            concat += parent.idNode; // Agrega el ID del padre
        }

        concat += "\t\t\t ["; // Inicia la lista de hijos
        for (int i = 0; i <= actual.count; i++) { // Recorre los hijos del nodo actual
            if (actual.childs.get(i) != null) {
                concat += actual.childs.get(i).idNode; // Agrega el ID del hijo
                if (i < actual.count) concat += ", "; // Si no es el último hijo, agrega una coma
            }
        }
        concat += "]\n"; // Cierra la lista de hijos

        for (BNode<E> child : actual.childs) { // Recorre los hijos del nodo actual
            if (child != null) {
                concat += writeTree(child, actual, ""); // Llama recursivamente al método para cada hijo
            }
        }
        return concat; // Retorna la cadena concatenada con la estructura del árbol
    }
}