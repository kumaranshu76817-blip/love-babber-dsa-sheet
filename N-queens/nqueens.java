import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class nqueens {

    //kon kon sa place safe hai queen rakhen ke liye ye decide karnege
    static boolean isSafetoPlace(int rowIndex, int colIndex, int n, char [][] boards ){

        //value to update karenge
        int row = rowIndex;
        int col = colIndex;

        

        //horizontal case 
        while (col >= 0) {
            if(boards[row][col] == 'Q'){
                return false;
            }
            col--;
        }


        row = rowIndex;
        col = colIndex;

        // upper-diagonal case
        while(col >= 0 && row >= 0){
            if(boards[row][col] == 'Q'){
                return false;
            }
            col--;
            row--;
        }

        row = rowIndex;
        col = colIndex;

        //lower-diagonal case
        while (row < n && col >= 0) {
            if(boards[row][col] == 'Q'){
                return false;
            }
            col--;
            row++;
        }

        return true;
    }

    static void solve(char[][] boards, int n, int colIndex, List<List<String>> ans){
        if(colIndex >= n){
            List<String> temp = new ArrayList<>();
            
            for(int i=0; i<n; i++){
                temp.add(new String(boards[i]));
            }
            ans.add(temp);
            return;
        }


        for(int rowIndex = 0; rowIndex<n; rowIndex++){
            if(isSafetoPlace(rowIndex, colIndex, n , boards)){
                boards[rowIndex][colIndex] = 'Q';
                //ek case hmm solve karenge baaki recursion sambal lega
                solve(boards, n, colIndex+1, ans);
                //important step undo karna hai
                boards[rowIndex][colIndex] = '.';
            }
        }
        
    }

    public static List<List<String>> nqueen(int n){
        char [][] boards = new char[n][n];


        for(int i=0; i<n; i++){
            Arrays.fill(boards[i], '.');
        }

        int colIndex = 0;

        List<List<String>> ans = new ArrayList<>();

        solve(boards, n, colIndex, ans);

        return ans;
    }

    public static void main(String[] args) {
        int n = 18;
        List<List<String>> result = nqueen(n);

        System.out.println(result);
    }
}
