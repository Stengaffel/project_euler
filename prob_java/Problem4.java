public class Problem4 {
	public static void main(String[] args) {
		
		final int UPPER_LIMIT = 1000000;
		final int LOWER_LIMIT = 100000;
		int[] nums = new int[2];
		
		for(int i = UPPER_LIMIT - 2; i > LOWER_LIMIT; i--) {
			
			// ex 123321
			
			int last = i % 1000; // 321
			int firstNums = i / 1000; // 123
			int first = (firstNums / 100) * 100 + ((firstNums % 100) / 10) * 10 + (firstNums % 10);
			
			boolean num1 = (last / 100) == (firstNums % 10);
			boolean num2 = ((last % 100) / 10) == ((firstNums % 100) / 10);
			boolean num3 = (last % 10) == (firstNums / 100);
			boolean palin = num1 && num2 && num3;
			
			
			/* if(i == 981018) {
				System.out.println(981018);
				System.out.println("last: " + last);
				System.out.println("firstNums: " + firstNums);
				System.out.println("first: " + first);
			} */
			
			if(palin) {
				// System.out.print(i);
				// System.out.println(palin);
				for(int k = 999; k > 99; k--) {
					if(i % k == 0) {
						int firstNum = k;
						int secondNum = i / k;
						
						if(firstNum > 999 || secondNum > 999) {
							break;
						}
						nums[0] = k;
						nums[1] = i / k;
						System.out.println(i);
						System.out.println(nums[0]);
						System.out.println(nums[1]);
						break;
					}

				}
				if(nums[nums.length - 1] != 0) {
						break;
					}
			}
		}
	}
}