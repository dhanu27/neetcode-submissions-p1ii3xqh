class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
       int total = m*n;
       Pair<Integer,Integer> temp[]= new Pair[total];
       int k= 0;
       for(int i =0; i<m; i++){
        for(int j=0; j<n; j++){
            temp[k++] = new Pair(i,j);
        }
       }
       int left = 0;
       int right = (m*n)-1;
       while(left<=right){
         int mid = (left+right)/2;
          int r = temp[mid].getKey();
          int c = temp[mid].getValue();
          if(matrix[r][c] == target){
            return true;
          }else if(matrix[r][c] > target){
              right = mid-1;
          }else{
            left = mid+1;
          }
       }
return false;
         
    }
}
