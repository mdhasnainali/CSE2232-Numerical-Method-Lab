import static java.lang.Math.abs;

public class Bisection {
    private double left;
    private double right;
    private double EPSILON;


    // Constructor
    public Bisection(double left, double right, double EPSILON) {
        this.left = left;
        this.right = right;
        this.EPSILON = EPSILON;
    }


    double functionValue(double x) {
        return Function.functionalValue(x);
    }

    public boolean isValid(){
        if(functionValue(left) * functionValue(right) <= 0) return true;
        else return false;
    }

    public void bisect(){
        if(!isValid()){
            System.out.println("Invalid Initial Values");
            return;
        }

        double root = 0.0;
        int iterationCount = 0;

        System.out.println("Solving Equation Using Bisection Method: ");

        do{
            System.out.print("Iteration: " + (++iterationCount) + " | ");
            root = (left + right) / 2;
            System.out.println("a: " + left + ", b: " + right + ", root: " + root);

            if(functionValue(root) * functionValue(left) < 0) {
                right = root;
            }
            else left = root;

        }while (abs(functionValue(root)) > EPSILON);
        System.out.println("Solution Found!");
        System.out.println("Solution is " + root);
    }
}