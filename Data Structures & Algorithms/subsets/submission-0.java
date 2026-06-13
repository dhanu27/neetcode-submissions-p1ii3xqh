class Solution {
    public List<List<Integer>> subsetsHelper(int[] nums, int index) {
        if (index == nums.length) {
            List<List<Integer>> result = new ArrayList<>();
            List<Integer> emptyList = new ArrayList<>();
            result.add(emptyList);
            return result;
        }

        List<List<Integer>> smallAns = subsetsHelper(nums, index + 1);
        List<List<Integer>> result = new ArrayList<>();

        for (int i = 0; i < smallAns.size(); i++) {
            List<Integer> temp = new ArrayList<>();
            temp.add(nums[index]);
            for (int j = 0; j < smallAns.get(i).size(); j++) {
                temp.add(smallAns.get(i).get(j));
            }
            result.add(smallAns.get(i));
            result.add(temp);
        }
        return result;
    }

    public List<List<Integer>> subsets(int[] nums) {
        return subsetsHelper(nums, 0);
    }
}
