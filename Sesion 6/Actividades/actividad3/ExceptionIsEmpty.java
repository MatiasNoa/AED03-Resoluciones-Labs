package Actividades.actividad3;

public class ExceptionIsEmpty extends Exception{
    public ExceptionIsEmpty(){
        super("La cola de prioridad esta vacia.");
    }
}
