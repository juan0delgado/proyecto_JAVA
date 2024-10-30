public class Electronico extends Producto {
    private String estado;

    public Electronico(String nombre, int cantidad, double precio, String estado) {
        super(nombre, cantidad, precio);
        this.estado = estado;
    }

    public String getEstado() {
        return estado;
    }

    @Override
    public void mostrarDetalles() {
        System.out.println("Electronico{" +
                "nombre='" + nombre + '\'' +
                ", cantidad=" + cantidad +
                ", precio=" + precio +
                ", estado='" + estado + '\'' +
                '}');
    }
}