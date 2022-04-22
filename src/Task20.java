import java.util.Random;

public class Task20 {
    public static void main(String[] args) {

        // 1. Generate random column size
        int randomSizeColumns = new Random(System.currentTimeMillis()).nextInt(5)+1;

        // 2. Generate random file size
        int randomSizeRows = new Random(System.currentTimeMillis()).nextInt(5)+1;

        // 3. Generate random array
        int[][] randomArray = generateRandomArray(randomSizeColumns,randomSizeRows);

        //4. Print array generated
        printArray(randomArray);

        int numberToSearch = getNumberToSearch(args);
        int repeatedTimesNumberOnArray = searchNumberOnArray(numberToSearch, randomArray);

        //5. Print times repeated that number on the array
        System.out.println("El "+numberToSearch+" aparece "+repeatedTimesNumberOnArray+" veces");
    }

    public static void printArray(int[][] arrayToPrint){

        for(int i = 0;i<arrayToPrint.length;i++){
            for(int j = 0;j<arrayToPrint[0].length;j++){
                System.out.print(" "+arrayToPrint[i][j]+" ");
            }
            System.out.println("");
        }
    }

    public static int getNumberToSearch(String[] args){
        try {
            return Integer.parseInt(args[0]);
        } catch (Exception e) {
            return (int)(Math.random()*10)+10;
        }
    }

    public static int searchNumberOnArray(int numberToSearch ,int[][] arrayToSearch){

        int counterFounded = 0;

        for(int i = 0;i<arrayToSearch.length;i++){
            for(int j = 0;j<arrayToSearch[0].length;j++){
                if(arrayToSearch[i][j]==numberToSearch){
                    counterFounded+=1;
                }
            }
        }

        return counterFounded;
    }

    public static int[][] generateRandomArray(int columns, int rows){
        
        int[][] randomArray;
        randomArray = new int[rows][columns];

        for(int i = 0;i<rows;i++){
            for(int j = 0;j<columns;j++){
                int randomNumber = (int)(Math.random()*10)+10;
                randomArray[i][j] = randomNumber;
            }
        }

        return randomArray;
    }
}
