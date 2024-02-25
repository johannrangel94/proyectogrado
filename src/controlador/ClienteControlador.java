package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.ClienteModelo;
import vistas.ClienteVista;

/**
 *
 * @author hongu
 */
public class ClienteControlador implements ActionListener {
    
    
    /*
        Esta clase es quien hace de intermediario entre la vista y el modelo,
        creamos instancias del modelo y la vista y luego utilizamos funciones para
        guardar los mensajes en la lista de Modelo y mostrarlos en el text area de la
        vista modelo.
    */
    
    
    private ClienteVista vista;    
    private ClienteModelo modelo;

    
    public ClienteControlador(ClienteVista vista, ClienteModelo modelo){
        this.vista = vista;
        this.modelo = modelo;
        this.vista.btnEnviar2.addActionListener(this);
    }
    
    
    public void iniciarVista(){
        vista.setTitle( "Demo MVC * jc-mouse.net" );
        vista.setLocationRelativeTo(null);
    }
    
 
    
   

    @Override
    public void actionPerformed(ActionEvent e) {

        String mensaje = vista.obtenerTexto();
        
        try {
            modelo.setMensaje(mensaje);
            vista.mostrarMensaje(mensaje);
            vista.limpiarTexto();
        } catch (IOException ex) {
            System.out.println("error");
            Logger.getLogger(ClienteControlador.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    
    }
    
    
    
}
