public class ModeloProb extends Modelo {
    private int casosFavorables;
    private int casosTotales;


    //Constructor del modelo probabilístico
    public ModeloProb(String nombre, int casosFavorables, int casosTotales) {
        super(nombre); //constructor de la clase modelo
        this.casosFavorables = casosFavorables;
        this.casosTotales = casosTotales;
    }


    //tipo de cálculo a realizar
    @Override
    public String calcular() {
        if (casosTotales == 0) {
            return "Error: No se puede dividir por cero";
        }
        
        if (casosFavorables > casosTotales) {
            return "Error: Los casos favorables no pueden ser mayores a los totales";
        }
        
        double probabilidad = (double) casosFavorables / casosTotales;
        double porcentaje = probabilidad * 100;
        
       return String.format("Probabilidad: %.4f (%. 2f%)\nCasos favorables: %d\nCasos totales: %d", probabilidad, porcentaje, casosFavorables, casosTotales);
    }
}
