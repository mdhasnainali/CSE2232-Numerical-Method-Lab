public class Simpson {
    private double low;
    private double high;
    private double h;
    private Point [] points;
    private int n;

    public Simpson(double low, double high, int n) {
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
        double even = 0.0;
        double odd = 0.0;

        System.out.println("Solving using Trapezoidal Rule...");

        for(int i=1;i<n-1; i+=2){
            odd += points[i].y * (h/3);
        }

        for(int i=2;i<n-1; i+=2){
            even += points[i].y * (h/3);
        }

        result += (points[0].y + points[n-1].y) * (h/3);
        result += (4 * odd) + (2 * even);

        System.out.println("Result: " + result);
    }
}
