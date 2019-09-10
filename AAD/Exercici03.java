import java.io.File;

public class Exercici02{

	public static void main(String[]args){
		String [] lista;
		File f1 = new File(args[0]);
		lista = f1.list();
		for (String list : lista){

			if(list.isDirectory()){
				System.out.println("-D- " + list);	
			}
			
		}
	}
}

