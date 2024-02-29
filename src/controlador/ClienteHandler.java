/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;

/**
 *
 * @author hongu
 */
public class ClienteHandler implements Runnable {

    private Socket clienteSocket;
    private DataInputStream entrada;
    private DataOutputStream salida;
    private ArrayList<ClienteHandler> listaClientes = new ArrayList<>();
    private String nombre;

    public ClienteHandler(Socket clienteSocket) throws IOException {
        this.clienteSocket = clienteSocket;
        entrada = new DataInputStream(clienteSocket.getInputStream());
        salida = new DataOutputStream(clienteSocket.getOutputStream());
        listaClientes.add(this);
    }

    @Override
    public void run() {
        try {
            while (true) {
                String mensaje = entrada.readUTF();
                System.out.println("Cliente ha dicho: " + mensaje);
            }
        } catch (IOException e) {
            // Manejar excepciones
        } finally {
            try {
                clienteSocket.close();
            } catch (IOException e) {
                // Manejar excepciones
            }
        }
    }
    
    
    public void enviarMensaje(String mensaje){
        for(ClienteHandler clientes : listaClientes) {
            try {
                if(!clientes.nombre.equals(nombre)){
                    salida.writeUTF(mensaje);
                    salida.flush();                    
                }
            } catch (IOException e) {
                System.out.println(e);

            }
        }
    }
    

}



