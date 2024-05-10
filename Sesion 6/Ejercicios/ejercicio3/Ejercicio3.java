/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicio4;

/**
 *
 * @author Asus
 */
public class Ejercicio3 {
    public static boolean estaBalanceado(String s) {
        StackLink<Character> pila = new StackLink<>();

        try {
            for (int i = 0; i < s.length(); i++) {
                char actual = s.charAt(i);
                if (actual == '(' || actual == '[' || actual == '{') {
                    pila.push(actual);
                } else if (actual == ')' || actual == ']' || actual == '}') {
                    if (pila.isEmpty()) {
                        return false;
                    }

                    char tope = pila.top();
                    if ((actual == ')' && tope == '(')
                            || (actual == ']' && tope == '[')
                            || (actual == '}' && tope == '{')) {
                        pila.pop();
                    } else {
                        return false;
                    }
                }
            }
        } catch (ExceptionIsEmpty e) {
            System.out.println(e.getMessage());
            return false;
        }

        return pila.isEmpty();
    }

    public static void main(String[] args) {
        
        System.out.println("()()()[()]() -> " + estaBalanceado("()()()[()]()"));
        System.out.println("((()))[] -> " + estaBalanceado("((()))[]"));
        System.out.println("([])[]( -> " + estaBalanceado("([])[]("));
        System.out.println("([{)]} -> " + estaBalanceado("([{)]}"));
        System.out.println("[ -> " + estaBalanceado("["));
        System.out.println("[][][]{{{}}} -> " + estaBalanceado("[][][]{{{}}}"));
    }
}
