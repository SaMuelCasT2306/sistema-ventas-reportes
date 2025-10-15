package Modelos;

public class Factura {
    
    private int id;
    private String numeroFactura;
    private String fecha;
    private String condicionPago;
    private float Subtotal;
    private float igv;
    private float total;
    private int idEmpresa;
    private int idCliente;

    public Factura(int id, String numeroFactura, String fecha, String condicionPago, float Subtotal, float igv, float total, int idEmpresa, int idCliente) {
        this.id = id;
        this.numeroFactura = numeroFactura;
        this.fecha = fecha;
        this.condicionPago = condicionPago;
        this.Subtotal = Subtotal;
        this.igv = igv;
        this.total = total;
        this.idEmpresa = idEmpresa;
        this.idCliente = idCliente;
    }

    public Factura() {
    }

    public int getId() {
        return id;
    }

    public String getNumeroFactura() {
        return numeroFactura;
    }

    public String getFecha() {
        return fecha;
    }

    public String getCondicionPago() {
        return condicionPago;
    }

    public float getSubtotal() {
        return Subtotal;
    }

    public float getIgv() {
        return igv;
    }

    public float getTotal() {
        return total;
    }

    public int getIdEmpresa() {
        return idEmpresa;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNumeroFactura(String numeroFactura) {
        this.numeroFactura = numeroFactura;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public void setCondicionPago(String condicionPago) {
        this.condicionPago = condicionPago;
    }

    public void setSubtotal(float Subtotal) {
        this.Subtotal = Subtotal;
    }

    public void setIgv(float igv) {
        this.igv = igv;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    public void setIdEmpresa(int idEmpresa) {
        this.idEmpresa = idEmpresa;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }
              
}
