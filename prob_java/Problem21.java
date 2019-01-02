import java.util.HashSet;

public class Problem21 {
  public static void main( String[] args ) {
    long startTime = System.nanoTime();
    final long limit = 10000;
    HashSet<Long> memories = new HashSet<Long>();
    long sum = 0;

    for( long currNum = 1; currNum < limit; currNum++ ) {
      if( memories.contains( currNum ) ) {
        continue;
      }
      long currSum = 0;
      for( long div = 1; div <= currNum/2; div++ ) {
        if( currNum % div == 0 ) {
          currSum = currSum + div;
        }
      }
      long secondSum = 0;
      for( long div = 1; div <= currSum/2; div++ ) {
        if ( currSum % div == 0 ) {
          secondSum = secondSum + div;
        }
      }
      if( currNum == secondSum && currNum != currSum ) {
        System.out.println( "Pair: " + currNum + ", " + currSum );
        sum = sum + currSum + currNum;
        memories.add( currSum );
        memories.add( currNum );
      }
    }

    System.out.println( "- - - - - - - - - - - - - - - - - - - " );
    System.out.println( "Sum of amicable numbers under " + limit + ": " + sum );
    long endTime = System.nanoTime();
		long duration = (endTime - startTime);
		System.out.println("Execution time: " + duration / (Math.pow(10, 9)) + " s");
  }
}
