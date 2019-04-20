package reservah.pruebas;

import java.sql.Connection;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import reservah.conexion.Conexion;
import reservah.dao.ClienteDao;
import reservah.dao.TrabajadorDao;
import reservah.dao.ReservaDao;
import reservah.dao.ReservaDao;
import reservah.bean.Cliente;
import reservah.bean.Trabajador;
import reservah.bean.Reserva;
import reservah.dao.impl.ClienteDaoImpl;
import reservah.dao.impl.TrabajadorDaoImpl;
import reservah.dao.impl.ReservaDaoImpl;

public class Prueba1 {

    public static void main(String[] args) {
        
        Cliente cliente = new Cliente("C000000001", null, "David Mijael", "Sanchez Quispe", "DNI", "72541607", null);
        ClienteDao dao = new ClienteDaoImpl();
        dao.create(cliente);
        
        dao.findAll().forEach((c) -> {
            System.out.println(c);
        });

    }
    
}
