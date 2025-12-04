package modelo;

public class Producto {
    // Variables privadas para proteger los datos del hardware
    private int id;
    private String nombre;
    private String categoria; // Ej: GPU, CPU, RAM
    private double precio;
    private int stock;

    // Constructor: Recibe los datos al crear el objeto y los guarda en las variables
    public Producto(int id, String nombre, String categoria, double precio, int stock) {
        this.id = id;
        this.nombre = nombre;
        this.categoria = categoria;
        this.precio = precio;
        this.stock = stock;
    }

    // Getters: Para leer los datos desde otras clases (como el Main)
    // Setters: Para modificar los datos si hiciera falta despues
    
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getCategoria() { return categoria; }
    public void setCategoria(String categoria) { this.categoria = categoria; }

    public double getPrecio() { return precio; }
    public void setPrecio(double precio) { this.precio = precio; }

    public int getStock() { return stock; }
    public void setStock(int stock) { this.stock = stock; }

    // Sobrescribimos este metodo para que al poner System.out.println salga texto legible
    // Si no hicieramos esto, saldria un codigo de memoria raro
    @Override
    public String toString() {
        return "ID: " + id + " | " + nombre + " (" + categoria + ") | S/." + precio;
    }
    
}