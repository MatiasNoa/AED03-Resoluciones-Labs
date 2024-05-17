package Actividades.actividad3;

public class BSTree<E extends Comparable<E>>{
    class Node{
        protected E data;
        protected Node left, right;

        public Node(E data){
            this (data,null,null);
        }
        public Node(E data, Node left, Node right){
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }

    private Node root;

    public BSTree(){ this.root = null; }
    public boolean isEmpty(){ return this.root == null; }

    public void insert(E x){
        Node newNode = new Node(x);
        if(isEmpty()){
            root = newNode;
        }else{
            Node p = null;
            Node current = root;
            boolean isLeftChild = true;
            while(current != null){
                p = current;
                if(x.compareTo(p.data)<0){
                    current = current.left;
                }else if(x.compareTo(p.data)>0){
                    current = current.right;
                    isLeftChild = false;
                }else{
                    System.out.println("No se admiten duplicados");
                    return;
                }
                if(isLeftChild){
                    p.left = newNode;
                }else{
                    p.right = newNode;
                }
            }
        }
    }
    public E search(E x) throws ItemNotFound{
        try{
            Node current = root;
            while(current != null){
                if(x.compareTo(current.data) < 0){
                    current = current.left;
                }else if(x.compareTo(current.data) > 0){
                    current = current.right;
                }else{
                    return current.data;
                }
            }
            throw new ItemNotFound("Dato no encontrado");
        }catch(ItemNotFound e){
            e.printStackTrace();
            return null;
        }
    }
    public void remove(E x) throws ItemNotFound{
        try{
            Node p = null;
            Node current = root;
            while(current != null && current.data != x){
                p = current;
                if(x.compareTo(current.data) < 0){
                    current = current.left;
                }else{
                    current = current.right;
                }
            }
            if(current == null){
                throw new ItemNotFound("Dato no encontrado");
            }
            //CASO1: Nodo a eliminar con 0 hijos
            if(current.left == null && current.right == null){
                if(x.compareTo(p.data)<0){
                    p.left = null;
                }else{
                    p.right = null;
                }
                return;
            }
            //CASO2: Nodo a eliminar con 1 hijos
            if(current.right == null){//Nodo a eliminar tiene hijo izquierdo
                if(x.compareTo(p.data)<0){
                    p.left = current.left;
                }else{
                    p.right = current.left;
                }
                return;
            }else if(current.left == null){//Nodo a eliminar tiene hijo derecho
                if(x.compareTo(p.data)<0){
                    p.left = current.right;
                }else{
                    p.right = current.right;
                }
                return;
            }
            //CASO3: Nodo a eliminar con 2 hijos
            Node minorOfMax = subeliminacion(current);
            current.data = minorOfMax.data;
        }catch(ItemNotFound e){
            e.printStackTrace();
            return;
        }
    }
    @Override
    public String toString(){}

    Node subeliminacion(Node c){
        Node p = c;
        Node aux = c;
        aux = aux.right;
        while(aux.left != null){
            p = aux;
            aux = aux.left;
        }
        p.left = aux.right;
        return aux;
    }
}