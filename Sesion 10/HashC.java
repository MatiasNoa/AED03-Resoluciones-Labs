import java.util.ArrayList;
public class HashC<E extends Comparable<E>>{
    protected class Element{
        int mark;
        Register<E> reg;

        public Element(int mark, Register<E> reg){
            this.mark = mark;
            this.reg = reg;
        }
    }

    protected ArrayList<Element> table;
    protected int m;

    public HashC(int n){
        this.m = findClosestPrime(n);
        this.table = new ArrayList<Element>(m);
        for(int i = 0; i < m; i++){
            this.table.add(new Element(0, null));
        }
    }

    //FUNCIONES HASH
    // private int functionHash(int key){
    //     return key % m;
    // }

    private int functionHash(int key){
        int square = key * key;
        //Extraccion de los dígitos centrales
        String squareStr = String.valueOf(square);
        int len = squareStr.length();
        int a = Math.max(0, len / 2 - 1);
        int b = a + 2; // Tomamos dos dígitos centrales
        String digits = squareStr.substring(a, b);

        int squareKey = Integer.parseInt(digits);
        return squareKey % m;
    }

    private int functionFoldHashing(int key) {
        String keyStr = String.valueOf(key);
        int len = keyStr.length();
        int foldSize = Integer.toString(m).length();
    
        int sum = 0;
        for (int i = 0; i < len; i += foldSize) {
            String segment = keyStr.substring(i, Math.min(i + foldSize, len));
            int segmentInt = Integer.parseInt(segment);
            sum += segmentInt;
        }
        return sum % m;
    }

    private int linearProbing(int key){
        int dressHash = functionHash(key);
        int posInit = dressHash;
        do{
            if(table.get(dressHash).mark == 0){
                return dressHash; //Posición disponible encontrada
            }
            dressHash = (dressHash + 1) % m;
        }while(dressHash != posInit);
        return -1; //No hay espacio disponible
    }

    public void insert(int key, E reg){
        int position = linearProbing(key);
        if(position != -1){
            Register<E> newRegister = new Register<E>(key, reg);
            Element newElement = new Element(1, newRegister); //Marcar como ocupado (mark = 1)
            table.set(position, newElement);
            return;
        }else{
            System.out.println("Tabla Hash está llena");
            return;
        }
    }

    public E search(int key){
        int dressHash = functionHash(key);
        int posInit = dressHash;
        do{
            Element element = table.get(dressHash);
            if(element != null && element.mark == 1 && element.reg.key == key){
                return element.reg.value; //Se encontró la clave
            }
            dressHash = (dressHash + 1) % m;
        }while(dressHash != posInit);
        return null; //No se encontró la clave
    }

    public String toString(){
        String s = "D.Real\tD.Hash\tRegister\n";
        int i = 0;
        for(Element item : table){
            s += (i++) + " -->\t";
            if(item.mark == 1){
                s += functionHash(item.reg.key) + "\t" + item.reg + "\n";
            }else{
                s += "empty\n";
            }
        }
        return s;
    }

    private int findClosestPrime(int x){
        if(x <= 1){
            return 2;
        }
        int prime = x;
        while(true){
            if(isPrime(prime)){
                return prime;
            }
            prime++;
        }
    }
    private boolean isPrime(int x){
        if (x <= 1){
            return false;
        }
        for(int i = 2; i <= Math.sqrt(x); i++){
            if(x % i == 0){
                return false;
            }
        }
        return true;
    }
}