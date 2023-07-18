public class GaussElimination {
    private double matrix[][];
    private int n;

    public GaussElimination(double[][] matrix) {
        this.matrix = matrix;
        this.n = matrix.length;
        System.out.println(n);
    }

    public void solve() {
        echelon_form(matrix, n);
        answer(matrix,n);
    }
    private void echelon_form(double matrix[][], int n){
        int i,j,k;
        for(i=0;i<n;i++){
            for(j=i+1;j<n;j++){
                double ratio = matrix[j][i]/matrix[i][i];
                for(k=0;k<n+1;k++)matrix[j][k]-=ratio*matrix[i][k];
            }
        }

    }
    private void answer(double matrix[][], int n){
        double x[]=new double[n];
        int i,j,k;
        for(i=n-1;i>=0;i--){
            double ans=matrix[i][n];
            for(j=i+1;j<n;j++)ans-=x[j]*matrix[i][j];
            x[i]=ans/matrix[i][i];
        }
        display(x,n);
    }
    private void display(double x[], int n){
        int i,j;
        for(i=0;i<n;i++) {
            System.out.print(x[i]+" ");
        }
        System.out.println();
    }
}
