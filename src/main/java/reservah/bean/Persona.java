package reservah.bean;

public class Persona {
    
    private Integer idPersona;
    private String nombres;
    private String apellidos;
    private String tipoDoc;
    private String numDoc;
    private String direccion;
    private String telefono;
    private String email;
    private String tipo;

    public Persona() {
    }

    public Persona(Integer idPersona, String nombres, String apellidos, String tipoDoc, String numDoc, String tipo) {
        this.idPersona = idPersona;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.tipoDoc = tipoDoc;
        this.numDoc = numDoc;
        this.tipo = tipo;
    }

    public Integer getIdpersona() {
        return idPersona;
    }

    public void setIdpersona(Integer idPersona) {
        this.idPersona = idPersona;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getTipoDoc() {
        return tipoDoc;
    }

    public void setTipoDoc(String tipoDoc) {
        this.tipoDoc = tipoDoc;
    }

    public String getNumDoc() {
        return numDoc;
    }

    public void setNumDoc(String numDoc) {
        this.numDoc = numDoc;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return "Persona{" + "idPersona=" + idPersona + ", nombres=" + nombres + ", apellidos=" + apellidos + ", tipoDoc=" + tipoDoc + ", numDoc=" + numDoc + ", direccion=" + direccion + ", telefono=" + telefono + ", email=" + email + ", tipo=" + tipo + '}';
    }
    
}
