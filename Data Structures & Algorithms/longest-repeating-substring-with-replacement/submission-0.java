class Solution {

    public boolean checkIsValid(int nums[], int allowed){
        int max = 0;
        for(int i=0; i<nums.length; i++){
            max = Math.max(max, nums[i]);
        }
        return max>= allowed;
    }

    public int characterReplacement(String s, int k) {
        int left = 0;
        int right = 1;
        int ans = 1;
        int hashSet[] = new int[26];
        hashSet[s.charAt(0)- 'A'] = 1;
        while(right<s.length()){
            ans = Math.max(ans, right-left);
            int index = s.charAt(right) - 'A';
            hashSet[index] = hashSet[index] + 1;
            while(!checkIsValid(hashSet,(right- left+1)-k)){
                int leftIndex = s.charAt(left)-'A';
                hashSet[leftIndex] = hashSet[leftIndex] - 1;
               left++;
            }  
            right++;
        }
        ans = Math.max(ans, right-left);
        return ans;
    }
}
