class Solution {
    public int longestConsecutive(int[] nums) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0; i<nums.length; i++){
            map.computeIfAbsent(nums[i],key -> 1);
        }
        int ans = 0;
        while(map.size()> 0){
            for(Integer key : map.keySet()){
                 int count = 1;
                 int start = key + 1;
                 while(map.get(start)!= null){
                    map.remove(start);
                    start = start+1;
                    count++;
                 }
                 int end = key -1;
                 while(map.get(end)!=null){
                     map.remove(end);
                    end =  end -1;
                    count++;
                 }
                 map.remove(key);
                 ans = Math.max(ans,count);
                 break;
            }
        }
        return ans;
    }
}
