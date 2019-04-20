package reservah.conexion;

import java.sql.Connection;
import java.sql.SQLException;
import org.apache.commons.dbcp2.BasicDataSource;

public class Conexion {

    private static Conexion instance;
    public static String db = null;
    public static String url = null;
    public static String user = null;
    public static String password = null;
    public static String driver = null;

    private Conexion() {
        try {
            db = "reservahotel";
            url = "jdbc:mysql://localhost/" + db + "?useSSL=false";
            user = "root";
            password = "dasc0694";
            driver = "com.mysql.cj.jdbc.Driver";
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            e.printStackTrace(System.err);
        }
    }

    public BasicDataSource getDataSource() {
        BasicDataSource ds = new BasicDataSource();
        ds.setDriverClassName(driver);
        ds.setUsername(user);
        ds.setPassword(password);
        ds.setUrl(url);
        //Definimos el tamaño inicial del pool de conexiones
        ds.setInitialSize(5);
        return ds;
    }

    public Connection getConnection() {
        Connection cn = null;
        try {
            cn = getDataSource().getConnection();
            System.out.println("Conexion exitosa");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cn;
    }

    public static Conexion getInstance() {
        if (instance == null) {
            instance = new Conexion();
        }
        return instance;
    }

}
