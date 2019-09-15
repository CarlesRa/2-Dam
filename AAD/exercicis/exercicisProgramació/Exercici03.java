import java.io.File;

public class Exercici03{

	public static void main(String[]args){
		String [] listaNombresArxivo;
		File f1 = new File(args[0]);
		listaNombresArxivo = f1.list();
		for (String list : listaNombresArxivo){
			File aux = new File(f1, list);
			if(aux.isDirectory()){
				System.out.println("-D- " + aux.getName() + " " + aux.length() + " bytes.");
			}
			else
				System.out.println("-A- " + aux.getName() + " " + aux.length() + " bytes.");	
		}
	}
}

