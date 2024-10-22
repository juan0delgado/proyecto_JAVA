import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    // Listas para almacenar productos y productos vendidos
    private static ArrayList<Producto> productos = new ArrayList<>();
    private static ArrayList<Producto> productosVendidos = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int opcion;
        do {
            System.out.println("\nSistema de Gestión de Productos");
            System.out.println("1. Agregar Producto");
            System.out.println("2. Vender Producto");
            System.out.println("3. Mostrar Productos");
            System.out.println("4. Mostrar Productos Vendidos");
            System.out.println("5. Realizar Predicción de Precio (Regresión Lineal)");
            System.out.println("6. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    agregarProducto(scanner);
                    break;
                case 2:
                    venderProducto(scanner);
                    break;
                case 3:
                    mostrarProductos();
                    break;
                case 4:
                    mostrarProductosVendidos();
                    break;
                case 5:
                    realizarRegresionLineal();
                    break;
                case 6:
                    System.out.println("Saliendo del sistema.");
                    break;
                default:
                    System.out.println("Opción inválida. Intente de nuevo.");
            }
        } while (opcion != 6);
    }

    // Método para agregar productos
    private static void agregarProducto(Scanner scanner) {
        System.out.println("Ingrese el tipo de producto (1: Alimento, 2: Electrónico): ");
        int tipo = scanner.nextInt();
        scanner.nextLine();  // Limpiar buffer

        System.out.print("Ingrese el nombre del producto: ");
        String nombre = scanner.nextLine();

        System.out.print("Ingrese la cantidad: ");
        int cantidad = scanner.nextInt();

        System.out.print("Ingrese el precio: ");
        double precio = scanner.nextDouble();

        if (tipo == 1) {
            System.out.print("Ingrese los meses de caducidad: ");
            int mesesCaducidad = scanner.nextInt();

            productos.add(new Alimento(nombre, cantidad, precio, mesesCaducidad, false));
        } else if (tipo == 2) {
            scanner.nextLine();  // Limpiar buffer
            System.out.print("Ingrese el estado del electrónico: ");
            String estado = scanner.nextLine();

            productos.add(new Electronico(nombre, cantidad, precio, estado));
        } else {
            System.out.println("Tipo de producto inválido.");
        }
    }

    // Método para vender productos
    private static void venderProducto(Scanner scanner) {
        scanner.nextLine();  // Limpiar buffer
        System.out.print("Ingrese el nombre del producto que desea vender: ");
        String nombre = scanner.nextLine();

        boolean encontrado = false;
        for (Producto producto : productos) {
            if (producto.getNombre().equalsIgnoreCase(nombre)) {
                if (producto instanceof Alimento) {
                    ((Alimento) producto).setEstaVendido(true);
                }
                productosVendidos.add(producto);
                productos.remove(producto);
                System.out.println("Producto vendido: " + nombre);
                encontrado = true;
                break;
            }
        }

        if (!encontrado) {
            System.out.println("Producto no encontrado.");
        }
    }

    // Método para mostrar productos disponibles
    private static void mostrarProductos() {
        System.out.println("\nProductos disponibles:");
        for (Producto producto : productos) {
            producto.mostrarDetalles();
        }
    }

    // Método para mostrar productos vendidos
    private static void mostrarProductosVendidos() {
        System.out.println("\nProductos vendidos:");
        for (Producto producto : productosVendidos) {
            producto.mostrarDetalles();
        }
    }

    // Método para realizar regresión lineal usando datos de productos vendidos
    private static void realizarRegresionLineal() {
        if (productosVendidos.size() < 2) {
            System.out.println("Se necesitan al menos 2 productos vendidos para realizar la regresión lineal.");
            return;
        }

        int n = productosVendidos.size();
        double[] cantidades = new double[n];
        double[] precios = new double[n];

        for (int i = 0; i < n; i++) {
            Producto producto = productosVendidos.get(i);
            cantidades[i] = producto.getCantidad();
            precios[i] = producto.getPrecio();
        }

        RegresionLineal regresion = new RegresionLineal(cantidades, precios);
        System.out.println("Ingrese la cantidad de un nuevo producto para predecir su precio:");
        Scanner scanner = new Scanner(System.in);
        double nuevaCantidad = scanner.nextDouble();

        double precioPredicho = regresion.predecir(nuevaCantidad);
        System.out.println("El precio predicho para una cantidad de " + nuevaCantidad + " es: " + precioPredicho);
    }
}