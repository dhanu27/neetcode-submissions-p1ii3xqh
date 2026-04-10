class Solution {
    public int[] dailyTemperatures(int[] temp) {
        Stack<Integer> st = new Stack<>();
        int n = temp.length;
        int[] ans = new int[n];
        st.push(0);
        for(int i=0; i<n; i++){
          while(!st.isEmpty() && temp[i] > temp[st.peek()]){ 
             int lastIndx = st.pop();
             ans[lastIndx] = i- lastIndx; 
          }
          st.push(i);
        }

        while(!st.isEmpty()){
           int lastIndx = st.pop();
           ans[lastIndx] = 0;
        }
        return ans;
    }
}
