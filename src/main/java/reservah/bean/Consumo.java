package reservah.bean;

public class Consumo {

    private Integer idConsumo;
    private Integer idProducto;
    private Integer idReserva;
    private Integer cantidad;
    private Double precioVenta;
    private String estado;

    public Consumo() {
    }

    public Consumo(Integer idConsumo, Integer idProducto, Integer idReserva, Integer cantidad, Double precioVenta, String estado) {
        this.idConsumo = idConsumo;
        this.idProducto = idProducto;
        this.idReserva = idReserva;
        this.cantidad = cantidad;
        this.precioVenta = precioVenta;
        this.estado = estado;
    }

    public Integer getIdConsumo() {
        return idConsumo;
    }

    public void setIdConsumo(Integer idConsumo) {
        this.idConsumo = idConsumo;
    }

    public Integer getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Integer idProducto) {
        this.idProducto = idProducto;
    }

    public Integer getIdReserva() {
        return idReserva;
    }

    public void setIdReserva(Integer idReserva) {
        this.idReserva = idReserva;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public Double getPrecioVenta() {
        return precioVenta;
    }

    public void setPrecioVenta(Double precioVenta) {
        this.precioVenta = precioVenta;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Consumo{" + "idConsumo=" + idConsumo + ", idProducto=" + idProducto + ", idReserva=" + idReserva + ", cantidad=" + cantidad + ", precioVenta=" + precioVenta + ", estado=" + estado + '}';
    }
    
}
