class Solution {
    public int findKthLargest(int[] nums, int k) {
        Comparator<Integer> c= (a,b) -> b-a; 
        PriorityQueue<Integer> pq = new PriorityQueue<>(c);
        for(int i=0; i<nums.length; i++){
            pq.add(nums[i]);
        }

        while(k-- > 1){
            pq.remove();
        }
        return pq.remove();
    }
}
