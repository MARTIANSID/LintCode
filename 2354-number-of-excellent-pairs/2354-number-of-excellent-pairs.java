class Solution {
    
    public int setBits(int n){
        return Integer.bitCount(n);
    }

    public long countExcellentPairs(int[] nums, int k) {
        int n = nums.length;
        long cnt=0;
        List<Integer> arr=new ArrayList<>();
        HashSet<Integer> set=new HashSet<>();
        
        for(int ele:nums){
            if(set.contains(ele))continue;
            set.add(ele);
            arr.add(setBits(ele));
        }
        Collections.sort(arr);
       
        
        int i=0,j=arr.size()-1;
        
        while(i<=j){
            int sum=arr.get(i)+arr.get(j);
            if(sum>=k){
                cnt+=2*(j-i)+1;
                j--;
            }else{
                i++;
            }
        }
        
        return cnt;
    }
}