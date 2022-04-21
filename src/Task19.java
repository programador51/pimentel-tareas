import java.util.Random;

public class Task19 {
    public static void main(String[] args) {

        int numberToSearch = getNumberToSearch(args);

        int randomSizeArray = new Random(System.currentTimeMillis()).nextInt(20)+1;
        
        int[] randomArray = generateRandomArray(randomSizeArray);
        
        int repeatedTimesNumber = lookForRepeatedNumber(numberToSearch, randomArray);
        String arrayAsAstring = getArrayAsString(randomArray);

        System.out.println("El número "+numberToSearch+" aparece "+repeatedTimesNumber+" veces en el vector: "+arrayAsAstring);
    }

    public static int lookForRepeatedNumber(int numberToSearch,int[] arrayToLookFor){

        int counterRepeatedNumber = 0;

        for(int i = 0;i<arrayToLookFor.length;i++){
            if(arrayToLookFor[i]==numberToSearch){
                counterRepeatedNumber+=1;
            }
        }

        return counterRepeatedNumber;
    }

    public static int getNumberToSearch(String[] args){
        if(args.length==0){
            return new Random(System.currentTimeMillis()).nextInt(10)+1;
        }else{
            return Integer.parseInt(args[0]);
        }
    }

    public static String getArrayAsString(int[] array){

        String arrayPrinted = "[";

        for(int i = 0;i<array.length;i++){
            arrayPrinted+=" "+array[i]+" ";
        }

        arrayPrinted+="]";

        return arrayPrinted;
        
    }

    public static int[] generateRandomArray(int sizeArray){

        int randomNumbers[];
        randomNumbers = new int[sizeArray];

        for(int i = 0;i<sizeArray;i++){
            randomNumbers[i] = new Random(i).nextInt(10)+1;
        }

        return randomNumbers;
    }
}
