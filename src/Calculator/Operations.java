package Calculator;
import Operations.*;
public enum Operations {

    ADDITION('+'),DIVIDE('/'), MULTIPLY('*'), SUBSTRACTION('-');

    private char operator;

    Operations(char operator) {
        this.operator=operator;
    }

    public char getOperator() {
        return operator;
    }

    public static OperationInterface parseOperation(char operatorsChar){
        switch (operatorsChar){
            case '+': return new AdditionClass();
            case '-': return new SubtractionClass();
            case '/': return new DivideClass();
            case '*': return new MultiplyClass();
            default: return null;
        }
    }

    public static Operations getOperation(Character operator){
        if (operator == null)
            return null;
        for (Operations operation : values()) {
            if (operation.getOperator() == operator)
                return operation;
        }
        return null;
    }

}
