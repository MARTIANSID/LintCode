class Solution {
    int mod=(int)1e9+7;
    public int countHomogenous(String s) {
        int n=s.length();
        
        long count=1;
        int si=0;
        
        for(int i=1;i<n;i++){
            char ch=s.charAt(i);
            char prevCh=s.charAt(i-1);
            if(ch == prevCh){
                
            }else{
                si=i;
            }
            count=(count+(i-si+1))%mod;
        }
        return (int)(count%mod);
        
    }
}