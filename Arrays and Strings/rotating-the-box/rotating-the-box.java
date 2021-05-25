class Solution {
    public char[][] rotateTheBox(char[][] box) {
            
        for(int i=0;i<box.length;i++){
                 int lastLoda=-1;
                for(int j=box[0].length-1;j>=0;j--){
                        if(box[i][j]=='.'){
                                if(lastLoda==-1)
                                lastLoda=j;
                        }else if(box[i][j]=='*'){
                                lastLoda=-1;
                                
                        }else{
                                if(lastLoda!=-1){
                                        box[i][lastLoda--]='#';
                                        box[i][j]='.';
                                }
                        }
                        
                        
                }
        }
                
                char[][] result = new char[box[0].length][box.length];
	for(int i=0;i<box.length;i++)
		for(int j=box[0].length-1;j>=0;j--) 
			result[j][box.length - i -1] = box[i][j];
            
            
            // rotate
	return result;
                
                
                
                
                
                
                
                
                
  
    
    }
}