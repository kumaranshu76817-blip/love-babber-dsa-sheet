// in this question says = You are provided with an mxn matrix, where each row and each column are sorted in ascending
// order. Your task is to find out whether a given target number exists in this matrix. The matrixis
// structured in such a way that facilitates efficient searching due to its sorted properties. Your goal is
// to implement the function bool searchMatrix(vector<vector <int>>& matrix, int target) that returns true
// if the target is present in the matrix, and false otherwise. 
//let solve it

public class search_element {
    public static boolean searchMatrix(int[][] matrix, int target) {
        int totalRows = matrix.length;
        int totalCols = matrix[0].length;

        int rows = 0;
        int cols = totalCols - 1;

        // optimal solution
        while (rows <= totalRows && cols >= 0) {
            if (matrix[rows][cols] == target) {
                return true;
            }

            else if (matrix[rows][cols] > target) {
                cols--;
            }

            else {
                // matrix[rows][cols]< target
                rows++;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] matrix = {
                { 1, 4, 7, 11, 15 },
                { 2, 5, 8, 12, 19 },
                { 3, 6, 9, 16, 22 },
                { 10, 13, 14, 17, 24 },
                { 18, 21, 23, 26, 30 }

        };  
        int target = 13;
        
        boolean found = searchMatrix(matrix, target);

        if(found){
            System.out.println("element found");
        }
        else{
            System.out.println("not found");
        }
    }
}
