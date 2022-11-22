// Sebastian Vega 28183, Alejo Fraga 281542
package dominio;

import java.io.Serializable;


public class Funcionario implements Serializable{
    private String nombre;
    private int edad;
    private String numeroDeFuncionario;

    public Funcionario(String nombre, int edad, String numeroDeFuncionario) {
        this.nombre = nombre;
        this.edad = edad;
        this.numeroDeFuncionario = numeroDeFuncionario;
    }

    public Funcionario() {
    }

    public String getNombre() {
        return nombre;
    }

    public int getEdad() {
        return edad;
    }

    public String getNumeroDeFuncionario() {
        return numeroDeFuncionario;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public void setNumeroDeFuncionario(String numeroDeFuncionario) {
        this.numeroDeFuncionario = numeroDeFuncionario;
    }

    @Override
    public String toString() {
        return nombre;
    } 
}
