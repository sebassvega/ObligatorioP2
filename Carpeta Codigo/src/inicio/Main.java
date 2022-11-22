// Sebastian Vega 28183, Alejo Fraga 281542
package inicio;

import dominio.*;
import interfaz.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;


public class Main {
    public static void main(String[] args) throws ClassNotFoundException{
        
        Sistema sistema = cargarSistema();
        sistema.setAreaActual("A");
        VentanaPrincipal vent = new VentanaPrincipal(sistema);
        vent.setVisible(true);
    }
    
    private static Sistema cargarSistema() throws ClassNotFoundException{
        Sistema sistema = null;
        
        try{
            FileInputStream archivo = new FileInputStream("datos.ser");
            ObjectInputStream deserializador = new ObjectInputStream(archivo);
            sistema = (Sistema)deserializador.readObject();
            
        } catch(FileNotFoundException ex){
            sistema = new Sistema();
            
        } catch(IOException ex){
            sistema = new Sistema();
            
        }
        return sistema;
    }
}
