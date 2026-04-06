class Solution {
    public boolean checkInclusion(String s1, String s2) {
       int alphaCount []= new int[26];
       ArrayList<Integer> alpha[] = (ArrayList<Integer>[])new ArrayList[26];
       int n = s2.length();
       for(int i=0; i<26; i++){
         alpha[i] = new ArrayList<>();
       }
       for(int j =0; j<s1.length(); j++){
          int indx = s1.charAt(j) - 'a';
          alphaCount[indx] = alphaCount[indx] + 1; 
       }

       int left = 0;
       int right = 0;
       int i=0;
       while(i<n){
        int currIndx = s2.charAt(i) - 'a';
         if(alphaCount[currIndx] == 0){
            System.out.println("Not currIndx:- "+currIndx+"");
            i++;
            left = i;
            right = i;
            continue;
         }else {
           if(alpha[currIndx].size() == alphaCount[currIndx]){
               while(alpha[currIndx].size()>0 && alpha[currIndx].get(0) <left){
                 alpha[currIndx].remove(0);
               }
               if(alpha[currIndx].size() == alphaCount[currIndx]){
                    int newLeft = alpha[currIndx].get(0);
                    alpha[currIndx].remove(0); 
                    alpha[currIndx].add(i);
                    left = newLeft + 1;
               }else{
                  alpha[currIndx].add(i);
               }
           }else{
              alpha[currIndx].add(i);
           }
           System.out.println("Left:-"+left+" i:- "+i);
           if( (i-left + 1) ==  s1.length()){
              return true;
           }
           i++;
           right = i;
         }
       }
       return false;
    }

}
