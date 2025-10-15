package Modelos;

public class DetalleFactura {
    
    private int id;
    private int idFactura;
    private int idProducto;
    private int cantidad;
    private float precioUnitario;
    private float importe;

    public DetalleFactura(int id, int idFactura, int idProducto, int cantidad, float precioUnitario, float importe) {
        this.id = id;
        this.idFactura = idFactura;
        this.idProducto = idProducto;
        this.cantidad = cantidad;
        this.precioUnitario = precioUnitario;
        this.importe = importe;
    }

    public DetalleFactura() {
    }

    public int getId() {
        return id;
    }

    public int getIdFactura() {
        return idFactura;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public float getPrecioUnitario() {
        return precioUnitario;
    }

    public float getImporte() {
        return importe;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setIdFactura(int idFactura) {
        this.idFactura = idFactura;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public void setPrecioUnitario(float precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    public void setImporte(float importe) {
        this.importe = importe;
    }
    
    
    
}
