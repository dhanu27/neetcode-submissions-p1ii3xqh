class Solution {

    public List<List<Integer>> combinationSumHelper(int [] nums, int index, int target){
        if(target == 0){
            List<List<Integer>> ans1 = new ArrayList<>();
            List<Integer> temp = new ArrayList<>();
            ans1.add(temp);
            return ans1;
        }
        if(target < 0 || index == nums.length){
            List<List<Integer>> ans1 = new ArrayList<>();
            return ans1;
        }


        List<List<Integer>> ans1 = combinationSumHelper(nums, index, target - nums[index]);
        List<List<Integer>> ans2 = combinationSumHelper(nums, index+1, target);
        List<List<Integer>> result = new ArrayList<>();
        for(int i=0; i<ans1.size(); i++){
            // List<Integer> temp = new ArrayList<>();
            // temp.add(nums[index]);
            // for(int j=0; j<ans1.get(i).size(); j++){
            //     temp.add(ans1.get(i).get(j));
            // }
            ans1.get(i).add(nums[index]);
            result.add(ans1.get(i));
        }
        for(int i=0; i<ans2.size(); i++){
            result.add(ans2.get(i));
        }
        return result;
    }



    public List<List<Integer>> combinationSum(int[] nums, int target) {
        return combinationSumHelper(nums, 0, target);
    }
}
