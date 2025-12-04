package estructuras;

import modelo.Producto;

public class Pila {
    // Variable que apunta siempre a lo que esta mas arriba
    private Nodo cima;
    
    public Pila() {
        this.cima = null;
    }
    
    // Metodo Push: Ponemos un elemento encima del anterior (como platos)
    public void push(Producto p) {
        Nodo nuevo = new Nodo(p);
        
        // El nuevo nodo se apoya sobre el que estaba antes en la cima
        nuevo.siguiente = cima; 
        
        // Ahora el nuevo pasa a ser la cima
        cima = nuevo;           
    }
    
    // Metodo Pop: Sacamos el elemento de mas arriba
    public Producto pop() {
        if (esVacia()) {
            return null; // No hay nada que sacar
        }
        
        // Guardamos el dato para retornarlo
        Producto dato = cima.dato;
        
        // La cima baja un nivel (al siguiente nodo)
        cima = cima.siguiente; 
        
        return dato;
    }
    
    // Metodo Peek: Solo miramos la cima sin eliminarla
    public Producto peek() {
        if (esVacia()) {
            return null;
        }
        return cima.dato;
    }
    
    public boolean esVacia() {
        return cima == null;
    }
}