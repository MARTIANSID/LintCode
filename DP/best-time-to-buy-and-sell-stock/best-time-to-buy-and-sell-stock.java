class Solution {
    public int maxProfit(int[] prices) {
        int n=prices.length;
        int[] preMax=new int[n];
        int max=0;
        for(int i=n-1;i>=0;i--){
            max=Math.max(max,prices[i]);
            preMax[i]=max;
        }
        max=0;
        for(int i=0;i<n-1;i++){
            max=Math.max(max,preMax[i+1]-prices[i]);
        }
        return max;
    }
}