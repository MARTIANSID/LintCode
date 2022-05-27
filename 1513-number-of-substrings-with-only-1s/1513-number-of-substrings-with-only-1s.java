class Solution {
    int mod=(int)1e9+7;
    public int numSub(String s) {
        int n=s.length();
        int si=0;
        long count=0;
        for(int i=0;i<n;i++){
            char ch=s.charAt(i);
            if(ch=='0'){
                si=i+1;
            }else{
                count=(count+(i-si+1))%mod;
            }
        }
        return (int)(count%mod);
    }
}