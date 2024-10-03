package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import vista.ventana;

public class logica_ventana implements ActionListener { 
    // Esta clase implementa la interfaz ActionListener, lo que significa que puede escuchar y manejar eventos de acción, 
    // como hacer clic en botones.

    private ventana delegado;
    // 'delegado' es un objeto de la clase 'ventana', que probablemente contiene la interfaz gráfica que tiene los botones.

    public logica_ventana(ventana delegado) {
        super();
        this.delegado = delegado;
        // En el constructor, se asigna el objeto 'delegado' pasado como argumento a la variable miembro.
        
        // A continuación, se añaden listeners a los botones del objeto 'delegado'. Esto vincula el listener (que es esta misma clase) a cada botón.
        this.delegado.btn_ERROR_MESSAGE.addActionListener(this);
        this.delegado.btn_INFORMATION_MESSAGE.addActionListener(this);
        this.delegado.btn_INPUT.addActionListener(this);
        this.delegado.btn_WARNING_MESSAGE.addActionListener(this);
        this.delegado.btn_YES_NO_CANCEL_OPTION.addActionListener(this);
        this.delegado.btn_YES_NO_OPTION.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // Este es el método principal que maneja los eventos. Se llama automáticamente cuando ocurre una acción (como un clic en un botón).
        
        if(e.getSource() == delegado.btn_ERROR_MESSAGE) {
            // Si el botón presionado es 'btn_ERROR_MESSAGE', muestra un cuadro de diálogo de error.
            JOptionPane.showMessageDialog(delegado, "No es posible Registrar", "Registro de usuario", JOptionPane.ERROR_MESSAGE);
        } else if(e.getSource() == delegado.btn_INFORMATION_MESSAGE) {
            // Si el botón presionado es 'btn_INFORMATION_MESSAGE', muestra un mensaje de información de éxito.
            JOptionPane.showMessageDialog(delegado, "Registro exitoso!!", "Registro de usuario", JOptionPane.INFORMATION_MESSAGE);
        } else if(e.getSource() == delegado.btn_INPUT) {
            // Si el botón presionado es 'btn_INPUT', pide un nombre al usuario con un cuadro de entrada y luego muestra un mensaje de bienvenida.
            String nombre = JOptionPane.showInputDialog(delegado, "Ingrese el nombre:");
            JOptionPane.showMessageDialog(delegado, "Bienvenido " + nombre, "Sistema de Inventario", JOptionPane.INFORMATION_MESSAGE);
        } else if(e.getSource() == delegado.btn_WARNING_MESSAGE) {
            // Si el botón presionado es 'btn_WARNING_MESSAGE', muestra un mensaje de advertencia.
            JOptionPane.showMessageDialog(delegado, "Problemas para Registrar", "Registro de usuario", JOptionPane.WARNING_MESSAGE);
        } else if(e.getSource() == delegado.btn_YES_NO_CANCEL_OPTION) {
            // Si el botón presionado es 'btn_YES_NO_CANCEL_OPTION', muestra una ventana de confirmación con tres opciones: Sí, No, Cancelar.
            int respuesta = JOptionPane.showConfirmDialog(delegado, "Desea eliminar el usuario?", "Sistema de Inventario", JOptionPane.YES_NO_CANCEL_OPTION);
            // El resultado de la confirmación se maneja con un switch.
            switch(respuesta) {
                case 0 -> JOptionPane.showMessageDialog(delegado, "Usuario eliminado!!", "Sistema de Inventario", JOptionPane.INFORMATION_MESSAGE);
                case 1 -> JOptionPane.showMessageDialog(delegado, "Usuario no fue eliminado!!", "Sistema de Inventario", JOptionPane.INFORMATION_MESSAGE);
                case 2 -> JOptionPane.showMessageDialog(delegado, "Acción Cancelada!!", "Sistema de Inventario", JOptionPane.INFORMATION_MESSAGE);
            }
        } else if(e.getSource() == delegado.btn_YES_NO_OPTION) {
            // Similar al caso anterior, pero esta vez la confirmación solo tiene dos opciones: Sí o No.
            int respuesta = JOptionPane.showConfirmDialog(delegado, "Desea Cerrar Session?", "Sistema de Inventario", JOptionPane.YES_NO_OPTION);
            switch(respuesta) {
                case 0 -> JOptionPane.showMessageDialog(delegado, "Session Cerrada!!", "Sistema de Inventario", JOptionPane.INFORMATION_MESSAGE);
                case 1 -> JOptionPane.showMessageDialog(delegado, "Se mantiene dentro de la session", "Sistema de Inventario", JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }
}
