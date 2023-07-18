import static java.lang.Math.abs;

public class FalsePosition {
    private double left;
    private double right;
    private double EPSILON;

    public FalsePosition(double left, double right, double EPSILON) {
        this.left = left;
        this.right = right;
        this.EPSILON = EPSILON;
    }

    public double functionValue(double x){
        return Function.functionalValue(x);
    }

    private boolean isValid(){
        if(functionValue(left) * functionValue(right) <=0) return true;
        else return false;
    }

    public void falsePosition(){
        if (!isValid()) {
            System.out.println("Invalid Initial Values");
            return;
        }

        double root = 0.0;
        int iterationCount = 0;

        do{
            System.out.print("Iteration: " + (++iterationCount) + " | ");

            double fx_a = functionValue(left);
            double fx_b = functionValue(right);

            root = (left * fx_b - right * fx_a) / (fx_b - fx_a);
            System.out.println("a: " + left + ", b: " + right + ", root: " + root);

            double fx_root = functionValue(root);

            if (fx_root * fx_a < 0) {
                right = root;
            }
            else {
                left = root;
            }
        }while(abs(functionValue(root)) > EPSILON);

        System.out.println("\nFinally using FalsePosition method the root is: " + root);

    }
}