// Archivo: OperacionBase.java
class OperacionBase {
    // Modificador de acceso 'protected' para que las clases hijas puedan acceder
    protected double operando1;
    protected double operando2;

    // Constructor
    public OperacionBase(double op1, double op2) {
        this.operando1 = op1;
        this.operando2 = op2;
    }
    
    // Constructor por defecto, útil para inicialización sin valores
    public OperacionBase() {
        this(0.0, 0.0);
    }

    // --- Getters ---
    public double getOperando1() {
        return operando1;
    }

    public double getOperando2() {
        return operando2;
    }

    // --- Setters ---
    public void setOperando1(double operando1) {
        this.operando1 = operando1;
    }

    public void setOperando2(double operando2) {
        this.operando2 = operando2;
    }

    // --- Operaciones Heredables ---
    public double sumar() {
        return operando1 + operando2;
    }

    public double restar() {
        return operando1 - operando2;
    }
}