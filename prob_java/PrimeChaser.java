public class PrimeChaser {
	public static void main(String[] args) {
		final int PRIME_LIMIT = 1000000;

		long startTime = System.nanoTime();
		int[] prime = new int[PRIME_LIMIT + 1];

		prime[0] = 2;
		prime[1] = 3;
		prime[2] = 5;

		int pos = 3;
		int test = 6;

		while(pos < PRIME_LIMIT + 1) {
			boolean isPrime = true;

			for(int i = 0; prime[i] <= Math.sqrt(test); i++) {
				if(test % prime[i] == 0) {
					isPrime = false;
					break;
				}
			}
			if(isPrime) {
				System.out.print(test + " ");
				prime[pos] = test;
				pos++;
				if(pos % 29 == 0) {
					System.out.print("\n");
				}
			}
			test++;
		}
		System.out.print("\n - - - - - - - - - - - - - - - - - - \n");
		System.out.println(PRIME_LIMIT + 1 + "st prime: " + prime[PRIME_LIMIT]);
		long endTime = System.nanoTime();
		long duration = (endTime - startTime);
		System.out.println("Execution time: " + duration / (Math.pow(10, 9)) + " s");
	}
}
