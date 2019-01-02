public class Problem6 {
	public static void main(String[] args) {
		int sumSquare = 0;
		int squareOfSum = 0;
		
		int diff;
		
		for(int i = 1; i < 101; i++) {
			sumSquare += i * i;
			squareOfSum += i;
		}
		
		squareOfSum = squareOfSum * squareOfSum;
		
		diff = squareOfSum - sumSquare;
		
		System.out.println(diff);
	}
}