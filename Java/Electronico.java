public class Electronico extends Producto {
    private String estado;

    public Electronico(String nombre, int cantidad, double precio, String estado) {
        super(nombre, cantidad, precio);
        this.estado = estado;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Override
    public void mostrarDetalles() {
        System.out.println("Electrónico: " + nombre + ", Cantidad: " + cantidad + ", Precio: " + precio + 
                ", Estado: " + estado);
    }
}