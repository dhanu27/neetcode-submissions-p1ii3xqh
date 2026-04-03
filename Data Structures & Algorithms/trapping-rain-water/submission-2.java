class Solution {
    public int trap(int[] height) {
         int n = height.length;
        int leftPeek = 1;
        int rightPeek = n;
        int prefixSum[] = new int[n+2];
        int suffixSum[] = new int[n+2];
        int newArray[] = new int[n+2];
        int sum =0;
        for(int i=0; i<n; i++){
            sum = sum + height[i];
            prefixSum[i+1] = sum; 
            newArray[i+1] = height[i];
        }
        sum =0;
        for(int i=n-1; i>0; i--){
            sum = sum + height[i];
            suffixSum[i+1] = sum; 
        }

        int j =2;
        int ans = 0;
        while(j<=n){
             if(newArray[leftPeek] <= newArray[j]){
                if((j-leftPeek-1) * Math.min(newArray[j], newArray[leftPeek]) > 0){
                   ans = ans + ((j-leftPeek-1) * Math.min(newArray[j], newArray[leftPeek])) - 
                                 (prefixSum[j-1] - prefixSum[leftPeek]);  
                 }

                    System.out.println("Ans:"+ans+ "leftPeek"+leftPeek +"j:- "+j);  
                      leftPeek = j;           
                
             }
             j++;
        }
       j = n-1;
       while(j>=0){
         if(newArray[rightPeek] <= newArray[j] && j >= leftPeek){
               if((rightPeek-j-1) * Math.min(newArray[j], newArray[rightPeek]) > 0){
                   ans = ans + ((rightPeek-j-1) * Math.min(newArray[j], newArray[rightPeek])) - 
                                 (suffixSum[j+1] - suffixSum[rightPeek]); 
               } 

                    System.out.println("Ans:"+ans+ "rightPeek"+rightPeek +"j:- "+j);  
                      rightPeek = j;           
                
             }
             j--;
       }
     return ans;
    }
}
