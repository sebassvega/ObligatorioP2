// Sebastian Vega 28183, Alejo Fraga 281542
package dominio;

public class VueloExitoso extends Vuelo {
    private int cantCoin;
    private int cantDif;


    public VueloExitoso(int cantCoin, int cantDif, Dron dron, String area, int fila, String nombreArchivo) {
        super(dron, area, fila, nombreArchivo);
        this.cantCoin = cantCoin;
        this.cantDif = cantDif;
    }

    public VueloExitoso(int cantCoin, int cantDif) {
        this.cantCoin = cantCoin;
        this.cantDif = cantDif;
    }



    @Override
    public String toString() {
        return "Nombre del archivo: " + super.getNombreArchivo() + "  ||  Area: " + super.getArea() + "  ||  Fila: " + super.getFila() +  "  ||  Coincidencias: "+ cantCoin + "  ||  Diferencias: " + cantDif;
    }
    
    
    
}
