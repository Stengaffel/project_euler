import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class Problem8 {
	public static void main(String[] args) {

		String numFile = "./CompFiles/BigNumP8.txt";
		String theString = "";

		try {
			File file = new File(numFile);
			Scanner scan = new Scanner(file);

			while(scan.hasNextLine()) {
				theString = theString + scan.nextLine();
			}
			// System.out.println(theString);
			char[] charArray = theString.toCharArray();

			long biggestProd = 0;
			int biggestPos = -1;
			/*for(int i = 0; i < charArray.length; ++i) {
				System.out.println(charArray[i]);
			} */

			for(int pos = 0; pos < (charArray.length - 12); pos++) {
				long tempProd = 1;
				System.out.println("- - - - - - - - - - - -");
				System.out.println("Pos: " + pos);
				for(int i = pos; i < pos + 13; ++i) {
					long temp = (long) theString.charAt(i) - '0';
					// System.out.println("Temp: " + temp);
					tempProd = tempProd * temp;
				}
				System.out.println("TempProd = " + tempProd);
				System.out.println("BiggestProd = " + biggestProd);
				if(tempProd > biggestProd) {
					System.out.println("INCREMENT");
					biggestProd = tempProd;
					biggestPos = pos;
				}
			}
			System.out.println(biggestPos);
			System.out.println("BiggestProd = " + biggestProd);

			}
		catch(FileNotFoundException e){
			System.out.println("Ding dong fel");
		}

	}
}
