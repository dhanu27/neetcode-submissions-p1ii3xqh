class Solution {

    public int findMiddlePoint(int[] nums){
        int left = 0;
        int right = nums.length - 1;

       // Find minimum element till number at left is greater than right number 
       // otherwise it sorted window return left
        while(left < right && nums[left] > nums[right]){
           
             int mid = left + (right - left)/2;

            System.out.println("Mid:- "+mid);
           if( ((mid-1 < 0 ? Integer.MAX_VALUE : nums[mid-1]) > nums[mid]) && 
               ((mid+1 >= nums.length ? Integer.MAX_VALUE : nums[mid+1]) > nums[mid])){
             return mid;
           }

           else if(nums[mid] >= nums[left]){
             left = mid + 1;
           }else{
            right = mid-1;
           }
        }
        return left;
    }
    
    public int findElement(int nums[], int st, int end, int target){
        while(st<=end){
            int mid = st + (end - st)/2;
            if(nums[mid] == target){
                return mid;
            }
            else if(nums[mid] > target){
                end = mid -1;
            }else{
                st = mid + 1;
            }
        }
        return -1;
    }

    public int search(int[] nums, int target) {
        int right = nums.length-1;
        int left = 0;

        int middlePoint = findMiddlePoint(nums);
        System.out.println("MiddlePoint:- "+middlePoint);
  
        if(left == middlePoint){
            return findElement(nums, 0, right, target);
        }
        else if( target >= nums[middlePoint] && nums[right] >= target){
             return findElement(nums, middlePoint, right, target);
        }else {
            return findElement(nums,  left , middlePoint, target);
        }
    }
}
