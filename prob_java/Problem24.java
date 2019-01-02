public class Problem24 {
  private static int[] nums;
  public static void main( String[] args ) {
    long startTime = System.nanoTime();
    nums = new int[10];
    final int LIMIT = 1000000;

    for( int i = 0; i < 10; i++ ) {
      nums[i] = i;
    }

    int iteration = 1;

    while( iteration < LIMIT ) {
      if( iteration < 100 ) {
        for( int i = 0; i < nums.length; i++ ) {
          System.out.print( nums[i] );
        }
        System.out.print("\n");
      }
      
      int tempPos = nums.length - 1;

      if( nums[tempPos] > nums[tempPos-1] ) {
        switchLast();
        iteration++;
        continue;
      }

      while( nums[tempPos] < nums[tempPos - 1] ) {
        tempPos--;
      }
      higher( tempPos - 1 );
      iteration++;

      if( iteration % 1000 == 0 ) {
        for( int i = 0; i < nums.length; i++ ) {
          System.out.print( nums[i] );
        }
        System.out.print("\n");
      }
    }

    System.out.println( "- - - - - - - - - - - - - - - - - - - " );
    System.out.println( "Results: " );
    for( int i = 0; i < nums.length; i++ ) {
      System.out.print( nums[i] );
    }
    System.out.print("\n");
    long endTime = System.nanoTime();
		long duration = (endTime - startTime);
		System.out.println("Execution time: " + duration / (Math.pow(10, 9)) + " s");
  }

  private static void switchLast() {
    int end = nums.length - 1;
    int tempVal = nums[end];
    nums[end] = nums[end-1];
    nums[end-1] = tempVal;
  }

  // Finds the next biggest number after the selected and switches their place
  private static void higher( int pos ) {
    int nextNum = Integer.MAX_VALUE;
    int newPos = -1;
    for( int i = pos; i < nums.length; i++ ) {
      if( nums[i] < nextNum && nums[i] > nums[pos] ) {
        nextNum = nums[i];
        newPos = i;
      }
    }
    nums[newPos] = nums[pos];
    nums[pos] = nextNum;
    sortRest( pos + 1 );
  }

  // Sorts the remaining elements after higher has been called
  private static void sortRest( int pos ) {
    int[] tempArray = new int[10];
    int index = 0;
    int startVal = nums[pos];
    for( int its = 11 - pos; its > 0; its-- ) {
      for( int i = pos; i < nums.length - 1; i++ ) {
        if( nums[i] > nums[i+1] ) {
          int tempVal = nums[i];
          nums[i] = nums[i+1];
          nums[i+1] = tempVal;
        }
      }
    }
  }
}
