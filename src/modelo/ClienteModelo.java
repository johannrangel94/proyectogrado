package modelo;


import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;



/**
 *
 * @author hongu
 */
public class ClienteModelo {
    
    
    /*
        Esta clase contendra los metodos que puede realizar el cliente, pero debe pasar antes por el controlador
        para que este los use.
    */

    private final Socket socketServidor;
    private DataInputStream entrada;
    private DataOutputStream salida;
    private final int puerto = 55555;
    private final String host = "localhost";
    private String mensaje = "";
    private String nombreCliente;
    
    
    public ClienteModelo () throws IOException {
        socketServidor = new Socket(host,puerto);
        entrada = new DataInputStream(socketServidor.getInputStream());
        salida = new DataOutputStream(socketServidor.getOutputStream()); 
        setNombre(nombreCliente);
    }
    
    
    public void conectarseServidor () throws IOException {       
        System.out.println("Escribe salir para cerrar el programa");
        
        String ultimoMensaje = "";

        while(true){
            
            String mensajeActual = getMensaje();
            
            System.out.println(recibirMensaje());

            
            if(!mensajeActual.equals(ultimoMensaje)){
                salida.writeUTF(mensajeActual);
                salida.flush();        
                ultimoMensaje = mensajeActual;               
            }
            
            
            try {
            Thread.sleep(100); // Pausar durante 100 milisegundos
            } catch (InterruptedException ex) {
            System.out.println("Error al pausar el hilo: " + ex.getMessage());
            }
            

        }
    }



    public void setMensaje(String mensaje) throws IOException {
        this.mensaje = mensaje;
        //salida.writeUTF(mensaje);
        //salida.flush();
    }
    
    public String getMensaje(){
        return mensaje;
    }
    
    
    public String recibirMensaje() throws IOException {
        return entrada.readUTF();
    }

    public void cerrarConexion() throws IOException {
        socketServidor.close();
    }
    
    
    public void setNombre(String nombre){
        this.nombreCliente = nombre;
    }
    
    
    
    
}
