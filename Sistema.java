import java.util.ArrayList;
import java.util.Scanner;

public class Sistema {
    private ArrayList<Modelo> modelos;
    private Scanner scanner;


    public Sistema() {
        modelos = new ArrayList<>();
        scanner = new Scanner(System.in);
    }


    //Antes de usarse, los modelos deben ser creados por el usuario
    public void agregarModelo(Modelo modelo) {
        modelos.add(modelo);
        System.out.println("Modelo agregado exitosamente: " + modelo.getNombre());
    }


    //Lista de todos los modelos creados por el usuario
    public void listarModelos() {
        if (modelos.isEmpty()) {
            System.out.println("No hay modelos registrados.");
            return;
        }
        
        System.out.println("\n=== MODELOS REGISTRADOS ===");
        for (int i = 0; i < modelos.size(); i++) {
            System.out.println((i + 1) + ". " + modelos.get(i));
        }
    }


    //Se ejecuta el modelo ya creado por el usuario
    public void ejecutarModelo(int indice) {
        if (indice < 0 || indice >= modelos.size()) {
            System.out.println("Índice inválido.");
            return;
        }
        
        Modelo modelo = modelos.get(indice);
        System.out.println("\n--- Ejecutando: " + modelo.getNombre() + " ---");
        String resultado = modelo.calcular(); //modelo.calcular() llama al método
        System.out.println("-----Resultado-----\n" + resultado);
    }



    //Métodos para crear cada modelo específico - el usuario ingresa datos
    public void crearModeloEstadistico() {
        System.out.print("Nombre del modelo: ");
        String nombre = scanner.nextLine();
        
        System.out.println("Tipo de cálculo (promedio/varianza/mediana): ");
        String tipo = scanner.nextLine();
        
        ModeloEst modelo = new ModeloEst(nombre, tipo);
        
        System.out.print("¿Cuántos datos desea ingresar? ");
        int n = scanner.nextInt();
        scanner.nextLine();
        
        for (int i = 0; i < n; i++) {
            System.out.print("Dato " + (i + 1) + ": ");
            double dato = scanner.nextDouble();
            modelo.agregarParametro(dato);
        }
        scanner.nextLine();
        
        agregarModelo(modelo);
    }


    public void crearModeloProbabilistico() {
        System.out.print("Nombre del modelo: ");
        String nombre = scanner.nextLine();
        
        System.out.print("Casos favorables: ");
        int favorables = scanner.nextInt();
        
        System.out.print("Casos totales: ");
        int totales = scanner.nextInt();
        scanner.nextLine();
        
        ModeloProb modelo = new ModeloProb(nombre, favorables, totales);
        agregarModelo(modelo);
    }


    public void crearModeloGeometrico() {
        System.out.print("Nombre del modelo: ");
        String nombre = scanner.nextLine();
        
        System.out.println("Tipo de figura (circulo/rectangulo/triangulo/cuadrado): ");
        String tipo = scanner.nextLine();
        
        ModeloGeo modelo = new ModeloGeo(nombre, tipo);
        
        switch (tipo.toLowerCase()) {
            case "circulo":
                System.out.print("Radio: ");
                modelo.agregarParametro(scanner.nextDouble());
                break;
            case "rectangulo":
            case "triangulo":
                System.out.print("Base: ");
                modelo.agregarParametro(scanner.nextDouble());
                System.out.print("Altura: ");
                modelo.agregarParametro(scanner.nextDouble());
                break;
            case "cuadrado":
                System.out.print("Lado: ");
                modelo.agregarParametro(scanner.nextDouble());
                break;
        }
        scanner.nextLine();
        
        agregarModelo(modelo);
    }


    public void crearModeloCuadratico() {
        System.out.print("Nombre del modelo: ");
        String nombre = scanner.nextLine();
        
        System.out.print("Coeficiente a: ");
        double a = scanner.nextDouble();
        
        System.out.print("Coeficiente b: ");
        double b = scanner.nextDouble();
        
        System.out.print("Coeficiente c: ");
        double c = scanner.nextDouble();
        scanner.nextLine();
        
        ModeloCuadra modelo = new ModeloCuadra(nombre, a, b, c);
        agregarModelo(modelo);
    }



    //Menú principal mostrado al usuario
    public void menuPrincipal() {
        int opcion;
        
        do {
            System.out.println("\n===========================================");
            System.out.println("||  SIMULADOR DE MODELOS MATEMATICOS     ||");
            System.out.println("===========================================");
            System.out.println("1. Crear modelo estadístico");
            System.out.println("2. Crear modelo probabilístico");
            System.out.println("3. Crear modelo geométrico");
            System.out.println("4. Crear modelo de ecuación cuadrática");
            System.out.println("5. Listar todos los modelos");
            System.out.println("6. Ejecutar un modelo específico");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");

            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    crearModeloEstadistico();
                    break;
                case 2:
                    crearModeloProbabilistico();
                    break;
                case 3:
                    crearModeloGeometrico();
                    break;
                case 4:
                    crearModeloCuadratico();
                    break;
                case 5:
                    listarModelos();
                    break;
                case 6:
                    listarModelos();
                    if (!modelos.isEmpty()) {
                        System.out.print("Ingrese el número del modelo a ejecutar: ");
                        int indice = scanner.nextInt() - 1;
                        scanner.nextLine();
                        ejecutarModelo(indice);
                    }
                    break;
                case 0:
                    System.out.println("¡Gracias por usar el simulador!");
                    break;
                default:
                    System.out.println("Opción inválida.");
            }
            
        } while (opcion != 0);
    }
}
