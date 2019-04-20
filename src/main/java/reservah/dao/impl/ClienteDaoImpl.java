package reservah.dao.impl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import reservah.conexion.Conexion;
import reservah.dao.ClienteDao;
import reservah.bean.Cliente;

public class ClienteDaoImpl implements ClienteDao {

    private Connection cn;

    @Override
    public List<Cliente> findAll() {
        List<Cliente> lstCliente = new ArrayList<>();
        try {
            cn = Conexion.getInstance().getConnection();
            String sql = "SELECT c.codCliente,p.idpersona,p.nombres,p.apellidos,p.tipodoc,p.numdoc,p.direccion,p.telefono,p.email\n"
                    + "	FROM persona p,cliente c\n"
                    + " WHERE p.idpersona=c.idpersona;";
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                Cliente cliente = new Cliente();
                cliente.setCodCliente(rs.getString("codCliente"));
                cliente.setIdpersona(rs.getInt("idPersona"));
                cliente.setNombres(rs.getString("nombres"));
                cliente.setApellidos(rs.getString("apellidos"));
                cliente.setTipoDoc(rs.getString("tipoDoc"));
                cliente.setNumDoc(rs.getString("numDoc"));
                cliente.setDireccion(rs.getString("direccion"));
                cliente.setTelefono(rs.getString("telefono"));
                cliente.setEmail(rs.getString("email"));
                lstCliente.add(cliente);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lstCliente;
    }

    @Override
    public void create(Cliente cliente) {
        try {
            cn = Conexion.getInstance().getConnection();
            String sql = "call sp_crud_cliente(null,?,?,?,?,?,?,?,?,1)";
            CallableStatement cs = cn.prepareCall(sql);
            cs.setString(1, cliente.getCodCliente());
            cs.setString(2, cliente.getNombres());
            cs.setString(3, cliente.getApellidos());
            cs.setString(4, cliente.getTipoDoc());
            cs.setString(5, cliente.getNumDoc());
            cs.setString(6, cliente.getDireccion());
            cs.setString(7, cliente.getTelefono());
            cs.setString(8, cliente.getEmail());
            cs.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            e.getMessage();
        }
    }

    @Override
    public void update(Cliente cliente) {
        try {
            cn = Conexion.getInstance().getConnection();
            String sql = "call sp_crud_cliente(?,?,?,?,?,?,?,?,?,2)";
            CallableStatement cs = cn.prepareCall(sql);
            cs.setInt(1, cliente.getIdpersona());
            cs.setString(2, cliente.getCodCliente());
            cs.setString(3, cliente.getNombres());
            cs.setString(4, cliente.getApellidos());
            cs.setString(5, cliente.getTipoDoc());
            cs.setString(6, cliente.getNumDoc());
            cs.setString(7, cliente.getDireccion());
            cs.setString(8, cliente.getTelefono());
            cs.setString(9, cliente.getEmail());
            cs.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Cliente cliente) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Cliente> findByParameter(String parametro) {
        List<Cliente> lstCliente = new ArrayList<>();
        try {
            cn = Conexion.getInstance().getConnection();
            String sql = "SELECT c.codCliente,p.idpersona,p.nombres,p.apellidos,p.tipodoc,p.numdoc,p.direccion,p.telefono,p.email\n"
                    + "	FROM persona p,cliente c\n"
                    + "    WHERE p.idpersona=c.idpersona\n"
                    + "    AND  (p.numdoc like '%"+parametro+"%'\n"
                    + "    OR p.nombres like '%"+parametro+"%'\n"
                    + "    OR p.apellidos like '%"+parametro+"%'\n"
                    + "    );";
            PreparedStatement ps = cn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Cliente cliente = new Cliente();
                cliente.setCodCliente(rs.getString("codCliente"));
                cliente.setIdpersona(rs.getInt("idPersona"));
                cliente.setNombres(rs.getString("nombres"));
                cliente.setApellidos(rs.getString("apellidos"));
                cliente.setTipoDoc(rs.getString("tipoDoc"));
                cliente.setNumDoc(rs.getString("numDoc"));
                cliente.setDireccion(rs.getString("direccion"));
                cliente.setTelefono(rs.getString("telefono"));
                cliente.setEmail(rs.getString("email"));
                lstCliente.add(cliente);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lstCliente;
    }

}
