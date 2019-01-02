public class Problem9 {
	public static void main(String[] args) {
		int a = 0;
		int b = 0;
		int c = 0;
		boolean isPyth = false;
		
		for(int i = 1; i < 333; i++) {
			
			for(int k = i+1;k < 1000 - 1; k++) {
				c = 1000 - k - i;
				isPyth = (i * i) + (k * k) == (c * c);
				if(isPyth) {
					a = i;
					b = k;
					break;
				}
			}
			if(isPyth) {
				break;
			}
		}
		System.out.println("a: " + a);
		System.out.println("b: " + b);
		System.out.println("c: " + c);
		System.out.println("a * b * c = " + a * b * c);
	}
}