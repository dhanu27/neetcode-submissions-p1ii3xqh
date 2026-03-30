class Pair{
  int f;
  int s;
  Pair(int f, int s){
    this.f = f;
    this.s = s;
  }
}
class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer> map= new HashMap<>();

        for(int i=0; i<nums.length; i++){
            int complement = target - nums[i];
            if(map.get(complement)!=null){
                return new int[]{map.get(complement), i};
            }
            map.put(nums[i],i);
        }
        return null;
    }
}
