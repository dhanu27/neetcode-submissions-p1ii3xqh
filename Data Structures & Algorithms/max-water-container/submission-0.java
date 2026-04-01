class Solution {
    public int maxArea(int[] heights) {
        int left =  0 ;
        int right =  heights.length-1;
        int sum = 0;
    
        while(left < right){
             sum = Math.max(Math.min(heights[left], heights[right]) * (right - left),sum);
             if(heights[left] == heights[right]){
                left++;
                right--;
             }else if(heights[left] < heights[right]){
                left++;
             }else{
                right--;
             }
        }
        return sum;
    }
}
