class Solution {

    public int nthSuperUglyNumber(int n, int[] primes) {
        int m = primes.length;
        int[] mults = new int[m];
        int[] dp = new int[n+1];
        Arrays.fill(mults, 1);
        
        
        dp[1]=1;
        
        
        for(int i=2;i<=n;i++){
            int min=(int)8e9,index=-1;
            for(int j=0;j<m;j++){
                long val=(long)primes[j]*(long)dp[mults[j]];
                if(val<min){
                    min=(int)val;
                    index=j;
                }else if(val == min){
                    mults[j]++;
                }
            }
            dp[i]=min;
            mults[index]++;
        }
        return dp[n];
    }
}
