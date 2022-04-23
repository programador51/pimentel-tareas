import java.util.Random;

public class Task18 {
    public static void main(String[] args){

        int untilNumber = getUntilNumberSerie(args);

        for(int i=1;i<=untilNumber;i++){
            double serieNumber = Math.pow(i,2*i-1);
            System.out.print(serieNumber+" ");
        }
    }

    public static int getUntilNumberSerie(String[] args){
        if(args.length==0){
            System.out.println("Debes pasar en los argumentos de la consola hasta que número de serie ejecutar");
            return getUntilNumberSerie(args);
        }else{
            return Integer.parseInt(args[0]);
        }
    }
}
