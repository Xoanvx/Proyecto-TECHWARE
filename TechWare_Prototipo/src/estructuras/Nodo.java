package estructuras;

import modelo.Producto;

public class Nodo {
    // Aqui guardamos el objeto real (la informacion del producto)
    public Producto dato;
    
    // Esta variable sirve de enlace para conectar con el siguiente nodo
    public Nodo siguiente;

    public Nodo(Producto dato) {
        this.dato = dato;
        // Al crearse, todavia no apunta a ningun lado
        this.siguiente = null; 
    }
}