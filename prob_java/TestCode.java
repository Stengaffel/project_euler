public class TestCode {
  private static long combinations;

  public static void main( String[] args ) {
  	long startTime = System.nanoTime();

    int a = 1;
    int b = a;

    b = b + 1;

    System.out.println("a: " + a);
    System.out.println("b: " + b);



    System.out.println( "- - - - - - - - - - - - - - - - - - - " );
    long endTime = System.nanoTime();
	  long duration = (endTime - startTime);
		System.out.println("Execution time: " + duration / (Math.pow(10, 9)) + " s");
  }
}
