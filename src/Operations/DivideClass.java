package Operations;

public class DivideClass implements OperationInterface {

    @Override
    public int executeOperation(int firstValue, int secondValue) {
        try {
            return firstValue/secondValue;
        } catch (ArithmeticException e){
            System.out.println(e + ". Can't divide by zero");
        }
        return 0;
    }

    @Override
    public float executeOperation(float firstValue, float secondValue) {
        try {
            return firstValue/secondValue;
        } catch (ArithmeticException e){
            System.out.println(e + ". Can't divide by zero");
        }
        return 0;
    }

}
