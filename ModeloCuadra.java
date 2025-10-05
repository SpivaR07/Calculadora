public class ModeloCuadra extends Modelo {
    private double a;
    private double b;
    private double c;

    //Constructor del modelo cuadrático
    public ModeloCuadra(String nombre, double a, double b, double c) {
        super(nombre); //constructor de la clase modelo
        this.a = a;
        this.b = b;
        this.c = c;
    }


    //Cálculo a realizar en base a la fórmula cuadrática
    @Override
    public String calcular() {
        if (a == 0) {
            return "Error: 'a' no puede ser cero en una ecuación cuadrática";
        }
        
        double discriminante = Math.pow(b, 2) - 4 * a * c;
        
        String resultado = String.format("Ecuación: %.2fx² + %.2fx + %.2f = 0\n", a, b, c);
        resultado += String.format("Discriminante: %.2f\n", discriminante);
        
        if (discriminante > 0) {
            double x1 = (-b + Math.sqrt(discriminante)) / (2 * a);
            double x2 = (-b - Math.sqrt(discriminante)) / (2 * a);
            resultado += String.format("Dos soluciones reales:\nx₁ = %.4f\nx₂ = %.4f", x1, x2);
        } else if (discriminante == 0) {
            double x = -b / (2 * a);
            resultado += String.format("Una solución real (doble):\nx = %.4f", x);
        } else {
            double parteReal = -b / (2 * a);
            double parteImag = Math.sqrt(-discriminante) / (2 * a);
            resultado += String.format("Dos soluciones complejas:\nx1 = %.4f + %.4fi\nx2 = %.4f - %.4fi", parteReal, parteImag, parteReal, parteImag);
        }
        
        return resultado;
    }
}
