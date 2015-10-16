package freeman;

public class Freeman {
	
	private int[][] input;
	
	public Freeman(int[][] in) {
		input = in;
	}
	
	public void print() {
		for(int i = 0; i < input.length; i++) {
			for(int j = 0; j < input[i].length; j++) {
				System.out.print(input[i][j] + " ");
			}
			System.out.println();
		}
	}

}
