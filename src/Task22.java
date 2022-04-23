public class Task22 {
    public static void main(String[] args) {
        // 1. Request dimension for tabla A
        int[] tableADimension = requestArraySize("Tabla A");

        // 2. Request dimension for table B
        int[] tableBDimension = requestArraySize("Tabla B");

        // 3. Validate tables dimension
        boolean areValidTables = validateArrays(tableADimension[1], tableBDimension[0]);

        // 4. Re-execute the code to re-ask the table dimensions
        if(!areValidTables){
            cleanConsole();
            System.out.println("Error: Las columnas de la Tabla A son diferentes a las filas de la Tabla B. Algo valido seria [2 x 4] [4 x 3]");
            main(args);
        }

        int[][] tableAValues = requestArrayValues(tableADimension[0], tableADimension[1], "Tabla A");
        int[][] tableBValues = requestArrayValues(tableBDimension[0], tableBDimension[1], "Tabla B");

        int[][] resultMultiplication = matrixMultiplication(tableAValues, tableBValues);

        cleanConsole();

        System.out.println("Tabla A");
        printTable(tableAValues);
        System.out.println("----------------------------");
        System.out.println("x");
        System.out.println("----------------------------");
        System.out.println("Tabla B");
        printTable(tableBValues);
        System.out.println("----------------------------");
        System.out.println("=");
        printTable(resultMultiplication);
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

    public static void printTable(int[][] table){
        for(int i=0;i<table.length;i++){
            for(int j=0;j<table[0].length;j++){
                System.out.print(table[i][j]+" ");
            }
            System.out.println("");
        }
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
    
    public static int[][] matrixMultiplication(int[][] tableA, int[][] tableB){
		
        int[][] multiplicationResult = new int[tableA.length][tableB[0].length];

        // Row of table A
		for(int i = 0; i < tableA.length; i++){
            // Columns table B
			for(int j = 0; j < tableB[0].length; j++){
                // Columns tabla A
				for(int k = 0; k <tableA[0].length; k++){
					multiplicationResult[i][j] += tableA[i][k]*tableB[k][j];
				}
			}
		}

        return multiplicationResult;
	}

    public static boolean validateArrays(int columnsTableA, int rowsTableB){
        if(columnsTableA == rowsTableB) return true;
        return false;
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
}
