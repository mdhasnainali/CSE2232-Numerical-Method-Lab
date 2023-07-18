public class GaussJordan {
    private double matrix[][];
    private int n;

    public GaussJordan(double[][] matrix) {
        this.matrix = matrix;
        this.n = matrix.length;
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
        for(i=n-1;i>=0;i--){
            for(j=i-1;j>=0;j--){
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
