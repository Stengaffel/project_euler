import java.math.BigInteger;
import java.util.HashSet;

public class Problem29 {
  public static void main( String[] args ) {
    long startTime = System.nanoTime();

    HashSet<BigInteger> bigInts = new HashSet<BigInteger>();

    for( int a = 2; a <= 100; a++ ) {

      String strNum = "" + a;
      BigInteger currNum = new BigInteger( strNum );

      for( int b = 2; b <= 100; b++ ) {
        BigInteger numPow = currNum.pow( b );
        bigInts.add( numPow );
      }
    }


    System.out.println( "- - - - - - - - - - - - - - - - - - - " );
    System.out.println( "Results: " + bigInts.size() + " distinct terms" );
    long endTime = System.nanoTime();
		long duration = (endTime - startTime);
		System.out.println("Execution time: " + duration / (Math.pow(10, 9)) + " s");
  }
}
