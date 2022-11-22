// Sebastian Vega 28183, Alejo Fraga 281542
package dominio;

import java.io.Serializable;


public class Dron implements Serializable{
    private String identificacion;
    private String modelo;
    private int tipoDeCamara;
    private boolean tieneVuelo = false;

    public Dron(String identificacion, String modelo, int tipoDeCamara) {
        this.identificacion = identificacion;
        this.modelo = modelo;
        this.tipoDeCamara = tipoDeCamara;
    }

    public Dron() {
    }

    public String getIdentificacion() {
        return identificacion;
    }

    public String getModelo() {
        return modelo;
    }

    public int getTipoDeCamara() {
        return tipoDeCamara;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public void setTipoDeCamara(int tipoDeCamara) {
        this.tipoDeCamara = tipoDeCamara;
    }

    public boolean tieneVuelo() {
        return tieneVuelo;
    }

    public void setTieneVuelo(boolean tieneVuelo) {
        this.tieneVuelo = tieneVuelo;
    }

    @Override
    public String toString() {
        return identificacion;
    }
    
    
    
}
