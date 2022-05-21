class Solution {
    int mod=(int)1e9+7;
    Long[] dp;
    public int countTexts(String pressedKeys) {
        
        dp=new Long[pressedKeys.length()];
        return (int)(solve(pressedKeys,0)%mod);
        
    }
    public long solve(String pressedKeys,int index){
        
        if(index == pressedKeys.length()){
            return 1;
        }
        
        long count=0;
        
        if(dp[index]!=null)return dp[index];
        
        for(int i=1;i<=4;i++){
            
            if(index+i-1== pressedKeys.length())return count;
            
            if(pressedKeys.charAt(i+index-1)!=pressedKeys.charAt(index))return count;
            
            if(i!=4)
            count=(count+solve(pressedKeys,index+i))%mod;
            else if(pressedKeys.charAt(index) == '9' || pressedKeys.charAt(index) == '7')
            count=(count+solve(pressedKeys,index+i))%mod;
        }
        return dp[index]= count;
    }
}