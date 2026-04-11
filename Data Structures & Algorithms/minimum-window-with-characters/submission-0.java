class Solution {

    public boolean isValidSubString(HashMap<Character,Integer> map){
        for(Character ch : map.keySet()){
            if(map.get(ch) > 0 ){
                return false;
            }
        }
        return true;
    }
    public String minWindow(String s, String t) {
       int n = s.length();
       int m = t.length();

       if(  m > n){
           return "";
       }
  
       // For string single length
       if( m == 1) {
          for(int i=0; i<n; i++){
            if(s.charAt(i) == t.charAt(0)){
                return t;
            }
          }
          return "";
       }
       
       //Count Map of shorter string
       HashMap<Character,Integer> map =  new HashMap<>();
       for(int i=0; i<m; i++){
         char ch = t.charAt(i);
         map.put(ch ,map.getOrDefault(ch,0) + 1);
       }


       int left =0;
       int right = 1;
       int minLength = Integer.MAX_VALUE;
       String result = "";

       map.computeIfPresent(s.charAt(left) , (key,val) -> val - 1);
       map.computeIfPresent(s.charAt(right) , (key,val) -> val - 1);

       while(right < n && left<right){

            // In case subString is valid remove left ptr till string is valid 
            while(isValidSubString(map)){
                 if(minLength > right-left +1){
                    result = s.substring(left,right+1);
                    minLength = right-left +1;
                 }
                 map.computeIfPresent(s.charAt(left) , (key,val) -> val + 1);
                 left = left + 1;
            }

            //Return incase we found exact string
            if(minLength == m){
                return result;
            }

            // We had found valid string but after moving left it got invalid and window is fixed now
            if(minLength < Integer.MAX_VALUE){
                map.computeIfPresent(s.charAt(left) , (key,val) -> val + 1);
                left = left + 1;
                right = right + 1;
                if(right < n){
                  map.computeIfPresent(s.charAt(right) , (key,val) -> val - 1);
                }
            }else{
                // Not found valid window till now
                while(left < n && map.get(s.charAt(left)) == null){
                    left = left + 1;
                }
                if(left > right && left < n){
                    map.computeIfPresent(s.charAt(left) , (key,val) -> val - 1);
                    right = left ;
                }
                right = right + 1;
                if(right < n){
                  map.computeIfPresent(s.charAt(right) , (key,val) -> val - 1);
                }
            }
       }
     return result;
    }
}
