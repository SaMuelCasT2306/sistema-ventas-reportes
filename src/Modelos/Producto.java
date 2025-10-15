package Modelos;

public class Producto {
    
    private int id;
    private String codigo;
    private String nombre;
    private float precioUnitario;

    public Producto(int id, String codigo, String nombre, float precioUnitario) {
        this.id = id;
        this.codigo = codigo;
        this.nombre = nombre;
        this.precioUnitario = precioUnitario;
    }

    public Producto() {
    }

    public int getId() {
        return id;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public float getPrecioUnitario() {
        return precioUnitario;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setPrecioUnitario(float precioUnitario) {
        this.precioUnitario = precioUnitario;
    }
        
    
}
