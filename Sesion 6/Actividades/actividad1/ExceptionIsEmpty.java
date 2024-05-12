package Actividades.actividad1;

public class ExceptionIsEmpty extends Exception {
    public ExceptionIsEmpty(){
        super("La pila está vacía");
    }
}
