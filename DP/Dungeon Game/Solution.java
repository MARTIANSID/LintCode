class Solution {
    //binary search solution
    public int calculateMinimumHP(int[][] dungeon) {
        
       
                  int hi=20001;
            int ei=0;
            
            while(hi>ei){
                    int mid=(hi+ei)/2;
                    
                    if(solve(dungeon,0,0,mid))hi=mid;
                    else ei=mid+1;
                    
            }
            
     
            return ei;
            
            
            
    }
        
        public boolean solve(int[][] dungeon,int row,int col,int h){
               if(row<0||col<0||row>=dungeon.length||col>=dungeon[0].length){
                       return false;
               } 
                
                if(h<1)return false;
                
              if(row==dungeon.length-1&&col==dungeon[0].length-1){
                      if(h+dungeon[row][col]<1)return false;
                      
                      return true;
              }  
                
                
            boolean x=    solve(dungeon,row+1,col,h+dungeon[row][col]);
                if(x)return true;
          boolean y=     solve(dungeon,row,col+1,h+dungeon[row][col]);
                if(y)return true;
                
            return false;
                
                
                
        }
}