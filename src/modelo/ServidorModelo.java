/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package modelo;

import controlador.ClienteHandler;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/*
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
*/


/**
 *
 * @author hongu
 */
public class ServidorModelo {
    
    
    private final int puerto = 55555;
    private ServerSocket servidorSocket;
    private Socket clienteSocket;
  /*  private DataInputStream entrada;
    private DataOutputStream salida;
    private ArrayList<DataOutputStream> flujoSalida;
*/
    
    
    // Metodo constructor
    
    public ServidorModelo () throws IOException{
        servidorSocket = new ServerSocket(puerto);
    }
    
    // Metodo para iniciar el servidor y estar a la espera de clientes    
    public void iniciarServidor() throws IOException{
        
        while(true){
            clienteSocket = servidorSocket.accept();
            
            
            Thread thread = new Thread(new ClienteHandler(clienteSocket));
            thread.start();
            
        }

    }


    
    
    
    
    public static void main(String[] args) throws IOException {
        ServidorModelo servidor = new ServidorModelo();
        servidor.iniciarServidor();
    }
    
}
