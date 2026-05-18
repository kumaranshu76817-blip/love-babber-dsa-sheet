public class rotate_90 {
    public static void  rotate(int [][] martrix){
        int n = martrix.length;

        for(int i=0; i<n; i++){
            for(int j = i+1; j<n; j++){
                int temp = martrix[i][j];
                martrix[i][j] = martrix[j][i];
                martrix[j][i] = temp;

            }
        }
        for(int i = 0; i<n; i++){
        int startcol = 0;
        int endcol = n- 1;

        while (startcol<=endcol) {
            int temp = martrix[i][startcol];
            martrix[i][startcol] = martrix[i][endcol];
            martrix[i][endcol]= temp;

            startcol++;
            endcol--;
        }
    }
        
    }

    public static void main(String[] args) {
        int [][] martrix = {{1,2,3},{4,5,6},{7,8,9}};
        rotate(martrix);
        int n = martrix.length;
     
        for(int i=0; i<n; i++){
            for(int j =0; j<n; j++){
                System.out.print(martrix[i][j] +" ");
            }
        }
    }
}
