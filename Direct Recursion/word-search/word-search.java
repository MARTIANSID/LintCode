class Solution {
    public boolean exist(char[][] board, String word) {
            
            boolean[][] visited=new boolean[board.length][board[0].length];
        for(int i=0;i<board.length;i++){
                for(int j=0;j<board[0].length;j++){
                        
                        if(word.charAt(0)==board[i][j]&&find(board,word,i,j,0,"",visited)){
                          return true;      
                        }
                         
                }
        }
            return false;
    }
        
        public boolean  find(char[][] board,String word,int row,int col,int pos,String asf,boolean[][] visited){
               
                 if(asf.equals(word)){
                          
                        return true;
                }
                
                if(row<0||col<0||row>=board.length||col>=board[0].length||pos>=word.length()||board[row][col]!=word.charAt(pos)||visited[row][col]==true){
                
                        return false;
                }
                
               
                visited[row][col]=true;
                     boolean one=find(board,word,row+1,col,pos+1,asf+board[row][col],visited);
                if(one)return true;
                boolean two=find(board,word,row,col+1,pos+1,asf+board[row][col],visited);
                  if(two)return true;
                boolean three=find(board,word,row-1,col,pos+1,asf+board[row][col],visited);
                  if(three)return true;
                boolean four=find(board,word,row,col-1,pos+1,asf+board[row][col],visited);
                  if(four)return true;
                 visited[row][col]=false;
                
                
                return false;
                
                
                
                
        }
}