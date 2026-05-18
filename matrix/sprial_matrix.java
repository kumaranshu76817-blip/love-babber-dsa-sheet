import java.util.ArrayList;
import java.util.List;

public class sprial_matrix {
    public static List<Integer> spiralMatrix(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        List<Integer> result = new ArrayList<>();
        int startingRow = 0;
        int endingRow = m - 1;
        int startingCol = 0;
        int endingcol = n - 1;

        while (startingRow <= endingRow && startingCol <= endingcol) {


            // left to right to print startingRow -> goes from startingCol to endingcol
            for (int col= startingCol; col <= endingcol; col++) {
                result.add(matrix[startingRow][col]);
            }
            startingRow++;


            // top to bottom print endingol then -> goes from startingRow to endingRow
            for (int row = startingRow; row <=endingRow; row++) {
                result.add(matrix[row][endingcol]);
            }
            endingcol--;

            // right to left to print endingRow -> goes from to endingcol to startingcol
            if (startingRow <= endingRow) {
                for (int col = endingcol; col >=startingCol; col--) {
                    result.add(matrix[endingRow][col]);
                }
            }
            endingRow--;

            // bottome to top to print startingCol -> then form to endingRow to startingRow
            if (startingCol <= endingcol) {
                for (int row = endingRow; row >= startingRow; row--) {
                    result.add(matrix[row][startingCol]);
                }
                startingCol++;
            }
        }
        return result;
    }
    public static void main(String[] args) {
        int matrix[][] = {{1,2,3},
                          {4,5,6},
                          {7,8,9}};
        List<Integer> ans = spiralMatrix(matrix);
        System.out.println(ans);
    }
}
