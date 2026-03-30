class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) return false;
        int alpha[][] = new int[2][26];
        for(int i=0; i<s.length(); i++){
            int indx1 = s.charAt(i) - 'a';
            int indx2 = t.charAt(i) - 'a';
            alpha[0][indx1] = alpha[0][indx1] + 1;
            alpha[1][indx2] = alpha[1][indx2] + 1;
        }

        for(int i=0; i<26; i++){
            if(alpha[0][i] != alpha[1][i]){
                return false;
            }
        }
     return true;
    }
}
