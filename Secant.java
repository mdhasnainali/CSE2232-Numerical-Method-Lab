import static java.lang.Math.abs;

public class Secant {
    private double left;
    private double right;
    private double EPSILON;

    public Secant(double left, double right, double EPSILON) {
        this.left = left;
        this.right = right;
        this.EPSILON = EPSILON;
    }

    private double functionalValue(double x){
        return Function.functionalValue(x);
    }

    public void secant(){

        double root = 0.0;
        int iterationCount = 0;

        System.out.println("Finding the root using Secant Method...");

        do{
            System.out.print("Iteration: " + (++iterationCount) + " | ");

            double fx_a = functionalValue(left);
            double fx_b = functionalValue(right);

            if(fx_a == fx_b) {
                System.out.println("Invalid Initial Values");
            }

            root = (left * fx_b - right * fx_a) / (fx_b - fx_a);
            System.out.println("a: " + left + ", b: " + right + ", root: " + root);

            double fx_root = functionalValue(root);

            left = right;
            right = root;

        }while (abs(functionalValue(root)) >= EPSILON);

        System.out.println("\nFinally using Newton Raphson method the root is: " + root);
    }
}
