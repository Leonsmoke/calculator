import Calculator.Calculator;
import Calculator.FloatCalculator;
import java.util.InputMismatchException;
import java.util.Scanner;

class Programm {

    private static Scanner scanner = new Scanner(System.in);

    private float firstValue,secondValue;
    private char operator;

    void run(){
        while (true){
            try {
                System.out.println("Enter first value");
                firstValue=getNumber();
                System.out.println("Enter second value");
                secondValue=getNumber();
                System.out.println("Enter operator");
                operator=getOperationChar();
                Calculator calculator = new FloatCalculator(firstValue,secondValue,operator);
                System.out.println(calculator.execute());
                System.out.println("Enter Y for exit, anykey for continue");
                if (exit()) break;
            } catch (InputMismatchException e){
                System.out.println(e + ". Please, enter correct number");
                scanner.next();
            }

        }



    }
    private static float getNumber(){
        float num;
        if(scanner.hasNextFloat()){
            num = scanner.nextFloat();
        } else {
            System.out.println("Error. Try again");
            scanner.next();
            num = getNumber();
        }
        return num;
    }

    private static char getOperationChar(){
        char operation;
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
