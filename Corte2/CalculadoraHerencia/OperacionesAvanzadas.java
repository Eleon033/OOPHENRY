// Archivo: OperacionesAvanzadas.java
// Asegúrate de que OperacionBase.java esté en el mismo directorio.
class OperacionesAvanzadas extends OperacionBase {

    // Constructor que llama al constructor de la clase base
    public OperacionesAvanzadas(double op1, double op2) {
        super(op1, op2);
    }
    
    // Constructor por defecto
    public OperacionesAvanzadas() {
        super();
    }

    // --- Operaciones Avanzadas ---
    public double multiplicar() {
        // Accede a 'operando1' y 'operando2' gracias al modificador 'protected'
        return operando1 * operando2;
    }

    public double dividir() {
        if (operando2 != 0) {
            return operando1 / operando2;
        } else {
            System.out.println("Error! Division por cero no permitida.");
            return Double.NaN; 
        }
    }

    public double potenciacion() {
        // Accede a 'operando1' y 'operando2' gracias al modificador 'protected'
        return Math.pow(operando1, operando2);
    }
}