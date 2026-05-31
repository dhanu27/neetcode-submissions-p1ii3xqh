class Solution {
    public int largestRectangleArea(int[] heights) {
        // Left to right
        int n = heights.length;
        Stack<Integer> st = new Stack<>();
        int[] sum = new int[n];
        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && heights[st.peek()] >= heights[i]) {
                st.pop();
            }
            int lastIndex = st.isEmpty() == true ? -1 : st.peek();
            sum[i] = heights[i] * (i - lastIndex);
            st.push(i);
        }
    //   System.out.println("After left to right");
    //      for (int i = 0; i < n; i++) {
    //          System.out.print(" "+ sum[i] + " ");
    //     }

        // right to left
        st = new Stack();
        for (int i = n - 1; i >= 0; i--) {
            while (!st.isEmpty() && heights[st.peek()] >= heights[i]) {
                st.pop();
            }

            int lastIndex = st.isEmpty() == true ? n : st.peek();
            sum[i] = sum[i] + (heights[i] * (lastIndex - i - 1));
            st.push(i);
        }
        int max = 0;
        for (int i = 0; i < n; i++) {
            max = Math.max(max, sum[i]);
        }
        return max;
    }
}
