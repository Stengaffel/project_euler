import java.util.HashSet;

public class Problem27 {
  public static void main( String[] args ) {
    long startTime = System.nanoTime();
    final int PRIME_LIMIT = 10000;

    long maxN = 0;
    long maxNProd = 0;

    PrimeHelper ph = new PrimeHelper( PRIME_LIMIT );
    long[] primes = ph.getPrime();
    HashSet<Long> primeSet = new HashSet<Long>();
    for( int i = 0; i < primes.length; i++ ) {
      primeSet.add( primes[i] );
    }

    System.out.println("0: " + primeSet.contains((long) 0) + ", " + primes[PRIME_LIMIT-1] );
    // n^2 + a*n + b

    for( int a = 0; primes[a] < 1000; a++ ) {
      for( int b = 0; primes[b] < 1000; b++ ) {
        // Positive a's
        long expression = 2;
        long n = 0;
        while( primeSet.contains(expression) ) {
            expression = (n * n) + primes[a] * n + primes[b];
            n++;
        }
        if( n > maxN ) {
          maxN = n;
          maxNProd = primes[a] * primes[b];
        }

        // Negative a's
        expression = 2;
        n = 0;
        while( primeSet.contains(expression) ) {
            expression = (n * n) - primes[a] * n + primes[b];
            n++;
        }
        if( n > maxN ) {
          maxN = n;
          maxNProd = - ( primes[a] * primes[b] );
        }
      }
    }

    System.out.println( "- - - - - - - - - - - - - - - - - - - " );
    System.out.println( "Results: biggest n = " + maxN + ", biggest prod = " + maxNProd );
    long endTime = System.nanoTime();
		long duration = (endTime - startTime);
		System.out.println("Execution time: " + duration / (Math.pow(10, 9)) + " s");
  }
}
