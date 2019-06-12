package Calculator;

import static Constants.Types.*;

public class CalculatorBuilder<T,V> {
    Calculator calc;
    public CalculatorBuilder(T firstValue, V secondValue, char operation) {
        if(!createCalculator(firstValue,secondValue,operation)){
            System.out.println("Error. Please, try again");
        } else {
            execute();
        }
    }

    public void execute(){
        System.out.println("Result: " + calc.execute());
    }

    private boolean createCalculator(T firstValue,V secondValue, char operation){
        if (Operations.parseOperation(operation)==null) return false;
        if (firstValue.getClass().getName()==secondValue.getClass().getName() && operation!='/'){
            switch (firstValue.getClass().getName()){
                case INTEGER: calc = new IntegerCalculator((Integer)firstValue,(Integer)secondValue,operation);break;
                case FLOAT:
                case DOUBLE:calc = new FloatCalculator((Float) firstValue,(Float) secondValue,operation); break;
            }
        } else {
            calc = new FloatCalculator(Float.parseFloat(firstValue.toString()),Float.parseFloat(secondValue.toString()),operation);
        }
        return true;
    }

}
