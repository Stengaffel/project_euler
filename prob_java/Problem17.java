public class Problem17 {
  public static void main( String[] args ) {
    long startTime = System.nanoTime();

    String[] nums = new String[40];

    nums[1] = "one";
    nums[2] = "two";
    nums[3] = "three";
    nums[4] = "four";
    nums[5] = "five";
    nums[6] = "six";
    nums[7] = "seven";
    nums[8] = "eight";
    nums[9] = "nine";
    nums[10] = "ten";
    nums[11] = "eleven";
    nums[12] = "twelve";
    nums[13] = "thirteen";
    nums[14] = "fourteen";
    nums[15] = "fifteen";
    nums[16] = "sixteen";
    nums[17] = "seventeen";
    nums[18] = "eighteen";
    nums[19] = "nineteen";
    nums[20] = "twenty";
    nums[21] = "thirty";
    nums[22] = "forty";
    nums[23] = "fifty";
    nums[24] = "sixty";
    nums[25] = "seventy";
    nums[26] = "eigthy";
    nums[27] = "ninety";
    nums[28] = "hundred";
    nums[29] = "thousand";

    long letters = 0;

    for( int i = 1; i < 1000; i++ ) {
      String numStr = "";
      if( i >= 100 ) {
        numStr += nums[i/100] + nums[28];
        if( (i % 100) != 0 ) {
          numStr += "and";
        }
      }
      if( (i % 100) < 20 && (i % 100) != 0 ) {
        numStr += nums[i%100];
      }
      if( (i % 100) >= 20 ) {
        if( (i % 10) == 0 ) {
          numStr += nums[18 + ((i % 100) / 10)];
        }
        else {
          numStr += nums[18 + ((i % 100) / 10)] + nums[i % 10];
        }
      }
      System.out.println(numStr);
      letters += numStr.length();
    }

    letters += nums[1].length() + nums[29].length(); // for one thousand
    System.out.println(nums[1] + nums[29]);

    System.out.println("Letters: " + letters);

    System.out.println( "- - - - - - - - - - - - - - - - - - - " );
    long endTime = System.nanoTime();
		long duration = (endTime - startTime);
		System.out.println("Execution time: " + duration / (Math.pow(10, 9)) + " s");
  }
}
