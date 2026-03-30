class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String,ArrayList<Integer>> map = new HashMap<>();
        for(int i=0; i<strs.length; i++){
            char[] charArray = strs[i].toCharArray();
            Arrays.sort(charArray);
            String sortedString =  new String(charArray);
            if(map.get(sortedString) == null){
                ArrayList<Integer> ans = new ArrayList<>();
                ans.add(i);
                map.put(sortedString,ans);
            }else{
                ArrayList<Integer> ans = map.get(sortedString);
                ans.add(i);
            }
        }
        List<List<String>> result = new ArrayList<>();
        for(String keys: map.keySet()){
            List<String> ans = new ArrayList<>();
            for(int j=0; j<map.get(keys).size(); j++){
                ans.add(strs[map.get(keys).get(j)]);
            }
            result.add(ans);
        }
        return result;
    }
}
