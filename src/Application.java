import Calculator.CalculatorBuilder;
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
        Object num=null;
        System.out.println("Enter value");
        try{
            if(scanner.hasNextInt()){
                num = scanner.nextInt();
            } else {
                num = scanner.nextFloat();
            }
        } catch (InputMismatchException e){
            System.out.println("Error. Try again");
            scanner.next();
            num = getNumber();
        }
        return num;
    }

    private static char getOperationChar(){
        char operation;
        System.out.println("Enter operator");
        if(scanner.hasNext()){
            operation = scanner.next().charAt(0);
        } else {
            System.out.println("Error. Try again");
            scanner.next();//рекурсия
            operation = getOperationChar();
        }
        return operation;
    }

    private static boolean exit(){
        return scanner.next().charAt(0)=='Y';
    }

}
