public class RegresionLineal {
    private double[] x;
    private double[] y;
    private double pendiente;
    private double intercepto;

    public RegresionLineal(double[] x, double[] y) {
        this.x = x;
        this.y = y;
        calcular();
    }

    private void calcular() {
        int n = x.length;
        double sumX = 0, sumY = 0, sumXY = 0, sumX2 = 0;

        for (int i = 0; i < n; i++) {
            sumX += x[i];
            sumY += y[i];
            sumXY += x[i] * y[i];
            sumX2 += x[i] * x[i];
        }

        pendiente = (n * sumXY - sumX * sumY) / (n * sumX2 - sumX * sumX);
        intercepto = (sumY - pendiente * sumX) / n;
    }

    public double predecir(double xNuevo) {
        return pendiente * xNuevo + intercepto;
    }
}