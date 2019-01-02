import java.util.Scanner;
import java.util.ArrayList;
import java.io.File;
import java.io.FileNotFoundException;

// Same code as Problem18 except for the different file used

public class Problem67 {

  private static long sum;

  public static void main( String[] args ) {
    long startTime = System.nanoTime();
    sum = 0;
    String filePath = "./CompFiles/BigNumPyramidP67.txt";
    File file = new File(filePath);

    Node<Long> root = null;
    ArrayList<ArrayList<Node<Long>>> levels = new ArrayList<ArrayList<Node<Long>>>();

    // Parse the pyramid
    try{
      Scanner scan = new Scanner(file);
      root = new Node<Long>( scan.nextLong() );
      int levelCount = 2;

      while( scan.hasNext() ) {
        ArrayList<Node<Long>> l = new ArrayList<Node<Long>>();

        for( int i = 0; i < levelCount; i++ ) {
          Node<Long> node = new Node<Long>( scan.nextLong() );
          l.add( node );
        }
        levelCount++;
        levels.add(l);
      }
    }
    catch(FileNotFoundException e) {
      System.out.println("File not found!");
    }

    root.left = levels.get(0).get(0);
    root.right = levels.get(0).get(1);

    for( int i = 0; i < levels.size() - 1; i++ ) {
      ArrayList<Node<Long>> currLev = levels.get(i);
      ArrayList<Node<Long>> nextLev = levels.get(i+1);
      for( int k = 0; k < currLev.size(); k++ ) {
        currLev.get(k).left = nextLev.get(k);
        currLev.get(k).right = nextLev.get(k+1);
      }
    }

    // Algorithm
    for( int i = levels.size() - 2; i >= -1; i-- ) {
      if( i == -1 ) {
        if( root.left.element > root.right.element ) {
          root.element += root.left.element;
        }
        else {
          root.element += root.right.element;
        }
        sum = root.element;
        break;
      }

      ArrayList<Node<Long>> currLev = levels.get(i);
      for( int rowPos = 0; rowPos < currLev.size(); rowPos++ ) {
        Node<Long> n1 = currLev.get(rowPos);
        if( n1.left.element > n1.right.element ) {
          n1.element += n1.left.element;
        }
        else {
          n1.element += n1.right.element;
        }
      }
    }


    System.out.println( "Biggest sum: " + sum );

    System.out.println( "- - - - - - - - - - - - - - - - - - - " );
    long endTime = System.nanoTime();
		long duration = (endTime - startTime);
		System.out.println("Execution time: " + duration / (Math.pow(10, 9)) + " s");
  }

  private static class Node<E> {
    Node<E> left;
    Node<E> right;
    E element;

    private Node(E e) {
      this.element = e;
      this.left = null;
      this.right = null;
    }
  }
}


//           -1
//          /   \
//         0     0
//        / \   / \
//       1   1 1   1
