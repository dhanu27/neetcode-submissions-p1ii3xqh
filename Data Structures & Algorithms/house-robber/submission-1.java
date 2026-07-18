class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 1) {
            return nums[0];
        }
        for (int i = n - 3; i >= 0; i--) {
            nums[i] = Math.max(nums[i + 2] + nums[i],nums[i+1]);
        }
        return Math.max(nums[0], nums[1]);
    }


    //   ans1 = nums[i] + rob(nums, i + 2);
    //   ans2 = rob(nums, i + 1);
    //   return max(ans1,ans2);
}
