// Sebastian Vega 28183, Alejo Fraga 281542
package dominio;

public class VueloNoExitoso extends Vuelo{
    private final int lineas;
    
    public VueloNoExitoso(int lineas, Dron dron, String area, int fila, String nombreArchivo) {
        super(dron, area, fila, nombreArchivo);
        this.lineas = lineas;
    }

    public VueloNoExitoso(int lineas, String nombreArchivo) {
        this.lineas = lineas;
    }

    @Override
    public String toString() {
        return "Nombre del archivo: "+super.getNombreArchivo()+"  ||  Area: "+ super.getArea()+ "  ||  Fila: " + super.getFila()+"  ||  Cantidad de lineas de carga: "+lineas;
    }
}
