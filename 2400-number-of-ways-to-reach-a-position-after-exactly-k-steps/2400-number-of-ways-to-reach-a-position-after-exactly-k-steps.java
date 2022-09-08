class Solution {
    HashMap<String,Long> dp=new HashMap<>();
    int mod=(int)1e9+7;
    public int numberOfWays(int startPos, int endPos, int k) {
       
        
        return (int)(dfs(startPos,endPos,k)%mod);
    }
    public long dfs(int startPos,int endPos,int k){
        
        
        if(k<0)return 0;
        
        if(Math.abs(startPos-endPos)>k)return 0;
        
        if(Math.abs(startPos-endPos)<k && (k-Math.abs(startPos-endPos))%2!=0)return 0;
        
        
        
        if(startPos==endPos && k==0)return 1;
        
        String key=startPos+"."+k;
        
        if(dp.containsKey(key))return dp.get(key);
        
        long count=0;
        
        count=(count+dfs(startPos+1,endPos,k-1))%mod;
        count=(count+dfs(startPos-1,endPos,k-1))%mod;
        
        dp.put(key,count);
        return  count;
    }
}