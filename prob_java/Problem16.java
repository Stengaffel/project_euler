import java.math.BigInteger;

public class Problem16 {
  public static void main( String[] args ) {
    long startTime = System.nanoTime();

    BigInteger bi = new BigInteger("2");
    BigInteger bigNum = bi.pow(1000);
    BigInteger sum = new BigInteger("0");
    BigInteger div = new BigInteger("10");
    BigInteger zero = new BigInteger("0");

    for( int i = 0; !bigNum.equals(zero); i++ ) {
      //System.out.println(sum);
      //System.out.println("div: " + bigNum.mod(div));
      sum = sum.add(bigNum.mod(div));
      bigNum = bigNum.divide(div);
    }

    System.out.println("Sum: " + sum);
    System.out.println( "- - - - - - - - - - - - - - - - - - - " );
    long endTime = System.nanoTime();
		long duration = (endTime - startTime);
		System.out.println("Execution time: " + duration / (Math.pow(10, 9)) + " s");
  }
}
