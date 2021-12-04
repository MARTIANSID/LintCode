class Solution {
List result = new ArrayList();
boolean found = false;
public List findWords(char[][] board, String[] words) {
for(String word : words){
find(word , board);
}

    return result;
}

public void find(String word , char[][] board){
    
     boolean visited[][] = new boolean[board.length][board[0].length];
   
    for(int i = 0 ; i < board.length ; i++){
        for(int j = 0 ; j < board[0].length ; j++){
            if(word.charAt(0) == board[i][j]){
                exist(board, i , j , word , 0 , visited);
                if(found){
                    result.add(word);
                    break;
                }
            }
        }
           if(found)
                break;
    }
    

  
    
    found = false;
}
public boolean exist(char[][] board , int i , int j , String word , int curr ,boolean visited[][]){
    if(i >= board.length || i < 0 || j >= board[0].length || j < 0 ||word.length() <= curr || word.charAt(curr) != board[i][j] || visited[i][j])
        return false;
    
    
    visited[i][j] = true;
    
    if(word.length()-1 == curr){
        found = true;
        return true;
    }
    

   boolean x= exist(board , i+1 , j , word , curr+1 , visited );
    if(x)return true;
   boolean y= exist(board , i-1 , j , word , curr+1  , visited);
    if(y)return true;
  boolean z=  exist(board , i , j+1 , word , curr+1 , visited);
    if(z)return true;
  boolean p=  exist(board , i , j-1, word , curr+1  , visited) ;
    if(p)return true;
    
    visited[i][j] = false;
    
    return false;
        

}
}