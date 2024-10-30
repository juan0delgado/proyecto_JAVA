public class Alimento extends Producto {
    private int mesesCaducidad;
    private boolean estaVendido;

    public Alimento(String nombre, int cantidad, double precio, int mesesCaducidad, boolean estaVendido) {
        super(nombre, cantidad, precio);
        this.mesesCaducidad = mesesCaducidad;
        this.estaVendido = estaVendido;
    }

    public int getMesesCaducidad() {
        return mesesCaducidad;
    }

    public boolean isEstaVendido() {
        return estaVendido;
    }

    public void setEstaVendido(boolean estaVendido) {
        this.estaVendido = estaVendido;
    }

    @Override
    public void mostrarDetalles() {
        System.out.println("Alimento{" +
                "nombre='" + nombre + '\'' +
                ", cantidad=" + cantidad +
                ", precio=" + precio +
                ", mesesCaducidad=" + mesesCaducidad +
                ", estaVendido=" + estaVendido +
                '}');
    }
}