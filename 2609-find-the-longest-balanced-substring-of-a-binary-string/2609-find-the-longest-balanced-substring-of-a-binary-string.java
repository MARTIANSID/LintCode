class Solution {

    public int findTheLongestBalancedSubstring(String s) {
        int n = s.length(), i = 0, zero = 0, one = 0, max = 0;

        while (i < n) {
            char ch = s.charAt(i);
            if (ch == '0') {
                if (one > 0) {
                    zero = 1;
                    one = 0;
                } else {
                    zero++;
                }
            } else {
                one++;
                if(one>zero){
                    one=0;
                    zero=0;
                }
            }
             max=Math.max(max,2*one);
            
            i++;
        }
        return max;
    }
}
