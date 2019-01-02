public class Problem15 {
  public static void main( String[] args ) {
    long startTime = System.nanoTime();

    int combinations = 0;

    // Använd simpel kombinatorik: Kombination = ( 40! ) / ( 20! * 20! ) = 137846528820

    System.out.println( "- - - - - - - - - - - - - - - - - - - " );
    long endTime = System.nanoTime();
		long duration = (endTime - startTime);
		System.out.println("Execution time: " + duration / (Math.pow(10, 9)) + " s");
  }
}
