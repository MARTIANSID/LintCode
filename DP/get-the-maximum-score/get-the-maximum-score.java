class Solution {
        int mod=(int)1e9+7;
    public int maxSum(int[] nums1, int[] nums2) {
        HashMap<Integer,Integer> map1=new HashMap<>();
        HashMap<Integer,Integer> map2=new HashMap<>();

            
         for(int i=0;i<nums1.length;i++){
                 map1.put(nums1[i],i);
         } 
            
            
            for(int i=0;i<nums2.length;i++){
                    map2.put(nums2[i],i);
                    
            }
            
            
            int n=Math.max(nums2.length,nums1.length);
            long[][] dp=new long[3][n+1];
            for(long[] row:dp)Arrays.fill(row,-1);
            
            return (int)Math.max(solve(nums1,nums2,0,0,1,map1,map2,dp)%mod,solve(nums1,nums2,0,0,2,map1,map2,dp)%mod);
         
           
    }
        public long solve(int[] nums1,int[] nums2,int i,int j,int current,HashMap<Integer,Integer> map1, HashMap<Integer,Integer> map2,long[][] dp){
                
                
                if(current==1&&i==nums1.length||current==2&&j==nums2.length)return 0;
                
                if(current==1)
                if(dp[current][i]!=-1)return dp[current][i];
                
                if(current==2)
                if(dp[current][j]!=-1)return dp[current][j];
                
                
                
                if(current==1){
                        long x=-(long)1e9;
                        long y=-(long)1e9;
                       x= solve(nums1,nums2,i+1,j,current,map1,map2,dp)+nums1[i];
                        if(map2.containsKey(nums1[i])){
                               y= solve(nums1,nums2,i,map2.get(nums1[i])+1,2,map1,map2,dp)+nums1[i];
                        }
                        
                        return  dp[current][i] = Math.max(x,y);
                        
                }else{
                        
                          long x=-(long)1e9;
                        long y=-(long)1e9;
                          x= solve(nums1,nums2,i,j+1,current,map1,map2,dp)+nums2[j];
                        
                        if(map1.containsKey(nums2[j])){
                                y=solve(nums1,nums2,map1.get(nums2[j])+1,j,1,map1,map2,dp)+nums2[j];
                        }
                          return  dp[current][j] =Math.max(x,y);
                }
                
              
        }
}