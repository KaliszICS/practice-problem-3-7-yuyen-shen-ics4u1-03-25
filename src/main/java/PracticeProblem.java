public class PracticeProblem {

	public static void main(String args[]) {

	}

	public static int searchMazeMoves(String[][] arr1) {
		int row = arr1.length - 1;
		int col = 0;
		int moves = 0;
		int result = searchMazeMovesHelper(arr1, row, col, moves);
		
		if (result == Integer.MAX_VALUE) {
			return -1;
		} else {
			return result;
		}
	}

	public static int searchMazeMovesHelper(String[][] arr1, int row, int col, int moves) {
		int rows = arr1.length;
		int cols = arr1[0].length;

		if (row < 0 || row >= rows || col < 0 || col >= cols || arr1[row][col].equals("*")) {
			return Integer.MAX_VALUE;
		} 

		if (arr1[row][col].equals("F")) {
			return moves;
		}

		String temp = arr1[row][col];
		arr1[row][col] = "*";

		int right = searchMazeMovesHelper(arr1, row, col + 1, moves + 1);
		int up = searchMazeMovesHelper(arr1, row - 1, col, moves + 1);
		int left = searchMazeMovesHelper(arr1, row, col - 1, moves + 1);
		int down = searchMazeMovesHelper(arr1, row + 1, col, moves + 1);

		arr1[row][col] = temp;
		
		int min =  Math.min((Math.min(down, up)), (Math.min(right, left)));

		return min;
	}
}
