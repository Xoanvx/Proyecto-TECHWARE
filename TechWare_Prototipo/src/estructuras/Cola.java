package estructuras;

import modelo.Producto;

public class Cola {
    // Usamos dos punteros: uno al principio y otro al final para movernos rapido
    private Nodo frente;
    private Nodo finalCola;
    
    public Cola() {
        this.frente = null;
        this.finalCola = null;
    }
    
    // Metodo para agregar un producto al final (Encolar)
    public void encolar(Producto p) {
        Nodo nuevo = new Nodo(p);
        
        if (esVacia()) {
            // Si no habia nadie, el nuevo es el primero y tambien el ultimo
            frente = nuevo;
            finalCola = nuevo;
        } else {
            // Si ya habia gente, lo ponemos detras del ultimo
            finalCola.siguiente = nuevo; 
            // Ahora el nuevo pasa a ser el ultimo de la fila
            finalCola = nuevo;           
        }
    }
    
    // Metodo para sacar el primero de la fila (Desencolar)
    public Producto desencolar() {
        if (esVacia()) {
            return null; // No hay nada que sacar
        }
        
        // Guardamos el producto del primero para no perderlo
        Producto datoAtendido = frente.dato; 
        
        // Movemos el puntero del frente al siguiente de la fila
        frente = frente.siguiente;            
        
        // Si al movernos el frente quedo vacio, arreglamos tambien el final
        if (frente == null) {
            finalCola = null; 
        }
        
        return datoAtendido;
    }
    
    public boolean esVacia() {
        return frente == null;
    }
}