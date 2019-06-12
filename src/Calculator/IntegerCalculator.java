package Calculator;

public class IntegerCalculator extends Calculator {
    private int firstValue;

    private int secondValue;

    public IntegerCalculator(int firstValue, int secondValue, char operatorsChar){
        this.firstValue=firstValue;
        this.secondValue=secondValue;
        this.operation=Operations.parseOperation(operatorsChar);
    }

    @Override
    public Object execute(){
        return operation.executeOperation(firstValue,secondValue);
    }
}
