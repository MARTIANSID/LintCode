class Solution {
    public int longestArithSeqLength(int[] nums) {
        int n=nums.length;
        int max=0;
        
        HashMap<Integer,int[]> map=new HashMap<>();
        
        for(int i=n-1;i>=0;i--){
            int[] freq=new int[501];
            Arrays.fill(freq,1);
            for(int j=0;j<=500;j++){
                if(map.containsKey(nums[i]+j)){
                   int[] arr= map.get(nums[i]+j);
                   freq[j]+=arr[j];
                   max=Math.max(max,freq[j]);
                }
            }
            map.put(nums[i],freq);
        }
        
        map=new HashMap<>();
        
         for(int i=0;i<n;i++){
            int[] freq=new int[501];
            Arrays.fill(freq,1);
            for(int j=0;j<=500;j++){
                if(map.containsKey(nums[i]+j)){
                   int[] arr= map.get(nums[i]+j);
                   freq[j]+=arr[j];
                   max=Math.max(max,freq[j]);
                }
            }
            map.put(nums[i],freq);
        }
        return max;
    }
}