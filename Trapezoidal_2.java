public class Trapezoidal_2 {

    private double low;
    private double high;
    private double h;
    private Point [] points;
    private int n;

    public Trapezoidal_2(double low, double high, int n) {
        this.low = low;
        this.high = high;
        this.n = n;
        this.h = (high - low)/n;

        this.points = new Point[n+1];
        this.n++;
    }

    private double functionalValue(double x){
        return Function.functionalValue(x);
    }

    public void printPoints(){
        for (Point a:points) {
            a.printPoint();
        }
    }

    private void calculatePoints(){
        double x,y;

        x = low;
        y = functionalValue(x);

        points[0] = new Point(x,y);

        for(int i=1;i<n;i++){
            x = points[i-1].x + h;
            y = functionalValue(x);
            points[i] = new Point(x,y);
        }

        printPoints();
    }

    public void solve(){
        calculatePoints();
        double result = 0.0;

        System.out.println("Solving using Trapezoidal Rule...");

        for(int i=1;i<n-1; i++){
            result += points[i].y * h;
        }

        result += ((points[0].y + points[n-1].y)/2 ) * h;

        System.out.println("Result: " + result);
    }

}
