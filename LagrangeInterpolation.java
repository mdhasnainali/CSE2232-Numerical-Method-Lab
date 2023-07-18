import static java.lang.Math.abs;

public class LagrangeInterpolation {
    private Point [] points;
    private double predict;
    private int n;

    public LagrangeInterpolation(Point[] points, double predict) {
        this.points = points;
        this.predict = predict;
        this.n = points.length;
    }

    public void printPoints(){
        for (Point a:points) {
            a.printPoint();
        }
    }

    public void solve(){

        System.out.println("Finding the value of " + predict + " using Lagrange Interpolation...");

        double result = 0.0;
        for(int i=0;i<n;i++){
            double p = 1;
            double q = 1;
            for(int j=0;j<n;j++){
                if(i!=j){
                    p *= (predict - points[j].x);
                    q *= (points[i].x - points[j].x);
                }
            }
            result += (p/q) * points[i].y;
        }

        System.out.println("The result of the interpolation is: " + result);
    }

}
