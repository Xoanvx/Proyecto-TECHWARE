/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto_inventario.modelo;

/**
 *
 * @author JuanVic
 */
public class Proveedor {
    // los atributos 
    private String ruc;
    private String razonSocial;
    private String telefono;
    private String direccion;

    // constructor
    public Proveedor(String ruc, String razonSocial, String telefono, String direccion) {
        this.ruc = ruc;
        this.razonSocial = razonSocial;
        this.telefono = telefono;
        this.direccion = direccion;
    }

    // getters y setters para datos
    public String getRuc() {
        return ruc;
    }

    public void setRuc(String ruc) {
        this.ruc = ruc;
    }

    public String getRazonSocial() {
        return razonSocial;
    }

    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    // esto es para las pruebas de las clases
    @Override
    public String toString() {
        return "Proveedor{" + "ruc=" + ruc + ", razonSocial=" + razonSocial + '}';
    }
}
