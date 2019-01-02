import java.util.HashMap;

public class Problem14 {

  private static HashMap<Long, Long> memories;
  private static long max;
  private static long maxNum;
  private static final int LIMIT = 1000000;

  public static void main( String[] args ) {
    	long startTime = System.nanoTime();

      memories = new HashMap<Long, Long>();
      max = Integer.MIN_VALUE;

      for( long i = 1; i <= LIMIT; i++ ) {
        long temp = recOp(i);
        if( temp > max ) {
          max = temp;
          maxNum = i;
        }
        memories.put(i,temp);
      }

    System.out.println("MaxNum: " + maxNum + ", Terms: " + max);
    System.out.println( "- - - - - - - - - - - - - - - - - - - " );
    long endTime = System.nanoTime();
		long duration = (endTime - startTime);
		System.out.println("Execution time: " + duration / (Math.pow(10, 9)) + " s");
  }

  private static long recOp(long n) {
    if ( n == 1 ) {
      return 1;
    }
    if( memories.containsKey(n) ) {
      return memories.get(n);
    }

    if(n % 2 == 0) {
      return 1 + recOp(n/2);
    }
    else {
      return 1 + recOp( 3*n + 1 );
    }
  }
}
