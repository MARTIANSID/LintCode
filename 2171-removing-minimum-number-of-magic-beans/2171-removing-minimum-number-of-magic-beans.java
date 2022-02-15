class Solution {
    public long minimumRemoval(int[] beans) {
        int n=beans.length;
        
        if(n==1)return 0;
        
        Arrays.sort(beans);
        
        long[] left=new long[n];
        
        long[] right=new long[n];
        
        long sum=0;
        for(int i=0;i<n;i++){
            sum+=beans[i];
            left[i]=sum;
        }
        
       
            
        sum=0;
        for(int i=n-1;i>=0;i--){
            sum+=beans[i];
            right[i]=sum;
        }
        long min=(long)1e13;
        
        for(int i=0;i<n;i++){
            if(i==0){
                min=Math.min(min,right[i+1]-(long)((long)(n-i-1)*(long)(beans[i])));
            }else if(i==n-1){
                min=Math.min(min,left[i-1]);
            }else{
                min=Math.min(min,((right[i+1]-(long)((long)(n-i-1)*(long)(beans[i])))+left[i-1]));
            }
            
        }
        
        return min;
        
    }
}