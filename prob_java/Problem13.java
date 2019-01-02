import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class Problem13 {

  public static void main( String[] args ) {
    long startTime = System.nanoTime();

    ArrayList<int[]> bigNums = new ArrayList<int[]>();

    File nums = new File("./CompFiles/ManyBigNumP13.txt");
    try {
      Scanner scan = new Scanner(nums);

      while( scan.hasNext() ) {
        String line = scan.nextLine();
        int[] numArray = new int[50];
        for(int i = 0; i < line.length(); i++ ) {
          numArray[i] = line.charAt(49 - i) - '0';
        }
        bigNums.add(numArray);
      }
      /*
      for(int i = 0; i < bigNums.size(); i++) {
        for(int k = 0; k < 50; k++) {
          System.out.print(bigNums.get(i)[k] + " ");
        }
        System.out.print("\n");
      }
      */
      int[] bigSum = new int[60];

      for(int i = 0; i < bigNums.size(); i++) {
        for(int k = 0; k < 50; k++) {
          bigSum[k] = bigSum[k] + bigNums.get(i)[k];
        }
        for(int k = 0; k < bigSum.length; k++) {
          if(bigSum[k] > 9) {
            bigSum[k] = bigSum[k] % 10;
            bigSum[k+1] = bigSum[k+1] + 1;
          }
        }
      }
      for( int i = bigSum.length - 1; i >= 0; i--) {
        System.out.print(bigSum[i]);
      }
    }
    catch( FileNotFoundException e ) {
      System.out.println("WRONG");
    }

    System.out.println( "\n- - - - - - - - - - - - - - - - - - - " );
    long endTime = System.nanoTime();
		long duration = (endTime - startTime);
		System.out.println("Execution time: " + duration / (Math.pow(10, 9)) + " s");
  }
}
