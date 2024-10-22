public class RegresionLineal {
    private double[] x; // Cantidades vendidas
    private double[] y; // Precios de productos vendidos
    private double m; // Pendiente
    private double b; // Intercepto

    public RegresionLineal(double[] x, double[] y) {
        this.x = x;
        this.y = y;
        calcularParametros();
    }

    private void calcularParametros() {
        int n = x.length;
        double sumX = 0, sumY = 0, sumXY = 0, sumX2 = 0;

        for (int i = 0; i < n; i++) {
            sumX += x[i];
            sumY += y[i];
            sumXY += x[i] * y[i];
            sumX2 += x[i] * x[i];
        }

        // Calculando la pendiente (m) y el intercepto (b)
        m = (n * sumXY - sumX * sumY) / (n * sumX2 - sumX * sumX);
        b = (sumY - m * sumX) / n;
    }

    public double predecir(double nuevaCantidad) {
        return m * nuevaCantidad + b;
    }

    public void mostrarParametros() {
        System.out.println("Pendiente (m): " + m + ", Intercepto (b): " + b);
    }
}