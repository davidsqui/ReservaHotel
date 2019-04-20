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
import reservah.dao.TrabajadorDao;
import reservah.bean.Trabajador;

public class TrabajadorDaoImpl implements TrabajadorDao {

    private Connection cn;

    @Override
    public List<Trabajador> findAll() {
        List<Trabajador> lstTrabajador = new ArrayList<>();
        try {
            cn = Conexion.getInstance().getConnection();
            String sql = "SELECT t.sueldo,t.acceso,t.login,t.password,t.estado,p.*\n"
                    + "	FROM trabajador t\n"
                    + " INNER JOIN persona p ON t.idpersona=p.idPersona;";
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                Trabajador trabajador = new Trabajador();
                trabajador.setSueldo(rs.getDouble("sueldo"));
                trabajador.setAcceso(rs.getString("acceso"));
                trabajador.setLogin(rs.getString("login"));
                trabajador.setPassword(rs.getString("password"));
                trabajador.setEstado(rs.getString("estado"));
                trabajador.setIdpersona(rs.getInt("idPersona"));
                trabajador.setNombres(rs.getString("nombres"));
                trabajador.setApellidos(rs.getString("apellidos"));
                trabajador.setTipoDoc(rs.getString("tipoDoc"));
                trabajador.setNumDoc(rs.getString("numDoc"));
                trabajador.setDireccion(rs.getString("direccion"));
                trabajador.setTelefono(rs.getString("telefono"));
                trabajador.setEmail(rs.getString("email"));
                lstTrabajador.add(trabajador);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lstTrabajador;
    }

    @Override
    public void create(Trabajador trabajador) {
        try {
            cn = Conexion.getInstance().getConnection();
            String sql = "call crudTrabajador(?,?,?,?,?,null,?,?,?,?,?,?,?,1)";
            CallableStatement cs = cn.prepareCall(sql);
            cs.setDouble(1, trabajador.getSueldo());
            cs.setString(2, trabajador.getAcceso());
            cs.setString(3, trabajador.getLogin());
            cs.setString(4, trabajador.getPassword());
            cs.setString(5, trabajador.getEstado());
            cs.setString(6, trabajador.getNombres());
            cs.setString(7, trabajador.getApellidos());
            cs.setString(8, trabajador.getTipoDoc());
            cs.setString(9, trabajador.getNumDoc());
            cs.setString(10, trabajador.getDireccion());
            cs.setString(11, trabajador.getTelefono());
            cs.setString(12, trabajador.getEmail());
            cs.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Trabajador trabajador) {
        try {
            cn = Conexion.getInstance().getConnection();
            String sql = "call crudTrabajador(?,?,?,?,?,?,?,?,?,?,?,?,?,2)";
            CallableStatement cs = cn.prepareCall(sql);
            cs.setDouble(1, trabajador.getSueldo());
            cs.setString(2, trabajador.getAcceso());
            cs.setString(3, trabajador.getLogin());
            cs.setString(4, trabajador.getPassword());
            cs.setString(5, trabajador.getEstado());
            cs.setInt(6, trabajador.getIdpersona());
            cs.setString(7, trabajador.getNombres());
            cs.setString(8, trabajador.getApellidos());
            cs.setString(9, trabajador.getTipoDoc());
            cs.setString(10, trabajador.getNumDoc());
            cs.setString(11, trabajador.getDireccion());
            cs.setString(12, trabajador.getTelefono());
            cs.setString(13, trabajador.getEmail());
            cs.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Trabajador trabajador) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Trabajador> findByParameter(String parametro) {
        List<Trabajador> lstTrabajador = new ArrayList<>();
        try {
            cn = Conexion.getInstance().getConnection();
            String sql = "SELECT t.sueldo,t.acceso,t.login,t.password,t.estado,p.*\n"
                    + "	FROM trabajador t\n"
                    + "    INNER JOIN persona p ON t.idpersona=p.idPersona\n"
                    + "    WHERE t.login like '%" + parametro + "%'\n"
                    + "    OR p.numdoc like '%" + parametro + "%'\n"
                    + "    OR p.nombres like '%" + parametro + "%'\n"
                    + "    OR p.apellidos like '%" + parametro + "%'\n";
            PreparedStatement ps = cn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Trabajador trabajador = new Trabajador();
                trabajador.setSueldo(rs.getDouble("sueldo"));
                trabajador.setAcceso(rs.getString("acceso"));
                trabajador.setLogin(rs.getString("login"));
                trabajador.setPassword(rs.getString("password"));
                trabajador.setEstado(rs.getString("estado"));
                trabajador.setIdpersona(rs.getInt("idPersona"));
                trabajador.setNombres(rs.getString("nombres"));
                trabajador.setApellidos(rs.getString("apellidos"));
                trabajador.setTipoDoc(rs.getString("tipoDoc"));
                trabajador.setNumDoc(rs.getString("numDoc"));
                trabajador.setDireccion(rs.getString("direccion"));
                trabajador.setTelefono(rs.getString("telefono"));
                trabajador.setEmail(rs.getString("email"));
                lstTrabajador.add(trabajador);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lstTrabajador;
    }

}
