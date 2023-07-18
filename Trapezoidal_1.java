public class Trapezoidal_1 {
    private double h;
    private Point [] points;
    private int n;

    public Trapezoidal_1(Point[] points) {
        this.points = points;
        this.h = points[1].x - points[0].x;
        this.n = points.length;
    }

    public void solve(){
        double result = 0.0;

        System.out.println("Solving using Trapezoidal Rule...");

        for(int i=1;i<n-1; i++){
            result += points[i].y * h;
        }

        result += ((points[0].y + points[n-1].y)/2) * h;

        System.out.println("Result: " + result);
    }

}
