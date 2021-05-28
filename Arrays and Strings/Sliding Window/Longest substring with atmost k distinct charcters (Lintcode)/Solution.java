public class Solution {
    /**
     * @param s: A string
     * @param k: An integer
     * @return: An integer
     */
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
              int si=0;
     int ei=0;
     int n=s.length();
     int distinct=0;
     int[] freq=new int[256];
     int max=0;
     while(ei<n){
        char ch=s.charAt(ei);
        freq[ch]++;
        ei++;
        if(freq[ch]==1){
            distinct++;
            if(distinct>k){
                while(distinct>k){
                    char c=s.charAt(si);
                    freq[c]--;
                    if(freq[c]==0){
                        distinct--;
                    }
                    si++;
                }
            }else{
                max=Math.max(max,ei-si);
            }
        }else{
             max=Math.max(max,ei-si);
        }
     }
    return max;
    }
}  