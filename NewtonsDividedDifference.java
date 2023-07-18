public class NewtonsDividedDifference {

    private int n;
    private double x[];
    private double y[];
    private double predict;

    public NewtonsDividedDifference(double[] x, double[] y, double predict) {
        this.x = x;
        this.y = y;
        this.predict = predict;
        n = x.length;
    }

    public void solve(){
        //for(i=1;i<n;i++) System.out.println(divided_difference(x, y, i, 0));
        calculation(x, y, predict, n);
    }
    private double divided_difference(double x[], double y[], int i, int j){
        if(i==1)return (y[j+1]-y[j])/(x[j+1]-x[j]);
        return (divided_difference(x, y, i-1, j+1)-divided_difference(x, y, i-1, j))/(x[i+j]-x[j]);
    }


    private void calculation(double x[], double y[], double input, int n){
        double ans=y[0],a=1.0;
        for(int i=1;i<n;i++){
            a*=(input-x[i-1]);
            ans+=divided_difference(x, y, i, 0) * a;
        }
        System.out.println(ans);
    }
}
