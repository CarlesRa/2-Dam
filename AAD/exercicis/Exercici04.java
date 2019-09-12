import java.io.File;
public class Exercici04{
	public static void main(String []args) throws IOException {
		File f1 = new File(".","Exercici01.java");
		System.out.println(f1.getPath() +"\n"+f1.getAbsolutePath()+"\n"+f1.getCanonicalPath());
		
	}
}
