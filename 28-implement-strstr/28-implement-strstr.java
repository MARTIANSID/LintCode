class Solution {
    /*
    idea->kmp
    */
    public int strStr(String haystack, String needle) {
        
        String s=needle+"*"+haystack;
        int n=s.length();
        int i=1,len=0;
        int[] lps=new int[n];
        while(i<n){
            if(s.charAt(i)==s.charAt(len)){
                len++;
                lps[i]=len;
                if(len==needle.length())return (i-2*needle.length());
                i++;
            }else{
                if(len>0){
                    len=lps[len-1];
                }else{
                    i++;
                }
            }
        }
        return -1;
    }
}