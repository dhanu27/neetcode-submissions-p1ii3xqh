class Solution {
    public List<Integer> getAllDigits(int n) {
        List<Integer> ans = new ArrayList<>();
        while (n > 0) {
            int d = n % 10;
            ans.add(d);
            n = n / 10;
        }
        return ans;
    }
    public boolean isHappy(int n) {
        HashMap<Integer, Boolean> map = new HashMap<>();
        int m=n*n;
        while (m-->0) {
            List<Integer> ans = getAllDigits(n);
            // System.out.println()
            int newN = 0;
            for (int i = 0; i < ans.size(); i++) {
                newN = newN + (ans.get(i) * ans.get(i));
            }
            if (newN == 1) {
                return true;
            }
            if (map.get(newN)!=null) {
                return false;
            }
            map.put(newN, true);
            n = newN;
        }
        return false;
    }
}
