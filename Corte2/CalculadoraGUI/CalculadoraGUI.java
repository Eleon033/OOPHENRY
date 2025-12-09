import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalculadoraGUI extends JFrame implements ActionListener {
    // Componentes de la GUI
    private JTextField campoOp1, campoOp2;
    private JLabel etiquetaResultado;
    private OperacionesAvanzadas calculadora; // Objeto de la clase hija para la lógica

    /**
     * Constructor para configurar la interfaz gráfica.
     */
    public CalculadoraGUI() {
        // Inicializa el objeto de la lógica de negocio (herencia)
        calculadora = new OperacionesAvanzadas();

        // Configuración de la Ventana Principal
        setTitle("Calculadora POO - GUI");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout(10, 10)); // Usar BorderLayout
        
        // --- Panel de Entrada (Norte) ---
        JPanel panelEntrada = new JPanel(new GridLayout(2, 2, 5, 5));
        panelEntrada.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        
        panelEntrada.add(new JLabel("Operando 1:"));
        campoOp1 = new JTextField(10);
        panelEntrada.add(campoOp1);

        panelEntrada.add(new JLabel("Operando 2:"));
        campoOp2 = new JTextField(10);
        panelEntrada.add(campoOp2);

        add(panelEntrada, BorderLayout.NORTH);
        
        // --- Panel de Botones (Centro) ---
        JPanel panelBotones = new JPanel(new GridLayout(3, 2, 10, 10)); // 3 filas, 2 columnas
        panelBotones.setBorder(BorderFactory.createEmptyBorder(0, 10, 10, 10));

        // Crear botones y añadirles el Listener
        String[] nombresBotones = {"Sumar (+)", "Restar (-)", "Multiplicar (*)", "Dividir (/)", "Potencia (a^b)"};
        for (String nombre : nombresBotones) {
            JButton boton = new JButton(nombre);
            boton.addActionListener(this); // La clase es el listener
            panelBotones.add(boton);
        }
        
        JButton botonLimpiar = new JButton("Limpiar Campos");
        botonLimpiar.addActionListener(e -> {
            campoOp1.setText("");
            campoOp2.setText("");
            etiquetaResultado.setText("Resultado: ");
        });
        panelBotones.add(botonLimpiar);

        add(panelBotones, BorderLayout.CENTER);
        
        // --- Panel de Resultado (Sur) ---
        JPanel panelResultado = new JPanel();
        etiquetaResultado = new JLabel("Resultado: ", SwingConstants.CENTER);
        etiquetaResultado.setFont(new Font("Arial", Font.BOLD, 16));
        panelResultado.add(etiquetaResultado);

        add(panelResultado, BorderLayout.SOUTH);
        
        // Finalizar configuración de la ventana
        pack(); // Ajustar el tamaño de la ventana a los componentes
        setLocationRelativeTo(null); // Centrar la ventana en la pantalla
    }

    /**
     * Maneja las acciones de los botones.
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        String comando = e.getActionCommand();
        double op1, op2;
        double resultado = Double.NaN;
        String mensajeError = null;

        try {
            // 1. Lectura de datos y validación de entrada
            op1 = Double.parseDouble(campoOp1.getText());
            op2 = Double.parseDouble(campoOp2.getText());
            
            // 2. Uso de Setters del objeto (Encapsulación)
            calculadora.setOperando1(op1);
            calculadora.setOperando2(op2);

            // 3. Ejecución de la operación (Polimorfismo/Herencia)
            switch (comando) {
                case "Sumar (+)":
                    resultado = calculadora.sumar(); // Heredado de OperacionBase
                    break;
                case "Restar (-)":
                    resultado = calculadora.restar(); // Heredado de OperacionBase
                    break;
                case "Multiplicar (*)":
                    resultado = calculadora.multiplicar();
                    break;
                case "Dividir (/)":
                    if (op2 == 0) {
                        mensajeError = "Error: División por cero no permitida.";
                        resultado = Double.NaN;
                    } else {
                        resultado = calculadora.dividir();
                    }
                    break;
                case "Potencia (a^b)":
                    resultado = calculadora.potenciacion();
                    break;
                default:
                    mensajeError = "Operación no reconocida.";
                    break;
            }

        } catch (NumberFormatException ex) {
            mensajeError = "Error: Por favor, ingrese números válidos en ambos campos.";
            resultado = Double.NaN;
        }

        // 4. Muestra de resultados
        if (mensajeError != null) {
            etiquetaResultado.setText(mensajeError);
            JOptionPane.showMessageDialog(this, mensajeError, "Error de Operación", JOptionPane.ERROR_MESSAGE);
        } else {
            // Uso de Getters para formar el mensaje de salida (Encapsulación)
            String opSimbolo = comando.replaceAll("\\s+\\([^)]+\\)", "").trim(); // Quita el contenido del paréntesis
            String resultadoTexto = String.format("%.2f", resultado);
            etiquetaResultado.setText("Resultado: " + resultadoTexto);
            
            // Muestra los operandos usados para la trazabilidad
            System.out.printf("Operación: %.2f %s %.2f = %.2f%n", 
                              calculadora.getOperando1(), opSimbolo, 
                              calculadora.getOperando2(), resultado);
        }
    }

    /**
     * Método principal para iniciar la aplicación.
     */
    public static void main(String[] args) {
        // Ejecutar la interfaz en el Event-Dispatching Thread (EDT) de Swing
        SwingUtilities.invokeLater(() -> {
            new CalculadoraGUI().setVisible(true);
        });
    }
}