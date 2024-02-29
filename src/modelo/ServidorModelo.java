/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package modelo;

import controlador.ClienteHandler;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;




/**
 *
 * @author hongu
 */
public class ServidorModelo {
    
    
    private final int puerto = 55555;
    private ServerSocket servidorSocket;
    private Socket clienteSocket;
    
    
    private DataOutputStream salida;
      
    
    // Metodo constructor
    
    public ServidorModelo () throws IOException{
        servidorSocket = new ServerSocket(puerto);
        salida = new DataOutputStream(clienteSocket.getOutputStream());
    }
    
    // Metodo para iniciar el servidor y estar a la espera de clientes    
    public void iniciarServidor() throws IOException{
        
        while(true){
            clienteSocket = servidorSocket.accept();
            System.out.println("Un cliente se ha conectado.");
            //Creamos un nuevo hilo por cada cliente para que sean independiente su conexion con el servidor
            //Thread hiloCliente = new Thread(new ClienteHandler(clienteSocket, clientes));
            Thread hiloCliente = new Thread(new ClienteHandler(clienteSocket));
            hiloCliente.start();
            
            salida.writeUTF("Probando");
            
            
        }

    }
    
    

    
    
    


    
    
    
    
    public static void main(String[] args) throws IOException {
        ServidorModelo servidor = new ServidorModelo();
        servidor.iniciarServidor();
    }
    
}
