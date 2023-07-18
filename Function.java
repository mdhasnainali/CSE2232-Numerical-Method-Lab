public class Function {
    public static double functionalValue(double x){
        return (x * x * x) - (2 * x * x) + 5 * x - 3;
//        return 1/(1 + x * x);
//        return (x*x - 2*x +1);
    }

    public static double derivativeValue(double x){
        return (3 * x * x) - (4 * x) + 5;
    }
}
