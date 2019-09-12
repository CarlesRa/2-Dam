import java.io.File;

public class Exercici05{

	public static void main(String[]args){
		String [] listaNombresArxivo;
		File f1 = new File(args[0]);
		listaNombresArxivo = f1.list();
		for (String list : listaNombresArxivo){
			File aux = new File(f1, list);
			if(aux.canRead() && aux.canWrite()){
				System.out.println(aux.getName() + " " + aux.length() + " bytes. L-E");
			}
			else if(aux.canRead() && !aux.canWrite()){
				System.out.println(aux.getName() + " " + aux.length() + " bytes. L");	
			}
			else if(!aux.canWrite() && aux.canWrite()){
				System.out.println(aux.getName() + " " + aux.length() + " bytes. E");	
			}	
		}
	}
}

