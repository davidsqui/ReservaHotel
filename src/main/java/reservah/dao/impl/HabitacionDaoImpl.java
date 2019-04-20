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
import reservah.dao.HabitacionDao;
import reservah.bean.Habitacion;

public class HabitacionDaoImpl implements HabitacionDao {

    private Connection cn;

    @Override
    public List<Habitacion> findAll() {
        List<Habitacion> lstHabitacion = new ArrayList<>();
        try {
            cn = Conexion.getInstance().getConnection();
            String sql = "SELECT * FROM habitacion";
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                Habitacion habitacion = new Habitacion();
                habitacion.setIdHabitacion(rs.getInt("idHabitacion"));
                habitacion.setNumero(rs.getString("numero"));
                habitacion.setPiso(rs.getString("piso"));
                habitacion.setDescripcion(rs.getString("descripcion"));
                habitacion.setCaracteristicas(rs.getString("caracteristicas"));
                habitacion.setPrecioDiario(rs.getDouble("precioDiario"));
                habitacion.setEstado(rs.getString("estado"));
                habitacion.setTipo(rs.getString("tipo"));
                lstHabitacion.add(habitacion);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lstHabitacion;
    }

    @Override
    public void create(Habitacion habitacion) {
        try {
            cn = Conexion.getInstance().getConnection();
            String sql = "call sp_crud_habitacion(null,?,?,?,?,?,?,?,1)";
            CallableStatement cs = cn.prepareCall(sql);
            cs.setString(1, habitacion.getNumero());
            cs.setString(2, habitacion.getPiso());
            cs.setString(3, habitacion.getDescripcion());
            cs.setString(4, habitacion.getCaracteristicas());
            cs.setDouble(5, habitacion.getPrecioDiario());
            cs.setString(6, habitacion.getEstado());
            cs.setString(7, habitacion.getTipo());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Habitacion habitacion) {
        try {
            cn = Conexion.getInstance().getConnection();
            String sql = "call sp_crud_habitacion(?,?,?,?,?,?,?,?,2)";
            CallableStatement cs = cn.prepareCall(sql);
            cs.setInt(1, habitacion.getIdHabitacion());
            cs.setString(2, habitacion.getNumero());
            cs.setString(3, habitacion.getPiso());
            cs.setString(4, habitacion.getDescripcion());
            cs.setString(5, habitacion.getCaracteristicas());
            cs.setDouble(6, habitacion.getPrecioDiario());
            cs.setString(7, habitacion.getEstado());
            cs.setString(8, habitacion.getTipo());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Habitacion habitacion) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Habitacion> findByParameter(String parametro) {
        List<Habitacion> lstHabitacion = new ArrayList<>();
        try {
            cn = Conexion.getInstance().getConnection();
            String sql = "SELECT *\n"
                    + "	FROM habitacion h\n"
                    + " WHERE h.numero like '%" + parametro + "%'\n"
                    + " OR h.piso like '%" + parametro + "%'\n"
                    + " OR h.tipo like '%" + parametro + "%'\n";
            PreparedStatement ps = cn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Habitacion habitacion = new Habitacion();
                habitacion.setIdHabitacion(rs.getInt("idHabitacion"));
                habitacion.setNumero(rs.getString("numero"));
                habitacion.setPiso(rs.getString("piso"));
                habitacion.setDescripcion(rs.getString("descripcion"));
                habitacion.setCaracteristicas(rs.getString("caracteristicas"));
                habitacion.setPrecioDiario(rs.getDouble("precioDiario"));
                habitacion.setEstado(rs.getString("estado"));
                habitacion.setTipo(rs.getString("tipo"));
                lstHabitacion.add(habitacion);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lstHabitacion;
    }

}
