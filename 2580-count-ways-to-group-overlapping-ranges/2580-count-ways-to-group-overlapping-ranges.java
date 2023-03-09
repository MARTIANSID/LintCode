class Solution {
    int mod=(int)1e9+7;
    public int countWays(int[][] ranges) {
        Arrays.sort(ranges,(a,b)->{
            return a[0]-b[0];
        });
        List<int[]> merged=new ArrayList<>();
        
        int s=ranges[0][0],e=ranges[0][1];
        
        for(int i=1;i<ranges.length;i++){
            int start=ranges[i][0],end=ranges[i][1];
            if(e>=start){
                e=Math.max(e,end);
            }else{
                merged.add(new int[]{s,e});
                s=start;
                e=end;
            }
        }
        merged.add(new int[]{s,e});
        int size=merged.size();
        
        long ans=1;
        
        for(int i=1;i<=size;i++){
            ans=(ans*2)%mod;
        }
        return (int)(ans%mod);
    }
}