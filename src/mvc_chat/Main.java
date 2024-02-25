package mvc_chat;

import controlador.ClienteControlador;
import java.io.IOException;
import modelo.ClienteModelo;
import vistas.ClienteVista;

/**
 *
 * @author hongu
 */
public class Main {
    
    public static void main(String[] args) throws IOException{

        ClienteModelo modelo = new ClienteModelo();
        ClienteVista vista = new ClienteVista();
        ClienteControlador controlador = new ClienteControlador(vista,modelo);

        controlador.iniciarVista();
   
        
        vista.setVisible(true);
        modelo.conectarseServidor();             
    }
    
}
