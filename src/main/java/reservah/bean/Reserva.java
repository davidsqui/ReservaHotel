package reservah.bean;

public class Reserva {
    
    private Integer idReserva;
    private Integer idHabitacion;
    private Integer idCliente;
    private Integer idTrabajador;
    private String fechaReserva;
    private String fechaIngreso;
    private String fechaSalida;
    private Double costoAlojamiento;
    private String estado;

    public Reserva() {
    }

    public Reserva(Integer idReserva, Integer idHabitacion, Integer idCliente, Integer idTrabajador, String fechaReserva, String fechaIngreso, String fechaSalida, Double costoAlojamiento, String estado) {
        this.idReserva = idReserva;
        this.idHabitacion = idHabitacion;
        this.idCliente = idCliente;
        this.idTrabajador = idTrabajador;
        this.fechaReserva = fechaReserva;
        this.fechaIngreso = fechaIngreso;
        this.fechaSalida = fechaSalida;
        this.costoAlojamiento = costoAlojamiento;
        this.estado = estado;
    }

    public Integer getIdReserva() {
        return idReserva;
    }

    public void setIdReserva(Integer idReserva) {
        this.idReserva = idReserva;
    }

    public Integer getIdHabitacion() {
        return idHabitacion;
    }

    public void setIdHabitacion(Integer idHabitacion) {
        this.idHabitacion = idHabitacion;
    }

    public Integer getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Integer idCliente) {
        this.idCliente = idCliente;
    }

    public Integer getIdTrabajador() {
        return idTrabajador;
    }

    public void setIdTrabajador(Integer idTrabajador) {
        this.idTrabajador = idTrabajador;
    }

    public String getFechaReserva() {
        return fechaReserva;
    }

    public void setFechaReserva(String fechaReserva) {
        this.fechaReserva = fechaReserva;
    }

    public String getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(String fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public String getFechaSalida() {
        return fechaSalida;
    }

    public void setFechaSalida(String fechaSalida) {
        this.fechaSalida = fechaSalida;
    }

    public Double getCostoAlojamiento() {
        return costoAlojamiento;
    }

    public void setCostoAlojamiento(Double costoAlojamiento) {
        this.costoAlojamiento = costoAlojamiento;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Reserva{" + "idReserva=" + idReserva + ", idHabitacion=" + idHabitacion + ", idCliente=" + idCliente + ", idTrabajador=" + idTrabajador + ", fechaReserva=" + fechaReserva + ", fechaIngreso=" + fechaIngreso + ", fechaSalida=" + fechaSalida + ", costoAlojamiento=" + costoAlojamiento + ", estado=" + estado + '}';
    }
    
}

