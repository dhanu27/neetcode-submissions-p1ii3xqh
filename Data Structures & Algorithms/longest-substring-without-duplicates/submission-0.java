class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Integer, Integer> map = new HashMap<>();
        if(s.length()<2) return s.length();
         int leftIndex = 0;
         int rightIndex = 1;
         map.put(s.charAt(0)-'a', 0);
         int ans = 1;
         while(rightIndex < s.length()){
            int key = s.charAt(rightIndex) - 'a';
             Integer existingAtIndx = map.get(key);
             if( existingAtIndx != null && (existingAtIndx>=leftIndex && existingAtIndx<=rightIndex)){
                // map.remove(key);
                ans = Math.max(ans, rightIndex - leftIndex);
                leftIndex = existingAtIndx+1;
             }else{
                ans = Math.max(ans, rightIndex - leftIndex +1);
             }
             map.put(key, rightIndex);
             rightIndex++;
         }
         return ans;
    }
}
