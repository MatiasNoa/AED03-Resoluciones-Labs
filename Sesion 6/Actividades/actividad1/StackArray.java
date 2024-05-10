/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package actividad01;

/**
 *
 * @author Asus
 */
public class StackArray<E> implements Stack<E> {

    private E[] array;
    private int tope;
    private int capacity;

    public StackArray(int capacity) {
        this.array = (E[]) new Object[capacity];
        this.capacity = capacity;
        tope = -1;
    }
      
    @Override
    public void push(E x) {
        if (tope < capacity - 1) {
            array[++tope] = x;
        } else {
            System.out.println("La pila está llena");
        }
    }

    @Override
    public E pop() throws ExceptionIsEmpty {
        if (isEmpty()) {
            throw new ExceptionIsEmpty();
        } else {
            E ele = array[tope];
            array[tope--] = null;
            return ele;
        }
    }

    @Override
    public E top() throws ExceptionIsEmpty {
        if (isEmpty()) {
            throw new ExceptionIsEmpty();
        } else {
            return array[tope];
        }
    }

    @Override
    public boolean isEmpty() {
        return tope == -1;
    }

    public boolean isFull() {
        return tope == capacity - 1;
    }

    @Override
    public String toString() {
        StringBuilder st = new StringBuilder();
        st.append("[");
        for (int i = tope; i >= 0; i--) {
            st.append(array[i]);
            if (i != 0) {
                st.append(",");
            }
        }
        st.append("]");
        return st.toString();
    }

}
