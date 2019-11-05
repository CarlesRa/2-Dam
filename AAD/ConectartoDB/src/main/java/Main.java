import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {

			//Class.forName("org.sqlite.JDBC");
			String urlConexion = "/home/carles/Escritorio/mibade.db";
			Connection conexio = DriverManager.getConnection(urlConexion);
			if(conexio != null) {
				System.out.println("Tira Nene");
			}
        //conectarApache();



    }
    public static void conectarApache() throws ClassNotFoundException, SQLException {
        //Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
        String urlConexion = "/home/carles/db-derby-10.14.2.0-bin/bin/dbalumnos";
        Connection conexio = DriverManager.getConnection(urlConexion);
        if(conexio != null) {
            System.out.println("Tira Nene");
        }

    }
}
