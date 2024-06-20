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
        Element element = table.get(hash);
        element.chain.insertLast(newRegister);
        element.mark = 1;
    }

    public E search(int key) {
        int hash = functionHash(key);
        Element element = table.get(hash);
        if (element.mark == 1) {
            Node<Register<E>> current = element.chain.getFirst();
            while (current != null) {
                if (current.getData().key == key) {
                    return current.getData().value; 
                }
                current = current.getNext();
            }
        }
        return null; 
    }
    
    public void readFromFile(String filename) {
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            int numberOfElements = Integer.parseInt(br.readLine().trim());
            this.m = findClosestPrime((int) (numberOfElements * 1.4));
            this.table = new ArrayList<>(m);
            for (int i = 0; i < m; i++) {
                this.table.add(new Element());
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


    public String toString() {
        String s = "D.Real\tD.Hash\tRegisters\n";
        int i = 0;
        for (Element item : table) {
            s += (i++) + " -->\t";
            if (item.mark == 1) {
                s += functionHash(item.chain.getFirst().getData().key) + "\t" + item.chain + "\n";
            } else {
                s += "empty\n";
            }
        }
        return s;
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