class Solution {
    public int evalRPN(String[] tokens) {
        Stack<String> st = new Stack<>();
        int n = tokens.length;
        for(int i=0; i<n; i++){
            if(tokens[i].equals("*")){
                int operand2 = Integer.parseInt(st.pop());
                int operand1 = Integer.parseInt(st.pop());
                int ans = operand1 * operand2;
                st.push(ans+"");
            }else if(tokens[i].equals( "+")){
                int operand2 = Integer.parseInt(st.pop());
                int operand1 = Integer.parseInt(st.pop());
                int ans = operand1 + operand2;
                st.push(ans+"");
            }else if(tokens[i].equals( "-")){
                 int operand2 = Integer.parseInt(st.pop());
                int operand1 = Integer.parseInt(st.pop());
                int ans = operand1 - operand2;
                st.push(ans+"");
            }else if(tokens[i].equals("/")){
                 int operand2 = Integer.parseInt(st.pop());
                int operand1 = Integer.parseInt(st.pop());
                int ans = operand1 / operand2;
                st.push(ans+"");
            }else{
                st.push(tokens[i]);
            }
        }
      return Integer.parseInt(st.pop());
    }
}
