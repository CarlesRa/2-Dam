public class Unsaludo{
    public static void main(String[] args) {
        if(args.length < 1){
            System.out.println("Tienes que indicar un saludo");
            System.exit(1);
        }
        for(int i=0; i<5; i++){
            System.out.println((i + 1) + ": " + args[0]);
        }
    }
}