public class Problem28 {
  public static void main( String[] args ) {
    long startTime = System.nanoTime();

    long diagSum = 0;
    int[][] spGrid = new int[1001][1001];

    // Starting point
    spGrid[500][500] = 1;

    // Inserting the numbers into the matrix
    int insertNum = 2;
    int row = 500;
    int col = 501;

    while( col < 1001 ) {
      //System.out.println("Row: " + row + ", Col: " + col);
      spGrid[row][col] = insertNum;
      insertNum++;

      // first quadrant
      if( col >= 500 && row <= 500 ) {
        if( spGrid[row+1][col] == 0 ) {
          row++;
        }
        else {
          col++;
        }
        continue;
      }

      // forth quadrant
      if( col >= 500 && row >= 500 ) {
        if( spGrid[row][col-1] == 0 ) {
          col--;
        }
        else {
          row++;
        }
        continue;
      }

      // third quadrant
      if( col <= 500 && row >= 500 ) {
        if( spGrid[row-1][col] == 0 ) {
          row--;
        }
        else {
          col--;
        }
        continue;
      }

      // second quadrant
      if( col <= 500 && row <= 500 ) {
        if( spGrid[row][col+1] == 0 ) {
          col++;
        }
        else {
          row--;
        }
        continue;
      }
    }

    for( int i = 0; i < 1001; i++ ) {
      if( i == 500 ) {
        diagSum = diagSum + spGrid[i][i];
        continue;
      }
      diagSum = diagSum + spGrid[i][i];
      diagSum = diagSum + spGrid[1000-i][i];
    }


    System.out.println( "- - - - - - - - - - - - - - - - - - - " );
    System.out.println( "Diagonal sum: " + diagSum );
    long endTime = System.nanoTime();
		long duration = (endTime - startTime);
		System.out.println("Execution time: " + duration / (Math.pow(10, 9)) + " s");
  }
}
