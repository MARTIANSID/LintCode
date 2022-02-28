class Solution {
    public long countVowels(String word) {
        int n=word.length();
        long[] dp=new long[n];
        
       char ch=word.charAt(0);
         if(ch == 'a'|| ch == 'e'|| ch == 'i' || ch == 'o' || ch == 'u'){
                    dp[0]=1;
             }else{
                 dp[0]=0;
             }
        
        for(int i=1;i<n;i++){
             ch=word.charAt(i);
             if(ch == 'a'|| ch == 'e'|| ch == 'i' || ch == 'o' || ch == 'u'){
                    dp[i]=dp[i-1]+(i)+1;
             }else{
                 dp[i]=dp[i-1];
             }
        }
        long ans=0;
        for(long ele:dp){
            ans+=ele;
        }
        
        return ans;
    }
}