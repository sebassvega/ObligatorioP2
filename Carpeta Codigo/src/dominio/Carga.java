// Sebastian Vega 28183, Alejo Fraga 281542
package dominio;

import java.io.Serializable;


public class Carga implements Serializable{
    private Funcionario funcionario;
    private Articulo articulo;
    private int cantidad;
    private String codigo;

    public Carga(Funcionario funcionario, Articulo articulo, int cantidad, String codigo) {
        this.funcionario = funcionario;
        this.articulo = articulo;
        this.cantidad = cantidad;
        this.codigo = codigo;
    }

    public Carga() {
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public Articulo getArticulo() {
        return articulo;
    }

    public int getCantidad() {
        return cantidad;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    public void setArticulo(Articulo articulo) {
        this.articulo = articulo;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    @Override
    public String toString() {
        return codigo;
    }
    
    
    
}
