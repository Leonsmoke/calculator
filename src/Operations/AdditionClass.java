package Operations;

public class AdditionClass implements OperationInterface{


    @Override
    public int executeOperation(int firstValue, int secondValue) {
        return firstValue+secondValue;
    }

    @Override
    public float executeOperation(float firstValue, float secondValue) {
        return firstValue+secondValue;
    }
}
