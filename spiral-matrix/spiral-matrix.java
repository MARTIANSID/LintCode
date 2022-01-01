class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int n=matrix.length;
        int m=matrix[0].length;
        
        
        //initially
        int top=0;
        int right=m-1;
        int left=0;
        int down=n-1;
        int total=m*n;
        int count=0;
        char direction='R';
        List<Integer> ans=new ArrayList<>();
        
        int i=0,j=0;
        
        while(count<total){
            if(direction=='L'){
                
                while(j>=left){
                    ans.add(matrix[i][j]);
                    count++;
                    if(j==left)break;
                    if(j!=left)j--;
                    
                   
                }
                i--;
                direction='T';
                down--;
                
            }else if(direction=='R'){
                while(j<=right){
                    
                    ans.add(matrix[i][j]);
                     count++;
                    if(j==right)break;
                    if(j!=right)j++;
                   
                    
                }
                i++;
                direction='D';
                top++;
                
            }else if(direction=='D'){
                while(i<=down){
                     ans.add(matrix[i][j]);
                     count++;
                     if(i==down)break;
                    if(i!=down)i++;
                   
                   
                }
                j--;
                direction='L';
                right--;
            }else {
                 
                while(i>=top){
                    ans.add(matrix[i][j]);
                    count++;
                    if(i==top)break;
                    if(i!=top)i--;
                    
                    
                }
                
                direction='R';
                left++;
                j++;
                
            }
        }
        
        
        
        return ans;
        
    }
}