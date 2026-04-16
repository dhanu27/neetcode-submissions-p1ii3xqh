class Solution {
    public int findMin(int[] nums) {

        int start = 0;
        int end = nums.length-1;
        int n = nums.length;

        while(start < end && nums[start] > nums[end]){
            int mid = (start+end)/2;
            if( (mid > 0) && (mid < n-1) && (nums[mid-1] > nums[mid]) && (nums[mid] < nums[mid+1])){
               return nums[mid];
            }else if(nums[mid] < nums[start]){
                 end = mid -1;
            }else{
                start = mid +1;
            }
        }
     return nums[start];
    }
}
