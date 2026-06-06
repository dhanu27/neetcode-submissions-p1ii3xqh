class KthLargest {
    // Comparator<Integer> c = new Comparator<Integer>(){
    //       public int compare(Integer i, Integer j){
    //         return j-i;
    //     }
    // };
    // Comparator<Integer> c = (a,b) -> b-a;
    PriorityQueue<Integer> pq;
    int capacity;
    public KthLargest(int k, int[] nums) {
        pq = new PriorityQueue<>(k);
        capacity = k;
        Arrays.sort(nums);
        for (int i = nums.length - 1; i >= 0 && pq.size() < k; i--) {
            pq.add(nums[i]);
        }
    }

    public int add(int val) {
        if (!pq.isEmpty()) {
            if (pq.peek() < val) {
                if (pq.size() == capacity) {
                    pq.poll();
                }
                pq.add(val);
            }
        } else {
            pq.add(val);
        }

        return pq.peek();
    }
}
