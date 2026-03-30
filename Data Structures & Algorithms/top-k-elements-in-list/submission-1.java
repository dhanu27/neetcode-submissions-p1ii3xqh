class Solution {

    public HashMap<Integer,Integer> sortByValue(HashMap<Integer,Integer> hm){
       List<Map.Entry<Integer,Integer>> list = new LinkedList<Map.Entry<Integer,Integer>>(hm.entrySet());
       Collections.sort(list, new Comparator<Map.Entry<Integer,Integer>>(){
           public int compare(Map.Entry<Integer,Integer> l1, Map.Entry<Integer,Integer> l2){
               return l2.getValue() - l1.getValue();
           }
       });
    
       HashMap<Integer,Integer> temp = new LinkedHashMap<Integer,Integer>();
       for(Map.Entry<Integer,Integer> aa: list){
           temp.put(aa.getKey(),aa.getValue());
       }
    
       return temp;
    }
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer> map = new HashMap<>();
        
        for(int i=0; i<nums.length; i++){
            map.computeIfPresent(nums[i],(key, val) -> val + 1);
            map.computeIfAbsent(nums[i],key -> 1);
        }
        int[] ans = new int[k];
        int z =0;
        HashMap<Integer,Integer> sortedMap = sortByValue(map);
        for(Map.Entry<Integer,Integer> entry: sortedMap.entrySet()){
              if(z == k){
                return ans;
              }
              ans[z++] = entry.getKey();
        }
        return ans;
    }
}
