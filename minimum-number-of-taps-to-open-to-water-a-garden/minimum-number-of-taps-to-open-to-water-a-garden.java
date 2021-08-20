class Solution {
    public int minTaps(int n, int[] ranges) {
    
        List<int[]>  intervals=new ArrayList<>();
        
        for(int i=0;i<ranges.length;i
            ++){
            intervals.add(new int[]{i-ranges[i],i+ranges[i]});
        }
        
        Collections.sort(intervals,(a,b)->{
            return a[0]-b[0];
        });
        
        int start=0;
        
        
        int count=0,i=0,max=0;
        while(start<n){
          
                while(i<ranges.length&&intervals.get(i)[0]<=start){
                   max=Math.max(max,intervals.get(i)[1]);
                    i++;
                }
            if(max<=start)return -1;
               start=max;
                count++;
            
        }
        
        return count;
    }
}