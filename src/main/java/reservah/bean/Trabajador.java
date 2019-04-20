package reservah.bean;

public class Trabajador extends Persona{
    
    private Double sueldo;
    private String acceso;
    private String login;
    private String password;
    private String estado;

    public Trabajador() {
    }

    public Trabajador(Double sueldo, String acceso, String login, String password, String estado, Integer idPersona, String nombres, String apellidos, String tipoDoc, String numDoc, String tipo) {
        super(idPersona, nombres, apellidos, tipoDoc, numDoc, tipo);
        this.sueldo = sueldo;
        this.acceso = acceso;
        this.login = login;
        this.password = password;
        this.estado = estado;
    }

    public Double getSueldo() {
        return sueldo;
    }

    public void setSueldo(Double sueldo) {
        this.sueldo = sueldo;
    }

    public String getAcceso() {
        return acceso;
    }

    public void setAcceso(String acceso) {
        this.acceso = acceso;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Trabajador{" + "sueldo=" + sueldo + ", acceso=" + acceso + ", login=" + login + ", password=" + password + ", estado=" + estado + '}'+super.toString();
    }
    
    
}
