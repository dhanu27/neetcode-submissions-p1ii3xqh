class Solution {
    public List<List<Integer>> combiHelper(int[] candidates, int index, int target) {
        // System.out.println("Index:- " + index +" target:- " + target);
        if (target == 0) {
            List<List<Integer>> ans = new ArrayList<>();
            ans.add(new ArrayList<Integer>());
            return ans;
        }
        if (target < 0 || index >= candidates.length) {
            List<List<Integer>> ans = new ArrayList<>();
            return ans;
        }

        List<List<Integer>> ans1 = combiHelper(candidates, index + 1, target - candidates[index]);
       
        while(index < candidates.length-1 && candidates[index] == candidates[index + 1]){
             index++;
        }
        List<List<Integer>> ans2 = combiHelper(candidates, index + 1, target);
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < ans1.size(); i++) {
            ans1.get(i).add(candidates[index]);
            result.add(ans1.get(i));
        }
        for (int i = 0; i < ans2.size(); i++) {
            result.add(ans2.get(i));
        }
        return result;
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        return combiHelper(candidates, 0, target);
    }
}
