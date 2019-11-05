package com.carlesramos.conectarsqlite;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Sqite {

	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		
		conectarSqlite();
		conectarApache();
		conectarH2();
		conectarMysql();
			
		
	}
	public static void conectarApache() throws ClassNotFoundException, SQLException {
		String urlConexion = "jdbc:derby:/home/carles/db-derby-10.14.2.0-bin/bin/dbalumnos";
		Connection conexio = DriverManager.getConnection(urlConexion);
		if(conexio != null) {
			System.out.println("Nene tira");
		
		}
		
	}
	
	public static void conectarSqlite() throws SQLException {
		String urlConexion = "jdbc:sqlite:/home/carles/Escritorio/mibade.db";
		Connection conexio = DriverManager.getConnection(urlConexion);
		if(conexio != null) {
			System.out.println("Tira Nene");
		}
	}
	
	public static void conectarH2() throws SQLException {
		String urlConexion = "jdbc:h2:/home/carles/Documentos/DAM/2º DAM/AAD/BaseDatosH2.mv.db";
		Connection conexio = DriverManager.getConnection(urlConexion);
		if(conexio != null) {
			System.out.println("Tira h2");
		}
	}
	
	public static void conectarMysql() throws SQLException {
		String urlConexion = "jdbc:mysql://localhost:3306/empresa?serverTimezone=UTC";
		Connection conexio = DriverManager.getConnection(urlConexion,"root","");
		if(conexio != null) {
			System.out.println("Tira mysql");
		}
	}
}
