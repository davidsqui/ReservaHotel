package reservah.bean;

public class Pago {
    
    private Integer idPago;
    private Integer idReserva;
    private String tipoComprobante;
    private String numComprobante;
    private Double igv;
    private Double total;
    private String fechaEmision;
    private String fechaPago;

    public Pago() {
    }

    public Pago(Integer idPago, Integer idReserva, String tipoComprobante, String numComprobante, Double igv, Double total, String fechaEmision, String fechaPago) {
        this.idPago = idPago;
        this.idReserva = idReserva;
        this.tipoComprobante = tipoComprobante;
        this.numComprobante = numComprobante;
        this.igv = igv;
        this.total = total;
        this.fechaEmision = fechaEmision;
        this.fechaPago = fechaPago;
    }

    public Integer getIdPago() {
        return idPago;
    }

    public void setIdPago(Integer idPago) {
        this.idPago = idPago;
    }

    public Integer getIdReserva() {
        return idReserva;
    }

    public void setIdReserva(Integer idReserva) {
        this.idReserva = idReserva;
    }

    public String getTipoComprobante() {
        return tipoComprobante;
    }

    public void setTipoComprobante(String tipoComprobante) {
        this.tipoComprobante = tipoComprobante;
    }

    public String getNumComprobante() {
        return numComprobante;
    }

    public void setNumComprobante(String numComprobante) {
        this.numComprobante = numComprobante;
    }

    public Double getIgv() {
        return igv;
    }

    public void setIgv(Double igv) {
        this.igv = igv;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public String getFechaEmision() {
        return fechaEmision;
    }

    public void setFechaEmision(String fechaEmision) {
        this.fechaEmision = fechaEmision;
    }

    public String getFechaPago() {
        return fechaPago;
    }

    public void setFechaPago(String fechaPago) {
        this.fechaPago = fechaPago;
    }

    @Override
    public String toString() {
        return "Pago{" + "idPago=" + idPago + ", idReserva=" + idReserva + ", tipoComprobante=" + tipoComprobante + ", numComprobante=" + numComprobante + ", igv=" + igv + ", total=" + total + ", fechaEmision=" + fechaEmision + ", fechaPago=" + fechaPago + '}';
    }
    
}
