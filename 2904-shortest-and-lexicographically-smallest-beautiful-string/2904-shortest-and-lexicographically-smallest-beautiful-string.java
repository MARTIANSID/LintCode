class Solution {
    public String shortestBeautifulSubstring(String s, int k) {
        int n = s.length();
        
        int si = 0, ei = 0;
        
        int one  = 0;
        
        String ans = "";
        
        int len = (int)1e9;
        
        while(ei<n){
            char ch = s.charAt(ei++);
            
            if(ch == '1'){
                one++;
            }
            
            while(one == k){
                String subString = s.substring(si,ei);
                
                int length = subString.length();
                
                if(length<len){
                    len = length;
                    ans = subString;
                }else if(len == length && subString.compareTo(ans)<0){
                    ans = subString;
                }
                ch = s.charAt(si++);
                if(ch == '1'){
                    one--;
                }
            }
        }
        return ans;
    }
}