public class Problem {
  public static void main( String[] args ) {
    long startTime = System.nanoTime();


    System.out.println( "- - - - - - - - - - - - - - - - - - - " );
    System.out.println( "Results: " );
    long endTime = System.nanoTime();
		long duration = (endTime - startTime);
		System.out.println("Execution time: " + duration / (Math.pow(10, 9)) + " s");
  }
}
