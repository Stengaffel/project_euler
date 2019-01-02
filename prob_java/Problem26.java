import java.math.BigInteger;
import java.util.ArrayList;

public class Problem26 {
  public static void main( String[] args ) {
    long startTime = System.nanoTime();

    final int NUM_LIMIT = 2000;
    final int CHECKS = 2;

    BigInteger zero = new BigInteger( "0" );
    BigInteger ten = new BigInteger( "10" );
    BigInteger topNum = ten.pow( NUM_LIMIT );

    BigInteger biggestNum = zero;
    int longSeq = 0;
    int biggestD = 0;

    int d = 2;

    while( d <= 1000 ) {
      String bottomNumStr = "" + d;
      BigInteger bottomNum = new BigInteger( bottomNumStr );
      BigInteger div = topNum.divide( bottomNum );

      ArrayList<Integer> numSeq = new ArrayList<Integer>();

      // Creates an array that contains the number-sequence
      BigInteger tempNum = div;
      while( ! tempNum.equals( zero ) ) {
        int digit = tempNum.mod( ten ).intValue();
        numSeq.add( digit );
        tempNum = tempNum.divide( ten );
      }

      ArrayList<Integer> pattern = new ArrayList<Integer>();
      pattern.add( numSeq.get(0) );
      // Iterates through the pattern-array to check if it follows the pattern
      for( int i = 1; i < numSeq.size() / CHECKS; i++ ) {
        boolean isPat = false;
        if( pattern.get(0) == numSeq.get(i) ) {
          // Finds the pattern CHECK times over
          int checkPos = 0;
          while( checkPos < (( CHECKS * pattern.size() ) + 1) ) {
            if( pattern.get( checkPos % pattern.size() ) != numSeq.get( checkPos ) ) {
              break;
            }
            checkPos++;
          }
          if( checkPos == (( CHECKS * pattern.size() ) + 1) ) {
            isPat = true;
          }
        }
        if( isPat ) {
          if( longSeq < pattern.size() ) {
            longSeq = pattern.size();
            biggestNum = div;
            biggestD = d;
            System.out.println( "D: " + d + ", " + pattern.size() );
            System.out.println( div );
          }
          break;
        }
        else {
          pattern.add( numSeq.get(i) );
        }
      }
      d++;
    }

    System.out.println( "- - - - - - - - - - - - - - - - - - - " );
    System.out.println( "Longest Sequence: d = " + biggestD + ", " + longSeq + " digits in sequence" );
    System.out.println( biggestNum );
    long endTime = System.nanoTime();
		long duration = (endTime - startTime);
		System.out.println("Execution time: " + duration / (Math.pow(10, 9)) + " s");
  }
}
