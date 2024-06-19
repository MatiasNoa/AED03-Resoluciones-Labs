/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hash;

public class TestHash {

    public static void main(String[] args) {
//        HashC<String> hash = new HashC<String>(11);
        HashA<String> hash = new HashA<String>(7);
        
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
        hash.insert(34, "Andrea");
     
        hash.insert(34,"Juan");
        hash.insert(3,"Pedro");
        hash.insert(7,"Lucas");
        hash.insert(30,"Ana");
        hash.insert(11,"Carol");
        hash.insert(8,"Diana");
        hash.insert(7,"Marco");
        hash.insert(23,"Saul");
        hash.insert(41,"Kim");
        hash.insert(16,"Genne");
        hash.insert(34,"Luz");
        
        System.out.println(hash);
    }
}
