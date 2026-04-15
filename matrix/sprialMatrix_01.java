
import java.util.ArrayList;
import java.util.List;

public class sprialMatrix_01 {
    public static List<Integer> sprrialPahtMatrix(int [][] matrix, int n, int m){
        List<Integer> ans = new ArrayList<>();
        int top = 0;
        int bottom = n-1;
        int left = 0;
        int right = m-1;

        while (top<=bottom && left<= right) {

            //top rows
            for(int i= left; i<= right; i++){
                ans.add(matrix[top][i]);
            }
            top++;


            //right columns
            for(int i=top; i<=bottom; i++){
                ans.add(matrix[i][right]);
            }
            right--;

            //bottom rows
            if(top<=bottom){
                for(int i=right; i>=left; i--){
                    ans.add(matrix[bottom][i]);
                }
                bottom--;
            }

            //left column
            if(left<=right){
                for(int i=top; i>=bottom; i--){
                    ans.add(matrix[i][left]);
                }
                left++;
            }
        }
        return ans;
    }
    
    public static void main(String[] args) {
        int[][] matrix = {
            {1, 2, 3, 4},
            {5, 6, 7, 8},
            {9, 10, 11, 12},
            {13, 14, 15, 16}
        };
        
        List<Integer> result = sprrialPahtMatrix(matrix, 4, 4);

        for(int num: result){
            System.out.print(num+" ");
        }
    }
}
