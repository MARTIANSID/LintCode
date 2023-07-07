class Solution {
    public int maxConsecutiveAnswers(String answerKey, int k) {
        int n=answerKey.length();
        int t=0,f=0,si=0,ei=0,ans=0;
        
        while(ei<n){
            char ch=answerKey.charAt(ei++);
            if(ch == 'T')t++;
            else f++;
            int max=Math.min(t,f);
            
            
            while(max>k){
                ch=answerKey.charAt(si++);
                if(ch == 'T')t--;
                else f--;
                max=Math.min(t,f);
            }
            ans=Math.max(ans,t+f);
        }
        return ans;
    }
}
