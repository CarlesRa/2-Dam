import java.io.File;

public class Exercici01{

	public static void main(String[]args){
		String [] lista;
		File f1 = new File(".");
		lista = f1.list();
		for (String list : lista){
			System.out.println(list);
		}
	}
}

