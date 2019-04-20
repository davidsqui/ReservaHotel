package reservah.dao.impl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import reservah.conexion.Conexion;
import reservah.dao.ConsumoDao;
import reservah.bean.Consumo;

public class ConsumoDaoImpl implements ConsumoDao {

    private Connection cn;

    @Override
    public List<Consumo> findAll() {
        List<Consumo> lstConsumo = new ArrayList<>();
        try {
            cn = Conexion.getInstance().getConnection();
            String sql = "SELECT p.nombre,c.*\n"
                    + "FROM consumo c\n"
                    + "INNER JOIN producto p ON c.idProducto=p.idProducto\n"
                    + "INNER JOIN reserva r ON c.idReserva=c.idReserva";
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                Consumo consumo = new Consumo();
                consumo.setIdConsumo(rs.getInt("idConsumo"));
                consumo.setIdProducto(rs.getInt("idProducto"));
                consumo.setIdReserva(rs.getInt("idReserva"));
                consumo.setCantidad(rs.getInt("cantidad"));
                consumo.setPrecioVenta(rs.getDouble("precioVenta"));
                consumo.setEstado(rs.getString("estado"));
                lstConsumo.add(consumo);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lstConsumo;
    }

    @Override
    public void create(Consumo consumo) {
        try {
            cn = Conexion.getInstance().getConnection();
            String sql = "call sp_crud_consumo(null,?,?,?,?,?,1)";
            CallableStatement cs = cn.prepareCall(sql);
            cs.setInt(1, consumo.getIdProducto());
            cs.setInt(2, consumo.getIdReserva());
            cs.setInt(3, consumo.getCantidad());
            cs.setDouble(4, consumo.getPrecioVenta());
            cs.setString(5, consumo.getEstado());
            cs.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Consumo consumo) {
        try {
            cn = Conexion.getInstance().getConnection();
            String sql = "call sp_crud_consumo(null,?,?,?,?,?,2)";
            CallableStatement cs = cn.prepareCall(sql);
            cs.setInt(1, consumo.getIdConsumo());
            cs.setInt(2, consumo.getIdProducto());
            cs.setInt(3, consumo.getIdReserva());
            cs.setInt(4, consumo.getCantidad());
            cs.setDouble(5, consumo.getPrecioVenta());
            cs.setString(6, consumo.getEstado());
            cs.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Consumo consumo) {
        try {
            cn = Conexion.getInstance().getConnection();
            String sql = "call sp_crud_consumo(null,null,?,?,?,?,3)";
            CallableStatement cs = cn.prepareCall(sql);
            cs.setInt(1, consumo.getIdConsumo());
            cs.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Consumo> findByParameter(String parametro) {
        List<Consumo> lstConsumo = new ArrayList<>();
        try {
            cn = Conexion.getInstance().getConnection();
            String sql = "SELECT p.nombre,c.*\n"
                    + "FROM consumo c\n"
                    + "INNER JOIN producto p ON c.idProducto=p.idProducto\n"
                    + "INNER JOIN reserva r ON c.idReserva=c.idReserva\n"
                    + "WHERE p.nombre like '%"+parametro+"%'\n"
                    + "OR c.estado like '%"+parametro+"%'\n"
                    + "OR c.precioVenta like '%"+parametro+"%';";
            PreparedStatement ps = cn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Consumo consumo = new Consumo();
                consumo.setIdConsumo(rs.getInt("idConsumo"));
                consumo.setIdProducto(rs.getInt("idProducto"));
                consumo.setIdReserva(rs.getInt("idReserva"));
                consumo.setCantidad(rs.getInt("cantidad"));
                consumo.setPrecioVenta(rs.getDouble("precioVenta"));
                consumo.setEstado(rs.getString("estado"));
                lstConsumo.add(consumo);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lstConsumo;
    }

}
