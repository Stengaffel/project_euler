public class Problem19 {
  public static void main( String[] args ) {
    long startTime = System.nanoTime();

    long year = 1900;
    long days = 0;
    int[] months = new int[13];
    boolean[] weekDay = new boolean[8];
    long allDays = 0;

    for( int i = 1; i < 7; i++ ) {
      weekDay[i] = false;
    }
    weekDay[7] = true;

    months[0] = 29;
    months[1] = 31;
    months[2] = 28;
    months[3] = 31;
    months[4] = 30;
    months[5] = 31;
    months[6] = 30;
    months[7] = 31;
    months[8] = 31;
    months[9] = 30;
    months[10] = 31;
    months[11] = 30;
    months[12] = 31;

    int currDay = 0; // monday
    int currMonth = 1; // january

    // starting date: 1900.1.1 monday

    while( year <= 2000 ) {
      for( int i = 1; i < 13; i++ ) {
        int thisMonth = months[i];
        if( ( ( year % 4 == 0 && year % 100 != 0 ) && i == 2 ) || ( year % 400 == 0 && i == 2 ) )  {
          thisMonth = months[0];
        }
        for( int k = 1; k <= thisMonth; k++ ) {
          currDay++;
          if( currDay > 7 ) {
            currDay = 1;
          }
          if( k == 1 && weekDay[currDay] ) {
            if( year >= 1901 && year <= 2000 ) {
              System.out.println(year + "." + i + "." + k + " , Weekday: " + currDay );
              days++;
            }
          }
          allDays++;
        }
      }
      year++;
    }
    System.out.println( allDays );

    System.out.println( "- - - - - - - - - - - - - - - - - - - " );
    System.out.println( "Sundays on 1st's: " + days );
    long endTime = System.nanoTime();
		long duration = (endTime - startTime);
		System.out.println("Execution time: " + duration / (Math.pow(10, 9)) + " s");
  }
}
