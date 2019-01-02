public class ProggTest {
	private static int row;
	private static int col;
	public static void main(String[] args) {
		row = 0;
		col = 0;
		
		System.out.print("|" + col + "|");
		for(int i = 1; i <= 80; i++) {
			System.out.print("|" + getCol() + "|");
			if(col >= 8) {
				System.out.print("\n");
			}
		}
	}
	
	public static int getCol() {
		if(row < 9) {
			if(col == 8 && row < 8) {
				col = 0;
				row++;
			}
			else {
				col++;
			}
		}
		return col;
	}
}