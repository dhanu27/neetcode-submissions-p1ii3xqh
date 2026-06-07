class Solution {
    public int lastStoneWeight(int[] stones) {
        Comparator<Integer> c = (a, b) -> b - a;
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(c);

        for (int i = 0; i < stones.length; i++) {
            pq.add(stones[i]);
        }

        while (pq.size() > 1) {
            int x = pq.remove();
            int y = pq.remove();
            if (x != y) {
                int newX = Math.abs(y - x);
                pq.add(newX);
            }
        }
        return pq.size() == 0 ? 0 : pq.peek();
    }
}
