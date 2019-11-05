package com.carlesramos;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Creates {
	public static void main(String[] args) throws SQLException {
		conectarSqlite();
	}
	
	public static void conectarSqlite() throws SQLException {
		String urlConexion = "jdbc:sqlite:/home/carles/Escritorio/clientes.db";
		Connection conexio = DriverManager.getConnection(urlConexion);
		if(conexio != null) {
			Statement s = conexio.createStatement();//interfaz para ejecutar cualquier tipo de sentencia
			String createSQL = "CREATE TABLE clientes(dni char(9) primary key, nom varchar(20),edad int);";
			s.execute(createSQL);
			System.out.println("Creando tabla...");
			insertar(s);
			selectClientes(s);
			s.close();
			conexio.close();
		}
	}
	
	public static void insertar(Statement s) {
		String insertSQL = "Insert into clientes values(100000000,'yo',33),(100000001,'tu',15);";
		
		try {
			int numFilas = s.executeUpdate(insertSQL);
			System.out.println("Se han insertado " + numFilas + " filas");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void selectClientes(Statement s) {
		String consulta = "SELECT * FROM clientes";
		try {
			ResultSet resultats = s.executeQuery(consulta);
			while (resultats.next()) {
				System.out.println("DNI: " + resultats.getString("dni") + " Nom: "
						+ resultats.getString("nom") + " edad: " + resultats.getString("edad"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
;	}
}
