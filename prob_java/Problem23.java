import java.util.ArrayList;

public class Problem23 {
  public static void main( String[] args ) {
    long startTime = System.nanoTime();
    final int LIMIT = 28123;
    ArrayList<Integer> abNums = new ArrayList<Integer>();
    long sum = 0;


    for( int i = 1; i < LIMIT; i++ ) {
      int tempSum = 0;
      for( int k = 1; k <= i/2; k++ ) {
        if( i % k == 0 ) {
          tempSum = tempSum + k;
        }
      }
      if( tempSum > i ) {
        abNums.add(i);
      }
    }
    System.out.println( "AbNums under " + LIMIT + ": " + abNums.size() );

    for( int i = 1; i < LIMIT; i++ ) {
      boolean abSum = false;
      int tempSum = 0;
      for( int pos = 0; i > abNums.get(pos); pos++ ) {
        for( int secPos = pos; ( abNums.get(pos) + abNums.get(secPos) ) <= i; secPos++ ) {
          if( abNums.get(pos) + abNums.get(secPos) == i ) {
            abSum = true;
            break;
          }
        }
        if( abSum ) {
          break;
        }
      }
      if( ! abSum ) {
        sum = sum + (long) i;
      }
    }





    System.out.println( "- - - - - - - - - - - - - - - - - - - " );
    System.out.println( "Sum: " + sum );
    long endTime = System.nanoTime();
		long duration = (endTime - startTime);
		System.out.println("Execution time: " + duration / (Math.pow(10, 9)) + " s");
  }
}
