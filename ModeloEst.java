import java.util.ArrayList;
import java.util.Collections;

public class ModeloEst extends Modelo {
    private String tipoCalculo;

    
    //Constructor del modelo estadístico
    public ModeloEst(String nombre, String tipoCalculo) {
        super(nombre); //constructor de la clase Modelo
        this.tipoCalculo = tipoCalculo;
    }


    //tipos de cálculos a realizar
    @Override
    public String calcular() {
        if (parametros.isEmpty()) {
            return "Error: no hay datos para calcular";
        }

        double resultado = 0;

        switch (tipoCalculo.toLowerCase()) {
            case "promedio":
                double suma = 0;
                for (double valor : parametros) {
                    suma += valor;
                }
                resultado = suma / parametros.size();
                return "Promedio: " + Math.round(resultado * 100.0) / 100.0;
            
            case "varianza":
                double promedio = 0;
                for (double valor : parametros) {
                    promedio += valor;
                }
                promedio /= parametros.size();
                
                double sumaCuadrados = 0;
                for (double valor : parametros) {
                    sumaCuadrados += Math.pow(valor - promedio, 2);
                }
                resultado = sumaCuadrados / parametros.size();
                return "Varianza: " + Math.round(resultado * 100.0) / 100.0;

            case "mediana":
                ArrayList<Double> ordenados = new ArrayList<>(parametros);
                Collections.sort(ordenados);
                int n = ordenados.size();
                if (n % 2 == 0) {
                    resultado = (ordenados.get(n/2 - 1) + ordenados.get(n/2)) / 2.0;
                } else {
                    resultado = ordenados.get(n/2);
                }
                return "Mediana: " + Math.round(resultado * 100.0) / 100.0;
                
            default:
                return "Tipo de cálculo no reconocido";
        }
    }
}
