import static java.lang.Math.abs;

public class NewtonRaphson {
    private double initialValue;
    private double EPSILON;

    public NewtonRaphson(double initialValue, double EPSILON) {
        this.initialValue = initialValue;
        this.EPSILON = EPSILON;
    }

    private double functionalValue(double x){
        return Function.functionalValue(x);
    }

    private double derivativeValue(double x){
        return Function.derivativeValue(x);
    }

    public void newtonRapson(){

        double root = initialValue;
        int iterationCount = 0;

        System.out.println("Finding the root using Newton Raphson");

        do{
            System.out.print("Iteration: " + (++iterationCount) + " | ");
            double f = functionalValue(root);
            double d = derivativeValue(root);

            root = root - (f/d);

            System.out.println("root: " + root);

        }while (abs(functionalValue(root)) > EPSILON);

        System.out.println("\nFinally using Newton Raphson method the root is: " + root);
    }
}
