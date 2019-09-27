package alumnos;

import java.io.Serializable;

/**
 * @author carles
 *
 */
public class Alumne implements Serializable{
	private String nom;
	private String expediente;
	private int edad;
	private double nota;
	
	
	
	public Alumne() {

	}



	public Alumne(String nom, String congnom, int edad, double nota) {
		this.nom = nom;
		this.expediente = congnom;
		this.edad = edad;
		this.nota = nota;
	}



	public String getNom() {
		return nom;
	}



	public void setNom(String nom) {
		this.nom = nom;
	}



	public String getCongnom() {
		return expediente;
	}



	public void setCongnom(String congnom) {
		this.expediente = congnom;
	}



	public int getEdad() {
		return edad;
	}



	public void setEdad(int edad) {
		this.edad = edad;
	}



	public double getNota() {
		return nota;
	}



	public void setNota(double nota) {
		this.nota = nota;
	}
	
	
	
}
