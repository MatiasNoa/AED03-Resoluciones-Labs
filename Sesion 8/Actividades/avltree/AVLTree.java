package avltree;
public class AVLTree<E extends Comparable<E>> extends BSTree<E>{
    class NodeAVL extends Node{
        protected int bf;

        public NodeAVL(E data){
            super(data);
            this.bf = 0;
        }

        @Override
        public String toString() {
            String msg = "";
            msg+=data + " ["+bf+"]";
            return msg;
        }
    }
    private boolean height;//true: se sufrio un cambio en la altura

    //METODO INSERT
    public void insert(E x) throws ItemDuplicated{
        this.height = false;
        this.root = insert(x, (NodeAVL)this.root);
    }
    protected Node insert(E x, NodeAVL node) throws ItemDuplicated{
        NodeAVL fat = node;
        if (node == null){
            this.height = true;
            fat = new NodeAVL(x);
        }else{
            int resC = node.data.compareTo(x);
            if(resC == 0)
                throw new ItemDuplicated(x+" ya se encuentra en el arbol...");

            if(resC < 0){
                fat.right = insert(x, (NodeAVL)node.right);
                if(this.height)
                    switch(fat.bf){
                        case -1:
                            fat.bf = 0;
                            this.height = false;
                            break;
                        case 0:
                            fat.bf = 1;
                            this.height = true;
                            break;
                        case 1: //bf = 2
                            fat = balanceToLeft(fat);
                            this.height = false;
                            break;
                    }
            }else{
                    fat.left = insert(x, (NodeAVL)node.left);
                    if(this.height)
                        switch (fat.bf) {
                            case -1: //bf = -2
                                fat = balanceToRight(node);
                                this.height = false;
                                break;
                            case 0:
                                fat.bf = -1;
                                this.height = true;
                                break;
                            case 1:
                                fat.bf = 0;
                                this.height = false;
                                break;
                        }
                }
            }
            return fat;
    }

    //BALANCE TO LEFT
    private NodeAVL balanceToLeft(NodeAVL node){
        NodeAVL hijo = (NodeAVL)node.right;
        switch(hijo.bf){
            case 1:
                node.bf = 0;
                hijo.bf = 0;
                node = rotateSL(node);
                break;
        
            case -1:
                NodeAVL nieto = (NodeAVL)hijo.left;
                switch(nieto.bf){
                    case -1:
                        node.bf = 0;
                        hijo.bf = 1;
                        break;
                    case -0:
                        node.bf = 0;
                        hijo.bf = 0;
                        break;
                    case 1:
                        node.bf = 1;
                        hijo.bf = 0;
                        break;
                }
                nieto.bf = 0;
                node.right = rotateSR(hijo);
                node = rotateSL(node);
                break;
        }
        return node;
    }

    //BALANCE TO RIGHT
    private NodeAVL balanceToRight(NodeAVL node){
        NodeAVL hijo = (NodeAVL)node.left;
        switch(hijo.bf){
            case -1:
                node.bf = 0;
                hijo.bf = 0;
                node = rotateSR(node);
                break;
        
            case 1:
                NodeAVL nieto = (NodeAVL)hijo.right;
                switch(nieto.bf){
                    case -1:
                        node.bf = 0;
                        hijo.bf = 1;
                        break;
                    case -0:
                        node.bf = 0;
                        hijo.bf = 0;
                        break;
                    case 1:
                        node.bf = 1;
                        hijo.bf = 0;
                        break;
                }
                nieto.bf = 0;
                node.left = rotateSL(hijo);
                node = rotateSR(node);
                break;
        }
        return node;
    }

    //ROTATESL
    private NodeAVL rotateSL(NodeAVL node){
        NodeAVL p = (NodeAVL)node.right;//Se guarda el hijo derecho en p
        node.right = p.left;//el izquierdo de p, pasa a ser derecho del root
        p.left = node;//el root pasa a ser el izquierdo de p
        node = p;//p es ahora el nuevo root
        return node;
    }

    //ROTATESR
    private NodeAVL rotateSR(NodeAVL node){
        NodeAVL p = (NodeAVL)node.left;//Se guarda el hijo izquierdo en p
        node.left = p.right;//el derecho de p, pasa a ser izquierdo del root
        p.right = node;//el root pasa a ser el derecho de p
        node = p;//p es ahora el nuevo root
        return node;
    }
}
