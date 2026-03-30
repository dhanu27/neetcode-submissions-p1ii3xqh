class Solution {
   
    public int blockNumber(int flatX, int flatY){
        if((flatX>=0 && flatX<3)){
            if(flatY>=0 && flatY<3){
               return 1;
            }
            if(flatY>=3 && flatY<6){
               return 2;
            }
            if(flatY>=6 && flatY<9){
                return 3;
            }
        }
        else if((flatX>=3 && flatX<6)){
            if(flatY>=0 && flatY<3){
               return 4;
            }
            if(flatY>=3 && flatY<6){
               return 5;
            }
            if(flatY>=6 && flatY<9){
                return 6;
            }
        }
        else {
            if(flatY>=0 && flatY<3){
               return 7;
            }
            if(flatY>=3 && flatY<6){
               return 8;
            }
            if(flatY>=6 && flatY<9){
                return 9;
            }
        }
        return -1;
    }


    public boolean isValidSudoku(char[][] board) {
        HashMap<Integer,List<List<Integer>>> map = new HashMap<>(); 
        for(int i=0; i< board.length; i++){
            for(int j=0; j<board[i].length; j++){
                if(board[i][j] != '.'){
                    int number = Integer.parseInt(board[i][j]+"");
                    List<List<Integer>> result = map.getOrDefault(number, new ArrayList<>());
                    for(int k = 0; k<result.size(); k++){
                        List<Integer> existed = result.get(k);
                        int prevI = existed.get(0);
                        int preJ = existed.get(1);
                        if(prevI == i || preJ == j || blockNumber(i,j) == blockNumber(prevI,preJ)){
                            return false;
                        }
                    }
                    result.add(Arrays.asList(i,j));
                    map.put(number,result);
                }
              }
            }
         return true;
        }
    }

