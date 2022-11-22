// Sebastian Vega 28183, Alejo Fraga 281542
package dominio;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.stream.Collectors;


public class Sistema implements Serializable {

    private final PropertyChangeSupport manejador;
    private final ArrayList<Articulo> listaArticulos = new ArrayList<>();
    private final ArrayList<Funcionario> listaFuncionarios = new ArrayList<>();
    private final ArrayList<Dron> listaDrones = new ArrayList<>();
    private  ArrayList<Carga> listaCargas = new ArrayList<>();
    private ArrayList<VueloExitoso> listaVuelosExitosos = new ArrayList<>();
    private ArrayList<VueloNoExitoso> listaVuelosNoExitosos = new ArrayList<>();
    private String areaActual = "A";
    private Carga[][] matA = new Carga[12][10];
    private Carga[][] matB = new Carga[12][10];
    private Carga[][] matC = new Carga[12][10];
    private Carga[][] matD = new Carga[12][10];
    private Carga[][] matE = new Carga[12][10];

    public Sistema() {
        this.manejador = new PropertyChangeSupport(this);
    }

    public ArrayList<Articulo> getListaArticulos() {
        return listaArticulos;
    } //

    public ArrayList<Funcionario> getListaFuncionarios() {
        return listaFuncionarios;
    } //

    public ArrayList<Dron> getListaDrones() {
        return listaDrones;
    } //

    public String getAreaActual() {
        return areaActual;
    } //

    public void setAreaActual(String areaActual) {
        this.areaActual = areaActual;
    } //

    public Carga[][] getMatA() {
        return matA;
    } //

    public Carga[][] getMatB() {
        return matB;
    } //

    public Carga[][] getMatC() {
        return matC;
    }//

    public Carga[][] getMatD() {
        return matD;
    }//

    public Carga[][] getMatE() {
        return matE;
    }//

    public ArrayList<Carga> getListaCargas() {
        return listaCargas;
    }//

    public void agregarCargaALista(Carga carga) {
        this.listaCargas.add(carga);
    }//

    public ArrayList<VueloExitoso> getListaVuelosExitosos() {
        return listaVuelosExitosos;
    }//

    public ArrayList<VueloNoExitoso> getListaVuelosNoExitosos() {
        return listaVuelosNoExitosos;
    }//

    public void agregarVueloExitoso(VueloExitoso vueloExitoso) {
        this.listaVuelosExitosos.add(vueloExitoso);
    } //

    public void agregarVueloNoExitoso(VueloNoExitoso vueloNoExitoso) {
        this.listaVuelosNoExitosos.add(vueloNoExitoso);
    }//

    public boolean vueloExitosoRepetido(String nombreArchivo) {
        boolean repetido = false;
        
        for (int i = 0; i < listaVuelosExitosos.size(); i++) {
            if (listaVuelosExitosos.get(i).getNombreArchivo().equals(nombreArchivo)) {
                repetido = true;
            }
        }
        return repetido;
    }//

    public boolean vueloNoExitosoRepetido(String nombreArchivo) {
        boolean repetido = false;
        for (int i = 0; i < listaVuelosNoExitosos.size(); i++) {
            if (listaVuelosNoExitosos.get(i).getNombreArchivo().equals(nombreArchivo)) {
                repetido = true;
            }
        }
        return repetido;
    } //

    public void agregarCarga(String area, int fila, int columna, Carga carga) {
        switch (area) {
            case "A": {
                matA[fila][columna] = carga;
                break;
            }
            case "B": {
                matB[fila][columna] = carga;
                break;
            }
            case "C": {
                matC[fila][columna] = carga;
                break;
            }
            case "D": {
                matD[fila][columna] = carga;
                break;
            }
            case "E": {
                matE[fila][columna] = carga;
                break;
            }
        }
    } //

    public void eliminarCarga(String area, int fila, int columna) {
        switch (area) {
            case "A": {
                listaCargas.remove(matA[fila][columna]);
                matA[fila][columna] = null;
                break;
            }
            case "B": {
                listaCargas.remove(matB[fila][columna]);
                matB[fila][columna] = null;
                break;
            }
            case "C": {
                listaCargas.remove(matC[fila][columna]);
                matC[fila][columna] = null;
                break;
            }
            case "D": {
                listaCargas.remove(matD[fila][columna]);
                matD[fila][columna] = null;
                break;
            }
            case "E": {
                listaCargas.remove(matE[fila][columna]);
                matE[fila][columna] = null;
                break;
            }
        }
    }//

    public void moverAreaHaciaDerecha(String area) {
        switch (area) {
            case "A": {
                this.areaActual = "B";
                break;
            }
            case "B": {
                this.areaActual = "C";
                break;
            }
            case "C": {
                this.areaActual = "D";
                break;
            }
            case "D": {
                this.areaActual = "E";
                break;
            }
            case "E": {
                this.areaActual = "A";
                break;
            }

        }
    }//

    public void moverAreaHaciaIzquierda(String area) {
        switch (area) {
            case "A": {
                this.areaActual = "E";
                break;
            }
            case "B": {
                this.areaActual = "A";
                break;
            }
            case "C": {
                this.areaActual = "B";
                break;
            }
            case "D": {
                this.areaActual = "C";
                break;
            }
            case "E": {
                this.areaActual = "D";
                break;
            }

        }
    }//

    public void agregarArticulo(Articulo articulo) {
        this.listaArticulos.add(articulo);
        this.manejador.firePropertyChange("listaArticulos", null, this.listaArticulos);
    }

    public void agregarFuncionario(Funcionario funcionario) {
        this.listaFuncionarios.add(funcionario);
        this.manejador.firePropertyChange("listaFuncionarios", null, this.listaFuncionarios);
    }
    
    public void agregarDron(Dron dron){
        this.listaDrones.add(dron);
        this.manejador.firePropertyChange("listaDrones", null, this.listaDrones);
    }

    public String[] codigosDeLaFila(String area, int fila) {
        String[] arr = new String[10];
        switch (area) {
            case "A": {
                return devolverFilaComoArray(matA, fila);
            }
            case "B": {
                return devolverFilaComoArray(matB, fila);
            }
            case "C": {
                return devolverFilaComoArray(matC, fila);
            }
            case "D": {
                return devolverFilaComoArray(matD, fila);
            }
            case "E": {
                return devolverFilaComoArray(matE, fila);
            }
        }
        return arr;
    }

    public String[] devolverFilaComoArray(Carga[][] mat, int fila) {
        String[] arr2 = new String[11];
        arr2[0] = "Manual";

        for (int i = 0; i < mat[fila].length; i++) {
            if (mat[fila][i] != null) {

                arr2[i + 1] = (mat[fila][i]).getCodigo();
            } else {
                arr2[i + 1] = "0";//aca tenemos que tirar un error porque tiene una posicion null, o ponerle 0 no se
            }
        }

        return arr2;
    }

    public boolean nombreUnico(String unNombre) {
        boolean esUnico = true;
        for (int i = 0; i < this.listaArticulos.size(); i++) {
            if (this.listaArticulos.get(i).getNombre().equals(unNombre)) {
                esUnico = false;
            }
        }
        return esUnico;
    }

    public boolean numeroDeFuncionarioUnico(String unNumero) {
        boolean esUnico = true;
        for (int i = 0; i < this.listaFuncionarios.size(); i++) {
            if (this.listaFuncionarios.get(i).getNumeroDeFuncionario().equals(unNumero)) {
                esUnico = false;
            }
        }
        return esUnico;
    }

    public boolean identificacionUnica(String unaIdentificacion) {
        boolean esUnico = true;
        for (int i = 0; i < this.listaDrones.size(); i++) {
            if (this.listaDrones.get(i).getIdentificacion().equals(unaIdentificacion)) {
                esUnico = false;
            }
        }
        return esUnico;
    }

    public boolean tipoDeCamaraValido(int tipoDeCamara) {
        boolean esValido = true;
        if (tipoDeCamara < 1 || tipoDeCamara > 6) {
            esValido = false;
        }
        return esValido;
    }

    public boolean codigoCargaUnico(String codigo) {
        boolean esUnico = true;
        for (int i = 0; i < this.listaCargas.size(); i++) {
            if (this.listaCargas.get(i).getCodigo().equals(codigo)) {
                esUnico = false;
            }
        }
        return esUnico;
    }

    public boolean ingresoNoVacio(String ingreso) {
        boolean noEsVacio = true;
        if (ingreso.equals(" ") || ingreso.length() == 0) {
            noEsVacio = false;
        }
        return noEsVacio;
    }

    public Dron buscarDronPorId(String id) {
        Dron dronEncontrado = new Dron();
        for (int i = 0; i < listaDrones.size(); i++) {
            if (listaDrones.get(i).getIdentificacion().equals(id)) {
                dronEncontrado = listaDrones.get(i);
            }
        }
        return dronEncontrado;
    }
    
    public boolean puedeIngresar(int fila, int columna) {
        switch (areaActual) {
            case "A": {
                return posicionEsNula(matA, fila, columna);
            }
            case "B": {
                return posicionEsNula(matB, fila, columna);
            }
            case "C": {
                return posicionEsNula(matC, fila, columna);
            }
            case "D": {
                return posicionEsNula(matD, fila, columna);
            }
            case "E": {
                return posicionEsNula(matE, fila, columna);
            }
        }
        return false;
    }
    
    public boolean posicionEsNula(Carga[][] mat, int fila, int columna){
        if (mat[fila][columna] == null){
            return true;
        }
        else {
            return false;
        }
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        this.manejador.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        this.manejador.removePropertyChangeListener(listener);
    }
}
