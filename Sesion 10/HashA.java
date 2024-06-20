import java.util.ArrayList;
import java.io.*;

public class HashA<E extends Comparable<E>> {

    protected ArrayList<ListLinked<Register<E>>> table;
    protected int m;

    public HashA(int n) {
        this.m = findClosestPrime(n);
        this.table = new ArrayList<>(m);
        for (int i = 0; i < m; i++) {
            this.table.add(new ListLinked<Register<E>>());
        }
    }

    private int functionHash(int key) {
        return key % m;
    }

    public void insert(int key, E reg) {
        int hash = functionHash(key);
        Register<E> newRegister = new Register<>(key, reg);
        table.get(hash).insertLast(newRegister);
    }

    public E search(int key) {
        int hash = functionHash(key);
        ListLinked<Register<E>> listaEnlazada = table.get(hash);

        Register<E> registro = new Register<E>(key, null);
        int pos = listaEnlazada.search(registro);
        if(pos != -1){
            E valor = listaEnlazada.getNth(pos).value;
            return valor;
        }
        return null; 
    }
    
    public void readFromFile(String filename) {
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            int numberOfElements = Integer.parseInt(br.readLine().trim());
            this.m = findClosestPrime((int) (numberOfElements * 1.4));
            this.table = new ArrayList<>(m);
            for (int i = 0; i < m; i++) {
                this.table.add(new ListLinked<Register<E>>());
            }
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                int key = Integer.parseInt(parts[0].trim());
                E value = (E) parts[1].trim();
                insert(key, value);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder("D.Real\tD.Hash\tRegisters\n");
        for (int i = 0; i < table.size(); i++) {
            s.append(i).append(" -->\t");
            ListLinked<Register<E>> list = table.get(i);
            if (!list.isEmptyList()) {
                s.append(functionHash(list.getFirst().getData().key)).append("\t").append(list).append("\n");
            } else {
                s.append("empty\n");
            }
        }
        return s.toString();
    }

    private int findClosestPrime(int x) {
        if (x <= 1) {
            return 2;
        }
        int prime = x;
        while (true) {
            if (isPrime(prime)) {
                return prime;
            }
            prime++;
        }
    }

    private boolean isPrime(int x) {
        if (x <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(x); i++) {
            if (x % i == 0) {
                return false;
            }
        }
        return true;
    }
}