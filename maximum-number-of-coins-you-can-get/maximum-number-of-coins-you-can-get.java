class Solution {
    public int maxCoins(int[] piles) {
        Arrays.sort(piles);
        int n=piles.length;
        int ans=0;
        int index=0;
        for(int i=n-2;i>=0;i-=2){
           if(i>index){
                ans+=piles[i];
               index++;
           }
           
        }
        return ans;
    }
}