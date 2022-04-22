public class Task21 {
    public static void main(String[] args) {
        // 1. Request dimension for tabla A
        int[] tableADimension = requestArraySize("Tabla A");

        // 2. Request dimension for table B
        int[] tableBDimension = requestArraySize("Tabla B");

        // 3. Validate are the same dimension
        boolean areValidTableDimensions = validateTables(tableADimension[0], tableBDimension[0], tableADimension[1], tableBDimension[1]);

        // If not, request data again
        if(!areValidTableDimensions){
            cleanConsole();  
            System.out.println("Error: Las dimensiones de Tabla A y Tabla B deben ser las mismas para poder sumar U_U");
            main(args);
        }

        // 4. Fill table A
        int[][] tableAValues = requestArrayValues(tableADimension[0], tableADimension[1], "Tabla A");

        // 5. Fill table B
        int[][] tableBValues = requestArrayValues(tableBDimension[0], tableBDimension[1], "Tabla B");

        // 6. Sum the tables
        int[][] sumTables = sumArrays(tableAValues, tableBValues);

        //7. Print results

        cleanConsole();

        System.out.println("Tabla A");
        printTable(tableAValues);
        System.out.println("-------------------------------");

        System.out.println("Tabla B");
        printTable(tableBValues);
        System.out.println("-------------------------------");

        System.out.println("Tabla A + Tabla B");
        printTable(sumTables);

    }

    public static void printTable(int[][] table){
        for(int i=0;i<table.length;i++){
            for(int j=0;j<table[0].length;j++){
                System.out.print(table[i][j]+" ");
            }
            System.out.println("");
        }
    }

    public static int[][] requestArrayValues(int rows, int columns,String tableName){
        int [][] table = new int[rows][columns];

        for(int i=0;i<rows;i++){
            for(int j=0;j<columns;j++){
                table[i][j] = requestNumber(tableName+" - "+(i+1)+"x"+(j+1)+" = ");
            }
        }
        System.out.println("----------------------------");
        return table;
    }

    public static int[][] sumArrays(int[][] arrayA , int[][] arrayB){
        int [][] table = new int[arrayA.length][arrayA[0].length];

        for(int i=0;i<arrayA.length;i++){
            for(int j=0;j<arrayA[0].length;j++){
                table[i][j] = arrayA[i][j] + arrayB[i][j];
            }
        }
        
        return table;
    }

    public static int[] requestArraySize(String tableName){

        try {
            String messageRequestRows = tableName+" - Ingresa el número de filas: ";
            int rows = requestNumber(messageRequestRows);
            
            String messsageRequestColumns = tableName+" - Ingresa el número de columnas: ";
            int columns = requestNumber(messsageRequestColumns);
    
            int[] dimension = {rows,columns};

            System.out.println("---------------------------------------------------------");
    
            return dimension;    
        } catch (Exception e) {
            cleanConsole();
            System.out.println("Error: Solo puede tipear números U_U");
            System.out.println("---------------------------------------------------------");

            return requestArraySize(tableName);
        }

        
    }

    public static void cleanConsole(){
        System.out.print("\033[H\033[2J");  
        System.out.flush();  
    }

    public static int requestNumber(String messageRequest){
        try {
            System.out.print(messageRequest);
            return Integer.parseInt(System.console().readLine());
        } catch (Exception e) {
            System.out.println("Error - Tipea solo números.");
            return requestNumber(messageRequest);
        }
    }

    public static boolean validateTables(int rowA, int rowB, int columnA , int columnB){
        if(rowA != rowB || columnA != columnB) return false;
        return true;
    }
}
