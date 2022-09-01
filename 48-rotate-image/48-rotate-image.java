class Solution {
    public void rotate(int[][] matrix) {
    //First we transpose the array
        transpose(matrix);

        //Then we reverse each row
        reverse(matrix);
    }
    
       public void transpose(int[][] arr){
        for (int i = 0; i < arr.length; i++){
            for (int j = 0; j < i; j++){
                int temp = arr[j][i];
                arr[j][i] = arr[i][j];
                arr[i][j] = temp;
            }
        }
    }

    public void reverse(int[][] arr){
        for (int i = 0; i < arr.length; i++){
            int k = 0;
            int j = arr[0].length-1;
            while(k < j){
                int temp = arr[i][k];
                arr[i][k] = arr[i][j];
                arr[i][j] = temp;
                k++;
                j--;
            }
        }
    }
}