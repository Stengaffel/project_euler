import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class Problem11 {
	public static void main(String[] args) {
		long startTime = System.nanoTime();

		int size = 20;
		int countSize = 4;
		long maxSum = 1;
		long sum1 = 1;
		/*int horizontalSum = 0;
		int verticalSum = 0;
		int diaSumRight = 0;
		int diaSumLeft = 0;*/

		String fileName = "./CompFiles/MatrixP11.txt";
		File file = new File(fileName);

		long[][] numMat = new long[size][size];

		try {
			Scanner scan = new Scanner(file);
			for(int i = 0; i < size; i++) {
				System.out.print("\n");
				for(int k = 0; k < size; k++) {
					numMat[i][k] = scan.nextLong();
					System.out.print(numMat[i][k] + " ");
				}
			}
		}
		catch(FileNotFoundException e) {
			System.out.println("Well, fuck!");
		}

		for(int i = 0; i < size; i++) {
			for(int k = 0; k < size; k++) {
				if(k >= countSize  && i <= size - countSize) { //down-left
					for(int prod = 0; prod < countSize; prod++) {
						sum1 = sum1 * numMat[i+prod][k-prod];
						if(i == 12 && k == 6) {
							System.out.println(numMat[i+prod][k-prod]);
						}
					}
					if(sum1 > maxSum) {
						maxSum = sum1;
						System.out.println("MaxDownLeft: " + maxSum);
					}
					sum1=1;
				}
				if(k <= size - countSize && i <= size - countSize) { //down-right
					for(int prod = 0; prod < countSize; prod++) {
						sum1 = sum1 * numMat[i+prod][k+prod];
					}
					if(sum1 > maxSum) {
						maxSum = sum1;
						System.out.println("MaxDownRight: " + maxSum);
					}
					sum1=1;
				}
				if(k <= size - countSize) { // horizontal
					for(int prod = 0; prod < countSize; prod++) {
						sum1 = sum1 * numMat[i][k+prod];
					}
					if(sum1 > maxSum) {
						maxSum = sum1;
						System.out.println("MaxHorizontal: " + maxSum);
					}
					sum1=1;
				}
				if(i <= size - countSize) { // vertical
					for(int prod = 0; prod < countSize; prod++) {
						sum1 = sum1 * numMat[i+prod][k];
					}
					if(sum1 > maxSum) {
						maxSum = sum1;
						System.out.println("MaxVert: " + maxSum);
						System.out.println("Pos: i = " + i + ", k = " + k );
					}
					sum1=1;
				}
			}
		}


		System.out.println("Greatest product: " + maxSum);
		long endTime = System.nanoTime();
		long duration = (endTime - startTime);
		System.out.println("Execution time: " + duration / (Math.pow(10, 9)) + " s");
	}
}
