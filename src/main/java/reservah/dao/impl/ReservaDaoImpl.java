package reservah.dao.impl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import reservah.conexion.Conexion;
import reservah.dao.ReservaDao;
import reservah.bean.Reserva;

public class ReservaDaoImpl implements ReservaDao {

    private Connection cn;

    @Override
    public List<Reserva> findAll() {
        List<Reserva> lstReserva = new ArrayList<>();
        try {
            cn = Conexion.getInstance().getConnection();
            String sql = "SELECT * FROM reserva";
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                Reserva reserva = new Reserva();
                reserva.setIdReserva(rs.getInt("idReserva"));
                reserva.setIdHabitacion(rs.getInt("idHabitacion"));
                reserva.setIdCliente(rs.getInt("idCliente"));
                reserva.setIdTrabajador(rs.getInt("idTrabajador"));
                reserva.setFechaReserva(rs.getString("fechaReserva"));
                reserva.setFechaIngreso(rs.getString("fechaIngreso"));
                reserva.setFechaSalida(rs.getString("fechaSalida"));
                reserva.setCostoAlojamiento(rs.getDouble("costoAlojamiento"));
                reserva.setEstado(rs.getString("estado"));
                lstReserva.add(reserva);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lstReserva;
    }

    @Override
    public void create(Reserva reserva) {
        try {
            cn = Conexion.getInstance().getConnection();
            String sql = "call crudReserva(null,?,?,?,?,?,?,?,?,1)";
            CallableStatement cs = cn.prepareCall(sql);
            cs.setInt(1, reserva.getIdHabitacion());
            cs.setInt(2, reserva.getIdCliente());
            cs.setInt(3, reserva.getIdTrabajador());
            cs.setString(4, reserva.getFechaReserva());
            cs.setString(5, reserva.getFechaIngreso());
            cs.setString(6, reserva.getFechaSalida());
            cs.setDouble(7, reserva.getCostoAlojamiento());
            cs.setString(8, reserva.getEstado());
            System.out.println(cs);
            cs.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Reserva reserva) {
        try {
            cn = Conexion.getInstance().getConnection();
            String sql = "call crudReserva(null,?,?,?,?,?,?,?,?,2)";
            CallableStatement cs = cn.prepareCall(sql);
            cs.setInt(1, reserva.getIdReserva());
            cs.setInt(2, reserva.getIdHabitacion());
            cs.setInt(3, reserva.getIdCliente());
            cs.setInt(4, reserva.getIdTrabajador());
            cs.setString(5, reserva.getFechaReserva());
            cs.setString(6, reserva.getFechaIngreso());
            cs.setString(7, reserva.getFechaSalida());
            cs.setDouble(8, reserva.getCostoAlojamiento());
            cs.setString(9, reserva.getEstado());
            System.out.println(cs);
            cs.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Reserva reserva) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Reserva> findByParameter(String parametro) {
        List<Reserva> lstReserva = new ArrayList<>();
        try {
            cn = Conexion.getInstance().getConnection();
            String sql = "SELECT h.numero,CONCAT(p.nombres,' ',p.apellidos) as Cliente,t.login,r.*\n"
                    + "FROM reserva r\n"
                    + "INNER JOIN habitacion h ON r.idHabitacion=h.idHabitacion\n"
                    + "INNER JOIN cliente c ON r.idCliente=c.idPersona \n"
                    + "INNER JOIN trabajador t ON r.idTrabajador=t.idPersona\n"
                    + "INNER JOIN persona p ON c.idPersona=p.idPersona\n"
                    + "WHERE h.numero like '%" + parametro + "%'\n"
                    + "OR p.nombres like '%" + parametro + "%'\n"
                    + "OR p.apellidos like '%" + parametro + "%'\n"
                    + "OR t.login like '%" + parametro + "%';";
            PreparedStatement ps = cn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Reserva reserva = new Reserva();
                reserva.setIdReserva(rs.getInt("idReserva"));
                reserva.setIdHabitacion(rs.getInt("idHabitacion"));
                reserva.setIdCliente(rs.getInt("idCliente"));
                reserva.setIdTrabajador(rs.getInt("idTrabajador"));
                reserva.setFechaReserva(rs.getString("fechaReserva"));
                reserva.setFechaIngreso(rs.getString("fechaIngreso"));
                reserva.setFechaSalida(rs.getString("fechaSalida"));
                reserva.setCostoAlojamiento(rs.getDouble("costoAlojamiento"));
                reserva.setEstado(rs.getString("estado"));
                lstReserva.add(reserva);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lstReserva;
    }

}
