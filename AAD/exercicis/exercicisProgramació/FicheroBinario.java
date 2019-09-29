import java.io.*;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.UnknownFormatConversionException;
import java.util.Locale;

public class FicheroBinario{
    static final int TAMAÑO_REGISTRO = 88;
    public static Scanner lec = new Scanner(System.in).useLocale(Locale.FRANCE);
    static long expediente;
    static String nombre;
    static String conOrdinaria;
    static double notaOrdinaria;
    static String conExtraordinaria;
    static double notaExtraordinaria;
    static File f1;
    public static void main(String[] args) throws IOException, FileNotFoundException {
        int eleccion;
        RandomAccessFile raf;
        f1 = new File(args[0]);
        raf = new RandomAccessFile(f1, "rw");
        do{
            eleccion = mostrarMenu();
            switch(eleccion){
                case 1:{
                    insertarRegistro(args[0]);
                    break;
                }
                case 2:{
                    modificarTodoRegistro(args[0]);
                    break;
                }
                case 3:{
                    modificarCampos(args[0]);
                    break;
                }
                case 4:{
                    listarRegistros(args[0]);
                    break;
                }
                case 5:{
                    System.out.println("Eleccion 5");
                    break;
                }
                case 0:{
                    System.out.println("VULEVE PRONTO!!");
                    raf.close();
                    break;
                }
            }
        }while(eleccion != 0);
    }
    /**
     * Métode que mostra el menu
     * @return la elecció del menu
     */
    public static int mostrarMenu(){
        int eleccion = Integer.MIN_VALUE;
        System.out.println("*******MENU PRINCIPAL*******");
        System.out.println("1-Crear un nuevo registro");
        System.out.println("2-Modificar todo un registro");
        System.out.println("3-Modificar campos");
        System.out.println("4-Listar todos los registros");
        System.out.println("5-Eliminar registro");
        System.out.println("0-SALIR");
        System.out.print("Elige una opción: ");
        try{
            eleccion = lec.nextInt();
            lec.nextLine();
        }
        catch(InputMismatchException imme){
            System.out.println("Solo se aceptan números....");
        }
        if(eleccion > 5 || eleccion < 0){
            System.out.println("Solo puedes elegir del 0 al 5");
            pausar();
        }
        return eleccion;
    }

    public static int menuCampos(){
        int eleccion = Integer.MIN_VALUE;
        System.out.println("*******CAMPOS A MODIFICAR*******");
        System.out.println("1-Expediente");
        System.out.println("2-Nombre");
        System.out.println("3-Convocatoria ordinaria");
        System.out.println("4-nota Ordinaria");
        System.out.println("5-convocatoria extraordinaria");
        System.out.println("6-nota Extraordinaria");
        System.out.println("0-MENU PRINCIPAL");
        System.out.print("Elige una opción: ");
        try{
            eleccion = lec.nextInt();
            lec.nextLine();
        }
        catch(InputMismatchException imme){
            System.out.println("Solo se aceptan números....");
        }
        if(eleccion > 6 || eleccion < 0){
            System.out.println("Solo puedes elegir del 0 al 6");
            pausar();
        }
        return eleccion;
    }   
    /**
     * Pide los datos e
     * Inserta un registro al fichero pasado por parametro
     * @param path pasamos el path del fichero donde queremos insertar
     * @throws IOException
     * @throws FileNotFoundException
     */
    public static void insertarRegistro(String path) throws IOException,FileNotFoundException {
        int posicion;
        boolean seguir;
        RandomAccessFile raf;
        f1 = new File(path);
        raf = new RandomAccessFile(f1, "rw");
        posicion = 0;
        seguir = false;
        if(raf.length() > 0){
            posicion = posicionRegistro();
            raf.seek(((long)posicion - 1) * TAMAÑO_REGISTRO );
        }
        else{
            posicion++;
        }
        System.out.print("Expediente del alumno: ");
        expediente = lec.nextLong();
        lec.nextLine();
        System.out.print("Nombre del alumno: ");
        nombre = lec.nextLine();
        do{
            System.out.print("Fecha convocatoria ordinaria: ");
            conOrdinaria = lec.nextLine();
            if(conOrdinaria.length() != 8){
                System.out.println("La fecha solo puede tener 8 caracteres...");
                pausar();
                seguir = false;
            }
            else{
                seguir = true;
            }
        }while(!seguir);
        System.out.print("Nota evaluación ordinaria: ");
        notaOrdinaria = lec.nextDouble();
        lec.nextLine();
        do{
            System.out.print("fecha convocatoria extraordinaria: ");
            conExtraordinaria = lec.nextLine();
            if(conExtraordinaria.length() != 8){
                System.out.println("La fecha solo puede tener 8 caracteres...");
                pausar();
                seguir = false;
            }
            else{
                seguir = true;
            }
        }while(!seguir);
        System.out.print("Nota evaluacion ordinaria: ");
        notaExtraordinaria = lec.nextDouble();
        lec.nextLine();
        raf.writeInt(posicion);
        raf.writeLong(expediente);
        raf.writeChars(stringDelimitado(nombre));
        raf.writeChars(stringDelimitado(conOrdinaria));
        raf.writeDouble(notaOrdinaria);
        raf.writeChars(stringDelimitado(conExtraordinaria));
        raf.writeDouble(notaExtraordinaria);
        raf.close();
    }
    /**
     * modifica todo un registro
     * @param path path del arxivo que necesita
     * @throws IOException
     * @throws FileNotFoundException
     */
    public static void modificarTodoRegistro(String path)throws IOException,FileNotFoundException {
        RandomAccessFile raf;
        int puntero;
        boolean seguir;
        f1 = new File(path);
        raf = new RandomAccessFile(f1, "rw");
        System.out.print("Indica el ID del registro a modificar: ");
        puntero = lec.nextInt();
        lec.nextLine();
        if((puntero-1) * TAMAÑO_REGISTRO > raf.length()){
            System.out.println("No existe registro con ese ID...");
        }
        else{
            raf.seek((long)(puntero - 1) * TAMAÑO_REGISTRO);
            System.out.print("Expediente del alumno: ");
            expediente = lec.nextLong();
            lec.nextLine();
            System.out.print("Nombre del alumno: ");
            nombre = lec.nextLine();
            do{
                System.out.print("Fecha convocatoria ordinaria: ");
                conOrdinaria = lec.nextLine();
                if(conOrdinaria.length() != 8){
                    System.out.println("La fecha solo puede tener 8 caracteres...");
                    pausar();
                    seguir = false;
                }
                else{
                    seguir = true;
                }
            }while(!seguir);
            System.out.print("Nota evaluación ordinaria: ");
            notaOrdinaria = lec.nextDouble();
            lec.nextLine();
            do{
                System.out.print("fecha convocatoria extraordinaria: ");
                conExtraordinaria = lec.nextLine();
                if(conExtraordinaria.length() != 8){
                    System.out.println("La fecha solo puede tener 8 caracteres...");
                    pausar();
                    seguir = false;
                }
                else{
                    seguir = true;
                }
            }while(!seguir);
            System.out.print("Nota evaluacion ordinaria: ");
            notaExtraordinaria = lec.nextDouble();
            lec.nextLine();
            raf.writeInt(puntero);
            raf.writeLong(expediente);
            raf.writeChars(stringDelimitado(nombre));
            raf.writeChars(stringDelimitado(conOrdinaria));
            raf.writeDouble(notaOrdinaria);
            raf.writeChars(stringDelimitado(conExtraordinaria));
            raf.writeDouble(notaExtraordinaria);
            raf.close();
        }
    }      
    
    public static int modificarCampos(String path)throws IOException,FileNotFoundException{
        RandomAccessFile raf;
        int puntero;
        int eleccion;
        f1 = new File(path);
        raf = new RandomAccessFile(f1, "rw");
        System.out.print("Indica el ID del registro a modificar: ");
        puntero = lec.nextInt();
        lec.nextLine();
        if((puntero-1) * TAMAÑO_REGISTRO > raf.length()){
            System.out.println("No existe registro con ese ID...");
        }
        else{
            do{
                eleccion = menuCampos();
                switch(eleccion){
                    case 1:{
                        raf.seek((puntero - 1) * TAMAÑO_REGISTRO + 4);
                        System.out.print("Introduce el nuevo expediente: ");
                        expediente = lec.nextLong();
                        lec.nextLine();
                        raf.writeLong(expediente);
                        break;
                    }
                    case 2:{
                        raf.seek((puntero - 1) * TAMAÑO_REGISTRO + 12);
                        System.out.print("Introduce el nuevo nombre: ");
                        nombre = lec.nextLine();
                        raf.writeChars(nombre);
                        break;
                    }
                    case 3:{
                        raf.seek((puntero - 1) * TAMAÑO_REGISTRO + 32);
                        System.out.print("Introduce la nueva convocatoria ordinaria: ");
                        conOrdinaria = lec.nextLine();
                        raf.writeChars(conOrdinaria);
                        break;
                    }
                    case 4:{
                        raf.seek((puntero - 1) * TAMAÑO_REGISTRO + 52);
                        System.out.print("Introduce la nueva nota ordinaria: ");
                        notaOrdinaria = lec.nextDouble();
                        lec.nextLine();
                        raf.writeDouble(notaOrdinaria);
                        break;
                    }
                    case 5:{
                        raf.seek((puntero - 1) * TAMAÑO_REGISTRO + 60);
                        System.out.print("Introduce la nueva convocatoria extraordinaria: ");
                        conExtraordinaria = lec.nextLine();
                        raf.writeChars(conExtraordinaria);
                        break;
                    }
                    case 6:{
                        raf.seek((puntero - 1) * TAMAÑO_REGISTRO + 80);
                        System.out.print("Introduce la nueva nota extraordinaria: ");
                        notaExtraordinaria = lec.nextDouble();
                        lec.nextLine();
                        raf.writeDouble(notaExtraordinaria);
                        break;
                    }
                }
            }while(eleccion != 0);
            
            
        }
        raf.close();
        return 0;
    }
    /**
     * Delimita un string a 10
     * @param s le pasamos el string a delimitar 
     * @return string modificado
     */
    public static String stringDelimitado(String s){
        StringBuffer buffer;
        buffer = new StringBuffer(s);
        buffer.setLength(10);
        return buffer.toString();
    }
    /**
     * Ver todos los registros
     * @param path el path del fichero el cual queremos ver
     * @throws IOException
     */
    public static void listarRegistros(String path)throws IOException, FileNotFoundException{
        int puntero;
        int iD;
        char[]nombres;
        char[]convocatoriaOr;
        char[]convocatoriaEx;
        String nombreST;
        String convocatoriaOrST;
        String convocatoriaExST;
        RandomAccessFile raf;
        puntero = 0;
        nombres = new char[10];
        convocatoriaOr = new char[10];
        convocatoriaEx = new char[10];
        f1 = new File(path);
        raf = new RandomAccessFile(f1, "r"); 
        if(raf.length() == 0){
            System.out.println("El fichero esta vacio....");
            pausar();
        }
        else{
        raf.seek(puntero);
            while(raf.length() != raf.getFilePointer()){
                iD = raf.readInt();
                expediente = raf.readLong();
                for(int i=0; i<nombres.length; i++){
                    nombres[i] = raf.readChar();
                }
                for(int i=0; i<convocatoriaOr.length; i++){
                    convocatoriaOr[i] = raf.readChar();
                }
                notaOrdinaria = raf.readDouble();
                for(int i=0; i<convocatoriaEx.length; i++){
                    convocatoriaEx[i] = raf.readChar();
                }
                nombreST = new String(nombres);
                convocatoriaOrST = new String(convocatoriaOr);
                convocatoriaExST = new String(convocatoriaEx);
                notaExtraordinaria = raf.readDouble();
                System.out.println("Id:" + iD + " Expediente:" + expediente + " Nombre:" + nombreST.trim() + " Ordinaria:" 
                + convocatoriaOrST.trim() + " Nota:" + notaOrdinaria + " Extraordinaria:" + convocatoriaExST.trim()
                + " Nota:" + notaExtraordinaria);
            }
            pausar();
        }        
        raf.close();
    }
    /**
     * busca la posicion del ultimo registro
     * @return devuelve la posicion
     * @throws IOException
     * @throws FileNotFoundException
     */
    public static int posicionRegistro() throws IOException,FileNotFoundException{
        int posicionUltimo = 0;
        int puntero = 0;
        RandomAccessFile raf;
        raf = new RandomAccessFile(f1, "r");
        System.out.println(raf.length());
        while(raf.length() != raf.getFilePointer()){
            raf.seek(puntero);
            posicionUltimo++;
            puntero += TAMAÑO_REGISTRO;
        }
        raf.close();
        return posicionUltimo;
    }
    /**
     * detiene la ejecucion del programa
     */
    public static void pausar(){
        System.out.print("Intro para continuar: ");
        lec.nextLine();
    }
}