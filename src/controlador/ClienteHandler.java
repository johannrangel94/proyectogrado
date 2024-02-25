/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

/**
 *
 * @author hongu
 */
public class ClienteHandler implements Runnable {

    private Socket clienteSocket;
    private DataInputStream entrada;
    private DataOutputStream salida;

    public ClienteHandler(Socket clienteSocket) throws IOException {
        this.clienteSocket = clienteSocket;
        entrada = new DataInputStream(clienteSocket.getInputStream());
        salida = new DataOutputStream(clienteSocket.getOutputStream());
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
}