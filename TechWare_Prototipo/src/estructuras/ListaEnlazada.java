package estructuras;

import modelo.Producto;

public class ListaEnlazada {
    // Puntero que nos dice donde arranca la lista
    private Nodo cabeza;
    
    // Variable para llevar la cuenta de cuantos hay sin contar uno por uno
    private int tamaño;

    public ListaEnlazada() {
        this.cabeza = null;
        this.tamaño = 0;
    }

    // Metodo para agregar un producto siempre al final
    public void agregar(Producto p) {
        Nodo nuevo = new Nodo(p);
        
        if (cabeza == null) {
            // Si la lista esta vacia, el nuevo se vuelve el primero
            cabeza = nuevo;
        } else {
            // Si ya hay nodos, creamos un auxiliar para recorrer
            Nodo auxiliar = cabeza;
            
            // Avanzamos hasta encontrar el que no tiene siguiente (el ultimo)
            while (auxiliar.siguiente != null) {
                auxiliar = auxiliar.siguiente; 
            }
            
            // Una vez en el final, enganchamos el nuevo nodo
            auxiliar.siguiente = nuevo;
        }
        tamaño++;
    }

    // Recorremos toda la lista sumando los precios
    public double calcularTotal() {
        double total = 0;
        Nodo auxiliar = cabeza;
        
        while (auxiliar != null) {
            // Sumamos el precio del producto actual
            total += auxiliar.dato.getPrecio();
            // Pasamos al siguiente
            auxiliar = auxiliar.siguiente;
        }
        return total;
    }
    
    // Solo chequeamos si la cabeza es nula
    public boolean esVacia() {
        return cabeza == null;
    }
    
    // Para vaciar el carrito
    public void limpiar() {
        // Al quitar la referencia al primero, Java borra el resto de la memoria solo
        cabeza = null; 
        tamaño = 0;
    }

    // Necesitamos esto para que el Main pueda recorrer la lista y mostrarla
    public Nodo getCabeza() {
        return cabeza;
    } 
}