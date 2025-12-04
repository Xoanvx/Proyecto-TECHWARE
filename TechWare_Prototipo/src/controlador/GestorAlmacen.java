package controlador;

import modelo.Producto;
import estructuras.ListaEnlazada;
import estructuras.Cola;
import estructuras.Pila;
import estructuras.ArbolABB;

public class GestorAlmacen {
    
    // Matriz 3x3 para simular los estantes fisicos del almacen
    private Producto[][] estante;
    
    // Arreglos para guardar usuarios y claves (login basico)
    private String[] usuarios;
    private String[] passwords; 
    
    // Estructuras de datos para manejar la logica del programa
    private ListaEnlazada carritoCompras;
    private Cola colaPedidos;
    private ArbolABB arbolProductos;
    private Pila historialVistos;
    
    public GestorAlmacen() {
        // Inicializamos todas las estructuras vacias
        estante = new Producto[3][3]; 
        usuarios = new String[2];
        passwords = new String[2];
        carritoCompras = new ListaEnlazada();
        colaPedidos = new Cola();
        arbolProductos = new ArbolABB(); 
        historialVistos = new Pila();
        
        // Cargamos los datos de prueba apenas inicia la clase
        cargarDatosFicticios();
    }
    
    // Metodo para meter datos "a mano" ya que no usamos base de datos
    private void cargarDatosFicticios() {
        // 1. Creamos usuarios de prueba
        usuarios[0] = "admin";    passwords[0] = "1234";
        usuarios[1] = "vendedor"; passwords[1] = "abcd";
        
        // 2. Llenamos el estante (Matriz) con productos
        // Fila 0: Tarjetas de Video
        estante[0][0] = new Producto(101, "RTX 3060", "GPU", 350.00, 10);
        estante[0][1] = new Producto(102, "RTX 4090", "GPU", 1200.00, 5);
        estante[0][2] = new Producto(103, "RX 6600", "GPU", 280.00, 8);
        
        // Fila 1: Procesadores
        estante[1][0] = new Producto(201, "Ryzen 5", "CPU", 180.00, 15);
        estante[1][1] = new Producto(202, "Core i7", "CPU", 320.00, 12);
        estante[1][2] = new Producto(203, "Ryzen 9", "CPU", 500.00, 4);
        
        // Fila 2: Memorias RAM
        estante[2][0] = new Producto(301, "RAM 8GB", "RAM", 40.00, 50);
        estante[2][1] = new Producto(302, "RAM 16GB", "RAM", 75.00, 30);
        estante[2][2] = new Producto(303, "RAM 32GB", "RAM", 140.00, 20);

        // 3. Pasamos todo lo de la matriz al Arbol Binario
        // Recorremos filas y columnas para copiar los datos
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (estante[i][j] != null) {
                    // Lo insertamos en el arbol para buscar rapido por ID despues
                    arbolProductos.insertar(estante[i][j]); 
                }
            }
        }
    }
    
    // Retorna la matriz para poder verla en el Main
    public Producto[][] getEstante() {
        return estante;
    }
    
    // Comprobamos si el usuario y la clave existen en los arreglos
    public boolean validarLogin(String user, String pass) {
        for (int i = 0; i < usuarios.length; i++) {
            // Si coinciden ambos en la misma posicion, es valido
            if (usuarios[i].equals(user) && passwords[i].equals(pass)) {
                return true;
            }
        }
        return false;
    }
    
    // Getters para que el Main pueda usar las estructuras
    public ListaEnlazada getCarrito() { return carritoCompras; }
    public Cola getColaPedidos() { return colaPedidos; }
    public ArbolABB getArbol() { return arbolProductos; }
    public Pila getHistorial() { return historialVistos; }
}