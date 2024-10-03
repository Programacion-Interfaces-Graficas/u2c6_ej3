package vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;

import controlador.logica_ventana;

import java.awt.GridLayout;
import javax.swing.JButton;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

public class ventana extends JFrame {
    private static final long serialVersionUID = 1L;
    // Serialización necesaria para evitar errores de compatibilidad al guardar o enviar instancias de esta clase.
    
    public JButton btn_INFORMATION_MESSAGE;
    public JButton btn_WARNING_MESSAGE;
    public JButton btn_ERROR_MESSAGE;
    public JButton btn_YES_NO_OPTION;
    public JButton btn_YES_NO_CANCEL_OPTION;
    public JButton btn_INPUT;
    // Se definen botones que serán mostrados en la ventana. Cada botón está asociado con una funcionalidad específica de diálogo.

    public static void main(String[] args) {
        // Método principal que lanza la aplicación.
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    ventana frame = new ventana();
                    frame.setVisible(true);
                    // Se crea una instancia de la clase 'ventana' y se hace visible.
                } catch (Exception e) {
                    e.printStackTrace();
                    // En caso de error, imprime el seguimiento de la pila.
                }
            }
        });
    }

    /**
     * Constructor de la ventana.
     */
    public ventana() {
        setTitle("Cajas de Dialogo");
        // Se establece el título de la ventana.
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // Se define que la operación por defecto al cerrar la ventana será salir de la aplicación.
        
        setBounds(100, 100, 299, 288);
        // Se establece el tamaño y la posición inicial de la ventana (posición x, y, ancho, alto).
        
        getContentPane().setLayout(null);
        // Se usa un diseño absoluto, sin gestor de diseño por defecto, lo que permite colocar los componentes en posiciones específicas.
        
        JPanel panel = new JPanel();
        panel.setBounds(5, 5, 280, 246);
        getContentPane().add(panel);
        panel.setLayout(new GridLayout(0, 1, 0, 0));
        // Se crea un panel que contiene todos los botones y se le asigna un diseño de rejilla (GridLayout) de una columna.

        // Se añaden los botones al panel, que se alinearán verticalmente gracias al GridLayout.
        btn_INFORMATION_MESSAGE = new JButton("INFORMATION_MESSAGE");
        panel.add(btn_INFORMATION_MESSAGE);

        btn_WARNING_MESSAGE = new JButton("WARNING_MESSAGE");
        panel.add(btn_WARNING_MESSAGE);

        btn_ERROR_MESSAGE = new JButton("ERROR_MESSAGE");
        panel.add(btn_ERROR_MESSAGE);

        btn_YES_NO_OPTION = new JButton("YES_NO_OPTION");
        panel.add(btn_YES_NO_OPTION);

        btn_YES_NO_CANCEL_OPTION = new JButton("YES_NO_CANCEL_OPTION");
        panel.add(btn_YES_NO_CANCEL_OPTION);

        btn_INPUT = new JButton("INPUT DIALOGS");
        panel.add(btn_INPUT);
        // Cada botón se crea y se añade al panel.

        new logica_ventana(this);
        // Se crea una instancia de la clase 'logica_ventana' y se le pasa esta ventana ('this') como argumento.
        // Esto vincula la lógica de los botones (eventos de clic) con la ventana actual.
    }
}