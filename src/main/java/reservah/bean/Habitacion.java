package reservah.bean;

public class Habitacion {
    private Integer idHabitacion;
    private String numero;
    private String piso;
    private String descripcion;
    private String caracteristicas;
    private Double precioDiario;
    private String estado;
    private String tipo;

    public Habitacion() {
    }

    public Habitacion(Integer idHabitacion, String numero, String piso, String descripcion, String caracteristicas, Double precioDiario, String estado, String tipo) {
        this.idHabitacion = idHabitacion;
        this.numero = numero;
        this.piso = piso;
        this.descripcion = descripcion;
        this.caracteristicas = caracteristicas;
        this.precioDiario = precioDiario;
        this.estado = estado;
        this.tipo = tipo;
    }

    public Integer getIdHabitacion() {
        return idHabitacion;
    }

    public void setIdHabitacion(Integer idHabitacion) {
        this.idHabitacion = idHabitacion;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getPiso() {
        return piso;
    }

    public void setPiso(String piso) {
        this.piso = piso;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getCaracteristicas() {
        return caracteristicas;
    }

    public void setCaracteristicas(String caracteristicas) {
        this.caracteristicas = caracteristicas;
    }

    public Double getPrecioDiario() {
        return precioDiario;
    }

    public void setPrecioDiario(Double precioDiario) {
        this.precioDiario = precioDiario;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return "Habitacion{" + "idHabitacion=" + idHabitacion + ", numero=" + numero + ", piso=" + piso + ", descripcion=" + descripcion + ", caracteristicas=" + caracteristicas + ", precioDiario=" + precioDiario + ", estado=" + estado + ", tipo=" + tipo + '}';
    }
    
}
