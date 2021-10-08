class Solution {
    public int maxConsecutiveAnswers(String answerKey, int k) {
        int ei=0,si=0,n=answerKey.length(),count=0,max=0,ans=0;
        
        int[] freq=new int[2];
        while(ei<n){
            int index=answerKey.charAt(ei++)=='T'?0:1;
            if(freq[index]++==0){
                count++;
            }
             max=Math.max(max,freq[index]);
            
            while(count==2&&(ei-si)-max>k){
                 index=answerKey.charAt(si++)=='T'?0:1;
                if(freq[index]--==1)count--;
                max=0;
                max=Math.max(max,Math.max(freq[0],freq[1]));
            }
            
            ans=Math.max(ans,ei-si);
            
            
        }
        return ans;
    }
}