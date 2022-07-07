class Solution {
    public int countBattleships(char[][] board) {
        int n=board.length;
        int m=board[0].length;
        
        int count=0;
        
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(board[i][j]=='X'){
                   if((j-1)>=0 && board[i][j-1]=='X')continue;   
                   if((i+1)<n && board[i+1][j]=='X')continue;
                   count++;
                }
            }
        }
        return count;
    }
}