class MinStack {
    Stack<Pair<Integer,Integer>> st;
    // int tempMin = Integer.MAX_VALUE;
    public MinStack() {
        st = new Stack<>();
    }
    
    public void push(int val) {
        int min = val;
        if(!st.isEmpty()){
           min = Math.min(val, st.peek().getValue());
        }
        st.push(new Pair(val,min));
    }
    
    public void pop() {
        st.pop();
    }
    
    public int top() {
        return st.peek().getKey();
    }
    
    public int getMin() {
        return st.peek().getValue();
    }
}
