class Solution {
    public int[] smallestRange(List<List<Integer>> nums) {
        List<int[]> mergedSortedNums=new ArrayList<>();
        
        int arrNumber=0;
        
        for(List<Integer> arr:nums){
            for(int ele:arr){
                mergedSortedNums.add(new int[]{arrNumber,ele});
            }
            arrNumber++;
        }
        
        Collections.sort(mergedSortedNums,(a,b)->{
            return a[1]-b[1];
        });
        
        int[] freq=new int[nums.size()];
        
        Arrays.fill(freq,1);
        
        int count=nums.size();
        
        int ei=0,si=0,n=mergedSortedNums.size(),gsi=0,gei=mergedSortedNums.size()-1;
        
        while(ei < n){
            int[] data = mergedSortedNums.get(ei++);
            freq[data[0]]--;
            if(freq[data[0]]==0)count--;
            
            while(count == 0){
                if(((mergedSortedNums.get(ei-1)[1]- mergedSortedNums.get(si)[1])<(mergedSortedNums.get(gei)[1]-mergedSortedNums.get(gsi)[1]))){
                    gsi=si;
                    gei=ei-1;
                }
                int[] temp=mergedSortedNums.get(si++);
                freq[temp[0]]++;
                if(freq[temp[0]]==1)count++;
            }
        }
        
        return new int[]{mergedSortedNums.get(gsi)[1],mergedSortedNums.get(gei)[1]};
    }
    
}