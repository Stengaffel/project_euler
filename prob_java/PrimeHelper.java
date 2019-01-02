public class PrimeHelper {
	private int primeLimit;
	private static long[] prime;

	public PrimeHelper(int limit) {
		this.primeLimit = limit;
		this.prime = new long[primeLimit];
		primeFinder();
	}

	public long[] getPrime() {
		return prime;
	}

	private void primeFinder() {
		prime[0] = 2;
		prime[1] = 3;
		prime[2] = 5;

		int pos = 3;
		long test1 = 6;

		while(pos < primeLimit) {
			boolean isPrime = true;

			for(int i = 0;prime[i] <= Math.sqrt(test1); i++) {
				//System.out.println("p: " + prime[i] + ", test: " + test1);
				if(test1 % prime[i] == 0) {
					isPrime = false;
					break;
				}
			}
			if(isPrime) {
				// System.out.println(test1 + " ");
				prime[pos] = test1;
				pos++;
				if(pos % 29 == 0) {
					// System.out.println("\n");
				}
			}
			test1++;
		}
	}
}
