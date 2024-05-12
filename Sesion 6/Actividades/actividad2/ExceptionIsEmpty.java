package Actividades.actividad2;

public class ExceptionIsEmpty extends Exception{
    public ExceptionIsEmpty(){
        super("La cola esta vacia.");
    }
}
