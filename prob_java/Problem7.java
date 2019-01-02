public class Problem7 {
	public static void main(String[] args) {
		final int PRIME_LIMIT = 1000000;
		
		long startTime = System.nanoTime();
		int[] prime = new int[PRIME_LIMIT + 2];
			
		prime[0] = 2;
		prime[1] = 3;
		prime[2] = 5;
		
		int pos = 3;
		int test = 6;
		
		while(pos < PRIME_LIMIT + 1) {
			int runs = 0;
			
			for(int i = 0;prime[i] != 0; ++i) {
				if(test % prime[i] == 0) {
					break;
				}
				runs++;
			}
			//System.out.println("Runs: " + runs);
			//System.out.println("Pos: " + pos/2 + 1);
			if(runs == pos) {
				System.out.print(test + " ");
				prime[pos] = test;
				pos++;
				if(pos % 14 == 0) {
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