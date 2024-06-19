package HashCerrado;
public class Empleado implements Comparable<Empleado> {
    private int codigoEmpleado;
    private String nombre;

    public Empleado(int codigoEmpleado, String nombre) {
        this.codigoEmpleado = codigoEmpleado;
        this.nombre = nombre;
    }

    public int getCodigoEmpleado() {
        return codigoEmpleado;
    }

    public String getNombre() {
        return nombre;
    }

    @Override
    public String toString() {
        return "" + nombre;
    }

    @Override
    public int compareTo(Empleado otroEmpleado) {
        return Integer.compare(this.codigoEmpleado, otroEmpleado.codigoEmpleado);
    }
}

