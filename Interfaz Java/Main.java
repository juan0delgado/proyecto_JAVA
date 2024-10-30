import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Main extends JFrame {
    private ArrayList<Producto> productos = new ArrayList<>();
    private ArrayList<Producto> productosVendidos = new ArrayList<>();

    public Main() {
        setTitle("Sistema de Gestión de Productos");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(6, 1));

        JButton btnAgregar = new JButton("Agregar Producto");
        JButton btnVender = new JButton("Vender Producto");
        JButton btnMostrar = new JButton("Mostrar Productos");
        JButton btnMostrarVendidos = new JButton("Mostrar Productos Vendidos");
        JButton btnPredecirPrecio = new JButton("Realizar Predicción de Precio");
        JButton btnSalir = new JButton("Salir");

        btnAgregar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                agregarProducto();
            }
        });

        btnVender.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                venderProducto();
            }
        });

        btnMostrar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                mostrarProductos();
            }
        });

        btnMostrarVendidos.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                mostrarProductosVendidos();
            }
        });

        btnPredecirPrecio.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                realizarRegresionLineal();
            }
        });

        btnSalir.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        add(btnAgregar);
        add(btnVender);
        add(btnMostrar);
        add(btnMostrarVendidos);
        add(btnPredecirPrecio);
        add(btnSalir);
    }

    private void agregarProducto() {
        String[] opciones = {"Alimento", "Electrónico"};
        int tipo = JOptionPane.showOptionDialog(this, "Seleccione el tipo de producto:", "Agregar Producto",
                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, opciones, opciones[0]);

        String nombre = JOptionPane.showInputDialog("Ingrese el nombre del producto:");
        int cantidad = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la cantidad:"));
        double precio = Double.parseDouble(JOptionPane.showInputDialog("Ingrese el precio:"));

        if (tipo == 0) {
            int mesesCaducidad = Integer.parseInt(JOptionPane.showInputDialog("Ingrese los meses de caducidad:"));
            productos.add(new Alimento(nombre, cantidad, precio, mesesCaducidad, false));
        } else if (tipo == 1) {
            String estado = JOptionPane.showInputDialog("Ingrese el estado del electrónico:");
            productos.add(new Electronico(nombre, cantidad, precio, estado));
        } else {
            JOptionPane.showMessageDialog(this, "Tipo de producto inválido.");
        }
    }

    private void venderProducto() {
        String nombre = JOptionPane.showInputDialog("Ingrese el nombre del producto que desea vender:");
        boolean encontrado = false;

        for (Producto producto : productos) {
            if (producto.getNombre().equalsIgnoreCase(nombre)) {
                if (producto instanceof Alimento) {
                    ((Alimento) producto).setEstaVendido(true);
                }
                productosVendidos.add(producto);
                productos.remove(producto);
                JOptionPane.showMessageDialog(this, "Producto vendido: " + nombre);
                encontrado = true;
                break;
            }
        }

        if (!encontrado) {
            JOptionPane.showMessageDialog(this, "Producto no encontrado.");
        }
    }

    private void mostrarProductos() {
        StringBuilder mensaje = new StringBuilder("Productos disponibles:\n");
        for (Producto producto : productos) {
            mensaje.append(producto.toString()).append("\n");
        }
        JOptionPane.showMessageDialog(this, mensaje.toString());
    }

    private void mostrarProductosVendidos() {
        StringBuilder mensaje = new StringBuilder("Productos vendidos:\n");
        for (Producto producto : productosVendidos) {
            mensaje.append(producto.toString()).append("\n");
        }
        JOptionPane.showMessageDialog(this, mensaje.toString());
    }

    private void realizarRegresionLineal() {
        if (productosVendidos.size() < 2) {
            JOptionPane.showMessageDialog(this, "Se necesitan al menos 2 productos vendidos para realizar la regresión lineal.");
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
        double nuevaCantidad = Double.parseDouble(JOptionPane.showInputDialog("Ingrese la cantidad de un nuevo producto para predecir su precio:"));
        double precioPredicho = regresion.predecir(nuevaCantidad);
        JOptionPane.showMessageDialog(this, "El precio predicho para una cantidad de " + nuevaCantidad + " es: " + precioPredicho);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new Main().setVisible(true);
            }
        });
    }
}