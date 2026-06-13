class MedianFinder {
    PriorityQueue<Integer> maxHeap;
    PriorityQueue<Integer> minHeap;

    public MedianFinder() {
        Comparator<Integer> c = (a, b) -> b - a;
        maxHeap = new PriorityQueue<>(c);
        minHeap = new PriorityQueue<>();
    }

    public void addNum(int num) {
        if(maxHeap.isEmpty()){
            maxHeap.add(num);
            return;
        }
        // if(minHeap.isEmpty()){
        //     minHeap.add(num);
        //     return;
        // }
        if (maxHeap.peek() >= num) {
            maxHeap.add(num);
        } else {
            minHeap.add(num);
        }

        if (minHeap.size() == maxHeap.size()) {
            return;
        }
        if (maxHeap.size() > minHeap.size()) {
            int newNum = maxHeap.remove();
            minHeap.add(newNum);
            return;
        }
        int newNum = minHeap.remove();
        maxHeap.add(newNum);
    }

    public double findMedian() {
        int totalLength = minHeap.size() + maxHeap.size();
        if(totalLength % 2 != 0){
            if(maxHeap.size() > minHeap.size()){
                return maxHeap.peek();
            }
            return minHeap.peek();
        }
        else{
            return (double)(maxHeap.peek() + minHeap.peek()) /2;
        }
    }
}
