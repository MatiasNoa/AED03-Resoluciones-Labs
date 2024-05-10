package Ejercicios.ejercicio1;

public class Test {
    public static void main(String[] args) throws ExceptionIsEmpty{
        Stack<Integer> pilaInteger = new StackLink<Integer>();
        pilaInteger.push(4);
        pilaInteger.push(1);
        pilaInteger.push(5);
        pilaInteger.push(7);
        pilaInteger.push(11);
        pilaInteger.push(10);
        pilaInteger.push(15);
        
        System.out.println(pilaInteger);
        System.out.println("Desapilar: " + pilaInteger.pop());
        System.out.println(pilaInteger);
        System.out.println("Top: " + pilaInteger.top());
        System.out.println("Desapilar: " + pilaInteger.pop());
        System.out.println(pilaInteger);

        System.out.println("\n\n");
        //===================================================================
        Stack<String> pilaString = new StackLink<String>();
        pilaString.push("Rojo");
        pilaString.push("Azul");
        pilaString.push("Verde");
        pilaString.push("Morado");
        pilaString.push("Blanco");
        
        System.out.println(pilaString);
        System.out.println("Desapilar: " + pilaString.pop());
        System.out.println(pilaString);
        System.out.println("Top: " + pilaString.top());
        System.out.println("Desapilar: " + pilaString.pop());
        System.out.println(pilaString);
    }
}
