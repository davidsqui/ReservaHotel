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
import reservah.dao.ProductoDao;
import reservah.bean.Producto;

public class ProductoDaoImpl implements ProductoDao {

    private Connection cn;

    @Override
    public List<Producto> findAll() {
        List<Producto> lstProducto = new ArrayList<>();
        try {
            cn = Conexion.getInstance().getConnection();
            String sql = "SELECT * FROM producto";
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                Producto producto = new Producto();
                producto.setIdProducto(rs.getInt("idProducto"));
                producto.setNombre(rs.getString("nombre"));
                producto.setDescripcion(rs.getString("descripcion"));
                producto.setUnidadMedida(rs.getString("unidadMedida"));
                producto.setPrecioVenta(rs.getDouble("precioVenta"));
                lstProducto.add(producto);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lstProducto;
    }

    @Override
    public void create(Producto producto) {
        try {
            cn = Conexion.getInstance().getConnection();
            String sql = " call crudProducto(null,?,?,?,?,1)";
            CallableStatement cs = cn.prepareCall(sql);
            cs.setString(1, producto.getNombre());
            cs.setString(2, producto.getDescripcion());
            cs.setString(3, producto.getUnidadMedida());
            cs.setDouble(4, producto.getPrecioVenta());
            cs.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Producto producto) {
        try {
            cn = Conexion.getInstance().getConnection();
            String sql = " call crudProducto(?,?,?,?,?,2)";
            CallableStatement cs = cn.prepareCall(sql);
            cs.setInt(1, producto.getIdProducto());
            cs.setString(2, producto.getNombre());
            cs.setString(3, producto.getDescripcion());
            cs.setString(4, producto.getUnidadMedida());
            cs.setDouble(5, producto.getPrecioVenta());
            cs.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Producto producto) {
        try {
            cn = Conexion.getInstance().getConnection();
            String sql = " call crudProducto(?,null,null,null,null,1)";
            CallableStatement cs = cn.prepareCall(sql);
            cs.setInt(1, producto.getIdProducto());
            cs.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Producto> findByParameter(String parametro) {
        List<Producto> lstProducto = new ArrayList<>();
        try {
            cn = Conexion.getInstance().getConnection();
            String sql = "SELECT *\n"
                    + "	FROM producto\n"
                    + " WHERE nombre like '%" + parametro + "%'\n"
                    + " OR descripcion like '%" + parametro + "%';";
            PreparedStatement ps = cn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            System.out.println(ps);
            while (rs.next()) {
                Producto producto = new Producto();
                producto.setIdProducto(rs.getInt("idProducto"));
                producto.setNombre(rs.getString("nombre"));
                producto.setDescripcion(rs.getString("descripcion"));
                producto.setUnidadMedida(rs.getString("unidadMedida"));
                producto.setPrecioVenta(rs.getDouble("precioVenta"));
                lstProducto.add(producto);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lstProducto;
    }

}
