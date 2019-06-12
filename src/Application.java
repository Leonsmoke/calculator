import Calculator.CalculatorBuilder;
import Operations.OperationInterface;
import Calculator.Operations;
import java.util.InputMismatchException;
import java.util.Scanner;

class Application {

    private static Scanner scanner = new Scanner(System.in);

    private Object firstValue,secondValue;
    private char operator;

    void run(){
        while (true){
            try {
                firstValue=getNumber();
                operator=getOperationChar();
                secondValue=getNumber();
                CalculatorBuilder calculator = new CalculatorBuilder<>(firstValue,secondValue,operator);
                System.out.println("Enter Y for exit, anykey for continue");
                if (exit()) break;
            } catch (InputMismatchException e){
                System.out.println(e + ". Please, enter correct number");
                scanner.next();
            }

        }



    }
    private static Object getNumber(){
        Object num;
        System.out.println("Enter value");
        try{
            if(scanner.hasNextInt()){
                num = scanner.nextInt();
            } else {
                num = scanner.nextFloat();
            }
        } catch (InputMismatchException e){
            System.out.println(e+". Input error, incorrect format. Try again");
            scanner.next();
            num = getNumber();
        }
        return num;
    }

    private static char getOperationChar(){
        char operation=' ';
        System.out.println("Enter operator");
        try{
            if(scanner.hasNext()){
                operation = scanner.next().charAt(0);
            }
        } catch (InputMismatchException e){
            System.out.println("Input error, incorrect format. Try again");
            scanner.next();
            operation = getOperationChar();
        }
        if (checkOperator(operation)==null){
            System.out.println("Error, wrong operator. Try again");
            scanner.next();
            operation = getOperationChar();
        }
        return operation;
    }

    private static boolean exit(){
        return scanner.next().charAt(0)=='Y';
    }

    private static OperationInterface checkOperator(char operator){
        return Operations.parseOperation(operator);
    }
}
