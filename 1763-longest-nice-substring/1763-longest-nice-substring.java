class Solution {

    public String longestNiceSubstring(String s) {
        int n = s.length();
        
        return solve(s,0,n-1);
    }

    public String solve(String s, int si, int ei) {
        
        if(si==ei)return "";
        
        HashSet<Character> set = new HashSet<>();

        for (int i = si; i <= ei; i++) {
            set.add(s.charAt(i));
        }
        
        StringBuilder sb=new StringBuilder();

        for (int i = si; i <= ei; i++) {
            char ch = s.charAt(i);
            char upper = Character.toUpperCase(ch);
            char lower = Character.toLowerCase(ch);
            
            sb.append(ch);
            
            if(!set.contains(lower) || !set.contains(upper)){
             String a= solve(s,si,i-1);
              String b=solve(s,i+1,ei);
                if(a.length()>=b.length()){
                    return a;
                }else{
                    return b;
                }
            }
        }
        
        return new String(sb);
    }
    // why divide and conquer?
    //if in a substring we find that the capital or small case of a character is not present then there is no need to continue with that particular substring break it from that point
}
