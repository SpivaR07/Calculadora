public class ModeloGeo extends Modelo{
    private String tipoFigura;


    //Constructor del modelo geométrico
     public ModeloGeo(String nombre, String tipoFigura) {
        super(nombre); //constructor de la clase Modelo
        this.tipoFigura = tipoFigura;
    }


    @Override //tipo de cálculos a realizar
    public String calcular() {
        double area = 0;
        
        switch (tipoFigura.toLowerCase()) {
            case "circulo":
                if (parametros.size() < 1) {
                    return "Error: Se necesita el radio";
                }
                double radio = parametros.get(0);
                area = Math.PI * Math.pow(radio, 2);
                return String.format("Área del círculo: %.2f", area);
                
            case "rectangulo":
                if (parametros.size() < 2) {
                    return "Error: Se necesitan base y altura";
                }
                double base = parametros.get(0);
                double altura = parametros.get(1);
                area = base * altura;
                return String.format("Área del rectángulo: %.2f", area);
                
            case "triangulo":
                if (parametros.size() < 2) {
                    return "Error: Se necesitan base y altura";
                }
                base = parametros.get(0);
                altura = parametros.get(1);
                area = (base * altura) / 2;
                return String.format("Área del triángulo: %.2f", area);
                
            case "cuadrado":
                if (parametros.size() < 1) {
                    return "Error: Se necesita el lado";
                }
                double lado = parametros.get(0);
                area = Math.pow(lado, 2);
                return String.format("Area del cuadrado: %.2f", area);
                
            default:
                return "Figura no reconocida";
        }
    }
}
