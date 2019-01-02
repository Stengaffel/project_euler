
public class Problem31 {

  public static void main( String[] args ) {
    long startTime = System.nanoTime();

    int combinations = 0;

    int[] coins = new int[8];

    coins[0] = 1;
    coins[1] = 2;
    coins[2] = 5;
    coins[3] = 10;
    coins[4] = 20;
    coins[5] = 50;
    coins[6] = 100;
    coins[7] = 200;

    for(int ones = 0; ones <= 200 / coins[0]; ones++) {
      int cursum = ones * coins[0];
      if(cursum > 200) {
        break;
      }
      if(cursum == 200) {
        combinations++;
      }
      if(cursum < 200) {
        for(int twos = 0; twos <= 200 / coins[1]; twos++) {
          int cursum2 = cursum + twos * coins[1];
          if(cursum2 > 200) {
            break;
          }
          if(cursum2 == 200) {
            combinations++;
            break;
          }
          if(cursum2 < 200) {
            for(int fives = 0; fives <= 200 / coins[2]; fives++) {
              int cursum3 = cursum2 + fives * coins[2];
              if(cursum3 > 200) {
                break;
              }
              if(cursum3 == 200) {
                combinations++;
                break;
              }
              if(cursum3 < 200) {
                for(int tens = 0; tens <= 200 / coins[3]; tens++) {
                  int cursum4 = cursum3 + tens * coins[3];
                  if(cursum4 > 200) {
                    break;
                  }
                  if(cursum4 == 200) {
                    combinations++;
                    break;
                  }
                  if(cursum4 < 200) {
                    for(int twents = 0; twents <= 200 / coins[4]; twents++) {
                      int cursum5 = cursum4 + twents * coins[4];
                      if(cursum5 > 200) {
                        break;
                      }
                      if(cursum5 == 200) {
                        combinations++;
                        break;
                      }
                      if(cursum5 < 200) {
                        for(int fifs = 0; fifs <= 200 / coins[5]; fifs++) {
                          int cursum6 = cursum5 + fifs * coins[5];
                          if(cursum6 > 200) {
                            break;
                          }
                          if(cursum6 == 200) {
                            combinations++;
                            break;
                          }
                          if(cursum6 < 200) {
                            for(int huns = 0; huns <= 200 / coins[6]; huns++) {
                              int cursum7 = cursum6 + huns * coins[6];
                              if(cursum7 > 200) {
                                break;
                              }
                              if(cursum7 == 200) {
                                combinations++;
                                break;
                              }
                              if(cursum7 < 200) {
                                for(int twohuns = 0; twohuns <= 200 / coins[7]; twohuns++) {
                                  int cursum8 = cursum7 + twohuns * coins[7];
                                  if(cursum8 > 200) {
                                    break;
                                  }
                                  if(cursum8 == 200) {
                                    combinations++;
                                    break;
                                  }
                                }
                              }
                            }
                          }
                        }
                      }
                    }
                  }
                }
              }
            }
          }
        }
      }
    }

    System.out.println( "- - - - - - - - - - - - - - - - - - - " );
    System.out.println( "Results: " + combinations);
    long endTime = System.nanoTime();
		long duration = (endTime - startTime);
		System.out.println("Execution time: " + duration / (Math.pow(10, 9)) + " s");
  }
}

// Next problems are in python
