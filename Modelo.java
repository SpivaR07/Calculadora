import java.util.ArrayList;

public abstract class Modelo {
    protected String nombre;
    protected ArrayList<Double> parametros;

    
    //Constructor de un modelo
    public Modelo(String nombre) {
        this.nombre = nombre;
        this.parametros = new ArrayList<>();
    }


    public void agregarParametro(double parametro) {
        parametros.add(parametro);
    }

    public String getNombre() { return nombre; }


    public void setParametros(ArrayList<Double> parametros) {
        this.parametros = new ArrayList<>(parametros);
    }


    //Método que todas las clases hijas deben hacer
    public abstract String calcular();


    @Override
    public String toString() {
        return "Modelo: " + nombre + " - Parámetros: " + parametros;
    }

}
