import java.util.ArrayList;
import java.util.List;

public class TablaHashSuma {
    private HashC<Integer> tablaNumeros;

    public TablaHashSuma(int size) {
        this.tablaNumeros = new HashC<>(size);
    }

    public void insert(int numero) {
        tablaNumeros.insert(numero, numero);
    }
    

    public List<String> encontrarParesQueSumen(int targetSum) {
        ArrayList<String> resultados = new ArrayList<>();

        for (int i = 0; i < tablaNumeros.table.size(); i++) {
            HashC<Integer>.Element elemento = tablaNumeros.table.get(i);
            if (elemento.mark == 1) {
                int num1 = elemento.reg.key;
                int complemento = targetSum - num1;
                HashC<Integer>.Element complementoElemento = tablaNumeros.table.get(tablaNumeros.functionHash(complemento));
                
                if (complementoElemento.mark == 1 && complementoElemento.reg.key == complemento) {
                    resultados.add(num1 + " + " + complemento);
                }
            }
        }

        return resultados;
    }
}
