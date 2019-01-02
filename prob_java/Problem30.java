public class Problem30 {
  public static void main( String[] args ) {
    long startTime = System.nanoTime();

    int testNum = 10;
    int largestSum = 0;

    while( testNum < 100000000 ) {
      testNum++;

      int sum = 0;
      int digit = testNum % 10;
      int div = testNum / 10;

      int sumProd = 1;

      for( int i = 0; i < 5; i++ ) {
        sumProd = sumProd * digit;
      }

      sum = sum + sumProd;

      if( sum > testNum ) {
        continue;
      }

      while( div != 0 ) {
        int tempDig = div % 10;
        int tempProd = 1;
        for( int i = 0; i < 5; i++ ) {
          tempProd = tempProd * tempDig;
        }
        sum = sum + tempProd;
        if( sum > testNum ) {
          break;
        }
        div = div / 10;
      }

      if( sum == testNum ) {
        System.out.println(testNum);
        largestSum = largestSum + sum;
      }
    }


    System.out.println( "- - - - - - - - - - - - - - - - - - - " );
    System.out.println( "Results: Sum of all fifth-power nums = " + largestSum );
    long endTime = System.nanoTime();
		long duration = (endTime - startTime);
		System.out.println("Execution time: " + duration / (Math.pow(10, 9)) + " s");
  }
}
