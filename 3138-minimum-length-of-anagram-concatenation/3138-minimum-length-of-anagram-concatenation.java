class Solution {
    public int minAnagramLength(String s) {
        int n = s.length(), min = (int)1e9;
        
        
        for(int i = 1; i <= Math.sqrt(n); i++) {
            
            if(n%i == 0) {
                
            if(isPossible(i,s)) {
                return i;
            } 
            
            if(isPossible(n/i,s)) {
                min = n/i;
            }
            }
            
        }
        
        return min;
        
        
        
    }
    
     public boolean isPossible(int len, String s) {
        boolean isFirst = true;

        int[] f = new int[26];

        int n = s.length();

        int cnt = n / len;

        int start = 0;

        boolean first = true;

        while (cnt-- > 0) {
            int[] temp = new int[26];
            for (int i = start; i < start + len; i++) {
                char ch = s.charAt(i);
                temp[ch - 'a']++;
            }
            start = start + len;

            if (first) {
                first = false;
                for (int i = 0; i < 26; i++) {
                    f[i] = temp[i];
                }
            } else {
                for (int i = 0; i < 26; i++) {
                    if (f[i] != temp[i]) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}