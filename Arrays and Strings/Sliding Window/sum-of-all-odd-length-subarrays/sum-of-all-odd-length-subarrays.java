class Solution {
    public int sumOddLengthSubarrays(int[] arr) {
        int n=arr.length,sum=0;
        for(int i=0;i<arr.length;i++){
            int x=(n-i)*(i+1);
            sum+=(x+1)/2*arr[i];
        }
        return sum;
    }
}