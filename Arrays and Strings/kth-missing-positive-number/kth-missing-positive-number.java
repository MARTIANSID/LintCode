class Solution {
    public int findKthPositive(int[] arr, int k) {
    
        int ans=k;
        for(int ele:arr){
            if(ele<=ans)ans++;
        }
        return ans;
    }
}