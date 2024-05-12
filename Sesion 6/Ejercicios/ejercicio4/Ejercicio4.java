/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicio4;

/**
 *
 * @author Asus
 */
public class Ejercicio4 {
    
    public static boolean parentesisDuplicados(String exp) throws ExceptionIsEmpty {
        StackLink<Character> pila = new StackLink<>();
        for (int i = 0; i < exp.length(); i++) {
            char actual = exp.charAt(i);
            if (actual == ')') {
                char top = pila.top();
                pila.pop();
                int elementosAdentro = 0;
                while (top != '(') {
                    elementosAdentro++;
                    top = pila.top();
                    pila.pop();
                }
                if (elementosAdentro < 1) {
                    return true;
                }
            } else {
                pila.push(actual);
            }
        }
        return false;
    }

    
    public static void main(String[] args) throws ExceptionIsEmpty {

        System.out.println("((a+b)+(c+d)) -> " + parentesisDuplicados("((a+b)+(c+d))"));
        System.out.println("((a+b)+((c+d))) -> " + parentesisDuplicados("((a+b)+((c+d)))"));
        System.out.println("(a+b)+(c+d) -> " + parentesisDuplicados("(a+b)+(c+d)"));
        System.out.println("(a+(b+(c+d))) -> " + parentesisDuplicados("([{)]}"));
        System.out.println("(a+b)+((c+d)) -> " + parentesisDuplicados("(a+b)+((c+d))"));
        System.out.println("((a+b))+c -> " + parentesisDuplicados("((a+b))+c"));
    }
}
