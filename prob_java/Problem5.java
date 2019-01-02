public class Problem5 {
	public static void main(String[] args) {
		int num = 0;
		int test = 0;
		
		while(num == 0) {
			for(int i = 1; i < 21; ++i) {
				if(test % i != 0) {
					break;
				}
				if(i == 20) {
					num = test;
				}
			}
			test++;
		}
		
		System.out.println(num);
	}
}