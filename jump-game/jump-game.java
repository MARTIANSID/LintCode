class Solution {
    public boolean canJump(int[] nums) {
        
        
        int end=0,steps=0,n=nums.length;
        
        
        while(end<n-1){
        
            int max=-1;
            int index=0;

            for(int i=end+1;i<=end+nums[end];i++){
                if(i>=n-1)return true;
                if(i+nums[i]>max){
                    max=i+nums[i];
                    index=i;
                }
                
                
            }
            
            if(index==end||index==0)return false;
                end=index;
                steps++;
            
          
        }
        
        return true;
        
    }
}