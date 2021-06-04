class Solution {
    public int longestSubstring(String s, int k) {
     
 return solve(s,0,s.length(),k);
            
            }
        
        
        
        public int solve(String s,int si,int ei,int k){
                
               if(ei-si<k)return 0;
                
                
                
                int[] freq=new int[26];
                
                for(int i=si;i<ei;i++){
                        freq[s.charAt(i)-'a']++;
                }
                
                
                
                for(int i=si;i<ei;i++)
                {
                        if(freq[s.charAt(i)-'a']<k){
                                
                                return Math.max(solve(s,si,i,k),solve(s,i+1,ei,k));
                        }
                        
                }
                
                return ei-si;
                
                
        }
               
    
}