class Solution {

    public long maximumSubsequenceCount(String text, String pattern) {
        int n = text.length();

        //first add pattern[0]

        
        char zero=pattern.charAt(0),first=pattern.charAt(1);

        long count = 1, ans = 0, max = 0;

        for (int i = 0; i < n; i++) {
            char ch=text.charAt(i);
            
             if(ch == first){
                ans+=count;
            }
            
            if(ch == zero){
                count++;
            } 
           
            
        }
        max=Math.max(max,ans);
        
        count=0;
        ans=0;
        for(int i=0; i<n;i++){
            char ch=text.charAt(i);
            
             if(ch == first){
                ans+=count;
            }
            
            if(ch == zero){
                count++;
            } 
           
        }
        max=Math.max(max,ans+count);
        
        return max;
    }
}
