/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto_inventario.controlador;

import proyecto_inventario.modelo.Proveedor;
import proyecto_inventario.modelo.ListaSimpleProveedores;

/**
 *
 * @author JuanVic
 */
public class MainPruebas {
    public static void main(String[] args) {
        ListaSimpleProveedores miLista = new ListaSimpleProveedores();
        
        System.out.println("Probando lista vacia:");
        miLista.mostrarEnConsola();
        
        // proveedores para pruebas
        Proveedor p1 = new Proveedor("123", "Gaseosas SAC", "999111", "Av. Sol 123");
        Proveedor p2 = new Proveedor("456", "Galletas SA", "999222", "Av. Luna 456");
        
        // insercion
        miLista.insertarAlFinal(p1);
        miLista.insertarAlFinal(p2);
        
        System.out.println("\nProbando lista con datos:");
        miLista.mostrarEnConsola();
    }
}
