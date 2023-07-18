import static java.lang.Math.abs;

public class ForwardInterpolation {
    private double u;
    private double a;
    private double h;
    private int n;
    private double [][] table;

    private Point [] points;
    private double predict;

    public ForwardInterpolation(Point[] points, double predict) {
        this.points = points;
        this.predict = predict;

        this.h = abs(points[1].x - points[0].x);
        this.n = points.length;
        this.a = points[0].x;
        this.u = (predict - a)/h;

    }

    public void printPoints(){
        for (Point a:points) {
            a.printPoint();
        }
    }

    private void makeTable(){
        table = new double[n+1][n+1];

        for(int i = 0; i < n; i++){
            table[i][0] = points[i].y;
        }

        for(int i = 1; i < n; i++) {
            for(int j = i; j < n; j++) {
                table[j - i][i] = table[j - i + 1][i - 1] - table[j - i][i - 1];
            }
        }
    }

    private void printTable(){
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                System.out.format("%8.2f\t", table[i][j]);
            }
            System.out.println();
        }
    }

    private int factorial(int x){
        if(x == 0 || x == 1) return 1;
        return x * x-1;
    }

    public void solve(){
        makeTable();
        printTable();

        System.out.println("a: " + a + "\th:" + h + "\tu:" +u);

        double result = 0.0;
        for(int j=0;j<n;j++){
            double p = 1;
            for(int i=0;i<j;i++){
                p *= u - i;
            }
            result += (p/factorial(j)) * table[0][j];
        }

        System.out.println("The result of the interpolation is: " + result);
    }
}
