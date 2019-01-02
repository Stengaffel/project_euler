public class Problem10 {
	public static void main(String[] args) {
		final int PRIME_LIMIT = 1000000;
		
		long startTime = System.nanoTime();
		long sum = 0;
		int[] prime = new int[PRIME_LIMIT + 2];
			
		prime[0] = 2;
		prime[1] = 3;
		prime[2] = 5;
		
		int pos = 3;
		int test = 6;
		
		while(test < 2000000) {
			boolean isPrime = false;
			
			for(int i = 0;prime[i] != 0 && i <= (pos/2); ++i) {
				if(test % prime[i] == 0) {
					break;
				}
				if(i == pos/2) {
					isPrime = true;
				}
			}
			if(isPrime && test < 2000000) {
				// System.out.print(test + " ");
				prime[pos] = test;
				pos++;
				if(pos % 29 == 0) {
					// System.out.print("\n");
				}
			}
			test++;
		}
		
		for(int i = 0; prime[i] != 0; i++) {
			sum += prime[i];
		}
		
		System.out.print("\n - - - - - - - - - - - - - - - - - - \n");
		System.out.println("Sum: " + sum);
		long endTime = System.nanoTime();
		long duration = (endTime - startTime);
		System.out.println("Execution time: " + duration / (Math.pow(10, 9)) + " s");
		
	
	}
}