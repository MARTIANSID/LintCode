class Solution {
    public int characterReplacement(String s, int k) {
        int[] freq=new int[26];
        int[] f=new int[26];
        int ei=0,si=0,n=s.length(),max=0,m=0;
        
    
        
        while(ei<n){
            char ch=s.charAt(ei++);
            f[ch-'A']++;
            
            m=Math.max(m,f[ch-'A']);
          
            
            while((ei-si)-m>k){
                char c=s.charAt(si++);
                f[c-'A']--;
                m=0;
                for(int i=0;i<26;i++){
                    m=Math.max(m,f[i]);
                }
             
            }
            
            max=Math.max(max,ei-si);
            
            
        }
        return max;
    }
}