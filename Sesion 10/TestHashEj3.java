//EJERCICIO 3
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class TestHashEj3 {
    public static void main(String[] args) {
        String filePath = "EMPLEADO2.TXT";

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            int numberOfElements = Integer.parseInt(br.readLine().trim());
            HashA<Empleado> hashEmpleados = new HashA<Empleado>(numberOfElements);
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                int codigoEmpleado = Integer.parseInt(parts[0]);
                String nombre = parts[1];

                Empleado empleado = new Empleado(codigoEmpleado, nombre);
                hashEmpleados.insert(codigoEmpleado, empleado);
            }
            System.out.println(hashEmpleados);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
