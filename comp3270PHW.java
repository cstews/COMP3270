/**
 * Import statements
 */
import java.io.FileReader;
import java.io.FileWriter;
import java.io.File;
import java.io.IOException;
import java.io.BufferedReader;
import java.util.Random;
import static java.util.concurrent.TimeUnit.NANOSECONDS;

/**
 * @author Courtney Stewart
 * cds0081
 * COMP3270 Programming Homework Source Code
 * Solves the Maximum Sum Contiguous Subvector (MSCS) Problem
 */
public class comp3270PHW {
 //Instantiate 19 arrays to be filled with random numbers for later
 public static int[] array1 = new int[10];
 public static int[] array2 = new int[15];
 public static int[] array3 = new int[20];
 public static int[] array4 = new int[25];
 public static int[] array5 = new int[30];
 public static int[] array6 = new int[35];
 public static int[] array7 = new int[40];
 public static int[] array8 = new int[45];
 public static int[] array9 = new int[50];
 public static int[] array10 = new int[55];
 public static int[] array11 = new int[60];
 public static int[] array12 = new int[65];
 public static int[] array13 = new int[70];
 public static int[] array14 = new int[75];
 public static int[] array15 = new int[80];
 public static int[] array16 = new int[85];
 public static int[] array17 = new int[90];
 public static int[] array18 = new int[95];
 public static int[] array19 = new int[100];

 //instantiate 19x8 matrix to use later
 public static int[][] matrix = new int[19][8];



 /**
  * Main function
  * reads in file called "phw_input.txt", runs all four algorithms
  * to calculate max values, outputs result to file named
  * "CourtneyStewart_phw_output.txt"
  * @param none
  */
 public static void main(String[] args) {
    //read in file
    int[] X = readToArray();

    //instantiate variable
    int max = 0;

    max = algorithm1(X);
    System.out.println("algorithm-1: " + max + "\n");

    max = algorithm2(X);
    System.out.println("algorithm-2: " + max + "\n");

    max = maxSum(X, 0, 9);
    System.out.println("algorithm-3: " + max + "\n");

    max = algorithm4(X);
    System.out.println("algorithm-4: " + max + "\n");

    //make arrays
    array1 = makeArray(10);
    array2 = makeArray(15);
    array3 = makeArray(20);
    array4 = makeArray(25);
    array5 = makeArray(30);
    array6 = makeArray(35);
    array7 = makeArray(40);
    array8 = makeArray(45);
    array9 = makeArray(50);
    array10 = makeArray(55);
    array11 = makeArray(60);
    array12 = makeArray(65);
    array13 = makeArray(70);
    array14 = makeArray(75);
    array15 = makeArray(80);
    array16 = makeArray(85);
    array17 = makeArray(90);
    array18 = makeArray(95);
    array19 = makeArray(100);

    //measure time complexities for each array
    measureTime(array1, 0);
    measureTime(array2, 1);
    measureTime(array3, 2);
    measureTime(array4, 3);
    measureTime(array5, 4);
    measureTime(array6, 5);
    measureTime(array7, 6);
    measureTime(array8, 7);
    measureTime(array9, 8);
    measureTime(array10, 9);
    measureTime(array11, 10);
    measureTime(array12, 11);
    measureTime(array13, 12);
    measureTime(array14, 13);
    measureTime(array15, 14);
    measureTime(array16, 15);
    measureTime(array17, 16);
    measureTime(array18, 17);
    measureTime(array19, 18);


    //write answers to "CourtneyStewart_phw_output.txt" file
    writeToFile();


    }



 /**
 * Reads the input file and turns it into an array to use as input 
 * for algorithms.
 * 
 * I forgot how to make string into int so I used this resource:
 * https://www.javatpoint.com/java-string-to-int
 * 
 * @return int array of values to use with algorithms
 */
    public static int[] readToArray() {

        //create variable to use in reading in values
        String[] stringInput =  new String[10];
        int[] intInput = new int[10];

        //use BufferedReader to read in file
        try {
            BufferedReader buffRead = new BufferedReader(new FileReader("phw_input.txt"));
            String line = null;

            //read in values separated by comma
            while((line = buffRead.readLine()) != null)
                stringInput = line.split(",");
            
            //change values from string to int 
            for (int i = 0; i < stringInput.length; i++)
                intInput[i] = Integer.parseInt(stringInput[i]);


            //close BufferedReader   
            buffRead.close();

        }

        //catch any exceptions
        catch(IOException e) {
            System.out.println(e);
        }

        //return int array
        return intInput;
    }


 /**
 * Algorithm-1 implementation
 * 
 * @param array to be used with first algorithm
 * @return returns int of max value so far
*/
 public static int algorithm1(int X[]) {
    //1     maxSoFar = 0
    int maxSoFar = 0;
    int P = 0;
    int Q = X.length;

    //2     for L = P to Q
    for(int L = P; L < Q; L++){
        //3     for U = L to Q
        for(int U = L; U < Q; U++){
            //4     sum =0
            int sum = 0;
            //5     for I = L to U
            for(int I = L; I <= U; I++){
                //6     sum = sum + X[I]
                sum = sum + X[I];
            }
            //7     maxSoFar = max (maxSoFar, sum)
            maxSoFar = Math.max(maxSoFar,sum);
        }
    }
    //8     return maxSoFar 
    return maxSoFar;
 }




 /**
 * Algorithm-2 Implementation
 * 
 * @param array to be used with second algorithm
 * @return returns int of max value so far
 */
 public static int algorithm2(int X[]) {
 //1    maxSoFar = 0
 int maxSoFar = 0;
 int P = 0;
 int Q = X.length;

 //2     for L = P to Q
 for(int L = P; L < Q; L++){
    //3     sum =0
    int sum = 0;
    //4     for U = L to Q
    for(int U = L; U < Q; U++){
        //5     sum = sum + X[U]
        sum = sum + X[U];
        //6     maxSoFar = max(maxSoFar,sum)
        maxSoFar = Math.max(maxSoFar, sum);
    }
 }
 //7     return maxSoFar
    return maxSoFar;
 }




 /**
 * Algorithm-3 Recursive Function Implementation
 * 
 * @param X[] is int given array, int L and int U are the spots 
 * in the array where the maxSum is being found
 * @return returns int of max value
 */

 public static int maxSum(int X[], int L, int U){

 //1    if L > U then
 if(L > U) {
    //     return 0 /* zero- element vector */
    return 0;
 }

 //2     if L=U then
 if(L == U){
    //     return max(0,X[L]) 
    /* one-element vector */
    return Math.max(0, X[L]);
 }
 
 //3    M = (L+U)/2 
 /* A is X[L..M], B is X[M+1..U] */
 int M = (L + U)/2;

 /* Find max crossing to left */
 //4     sum = 0; maxToLeft =0
 int sum = 0;
 int maxToLeft = 0;

 //5    for I = M downto L do
 for(int I = M; I >= L; I--){
    //6    sum =sum+X[I]
    sum = sum + X[I];
    //7    maxToLeft = max(maxToLeft,sum)
    maxToLeft = Math.max(maxToLeft, sum);
 }

 /* Find max crossing to right */
 //8    sum=0; maxToRight=0
 sum = 0;
 int maxToRight = 0;

 //9    for I = M+1 to U
 for(int I = M+1; I <= U; I++){
    //10   sum=sum+X[I]
    sum = sum + X[I];
    //11   maxToRight = max(maxToRight, sum)
    maxToRight = Math.max(maxToRight, sum);
 }
 
 //12   maxCrossing = maxToLeft + maxToRight
 int maxCrossing = maxToLeft + maxToRight;

 //13   maxInA = maxSum(X, L, M)
 int maxInA = maxSum(X, L, M);

 //14   maxInB = maxSum(X,M+1,U)
 int maxInB = maxSum(X, M+1, U);

 //15   return max(maxCrossing, maxInA, maxInB)
 return Math.max(maxCrossing, Math.max(maxInA, maxInB));
 }


 /**
  * Algorithm-4 Implementation
  * 
  * @param int array X[]
  * @return maximum value so far
  */
 public static int algorithm4(int X[]) {
 //1    maxSoFar = 0
 int maxSoFar = 0;

 //2    maxEndingHere= 0
 int maxEndingHere = 0;

 int P = 0;
 int Q = X.length;

 //3    for I = P to Q
 for(int I = P; I < Q; I++) {
    //4    maxEndingHere = max(0, maxEndingHere + X[I])
    maxEndingHere = Math.max(0, maxEndingHere + X[I]);
    //5    maxSoFar = max(maxSoFar, maxEndingHere)
    maxSoFar = Math.max(maxSoFar, maxEndingHere);
 }
 //6    return maxSoFar
 return maxSoFar;
 }

/**
 * Function to put random ints from -50 to 50 into the given array
 * @param length is the length of the array
 * @return temporaryArray is the array with the random ints made
 */
 public static int[] makeArray(int length){
    Random rand = new Random();
    int[] temporaryArray = new int[length];
    //iterate through array adding new random number to each index
    for(int i = 0; i < length; i++){
        temporaryArray[i] = rand.nextInt(100) - 50;
    }
    return temporaryArray;
}

/**
 * Function to calculate the time complexity for a given algorithm
 * Referenced Lecture 5 again to get timeComplexity equations
 * @param n is the input size
 * @param algNum is the number of which algorithm is being analyzed
 * @return timeComplexity is the calculated time complexity
 */
 public static double calculateTimeComplexity(int n, int algNum){
    //instantiate variable
    double timeComplexity = 0;

    //switch case for which algorithm is being analyzed
    switch(algNum){
        case 1:
            timeComplexity = ((7/2) * Math.pow(n, 3)) + (3 * Math.pow(n, 2)) + ((33/2) * n) + 3;
            break;
        case 2:
            timeComplexity = Math.pow(n, 2) + ((17/2) * n) + 4;
            break;
        case 3:
            timeComplexity = (12 * n)* (Math.log(2)/Math.log(n)) + (12 * n);
            break;
        case 4:
            timeComplexity = (13 * n) + 5;
            break;
    }
    //return value
    return timeComplexity;
}

/**
 * Function to measure the running time for algorithms
 * Used to fill in matrix values
 * @param temporaryArray is the array created from makeArray function
 */
 public static void measureTime(int[] temporaryArray, int row){
    //instantiate variables
    long start = 0;
    long stop = 0;
    long exe = 0;

    int avgAlg1 = 0;
    int avgAlg2 = 0;
    int avgAlg3 = 0;
    int avgAlg4 = 0;

    double timeComplexAlg1 = 0;
    double timeComplexAlg2 = 0;
    double timeComplexAlg3 = 0;
    double timeComplexAlg4 = 0;

    int arrayLength = temporaryArray.length;

    //I chose N to equal 500
    for(int i = 0; i < 500; i++){
        //measure for Algorithm-1
        start = System.nanoTime();
        int max = algorithm1(temporaryArray);
        stop = System.nanoTime();
        exe = stop - start;
        avgAlg1 += exe;


        //measure for Algorithm-2
        start = System.nanoTime();
        max = algorithm2(temporaryArray);
        stop = System.nanoTime();
        exe = stop - start;
        avgAlg2 += exe;
        

        //measure for Algorithm-3
        start = System.nanoTime();
        max = maxSum(temporaryArray, 0, arrayLength-1);
        stop = System.nanoTime();
        exe = stop - start;
        avgAlg3 += exe;


        //measure for Algorithm-4
        start = System.nanoTime();
        max = algorithm4(temporaryArray);
        stop = System.nanoTime();
        exe = stop - start;
        avgAlg4 += exe;
    }

 //calculate average value for each algorithm
 avgAlg1 = avgAlg1 / 500;
 avgAlg2 = avgAlg2 / 500;
 avgAlg3 = avgAlg3 / 500;
 avgAlg4 = avgAlg4 / 500;

 //calcualte time complexity of each algorithm
 timeComplexAlg1 = calculateTimeComplexity(arrayLength, 1);
 timeComplexAlg2 = calculateTimeComplexity(arrayLength, 2);
 timeComplexAlg3 = calculateTimeComplexity(arrayLength, 3);
 timeComplexAlg4 = calculateTimeComplexity(arrayLength, 4);

 //make values into array
 int[] arrayOfValues = { avgAlg1, avgAlg2, avgAlg3, avgAlg4, (int) timeComplexAlg1, (int) timeComplexAlg2, (int) timeComplexAlg3, (int) timeComplexAlg4};

 //iterate through and add values into 19x8 matrix
 for(int k = 0; k < 8; k++){
    matrix[row][k] = arrayOfValues[k];
 }

}

/**
 * Function to output values into "CourtneyStewart_phw_output.txt" file
 * used source below to refresh memory on writing to file
 *  https://www.w3schools.com/java/java_files_create.asp
 */
public static void writeToFile() {
    try{
        //Create file to write to
        File myFile = new File("CourtneyStewart_phw_output.txt");
        FileWriter writer = new FileWriter("CourtneyStewart_phw_output.txt");
        writer.write("algorithm-1,algorithm-2,algorithm-3,algorithm-4,T1(n),T2(n),T3(n),T4(n)\n");

        //iterate through matrix and write values
        for(int i = 0; i < 19; i++){
            for(int j = 0; j < 8; j++){
                String value = Integer.toString(matrix[i][j]);
                writer.write(value);

                //add comma between
                if(j < 7) {
                    writer.write(",");
                }
            }
            writer.write("\n");
        }
        //close to save correctly
        writer.close();
    }

    //catch exception
    catch(IOException e){
        System.out.println(e);
    }
}




}
