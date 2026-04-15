class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int n = piles.length;
        long left = 1;
        long right = piles[0];
        for(int i =1; i<n; i++){
            // left = Math.min(left,piles[i]);
            right = Math.max(right,piles[i]);
        }

        long min = Integer.MAX_VALUE;

        while(left<=right){
            long rate = (left+right)/2;
            long timeTaken = 0;
            for(int i=0; i<n; i++){
               timeTaken = timeTaken + (piles[i] < rate ? 1 : (piles[i]/rate) + (piles[i]%rate == 0 ? 0 : 1));
            }
            System.out.println("Rate:- "+rate+" timeTake:- "+timeTaken);
            if(timeTaken <= h){
                min = Math.min(min,rate);
                right = rate -1;
                // return rate;
            }
            else {
               left = rate + 1;
            }
        }
        return (int)min;
    }
}
