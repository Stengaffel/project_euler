import java.math.BigInteger;

public class Problem20 {
  public static void main( String[] args ) {
    long startTime = System.nanoTime();

    BigInteger sum = new BigInteger("0");
    BigInteger bigNum = new BigInteger("1");
    BigInteger div = new BigInteger("10");
    BigInteger zero = new BigInteger("0");

    for( int i = 2; i <= 100; i++ ) {
      String mult1 = "" + i;
      BigInteger mult = new BigInteger(mult1);
      bigNum = bigNum.multiply(mult);
    }

    while( ! bigNum.equals( zero ) ) {
      System.out.println(bigNum);
      sum = sum.add( bigNum.mod(div) );
      bigNum = bigNum.divide(div);
    }

    System.out.println( "Sum: " + sum );

    System.out.println( "- - - - - - - - - - - - - - - - - - - " );
    long endTime = System.nanoTime();
		long duration = (endTime - startTime);
		System.out.println("Execution time: " + duration / (Math.pow(10, 9)) + " s");
  }
}
