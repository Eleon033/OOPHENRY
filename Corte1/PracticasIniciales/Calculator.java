package calculator;
import java.util.Scanner;

public class Calculator {
    public Calculator() {
    }

    public int add(int a, int b) {
        return a + b;
    }

    public int substract(int a, int b) {
        return a - b;
    }

    public int multiply(int a, int b) {
        return a * b;
    }

    public double divide(int a, int b) {

        return a / b;
    }

    public int modulo(int a, int b) {
        return a % b;
    }

    public static void main(String[] args) {
        Scanner digito = new Scanner(System.in);

        System.out.print("Escriba el primer dígito: ");
        int D1 = digito.nextInt();

        System.out.print("Escriba el segundo dígito: ");
        int D2 = digito.nextInt();

        Calculator myCalculator = new Calculator();

        System.out.println("Suma: " + myCalculator.add(D1, D2));
        System.out.println("Resta: " + myCalculator.substract(D1, D2));
        System.out.println("Multiplicación: " + myCalculator.multiply(D1, D2));
        System.out.println("División: " + myCalculator.divide(D1, D2));
        System.out.println("Módulo: " + myCalculator.modulo(D1, D2));
    }
}











