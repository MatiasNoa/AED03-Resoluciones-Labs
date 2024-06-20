//EJERCICIO 2
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Ejercicio2{
    public static void main(String[] args) {
        String archivo = "EMPLEADO.txt";

        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            String linea;
            HashC<Empleado> hashEmpleados = new HashC<Empleado>(Integer.parseInt(br.readLine()));
            while ((linea = br.readLine()) != null) {
                // Separar la línea en códigoEmpleado y nombre
                String[] partes = linea.split(" ");
                int codigoEmpleado = Integer.parseInt(partes[0]);
                String nombre = partes[1];

                // Crear objeto Empleado y agregarlo a la lista
                Empleado empleado = new Empleado(codigoEmpleado, nombre);
                hashEmpleados.insert(codigoEmpleado, empleado);
            }
            System.out.println(hashEmpleados);
        } catch (IOException e) {
            System.err.println("Error al leer el archivo: " + e.getMessage());
        }
    }
}
