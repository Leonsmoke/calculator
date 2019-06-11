package Calculator;

import Operations.*;

public abstract class Calculator {

    OperationInterface operation;

    OperationInterface parseOperation(char operatorsChar){
        switch (operatorsChar){
            case '+': return new AdditionClass();
            case '-': return new SubtractionClass();
            case '/': return new DivideClass();
            case '*': return new MultiplyClass();
            default: return null;
        }
    }

    abstract public float execute();

}
