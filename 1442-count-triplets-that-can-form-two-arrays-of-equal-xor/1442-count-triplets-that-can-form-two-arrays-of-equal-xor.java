class Solution {
    public int countTriplets(int[] arr) {
        int n=arr.length;
        
        int count=0;
        
        for(int i=0;i<n;i++){
            int xor=arr[i];
            for(int j=i+1;j<n;j++){
                xor^=arr[j];
                if(xor==0 ){
                    count+=(j-i);
                }
            }
        }
        
        return count;
    }
}