class Solution {
    public ArrayList<ArrayList<Integer>> permuteHelper(int[] nums, int indx) {
        if (indx == nums.length) {
            ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
            ArrayList<Integer> temp = new ArrayList<Integer>();
            // temp.add(nums[indx]);
            ans.add(temp);
            return ans;
        }

        ArrayList<ArrayList<Integer>> smallAns = permuteHelper(nums, indx + 1);
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < smallAns.size(); i++) {
            List<Integer> copy = List.copyOf(smallAns.get(i));
            for (int j = 0; j < copy.size() + 1; j++) {
                ArrayList<Integer> temp = new ArrayList<Integer>(smallAns.get(i));
                temp.add(j, nums[indx]);
                ans.add(temp);
            }
        }
        return ans;
    }

    public List<List<Integer>> permute(int[] nums) {
        return new ArrayList<>(permuteHelper(nums, 0));
    }
}
