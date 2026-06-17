class Solution {
    List<String> ans = new ArrayList<>();
    public void letterCombinationsHelper(
        String digits, HashMap<Integer, List<Character>> map, StringBuilder curr, int indx) {
        if (indx >= digits.length()) {
            ans.add(new String(curr.toString()));
            return;
        }
        int num = Integer.valueOf(digits.charAt(indx) + "");
        List<Character> temp = map.get(num);
        for (int i = 0; i < temp.size(); i++) {
            curr.append((char) (temp.get(i)));
            letterCombinationsHelper(digits, map, curr, indx + 1);
            curr.deleteCharAt(curr.length() - 1);
        }
    }

    public List<String> letterCombinations(String digits) {
        if(digits.length() == 0){
            return ans;
        }
        HashMap<Integer, List<Character>> map = new HashMap<>();
        int i = 0;
        int number = 2;
        while (i < 26) {
            int cycle = (i == 15 || i == 22) ? 4 : 3;
            List<Character> ch = new ArrayList<>();
            while (cycle-- > 0) {
                ch.add((char) ('a' + i));
                i++;
            }
            map.put(number, ch);
            number++;
        }
        StringBuilder curr = new StringBuilder("");
        letterCombinationsHelper(digits, map, curr, 0);
        return ans;
    }
}
