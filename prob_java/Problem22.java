import java.util.Scanner;
import java.util.ArrayList;
import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigInteger;

public class Problem22 {
  public static void main( String[] args ) {
    long startTime = System.nanoTime();
    String filePath = "./CompFiles/NamesP22.txt";
    File file = new File( filePath );

    BigInteger nameSum = new BigInteger("0");

    ArrayList<String> names = new ArrayList<String>();

    // Parsing the name list
    try {
      Scanner scan = new Scanner( file );
      String bunchaNames = scan.next();
      scan.close();

      bunchaNames = bunchaNames.replaceAll( "[^A-Za-z]", " " );
      Scanner scanNames = new Scanner( bunchaNames );

      while( scanNames.hasNext() ) {
        names.add( scanNames.next() );
      }
    }
    catch( FileNotFoundException e ) {
      System.out.println( "Error while parsing!" );
    }

    // Algorithm
    names.sort( ( s1, s2 ) -> s1.compareTo( s2 ) );

    for( int i = 0; i < names.size(); i++ ) {
      int sum = 0;
      for( int k = 0; k < names.get(i).length(); k++ ) {
        sum = sum + (names.get(i).charAt(k) - 64);
      }
      sum = sum * ( i + 1 );
      String strSum = "" + sum;
      BigInteger inc = new BigInteger( strSum );
      nameSum = nameSum.add( inc );
      if( i < 2000 ) {
        System.out.println( "Name: " + names.get(i) + ", Score: " + sum + ", Index: " + ( i + 1 ) );
      }
    }

    System.out.println( "- - - - - - - - - - - - - - - - - - - " );
    System.out.println( "NameSum: " + nameSum );
    long endTime = System.nanoTime();
		long duration = (endTime - startTime);
		System.out.println("Execution time: " + duration / (Math.pow(10, 9)) + " s");
  }
}
