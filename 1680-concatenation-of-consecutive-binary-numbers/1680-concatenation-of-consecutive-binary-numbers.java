class Solution {
    public int countBits(int n){
        for(int i=20;i>=0;i--){
            int bit=((n&(1<<i))==0?0:1);
            if(bit==1){
                return i+1;
            }
        }
        return 0;
    }
    int mod=(int)1e9+7;
    public int concatenatedBinary(int n) {
        long val=0;
        int i=1;
        
        while(i<=n){
            int count=countBits(i);
            // System.out.println(count);
            val=(val<<count)%mod;
            val+=(i++);
        }
        return (int)(val%mod);
    }
}