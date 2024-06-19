/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hash;

/**
 *
 * @author Asus
 */
public class TestHashEj3 {
    public static void main(String[] args) {
        HashA<String> hashTable = new HashA<>(10); 
        String filePath = "C:\\Users\\Asus\\OneDrive\\Documentos\\Pruebas code\\hash\\src\\hash\\EMPLEADO.TXT";
        hashTable.readFromFile(filePath);
        System.out.println(hashTable);;
    }
}
