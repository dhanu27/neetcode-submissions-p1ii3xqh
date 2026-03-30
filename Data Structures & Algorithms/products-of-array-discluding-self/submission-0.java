class Solution {
    public int[] productExceptSelf(int[] nums) {
        int total = 1;
        int numberOfZeros = 0;
        int numberOfNegatives = 0;
        int ans[] = new int[nums.length];
        for(int i=0; i<nums.length; i++){
            if(nums[i] == 0){
               if(numberOfZeros > 0){
                 numberOfZeros++;
                 total = 0;
                 break;
               }else{
                numberOfZeros++;
               }
            }else if(nums[i] < 0){
               numberOfNegatives++;
               total = total * Math.abs(nums[i]); 
            }else{
            total = total * nums[i];
            }
        }
        for(int i =0;  i<nums.length; i++){
        
            if(nums[i] == 0){
                if(numberOfZeros > 1){
                    ans[i] = 0;
                }else{
                    ans[i] = total * (numberOfNegatives%2 ==0 ? 1 : -1);
                }
            }
            else if(nums[i] < 0){
                if(numberOfZeros > 0){
                    ans[i] = 0;
                }else{
                    ans[i] = (total/Math.abs(nums[i])) * ((numberOfNegatives -1)%2 ==0 ? 1 : -1);
                }
            }else{
                  if(numberOfZeros > 0){
                    ans[i] = 0;
                }else{
                    ans[i] = (total/Math.abs(nums[i])) * ((numberOfNegatives)%2 ==0 ? 1 : -1);
                }
            }
        }
return ans;
    }
}  
