class Solution {
    public int[] countBits(int n) {
        
        int[] ans=new int[n+1];
        int index=0;
        
        for(int i=0;i<=n;i++){
            int ones=0;
            for(int j=0;j<32;j++){
                int x=(1<<j);
                int bit=(x&i);
                if(bit!=0)ones++;
            }
            ans[index++]=ones;
        }
        return ans;
    }
}