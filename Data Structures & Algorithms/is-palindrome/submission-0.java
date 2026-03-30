class Solution {
    public boolean isPalindrome(String str) {
        String s = str.toLowerCase();
        int i=0;
        int j=s.length()-1;
        int n = s.length();
        while(i<j){
           if(s.charAt(i)== s.charAt(j)){
             i++;
             j--;
             continue;
           }
           else if(!Character.isLetterOrDigit(s.charAt(i)) || !Character.isLetterOrDigit(s.charAt(j))){
           if(!Character.isLetterOrDigit(s.charAt(i))){
             i++;
           }
           if(!Character.isLetterOrDigit(s.charAt(j))){
             j--;
           }
           continue;
        }
        return false;
        }
       return true; 
    }
}
