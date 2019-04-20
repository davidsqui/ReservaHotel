package reservah.dao.impl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import reservah.conexion.Conexion;
import reservah.dao.PagoDao;
import reservah.bean.Pago;

public class PagoDaoImpl implements PagoDao {

    private Connection cn;

    @Override
    public List<Pago> findAll() {
        List<Pago> lstPago = new ArrayList<>();
        try {
            cn = Conexion.getInstance().getConnection();
            String sql = "SELECT p.*\n"
                    + "FROM pago p\n"
                    + "INNER JOIN reserva r ON p.idReserva=r.idReserva";
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                Pago pago = new Pago();
                pago.setIdPago(rs.getInt("idPago"));
                pago.setIdReserva(rs.getInt("idReserva"));
                pago.setTipoComprobante(rs.getString("tipoComprobante"));
                pago.setNumComprobante(rs.getString("numComprobante"));
                pago.setIgv(rs.getDouble("igv"));
                pago.setTotal(rs.getDouble("totalPago"));
                pago.setFechaEmision(rs.getString("fechaEmision"));
                pago.setFechaPago(rs.getString("fechaPago"));
                lstPago.add(pago);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lstPago;
    }

    @Override
    public void create(Pago pago) {
        try {
            cn = Conexion.getInstance().getConnection();
            String sql = "call sp_crud_pago(null,?,?,?,?,?,?,?,1)";
            CallableStatement cs = cn.prepareCall(sql);
            cs.setInt(1, pago.getIdReserva());
            cs.setString(2, pago.getTipoComprobante());
            cs.setString(3, pago.getNumComprobante());
            cs.setDouble(4, pago.getIgv());
            cs.setDouble(5, pago.getTotal());
            cs.setString(6, pago.getFechaEmision());
            cs.setString(7, pago.getFechaPago());
            cs.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Pago pago) {
        try {
            cn = Conexion.getInstance().getConnection();
            String sql = "call sp_crud_pago(?,?,?,?,?,?,?,?,2)";
            CallableStatement cs = cn.prepareCall(sql);
            cs.setInt(1, pago.getIdPago());
            cs.setInt(2, pago.getIdReserva());
            cs.setString(3, pago.getTipoComprobante());
            cs.setString(4, pago.getNumComprobante());
            cs.setDouble(5, pago.getIgv());
            cs.setDouble(6, pago.getTotal());
            cs.setString(7, pago.getFechaEmision());
            cs.setString(8, pago.getFechaPago());
            cs.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Pago pago) {
        try {
            cn = Conexion.getInstance().getConnection();
            String sql = "call sp_crud_pago(?,null,null,null,null,null,null,null,3)";
            CallableStatement cs = cn.prepareCall(sql);
            cs.setInt(1, pago.getIdPago());
            cs.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Pago> findByParameter(String parametro) {
        List<Pago> lstPago = new ArrayList<>();
        try {
            cn = Conexion.getInstance().getConnection();
            String sql = "SELECT p.*\n"
                    + "FROM pago p\n"
                    + "INNER JOIN reserva r ON p.idReserva=r.idReserva\n"
                    + "WHERE p.tipoComprobante LIKE '%" + parametro + "%'\n"
                    + "OR p.numComprobante LIKE '%" + parametro + "%'\n"
                    + "OR p.fechaPago LIKE '%" + parametro + "%'\n"
                    + "OR p.fechaEmision LIKE '%" + parametro + "%'\n";
            PreparedStatement ps = cn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Pago pago = new Pago();
                pago.setIdPago(rs.getInt("idPago"));
                pago.setIdReserva(rs.getInt("idReserva"));
                pago.setTipoComprobante(rs.getString("tipoComprobante"));
                pago.setNumComprobante(rs.getString("numComprobante"));
                pago.setIgv(rs.getDouble("igv"));
                pago.setTotal(rs.getDouble("totalPago"));
                pago.setFechaEmision(rs.getString("fechaEmision"));
                pago.setFechaPago(rs.getString("fechaPago"));
                lstPago.add(pago);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lstPago;
    }

}
