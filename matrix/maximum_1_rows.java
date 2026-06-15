public class maximum_1_rows {
    static int getFristOccurence(int [][] arr ,int rowIndex){
        int totalRows = arr.length;
        int totalCols = arr[0].length;

        int ans = -1;
        int target = 1;
        if(arr[rowIndex][totalRows-1]== 0){
            return totalCols;
        }
        else{
            //1 index ho to
            int start = 0;
            int end = totalCols -1;
            while (start<=end) {
                int mid = start + (end - start)/2;
                if(arr[rowIndex][mid] == 0 ){
                    start = mid +1;
                }

                else{
                    ans = mid;
                    end = mid -1;
                }

            }
        }
        return ans;
    }

    public static int rowsWithMaxOnes(int [][] matrix){
        int totalRows = matrix.length;
        int totalCols = matrix[0].length;

        int maxi = -1;
        int maxOneWaliRowIndex = -1;


        //move to each row for each row
        //find the first element 
        //using the f.o will be calculate the count of 1's
        //update the maxi variable or the indxe variable basis on that



        for(int rows = 0; rows < totalRows; rows++){

            //for each row find first occurence
            int firstOccurence = getFristOccurence(matrix, rows);

            //calculate number of 1's in rows
            int oneCount = totalCols - firstOccurence;

            //update maxin or index variables
            if(oneCount != 0 && oneCount > maxi){

                //update the maxi
                maxi = oneCount;
                maxOneWaliRowIndex = rows;
            }

        }
        return maxOneWaliRowIndex;
    }

    public static void main(String[] args) {
        int [][] matrix = {
            {0,0,0,0,1,1},
            {0,0,0,1,1,1},
            {0,0,1,1,1,1},
            {0,1,1,1,1,1}
        };
        System.out.println(rowsWithMaxOnes(matrix));
    }
}
