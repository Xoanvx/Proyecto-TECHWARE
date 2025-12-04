package estructuras;

import modelo.Producto;

public class ArbolABB {
    private NodoArbol raiz;

    public ArbolABB() {
        // Al principio el arbol no tiene nada
        this.raiz = null;
    }

    // Metodo publico que llama quien usa la clase
    public void insertar(Producto p) {
        raiz = insertarRecursivo(raiz, p);
    }

    // Metodo privado que hace el trabajo real repitiendose a si mismo
    private NodoArbol insertarRecursivo(NodoArbol actual, Producto p) {
        // Si llegamos a un hueco vacio, ahi ponemos el nuevo nodo
        if (actual == null) {
            return new NodoArbol(p);
        }

        // Si el ID nuevo es menor, nos vamos a la rama izquierda
        if (p.getId() < actual.dato.getId()) {
            actual.izquierdo = insertarRecursivo(actual.izquierdo, p);
        } 
        // Si el ID nuevo es mayor, nos vamos a la rama derecha
        else if (p.getId() > actual.dato.getId()) {
            actual.derecho = insertarRecursivo(actual.derecho, p);
        }

        return actual;
    }

    // Metodo para buscar un producto especifico
    public Producto buscar(int id) {
        return buscarRecursivo(raiz, id);
    }

    private Producto buscarRecursivo(NodoArbol actual, int id) {
        // Si se acaba el camino (null) o si justo lo encontramos
        if (actual == null || actual.dato.getId() == id) {
            return (actual != null) ? actual.dato : null;
        }

        // Decidimos por donde seguir buscando
        if (id < actual.dato.getId()) {
            return buscarRecursivo(actual.izquierdo, id); // Busca por la izquierda
        }
        return buscarRecursivo(actual.derecho, id); // Busca por la derecha
    }
    
    // Recorrido InOrden: Sirve para mostrar todo ordenado por ID
    public void mostrarInOrden() {
        mostrarInOrdenRecursivo(raiz);
    }

    private void mostrarInOrdenRecursivo(NodoArbol actual) {
        if (actual != null) {
            // 1. Visitamos todo lo de la izquierda
            mostrarInOrdenRecursivo(actual.izquierdo);
            
            // 2. Mostramos el dato del centro (actual)
            System.out.println(actual.dato.toString()); 
            
            // 3. Visitamos todo lo de la derecha
            mostrarInOrdenRecursivo(actual.derecho);
        }
    }
}