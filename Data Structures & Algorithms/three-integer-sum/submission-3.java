class Solution {
 
   public List<List<Integer>> twoSum(int[] nums, int left, int right, int target){
      List<List<Integer>> result = new ArrayList<>();
      while(left < right){
         if(nums[left] + nums[right] == target){
            List<Integer> ans = new ArrayList<>();
            ans.add(nums[left]);
            ans.add(nums[right]);
            result.add(ans);
            while(left < nums.length-1 && nums[left + 1] == nums[left]){
                left++;
            }
            left++;
            right--;
         }
         else if(nums[left] + nums[right] > target){
              right--;
         }else{
            left++;
         }
      }
      return result;
   }
    
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int i=0;
        List<List<Integer>> result = new ArrayList<>();
        while(i<n-2 && nums[i] <= 0){
            int left = i + 1;
            int right = n - 1;
            int target = nums[i] * -1;
            List<List<Integer>> temp = twoSum(nums,left,right,target);
            for(int z=0; z<temp.size(); z++){
              temp.get(z).add(nums[i]);
              result.add(temp.get(z));
            }
            while(i<n-1 && nums[i] == nums[i+1]){
                i++;
            }
            i++;
        }
        return result;
    }
}
