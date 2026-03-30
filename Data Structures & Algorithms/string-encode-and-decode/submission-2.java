class Solution {

    public String encode(List<String> strs) {
        String decodedString = "";
        for(int i=0; i<strs.size(); i++){
            // if(strs.get(i).length()> 0){
            decodedString = decodedString + strs.get(i).length() + "*" + strs.get(i);
            // }
        }
        return decodedString;
    }

    public List<String> decode(String str) {
        List<String> ans = new ArrayList<>();
        // if(str.length() == 0){
        //     ans.add("");
        //     return ans;
        // }
        System.out.println("decode str"+ str);
        int i=0;
        while(i<str.length()-1){
            int startIndx = i;
            int endIndx = i;
            String number = "";
            System.out.println("New word starting Index "+ i);
            while(endIndx < str.length() && str.charAt(endIndx) != '*' ){
                number = number + str.charAt(endIndx);
                endIndx++;
            }
            System.out.println("number "+ number);
            
            int lengthOfString = Integer.parseInt(number);

            String result = lengthOfString > 0 ? str.substring(endIndx+1, endIndx + lengthOfString + 1) : "";
            System.out.println("result  "+ result);
            ans.add(result);
            i = endIndx+ lengthOfString + 1;
        }
        return ans;
    }
}
