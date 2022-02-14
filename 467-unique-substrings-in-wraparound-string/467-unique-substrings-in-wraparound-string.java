class Solution {
    public int findSubstringInWraproundString(String p) {
        
        int n=p.length();
        int[] freq=new int[26];
        
        int[] dp=new int[n];
        
        dp[n-1]=1;
        
        freq[p.charAt(n-1)-'a']=1;
        
        for(int i=n-2;i>=0;i--){
            
            int ch=p.charAt(i)-'a';
            
            int infrontCh=p.charAt(i+1)-'a';
            
            int ans=1;
            
            if((ch+1)%26==infrontCh){
                ans=dp[i+1]+1;
            }
            
            dp[i]=ans;
            
            if(dp[i]==0)dp[i]=1;
            
            if(freq[ch]<ans){
                freq[ch]=ans;
            }
            
        }
        
        int result=0;
        
        for(int ele:freq){
            result+=ele;
        }
        
        return result;
        
    }
}