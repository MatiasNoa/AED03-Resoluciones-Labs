package Ejercicio2;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class HashCerrado{
    public static void main(String[] args) {
        String archivo = "C:\\Users\\MATIAS\\Desktop\\AED03-Resoluciones-Labs\\Sesion 10\\HashCerrado\\EMPLEADO";
        List<Empleado> empleados = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                // Separar la línea en códigoEmpleado y nombre
                String[] partes = linea.split(" ");
                int codigoEmpleado = Integer.parseInt(partes[0]);
                String nombre = partes[1];

                // Crear objeto Empleado y agregarlo a la lista
                Empleado empleado = new Empleado(codigoEmpleado, nombre);
                empleados.add(empleado);
            }
        } catch (IOException e) {
            System.err.println("Error al leer el archivo: " + e.getMessage());
        }

        HashC<Empleado> hashCerrado = new HashC(empleados.size());
        for(Empleado i : empleados){
            hashCerrado.insert(i.getCodigoEmpleado(), i);
        }
        System.out.println(hashCerrado);
    }
}
