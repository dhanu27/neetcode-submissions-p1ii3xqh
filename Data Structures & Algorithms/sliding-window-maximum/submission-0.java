class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        TreeMap<Integer,Integer> map = new TreeMap<>();
        // Number of windows get created
         int m = nums.length - (k - 1);
         int [] result= new int[m];
         //Add first k element in treeMap
        for(int i=0; i<k; i++){
            map.put(nums[i], map.getOrDefault(nums[i],0) + 1);
        }

        int left = 0;
        int right = k-1;
        int j=0;
        while(j<m){ 
            // Add maximum element of window
            result[j++] = map.lastKey(); 
           // Handle case where next window is there
            if(right + 1 <nums.length){
                // remove or update left pointer in tree
               map.put(nums[left] , map.get(nums[left])-1);
               if(map.get(nums[left]) == 0){
                map.remove(nums[left]);
               }
               left = left +1;
               // Add right pointer in a tree
               right = right + 1;
               map.put(nums[right], map.getOrDefault(nums[right],0) + 1);
            }else{
                return result;
            }
        }
       return result;  
    }
}
