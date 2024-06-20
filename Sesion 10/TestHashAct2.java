//ACTIVIDAD 2
public class TestHashAct2 {
    public static void main(String[] args) {
        HashC<String> hash = new HashC<String>(11);
        hash.insert(34, "Alice");
        hash.insert(3, "Bob");
        hash.insert(7, "Charlie");
        hash.insert(30, "David");
        hash.insert(11, "Eve");
        hash.insert(8, "Frank");
        hash.insert(7, "Grace");
        hash.insert(23, "Helen");
        hash.insert(41, "Isaac");
        hash.insert(16, "Jane");
        hash.insert(34, "Alice");
        System.out.println(hash);
    }
}