package estructuras;

import modelo.Producto;

public class NodoArbol {
    // El objeto producto que vamos a guardar en este nodo
    public Producto dato;
    
    // Punteros para las ramas del arbol (hijos)
    public NodoArbol izquierdo;
    public NodoArbol derecho;

    public NodoArbol(Producto dato) {
        this.dato = dato;
        // Inicialmente es una hoja, no tiene hijos
        this.izquierdo = null;
        this.derecho = null;
    }
}