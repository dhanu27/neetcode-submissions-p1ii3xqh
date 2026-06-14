class Solution {
    public void generateParenthesisHelper(
        int n, char[] ans, int open, int close, List<String> result, int indx) {
        if (open == 0 && close == 0) {
            result.add(new String(ans));
            return;
        }
        if (open > 0) {
            ans[indx] = '(';
            open = open - 1;
            generateParenthesisHelper(n, ans, open, close, result, indx + 1);
            open = open + 1;
        }

        if (close > 0 && open <= close - 1) {
            ans[indx] = ')';
            close = close - 1;
            generateParenthesisHelper(n, ans, open, close, result, indx + 1);
            close = close + 1;
        }
    }

    public List<String> generateParenthesis(int n) {
        char[] ans = new char[n * 2];
        List<String> result = new ArrayList<String>();
        generateParenthesisHelper(n, ans, n, n, result, 0);
        return result;
    }
}
