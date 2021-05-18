class Solution {
    public int longestSubsequence(int[] arr, int difference) {
        
            int max=1;
            
          
            
            HashMap<Integer,Integer> map=new HashMap<>();
            
            
            int[] dp=new int[arr.length];
            dp[0]=1;
            map.put(arr[0],0);
            for(int i=1;i<arr.length;i++){
                    if(map.containsKey(arr[i]-difference)){
                            dp[i]=dp[map.get(arr[i]-difference)]+1;
                            max=Math.max(max,dp[i]);
                    }else{
                            dp[i]=1;
                    }
                    map.put(arr[i],i);
                    
            }
            
            return max;
            
    }
}