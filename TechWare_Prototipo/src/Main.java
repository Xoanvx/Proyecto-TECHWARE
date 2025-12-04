package vista;

import controlador.GestorAlmacen;
import modelo.Producto;
import estructuras.Nodo;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Preparamos el gestor que tiene todas las estructuras y el scanner
        GestorAlmacen gestor = new GestorAlmacen();
        Scanner leer = new Scanner(System.in);
        int opcion = 0;

        System.out.println("--- SISTEMA CARGADO CORRECTAMENTE ---");

        // Login basico pidiendo datos por consola
        System.out.print("Ingrese Usuario (admin): ");
        String user = leer.next();
        System.out.print("Ingrese Password (1234): ");
        String pass = leer.next();

        // Validamos si entra o no
        if (!gestor.validarLogin(user, pass)) {
            System.out.println("Credenciales Incorrectas! Cerrando sistema...");
            return; // Si falla, termina el programa aqui
        }

        // Bucle del menu principal, se repite hasta que elijan salir
        do {
            System.out.println("\n========== TECHWARE SYSTEM ==========");
            System.out.println("1. Ver Catalogo (Arbol ABB - Ordenado por ID)");
            System.out.println("2. Ver Estante (Matriz - Ubicacion Fisica)");
            System.out.println("3. Buscar Producto (Por ID usando Arbol)");
            System.out.println("4. Agregar al Carrito (Lista Enlazada)");
            System.out.println("5. Ver Carrito / Pagar");
            System.out.println("6. Atender Pedido (Cola - Despacho FIFO)");
            System.out.println("7. Ver Ultimo Visto (Pila - Historial LIFO)"); 
            System.out.println("8. Salir");
            System.out.print("Elija una opcion: ");
            opcion = leer.nextInt();

            switch (opcion) {
                case 1:
                    // Muestra el arbol en orden (InOrden)
                    System.out.println("\n--- CATALOGO (Recorrido InOrden del Arbol) ---");
                    gestor.getArbol().mostrarInOrden();
                    break;
                    
                case 2:
                    // Llamamos a la funcion de abajo para dibujar la matriz
                    mostrarEstante(gestor);
                    break;

                case 3:
                    // Busqueda en el arbol binario
                    System.out.print("Ingrese ID del producto a buscar: ");
                    int idBuscar = leer.nextInt();
                    Producto prod = gestor.getArbol().buscar(idBuscar); 

                    if (prod != null) {
                        System.out.println("ENCONTRADO: " + prod.toString());
                        // Si lo encontramos, lo metemos a la pila (historial)
                        gestor.getHistorial().push(prod); 
                        System.out.println("(Guardado en historial de vistos)");
                    } else {
                        System.out.println("Producto no existe.");
                    }
                    break;

                case 4:
                    // Busca primero y si existe lo mete a la lista (carrito)
                    System.out.print("Ingrese ID del producto a comprar: ");
                    int idComprar = leer.nextInt();
                    Producto pComprar = gestor.getArbol().buscar(idComprar);
                    
                    if (pComprar != null) {
                        gestor.getCarrito().agregar(pComprar);
                        System.out.println("Agregado al carrito: " + pComprar.getNombre());
                    } else {
                        System.out.println("Producto no encontrado.");
                    }
                    break;

                case 5:
                    // Recorremos la lista enlazada para mostrar el carrito
                    System.out.println("\n--- SU CARRITO DE COMPRAS ---");
                    Nodo aux = gestor.getCarrito().getCabeza();
                    if (aux == null) {
                        System.out.println("(Vacio)");
                    } else {
                        while (aux != null) {
                            System.out.println("- " + aux.dato.getNombre() + " : S/." + aux.dato.getPrecio());
                            aux = aux.siguiente; // Avanzamos al siguiente nodo
                        }
                        System.out.println("TOTAL A PAGAR: S/." + gestor.getCarrito().calcularTotal());
                        
                        // Confirmacion de compra
                        System.out.print("Confirmar Pedido? (1: Si / 0: No): ");
                        int confirma = leer.nextInt();
                        if (confirma == 1) {
                            // Pasamos todo lo del carrito a la cola de pedidos
                            Nodo temp = gestor.getCarrito().getCabeza();
                            while(temp != null) {
                                gestor.getColaPedidos().encolar(temp.dato);
                                temp = temp.siguiente;
                            }
                            System.out.println("Pedido completo enviado a Almacen (Cola)!");
                            gestor.getCarrito().limpiar(); // Vaciamos el carrito
                        }
                    }
                    break;
                    
                case 6: 
                    // Simulacion de despacho, saca el primero de la cola
                    System.out.println("\n--- DESPACHO DE ALMACEN (Cola) ---");
                    if (gestor.getColaPedidos().esVacia()) {
                        System.out.println("No hay pedidos pendientes.");
                    } else {
                        Producto atendido = gestor.getColaPedidos().desencolar();
                        System.out.println("Atendiendo pedido de: " + atendido.getNombre());
                        System.out.println("Stock descontado. Despachado!");
                    }
                    break;

                case 7: 
                    // Muestra el ultimo que buscamos 
                    System.out.println("\n--- HISTORIAL (PILA LIFO) ---");
                    if (gestor.getHistorial().esVacia()) {
                        System.out.println("No hay historial reciente.");
                    } else {
                        Producto ultimo = gestor.getHistorial().pop(); 
                        System.out.println("Ultimo producto consultado: " + ultimo.getNombre());
                        System.out.println("(Eliminado de la pila)");
                    }
                    break;
            }

        } while (opcion != 8); // Sale cuando elige 8
    }
    
    // Metodo extra para imprimir la matriz ordenada
    public static void mostrarEstante(GestorAlmacen gestor) {
        Producto[][] estante = gestor.getEstante();
        System.out.println("\n--- MAPA DEL ALMACEN (Matriz 3x3) ---");
        // Recorremos filas y columnas
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (estante[i][j] != null) {
                    System.out.print("[" + estante[i][j].getId() + "-" + estante[i][j].getNombre() + "] ");
                } else {
                    System.out.print("[ Vacio ] ");
                }
            }
            System.out.println(""); // Salto de linea al terminar la fila
        }
    }
}