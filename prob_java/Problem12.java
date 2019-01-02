import java.util.Map;
import java.util.HashMap;

public class Problem12 {
	private static Map<Long, Long> primeCount; // Keeps track of the primes in the current number
	private static long factors;	// The amount of divisors for the current number
	private static PrimeHelper ph; // Generates an array of primes
	private static long[] primes; // The array of primes

	public static void main(String[] args) {
		long startTime = System.nanoTime();
		primeCount = new HashMap<Long, Long>();
		ph = new PrimeHelper( 10000 );
		primes = ph.getPrime();
		System.out.println("GO!");

		long triNum = 6;

		for( long inc = 4; factors < 500; inc++ ) {
			primeCount.clear();
			factors = 1;
			triNum += inc;
			long tempNum = 0;
			tempNum += triNum;
			while ( tempNum > 1 ) {
				for( int pos = 0; primes[pos] <= tempNum; pos++ ) {
					if ( tempNum % primes[pos] == 0 ) {
						addMap( primes[pos] );
						tempNum = tempNum / primes[pos];
						break;
					}
					// System.out.println("BOOP");
				}
			}
			// System.out.println("OUT!");
			for( long val : primeCount.values() ) {
				long addition = (long) val + 1;
				factors = factors * addition;
			}

			if( factors > 200 ) {
        System.out.println( "Num: " + triNum + ", Factors: " + factors );
      }
		}

		System.out.println( "Highest triNum: " + triNum + ", Factors: " + factors);
		System.out.println( "- - - - - - - - - - - - - - - - - - - " );

		long endTime = System.nanoTime();
		long duration = (endTime - startTime);
		System.out.println("Execution time: " + duration / (Math.pow(10, 9)) + " s");
	}

	private static void addMap( long key ) {
		if( primeCount.containsKey( key ) ) {
			primeCount.put( key , primeCount.get( key ) + (long) 1 );
		}
		else {
			primeCount.put( key, (long) 1 );
		}
	}
}
