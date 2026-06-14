//in this question i solve to search in 2d array by using binary search 
// question hai mera ki  = {
//     (1,3,5,7),
//     (10,11,16,20),
//     (20,30,34,60)
// }
//the first integer of each row greater than previous row.
//let solve it

public class search_matrix {
    public static boolean searchMatrix(int[][] matrix, int target) {
        int totalRows = matrix.length;
        int totalCols = matrix[0].length;

        // total matrix ki length nikalna hai to
        int n = totalRows * totalCols;

        int start = 0;
        int end = n - 1;

        // binary search

        while (start <= end) {
            int mid = start + (end - start) / 2;

            // value ki index nikalne ka formula = mid / totalcols

            int rowIndex = mid / totalCols;
            int colIndex = mid % totalCols;

            if (matrix[rowIndex][colIndex] == target) {
                return true;
            }

            else if (matrix[rowIndex][colIndex] > target) {
                end = mid - 1;
            }

            else {
                start = mid + 1;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        
    int [][] matrix  = {
        {1,3,5,7},
        {10,11,16,20},
        {20,30,34,60}
    };
    int target = 11;
    int target2 = 22;
    System.out.println(searchMatrix(matrix, target));
    System.out.println(searchMatrix(matrix, target2));
    }
}
