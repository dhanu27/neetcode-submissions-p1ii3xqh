class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int n = position.length;
        int[][] cars = new int[n][2];
        for(int i=0; i<n; i++){
            cars[i][0] = position[i];
            cars[i][1] = speed[i]; 
        }
        Arrays.sort(cars, new Comparator<int[]>(){
            @Override
            public int compare(int[] arr1, int []arr2){
             return arr2[0] - arr1[0];
           }
        });
        Stack<Double> st = new Stack<>();
        for(int i=0; i<n; i++){
            Double time = ((double)(target - cars[i][0]) / cars[i][1]);
              if(!st.isEmpty() && st.peek() >= time){
                    continue;
              }
              st.push(time);
        }
        return st.size();  
    }
}
