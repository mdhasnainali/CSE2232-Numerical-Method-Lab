public class LeastSquare {
    private double sumX = 0.0;
    private double sumY = 0.0;
    private double sumXY = 0.0;
    private double sumXSquare = 0.0;
    private int n;

    private double X[];
    private double Y[];

    public LeastSquare(double[] x, double[] y) {
        X = x;
        Y = y;

        n = X.length;
        calculateAll();
    }

    private void calculateAll(){
        for(int i=0;i<n;i++){
            sumX = sumX + X[i];
            sumY = sumY + Y[i];
            sumXY = sumXY + (X[i] * Y[i]);
            sumXSquare = sumXSquare + (X[i] * X[i]);
        }
    }

    public void leastSquare(){
        System.out.println("Curve Fitting using LeastSquare Method: ");

        double m = (n * sumXY - sumX * sumY) / (n * sumXSquare - sumX * sumX);
        double c = (sumY - m * sumX)/n;

        System.out.printf("\nThe line for the given points is: Y = %.4f + %.4f X\n", c, m);
    }
}
