class Solution {
    public int minimumMountainRemovals(int[] nums) {
        return LongestBitonicSequence(nums);
    }
    
    public int LongestBitonicSequence(int[] nums)
    {
        
        
      int[] dp1=  LDS_LR(nums);
       int[] dp2= LDS_RL(nums);
       
       
      int max=0;
       
      for(int i=0;i<dp1.length;i++){
          if(dp1[i]>1&&dp2[i]>1)
         max= Math.max(max,dp1[i]+dp2[i]-1);
      }
      
      return nums.length-max;
        
        // Code here
    }
    
        public int[] LDS_LR(int[] nums){
        
           int ans=0;
            int[] dp=new int[nums.length+1];
            Arrays.fill(dp,-1);
            for(int i=0;i<nums.length;i++){
                    
                
                    ans=Math.max(solve(nums,i,dp),ans);
            }
            
            return dp;
            
        
        
        
    }
    
      
     
        public int solve(int[] nums,int index,int[] dp){
              
                 
             int a=1;  
                 if(dp[index]!=-1)return dp[index]; 
             for(int i=index+1 ;i<nums.length;i++){
                     if(nums[index]>nums[i]){
                            int o= solve(nums,i,dp)+1;
                             
                             a=Math.max(o,a);
                     }
             }   
                
                
                return dp[index]=a;
                
        }
    
    
        
    public int[] LDS_RL(int[] nums){
        
           int ans=0;
            int[] dp=new int[nums.length+1];
            Arrays.fill(dp,-1);
            for(int i=nums.length-1;i>=0;i--){
                    
                    ans=Math.max(solve1(nums,i,dp),ans);
            }
            
            return dp;
            
        
        
        
    }
    
    
    
    
        public int solve1(int[] nums,int index,int[] dp){
              
                 
             int a=1;  
                 if(dp[index]!=-1)return dp[index]; 
             for(int i=index ;i>=0;i--){
                     if(nums[index]>nums[i]){
                            int o= solve1(nums,i,dp)+1;
                             
                             a=Math.max(o,a);
                     }
             }   
                
                
                return dp[index]=a;
                
        }
    
    
}