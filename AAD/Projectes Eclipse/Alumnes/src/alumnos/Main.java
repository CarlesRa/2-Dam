package alumnos;
import java.io.*;
public class Main {

	public static void main(String[] args)  throws IOException{
		File fichero = new File("./FicherAlumnes.dat");
		FileOutputStream fileOut = new FileOutputStream(fichero,true);
		ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
		FileInputStream fileIn = new FileInputStream(fichero);
		ObjectInputStream objectIn = new ObjectInputStream(fileIn);
		String [] nombres = {"Ana","Luis Miguel","Alicia","Pedro","Manuel"};
		String [] expedients = {"3452345","22342211","89768564","74567456","25652135"};
		int []edades = {18,12,15,16,14};
		double [] notas = {5.2,6.32,4.25,4.10,9.8};
		Alumne alumne;
		Alumne alumneMostrar;
		
		for(int i=0; i<nombres.length; i++) {
			alumne = new Alumne(nombres[i],expedients[i],edades[i],notas[i]);
			try {
			objectOut.writeObject(alumne);
			}
			catch(NotSerializableException nse) {
				
			}
		}	
		System.out.println("Alumnes ingressats amb exit!!");
		objectOut.close();
		while(true) {
			
			try {
				alumne = (Alumne)objectIn.readObject();
				System.out.println("alumne: "+alumne.getNom());
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
		}
		
	}

}
