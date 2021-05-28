class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        
            return solve(nums,k)-solve(nums,k-1);
        
    }
        public int solve(int[] nums,int k){
                   int ei=0;
            int si=0;
            int n=nums.length;
            int odds=0;
            int ans=0;
            while(ei<n){
                    if(nums[ei]%2!=0)odds++;
                    ei++;
                    
                    while(odds>k){
                              if(nums[si]%2!=0)odds--;
                            si++;
                            
                    }
                    
                    
                           ans+=ei-si;
                    
                   
                    
                    
                    
            }
               
            return ans;
        }
        
        
        
}