// Sebastian Vega 28183, Alejo Fraga 281542
package dominio;

import java.io.Serializable;

public class Vuelo implements Serializable{
    private Dron dron;
    private String area;
    private int fila;
    private String nombreArchivo;

    public Vuelo(Dron dron, String area, int fila, String nombreArchivo) {
        this.dron = dron;
        this.area = area;
        this.fila = fila;
        this.nombreArchivo = nombreArchivo;
    }

    public Vuelo() {
    }

    public Dron getDron() {
        return dron;
    }

    public String getArea() {
        return area;
    }

    public int getFila() {
        return fila;
    }

    public void setDron(Dron dron) {
        this.dron = dron;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public void setFila(int fila) {
        this.fila = fila;
    }

    public String getNombreArchivo() {
        return nombreArchivo;
    }

    public void setNombreArchivo(String nombreArchivo) {
        this.nombreArchivo = nombreArchivo;
    }
    
    
}
