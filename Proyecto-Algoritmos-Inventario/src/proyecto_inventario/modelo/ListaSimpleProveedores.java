/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto_inventario.modelo;

/**
 *
 * @author JuanVic
 */
public class ListaSimpleProveedores {
    // inicio de la lista
    private NodoProveedor inicio;
    private int tamano; // numr de elementos q hay

    // constructor q inicia en 0
    public ListaSimpleProveedores() {
        this.inicio = null;
        this.tamano = 0;
    }

    // meotodo de lista vacia
    public boolean estaVacia() {
        return inicio == null;
    }

    // metodo para insertar un proveedor
    public void insertarAlFinal(Proveedor proveedor) {
        NodoProveedor nuevoNodo = new NodoProveedor(proveedor);
        
        if (estaVacia()) {
            // si la lista esta vacia, el nuevo nodo es el inicio
            inicio = nuevoNodo;
        } else {
            // si esq no esta vacio se recorre denuevo
            NodoProveedor actual = inicio;
            while (actual.siguiente != null) {
                actual = actual.siguiente;
            }
            // cuando se encuentra se vuelve a enlazar
            actual.siguiente = nuevoNodo;
        }
        tamano++; // aumento de tamaño
    }

    // METODO TEMPORAL para visualizar la consola
    public void mostrarEnConsola() {
        if (estaVacia()) {
            System.out.println("La lista de proveedores esta vacia.");
            return;
        }
        
        System.out.println("--- Lista de Proveedores ---");
        NodoProveedor actual = inicio;
        while (actual != null) {
            System.out.println(" - RUC: " + actual.dato.getRuc() + ", Razon Social: " + actual.dato.getRazonSocial());
            actual = actual.siguiente;
        }
        System.out.println("----------------------------");
    }
    
    // aqui continuan los metods
}
