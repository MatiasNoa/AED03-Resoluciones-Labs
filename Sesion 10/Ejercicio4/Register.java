package Ejercicio4;
public class Register{
    protected int frecuencia;
    protected String clave;
    public Register(int frecuencia, String clave){
        this.frecuencia = frecuencia;
        this.clave = clave;
    }
    public String getClave(){return this.clave;}
    
    public String toString(){
        return this.frecuencia+":"+this.clave.toString();
    }
}