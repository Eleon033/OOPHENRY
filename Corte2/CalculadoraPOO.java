// Archivo: CalculadoraPOO.java
import java.util.Scanner;

public class CalculadoraPOO {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // Se crea el objeto de la clase hija (OperacionesAvanzadas)
        OperacionesAvanzadas calculadora = new OperacionesAvanzadas();
        boolean ejecutando = true;
        
        System.out.println("--- Calculadora ---");

        while (ejecutando) {
            System.out.println("\nSeleccione una operacion:");
            System.out.println("1. Sumar");
            System.out.println("2. Restar");
            System.out.println("3. Multiplicar");
            System.out.println("4. Dividir");
            System.out.println("5. Potenciacion (Op1 ^ Op2)");
            System.out.println("6. Salir");
            System.out.print("Opcion: ");

            if (!scanner.hasNextInt()) {
                System.out.println("Entrada no valida. Por favor, ingrese un numero del 1 al 6.");
                scanner.next(); 
                continue; 
            }

            int opcion = scanner.nextInt();
            double resultado = 0.0;
            boolean operacionExitosa = true;

            if (opcion >= 1 && opcion <= 5) {
                try {
                    // 1. Lectura de datos
                    System.out.print("Ingrese el primer operando: ");
                    double op1 = scanner.nextDouble();
                    System.out.print("Ingrese el segundo operando: ");
                    double op2 = scanner.nextDouble();
                    
                    // 2. Uso de Setters del objeto
                    calculadora.setOperando1(op1);
                    calculadora.setOperando2(op2);

                    // 3. Ejecucion de la operacion
                    switch (opcion) {
                        case 1:
                            resultado = calculadora.sumar(); // Heredado de OperacionBase
                            break;
                        case 2:
                            resultado = calculadora.restar(); // Heredado de OperacionBase
                            break;
                        case 3:
                            resultado = calculadora.multiplicar();
                            break;
                        case 4:
                            resultado = calculadora.dividir();
                            if (Double.isNaN(resultado)) {
                                operacionExitosa = false;
                            }
                            break;
                        case 5:
                            resultado = calculadora.potenciacion();
                            break;
                    }
                    
                    // 4. Muestra de resultados
                    if (operacionExitosa) {
                         System.out.println("------------------------------------");
                         // Uso de Getters para mostrar los operandos usados
                         System.out.printf("Resultado de la operacion con %.2f y %.2f: %.2f%n", 
                                          calculadora.getOperando1(), 
                                          calculadora.getOperando2(), 
                                          resultado);
                         System.out.println("------------------------------------");
                    }
                    
                } catch (java.util.InputMismatchException e) {
                    System.out.println("Error: Ingrese solo numeros para los operandos.");
                    scanner.next(); 
                }

            } else if (opcion == 6) {
                ejecutando = false;
                System.out.println("Saliendo de la calculadora. Hasta pronto!");
            } else {
                System.out.println("Opcion no valida. Intente de nuevo.");
            }
        }
        
        scanner.close();
    }
}