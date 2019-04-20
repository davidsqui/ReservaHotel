package reservah.bean;

public class Cliente extends Persona{
    private String codCliente;

    public Cliente() {
    }

    public Cliente(String codCliente, Integer idPersona, String nombres, String apellidos, String tipoDoc, String numDoc, String tipo) {
        super(idPersona, nombres, apellidos, tipoDoc, numDoc, tipo);
        this.codCliente = codCliente;
    }

    public String getCodCliente() {
        return codCliente;
    }

    public void setCodCliente(String codCliente) {
        this.codCliente = codCliente;
    }

    @Override
    public String toString() {
        return "Cliente{" + "codCliente=" + codCliente + '}'+super.toString();
    }
    
}
