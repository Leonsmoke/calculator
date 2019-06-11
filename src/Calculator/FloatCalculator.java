package Calculator;

public class FloatCalculator extends Calculator {

    private float firstValue;

    private float secondValue;

    public FloatCalculator(float firstValue, float secondValue, char operatorsChar){
        this.firstValue=firstValue;
        this.secondValue=secondValue;
        this.operation=parseOperation(operatorsChar);
    }

    @Override
    public float execute(){
        return operation.executeOperation(firstValue,secondValue);
    }

    public float getFirstValue() {
        return firstValue;
    }

    public void setFirstValue(float firstValue) {
        this.firstValue = firstValue;
    }

    public float getSecondValue() {
        return secondValue;
    }

    public void setSecondValue(float secondValue) {
        this.secondValue = secondValue;
    }
}
