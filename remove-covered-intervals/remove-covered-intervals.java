class Solution {
    public int removeCoveredIntervals(int[][] intervals) {
        Arrays.sort(intervals,(a,b)->{
            if(a[0]==b[0])return b[1]-a[1];
            return a[0]-b[0];
        });
        
        int remove=0;
        int end=intervals[0][1];
        for(int i=1;i<intervals.length;i++){
            
            while(i<intervals.length&&end>=intervals[i][1]){
                remove++;
                i++;
            }
            if(i>=intervals.length-1)break;
            end=intervals[i][1];
            
            
        }
        
        return intervals.length-remove;

    }
}