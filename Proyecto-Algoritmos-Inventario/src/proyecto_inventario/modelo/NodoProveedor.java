/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto_inventario.modelo;

/**
 *
 * @author JuanVic
 */
public class NodoProveedor {
    // dato q guarda
    public Proveedor dato;
    
    // enlace al siguiente nodo
    public NodoProveedor siguiente;

    // cosntructor
    public NodoProveedor(Proveedor dato) {
        this.dato = dato;
        this.siguiente = null;
    }
}
