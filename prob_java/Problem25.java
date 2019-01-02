import java.math.BigInteger;

public class Problem25 {
  public static void main( String[] args ) {
    long startTime = System.nanoTime();
    BigInteger fib1 = new BigInteger( "1" );
    BigInteger fib2 = new BigInteger( "1" );

    int index = 2;

    //Creating the big-ass number
    BigInteger ten = new BigInteger( "10" );
    BigInteger bigAssNum = ten.pow( 999 );

    while( fib2.compareTo( bigAssNum ) < 0 ) {
       BigInteger newFib = fib1.add(fib2);
       fib1 = fib2;
       fib2 = newFib;
       index++;
     }

    System.out.println( "- - - - - - - - - - - - - - - - - - - " );
    System.out.println( "The first Fibonacci-number's with over 1000 digits' index: " + index );
    long endTime = System.nanoTime();
		long duration = (endTime - startTime);
		System.out.println("Execution time: " + duration / (Math.pow(10, 9)) + " s");
  }
}
