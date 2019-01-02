public class Problem3 {
	public static void main(String[] args) {
		final long NUM = 600851475143L;
		
		long[] prime = new long[8];
		int pos = 0;
		
		// final long end = (long) Math.round(Math.sqrt(NUM));
		final long end = 10000000;
		long count = 2;
		
		while(count < end) {
			if(NUM % count == 0) {
				int go = 0;
				for(int i = 0; i < prime.length; i++) {
					if(prime[i] != 0 && count % prime[i] == 0) {
						break;
					}
					go++;
				}
				if(go == prime.length) {
					prime[pos] = count;
					pos++;
				}
			}
			count++;
		}
		
		for(int i = 0; i < prime.length; i++) {
			System.out.println(prime[i]);
		}
	}
}